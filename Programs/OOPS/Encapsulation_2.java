import java.util.Scanner;

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

public class Encapsulation_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number Of Employees: ");
        int n = sc.nextInt();

        // Create an array to store Employee objects
        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter Details of Student " + (i + 1));

            // Initialize each Employee object
            employees[i] = new Employee();

            System.out.println("Enter ID : ");
            employees[i].setId(sc.nextInt());

            sc.nextLine();

            System.out.println("Enter Name : ");
            employees[i].setName(sc.nextLine());
        }

        sc.close();

        // Display Employee information
        System.out.println("\nDisplaying Employee Information:");
        for (int i = 0; i < n; i++) {
            System.out.println("ID: " + employees[i].getId());
            System.out.println("Name: " + employees[i].getName());
        }
    }
}
