import java.util.Objects;
import java.util.TreeSet;

//For custom objects storing we need to use comparable or comparator for defining the sequence/indexing
class Employee implements Comparable<Employee> {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Sorting employees by salary, then by ID, then by name (if necessary)
    @Override
    public int compareTo(Employee e) {
        int cmp = Double.compare(this.salary, e.salary);
        if (cmp != 0) return cmp;

        cmp = Integer.compare(this.id, e.id);
        if (cmp != 0) return cmp;

        return this.name.compareTo(e.name); // Compare by name if everything else is equal
    }

    // Ensuring proper equality check for TreeSet's contains() method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Double.compare(salary, employee.salary) == 0 &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary);
    }

    @Override
    public String toString() {
        return "\nid=" + id + ", name='" + name + "', salary=" + salary;
    }
}


public class TreeSetEx1 {
    public static void main(String[] args) {
        TreeSet<Employee> employees = new TreeSet<>();

        // Adding employees to the TreeSet
        employees.add(new Employee(102, "Charlie", 70000));
        employees.add(new Employee(104, "David", 80000));
        employees.add(new Employee(106, "Roy", 90000));
        employees.add(new Employee(101, "Alice", 50000));
        employees.add(new Employee(103, "Bob", 60000));
        employees.add(new Employee(105, "Jay", 100000));

        // Since TreeSet uses salary for comparison, employees with duplicate salaries would normally be ignored.
        // However, since IDs are also used for comparison employees with the same salary but different IDs are still added.
        employees.add(new Employee(107, "Tommy", 80000));

        System.out.println("Employees:");
        System.out.println(employees);

        // Checking if a specific employee exists
        System.out.println("\nContains Alice with salary 50000?: "
                + employees.contains(new Employee(101, "Alice", 50000)));

        // Retrieving first and last employees based on salary
        System.out.println("First Employee: " + employees.first());
        System.out.println("Last Employee: " + employees.last());

        // Using dummy objects for comparison since compareTo() only considers salary and ID.
        // We can use real object but, it is not a good practice.
        Employee ref = new Employee(0, "", 50000);  // Dummy object with salary 50000
        Employee ref2 = new Employee(0, "", 80000); // Dummy object with salary 80000

        // Finding employees based on salary
        System.out.println("\nEmployee with salary lower than Alice: " + employees.lower(ref));
        System.out.println("Employee with salary higher than Alice: " + employees.higher(ref));
        System.out.println("Employee with salary equal to or just above Alice: " + employees.ceiling(ref));
        System.out.println("Employee with salary equal to or just below Alice: " + employees.floor(ref));

        // Creating subsets based on salary
        System.out.println("\nEmployees with salary less than David: " + employees.headSet(ref2));
        System.out.println("Employees with salary greater than or equal to David: " + employees.tailSet(ref2));
        System.out.println("Employees with salary between Alice and David: " + employees.subSet(ref, ref2));

        // Removing employees with salary <= 100000
        employees.removeIf(emp -> emp.salary >= 100000);
        System.out.println("\nEmployees after removal:");
        System.out.println(employees);

        // Iterating through the TreeSet
        System.out.println("\nIterating through employees:");
        for (Employee emp : employees) {
            System.out.println("id=" + emp.id + ", name='" + emp.name + "', salary=" + emp.salary);
        }
    }
}
