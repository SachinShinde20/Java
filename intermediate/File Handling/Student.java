import java.io.Serializable;

// 🔹 Serializable class for Student object
class Student implements Serializable {
    private static final long serialVersionUID = 1L; // Ensures compatibility during deserialization

    private int id;
    private String name;
    private String department;

    public Student(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // 🔹 Overriding toString() for better object representation
    @Override
    public String toString() {
        return "Student { ID: " + id + ", Name: " + name + ", Department: " + department + " }";
    }
}