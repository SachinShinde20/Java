import java.util.Scanner;

class Wages {
    private int hours;

    // Parameterized Constructor
    Wages(int hours) {
        this.hours = hours;
    }

    public int calculateWages() {
        return hours * 200;
    }
}

public class Constructor_Parameterized {
    public static void main(String[] args) {

        int Salary, hours;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee Hours: ");
        hours = sc.nextInt();
        sc.close();

        Wages wages = new Wages(hours);
        Salary = wages.calculateWages();
        System.out.println("Salry: " + Salary);
    }
}
