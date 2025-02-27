import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.TreeSet;

class Intern {
    int id;
    String name;
    int age;
    double salary;

    public Intern(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id=" + id + ", \tname='" + name + "', \tage=" + age + ", \tsalary=" + salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Intern intern = (Intern) o;
        return id == intern.id && age == intern.age && Double.compare(intern.salary, salary) == 0 &&
                Objects.equals(name, intern.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, salary);
    }
}

// Comparator to sort Interns by Age, then Salary, then ID, then Name
class SortByAge implements Comparator<Intern> {
    @Override
    public int compare(Intern o1, Intern o2) {
        // 1. Compare by age
        int status = Integer.compare(o1.age, o2.age);
        if (status != 0) return status;

        // 2. Compare by salary
        status = Double.compare(o1.salary, o2.salary);
        if (status != 0) return status;

        // 3. Compare by ID
        status = Integer.compare(o1.id, o2.id);
        if (status != 0) return status;

        // 4. Compare by Name
        return o1.name.compareTo(o2.name);
    }
}

public class TreeSetEx2 {
    public static void main(String[] args) {
        TreeSet<Intern> interns = new TreeSet<>(new SortByAge());

        interns.add(new Intern(107, "Kim", 20, 3500.00));
        interns.add(new Intern(101, "Alex", 20, 3500.00));
        interns.add(new Intern(102, "Maria", 19, 2800.50));
        interns.add(new Intern(105, "James", 22, 3700.00));
        interns.add(new Intern(106, "Olivia", 25, 3100.50));
        interns.add(new Intern(103, "David", 24, 4000.75));
        interns.add(new Intern(104, "Sophia", 20, 3200.25));

        System.out.println("\nInterns Sorted by Age:");
        for (Intern intern : interns) {
            System.out.println(intern);
        }

        // Checking if an intern exists
        boolean containsIntern = interns.contains(new Intern(107, "Kim", 20, 3500.00));
        System.out.println("\nTreeSet contains Kim (id=107, age=20, salary=3500.00): " + containsIntern);

        // First and last interns in the sorted set
        System.out.println("\nFirst Intern: " + interns.first());
        System.out.println("Last Intern: " + interns.last());

        // Finding elements using comparison
        Intern ref = new Intern(0, "", 21, Double.MAX_VALUE);  // Dummy object for age 21
        Intern ref2 = new Intern(0, "", 23, Double.MAX_VALUE);  // Dummy object for age 23

        System.out.println("\nIntern lower than age 21: " + interns.lower(ref));
        System.out.println("Intern higher than age 21: " + interns.higher(ref));
        System.out.println("Intern at least age 21: " + interns.ceiling(ref));
        System.out.println("Intern at most age 21: " + interns.floor(ref));

        // Subset operations
        System.out.println("\nInterns with age less than 21: " + interns.headSet(ref));
        System.out.println("Interns with age 21 or greater: " + interns.tailSet(ref));
        System.out.println("Interns between age 21 and 23: " + interns.subSet(ref, ref2));

        // Removing interns based on salary
        interns.removeIf(intern -> intern.salary >= 4000);

        // Iterating over the updated TreeSet
        System.out.println("\nInterns after removal (salary >= 4000 removed):");
        Iterator<Intern> it = interns.iterator();
        while (it.hasNext()) {
            Intern in = it.next();
            System.out.println(in);
        }
    }
}
