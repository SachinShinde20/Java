import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;

class Student {
    private int id;
    private String name;

    // Constructor
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Displays the list of students.
    public static void displayList(LinkedList<Student> list) {
        list.forEach(student -> System.out.println(student.id + "\t" + student.name));
    }
}

public class LinkedListEx2 {
    public static void main(String[] args) {
        LinkedList<Student> studentList = new LinkedList<>();

        // Adding students to the LinkedList
        studentList.add(new Student(5, "Rahul"));
        studentList.add(new Student(2, "Anjali"));
        studentList.add(new Student(3, "Shardul"));
        studentList.add(new Student(1, "Shradha"));
        studentList.add(new Student(4, "Jyoti"));

        // Display initial list
        System.out.println("Initial Student List:");
        Student.displayList(studentList);

        // Updating a student's name using ListIterator
        ListIterator<Student> iterator = studentList.listIterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getName().equals("Shardul")) {
                student.setName("Kishor");
            }
        }
        System.out.println("\nAfter Changing the Name 'Shardul' to 'Kishor':");
        Student.displayList(studentList);

        // Sorting the list by student ID
        System.out.println("\nSorting LinkedList by ID:");
        Collections.sort(studentList, new SortById());
        Student.displayList(studentList);

        // Sorting the list by student name
        System.out.println("\nSorting LinkedList by Name:");
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });
        Student.displayList(studentList);
    }
}

/*
 * Comparator for sorting students by ID.
 */
class SortById implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getId(), s2.getId());
    }
}