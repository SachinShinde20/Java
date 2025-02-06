class Student {
    int id;
    String name;
    String cource;

    public Student(int id, String name, String cource) {
        this.id = id;
        this.name = name;
        this.cource = cource;
    }

    @Override
    public String toString() {
        return "Student [ id = " + id + ", Name = " + name + ", Cource = " + cource + ", getClass() = " + getClass()
                + " ]";
    }
}

public class ToString {
    public static void main(String[] args) {

        Student student = new Student(101, "Raj", "CSE");
        Student student2 = new Student(102, "Manoj", "AIML");

        System.out.println(student.toString());
        System.out.println(student2.toString());
    }
}