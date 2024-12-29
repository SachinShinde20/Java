class CopyExample {
    private int id;
    private String name;

    // Setters
    // Parameterized Constructor
    CopyExample(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Copy Constructor
    CopyExample(CopyExample other) {
        this.id = other.id;
        this.name = other.name;
    }

    // Getters
    public void show() {
        System.out.println("Id: " + id + ", Name: " + name);
    }
}

public class Constructor_Copy {
    public static void main(String[] args) {
        CopyExample original = new CopyExample(101, "Raj");
        original.show();

        CopyExample copy = new CopyExample(original);
        copy.show();
    }
}
