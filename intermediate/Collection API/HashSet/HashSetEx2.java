import java.util.HashSet;
import java.util.Iterator;

public class HashSetEx2 {
    public static void main(String[] args) {
        // Creating a HashSet of Student objects
        HashSet<Student> hSet = new HashSet<>();

        // Adding Student objects to the HashSet
        hSet.add(new Student(2, "Ganesh", "Jadhav"));
        hSet.add(new Student(3, "Shruti", "Patil"));
        hSet.add(new Student(4, "Shravani", "Deshmukh"));
        hSet.add(new Student(5, "Rohini", "Kale"));
        hSet.add(new Student(1, "Tanmay", "Sawant"));
        hSet.add(null);
        // hSet.add(null); -> Only added Once

        // Printing the HashSet
        System.out.println("HashSet elements: " + hSet);

        // Removing null from the HashSet
        hSet.remove(null);

        // Removing a specific student based on first and last name
        boolean result = hSet.removeIf(student -> student.getFirstName().equals("Rohini") && student.getLastName().equals("Kale"));
        System.out.println("Removal Result: " + result);
        System.out.println("After Removal: " + hSet);

        // Iterating over the HashSet to modify a specific student's details
        Iterator<Student> it = hSet.iterator();
        while (it.hasNext()) {
            Student student = it.next();

            if (student.getFirstName().equals("Ganesh") && student.getLastName().equals("Jadhav")) {
                student.setFirstName("Sanket");
                student.setRollNo(5);
            }
        }

        // Printing the modified HashSet
        System.out.println("Updated HashSet: " + hSet);
    }
}
