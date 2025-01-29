class Employee {
    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Company extends Employee {
    Company(int id, String name) {
        super(id, name);
    }

    public void getEmployeeInfo() {
        System.out.println("Id: " + id + ",\tName: " + name);
    }
}

public class Inheritance_Single {
    public static void main(String[] args) {
        Company company = new Company(1, "Viraj");
        company.getEmployeeInfo();
    }
}
