class Employee {
    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
        show();
    }

    public void show() {
        System.out.println("id: " + id + " \tName: " + name);
    }
}

public class Inheritance_Single {
    public static void main(String[] args) {
        new Employee(1, "Virat");
        new Employee(2, "Rohit");
    }
}
