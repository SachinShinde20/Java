class University {
    private static String uniName = "Tech University";

    // Static nested class
    static class Department {
        void showDept() {
            System.out.println("Department of Computer Science at " + uniName);
        }
    }
}

public class StaticClass {
    public static void main(String[] args) {
        // Inner class does not require an instance of the outer class.
        University.Department csDept = new University.Department();
        csDept.showDept();
    }
}
