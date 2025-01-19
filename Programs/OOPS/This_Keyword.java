class Student {
    private int id;
    private String name;

    /*
     * The JVM automatically passes the reference of the calling object to a
     * non-static method when it is invoked.
     * This is how the method get acess to this keyword
     */
    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /*
     * We can call another methods, variables of same class, use using this
     * keyword, We also can pass object by passing this to a method
     */
    public void getCall() {
        System.out.println("Inside getCall...");
        show(); // ->>> this.show(); ->>> By default "this" is present here
    }

    public void show() {
        System.out.println("id: " + id);
        System.out.println("Name: " + name + "\n");
    }
}

public class This_Keyword {
    public static void main(String[] args) {

        Student s1 = new Student(1, "Raj");
        Student s2 = new Student(2, "Roy");

        s1.getCall();
        s2.getCall();
    }
}
