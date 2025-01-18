class Example {
    Example() {
        System.out.println("Default Constructor is Called...");
    }

    Example(String str) {
        this(); // Default constructor is called here
        System.out.println(str);
    }
}

public class This_Keyword2 {
    public static void main(String[] args) {
        new Example("Parameterized Constructor Called...");
    }
}
