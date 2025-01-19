class Employee {
    private int id;
    private String name;

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.setId(101);
        e.setName("Radhika");

        System.out.println("Displaying Details");
        System.out.println("ID: " + e.getId() + ", " + "Name: " + e.getName() + "\n");
    }
}