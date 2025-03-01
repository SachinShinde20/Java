import java.util.*;

/**
 * Represents an Intern with attributes id, name, age, and salary.
 */
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
        return "ID=" + id + ", Name='" + name + "', Age=" + age + ", Salary=" + salary;
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

/**
 * Comparator to sort Interns by Age, then Salary, then ID, then Name.
 */
class SortByAge implements Comparator<Intern> {
    @Override
    public int compare(Intern o1, Intern o2) {
        int status = Integer.compare(o1.age, o2.age);
        if (status != 0) return status;

        status = Double.compare(o1.salary, o2.salary);
        if (status != 0) return status;

        status = Integer.compare(o1.id, o2.id);
        if (status != 0) return status;

        return o1.name.compareTo(o2.name);
    }
}

public class TreeSetEx2 {
    public static void main(String[] args) {
        TreeSet<Intern> interns = new TreeSet<>(new SortByAge());

        // Adding Interns to the TreeSet
        interns.addAll(Arrays.asList(
                new Intern(107, "Kim", 20, 3500.00),
                new Intern(101, "Alexa", 20, 3500.00),
                new Intern(102, "Smriti", 19, 2800.50),
                new Intern(105, "Smriti", 22, 3700.00),
                new Intern(106, "Olivia", 25, 3100.50),
                new Intern(103, "David", 24, 4000.75),
                new Intern(104, "Sophia", 20, 3200.25)
        ));

        // Displaying Interns sorted by Age
        System.out.println("\nInterns Sorted by Age:");
        for (Intern intern : interns) {
            System.out.println(intern);
        }

        // Checking if an intern exists
        boolean containsIntern = interns.contains(new Intern(107, "Kim", 20, 3500.00));
        System.out.println("\nTreeSet contains Kim (ID=107, Age=20, Salary=3500.00): " + containsIntern);

        // Displaying the first and last Intern in the sorted set
        System.out.println("\nFirst Intern: " + interns.first());
        System.out.println("Last Intern: " + interns.last());

        // Finding elements using comparison
        Intern ref = new Intern(0, "", 21, Double.MAX_VALUE);  // Reference object for age 21
        Intern ref2 = new Intern(0, "", 23, Double.MAX_VALUE);  // Reference object for age 23

        System.out.println("\nIntern lower than age 21: " + interns.lower(ref));
        System.out.println("Intern higher than age 21: " + interns.higher(ref));
        System.out.println("Intern at least age 21: " + interns.ceiling(ref));
        System.out.println("Intern at most age 21: " + interns.floor(ref));

        // Subset operations
        System.out.println("\nInterns with age less than 21: " + interns.headSet(ref));
        System.out.println("Interns with age 21 or greater: " + interns.tailSet(ref));
        System.out.println("Interns between age 21 and 23: " + interns.subSet(ref, ref2));

        // Removing interns based on salary condition
        interns.removeIf(intern -> intern.salary >= 4000);

        // Displaying Interns after removal
        System.out.println("\nInterns after removal (salary >= 4000 removed):");
        for (Intern intern : interns) {
            System.out.println(intern);
        }

        System.out.println("\n**********************************************\n");

        // TreeSet sorted by Name, then ID, then Age, then Salary
        TreeSet<Intern> interns1 = new TreeSet<>(new Comparator<Intern>() {
            @Override
            public int compare(Intern o1, Intern o2) {
                int status = o1.name.compareTo(o2.name);
                if (status != 0) return status;

                status = Integer.compare(o1.id, o2.id);
                if (status != 0) return status;

                status = Integer.compare(o1.age, o2.age);
                if (status != 0) return status;

                return Double.compare(o1.salary, o2.salary);
            }
        });

        // Adding all Interns to new TreeSet with different sorting order
        interns1.addAll(interns);

        System.out.println("\tSet 1 (Sorted by Age, then Salary, then ID, then Name):");
        for (Intern intern : interns) {
            System.out.println(intern);
        }
        System.out.println("\n\tSet 2: (Sorted by Name, then ID, then Age, then Salary):");
        for (Intern intern : interns1) {
            System.out.println(intern);
        }

        // SubSet On interns1
        Intern search1 = new Intern(0, "A", 0, 0.0);
        Intern search2 = new Intern(0, "M", 0, 0.0);
        System.out.println("\nPrinting Names between A and M");
        System.out.println(interns1.subSet(search1, search2));
    }
}

/*
Question:
I have a `TreeSet<Intern>` sorted by name using the following comparator:

TreeSet<Intern> internsByName = new TreeSet<>(new Comparator<Intern>() {
    @Override
    public int compare(Intern o1, Intern o2) {
        int status = o1.name.compareTo(o2.name);
        if (status != 0) return status;

        status = Integer.compare(o1.id, o2.id);
        if (status != 0) return status;

        status = Integer.compare(o1.age, o2.age);

        return status != 0 ? status : Double.compare(o1.salary, o2.salary);
    }
});



1. Can I perform operations like `lower()`, `higher()`, `ceiling()`, `floor()`, `headSet()`, `tailSet()`, and `subSet()` based on id, age, or salary separately?
        2. How can I perform these operations based on id, age, or salary efficiently?
        3. How can I find interns whose salary falls within a given range (e.g., between 3000 and 4000)?
Answer:



        1. Can I perform `lower()`, `higher()`, `ceiling()`, `floor()`, `headSet()`, `tailSet()`, and `subSet()` based on id, age, or salary separately?
        ✅ No, not directly.
The `TreeSet` supports these operations only based on its sorting order (which is name-based in this case).

        - `lower()`, `higher()`, `ceiling()`, `floor()` will find elements based on name first, not id, age, or salary.
- `headSet()`, `tailSet()`, and `subSet()` will also work according to name-based ordering.
        - If you want to perform these operations based on id, age, or salary, you need a different sorting order.



        2. How can I perform these operations based on id, age, or salary efficiently?
        📌 Solution: Use multiple `TreeSet` instances, each sorted by a different attribute.

Create separate `TreeSet` objects for each attribute:
java
// Sorting Interns by ID
TreeSet<Intern> internsById = new TreeSet<>(new Comparator<Intern>() {
    @Override
    public int compare(Intern o1, Intern o2) {
        int status = Integer.compare(o1.id, o2.id);
        if (status != 0) return status;
        status = o1.name.compareTo(o2.name);
        if (status != 0) return status;
        status = Integer.compare(o1.age, o2.age);
        return status != 0 ? status : Double.compare(o1.salary, o2.salary);
    }
});

// Sorting Interns by Age
TreeSet<Intern> internsByAge = new TreeSet<>(new Comparator<Intern>() {
    @Override
    public int compare(Intern o1, Intern o2) {
        int status = Integer.compare(o1.age, o2.age);
        if (status != 0) return status;
        status = o1.name.compareTo(o2.name);
        if (status != 0) return status;
        status = Integer.compare(o1.id, o2.id);
        return status != 0 ? status : Double.compare(o1.salary, o2.salary);
    }
});

// Sorting Interns by Salary
TreeSet<Intern> internsBySalary = new TreeSet<>(new Comparator<Intern>() {
    @Override
    public int compare(Intern o1, Intern o2) {
        int status = Double.compare(o1.salary, o2.salary);
        if (status != 0) return status;
        status = o1.name.compareTo(o2.name);
        if (status != 0) return status;
        status = Integer.compare(o1.id, o2.id);
        return Integer.compare(o1.age, o2.age);
    }
});
Now, you can perform operations based on different attributes efficiently.

        ✅ Best Practice: Maintain multiple `TreeSet` instances, each sorted by a different attribute, to support various queries efficiently.
*/