import java.util.Scanner;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void show() {
        System.out.println("Id: " + id + ",  Name: " + name);
    }
}

public class Constructor_Ex2 {
    public static void main(String[] args) {
        int id, n;
        String name;
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter No. of Students: ");
        n = sc.nextInt();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter Student " + (i + 1) + " Details: ");

            System.out.print("Enter ID : ");
            id = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter Name : ");
            name = sc.nextLine();

            students[i] = new Student(id, name);
        }
        sc.close();

        System.out.println("\nShowing Details");
        for (Student s : students) {
            s.show();
        }
    }
}
