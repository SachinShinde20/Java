class Student {
    int id = 100;
    String name = "Roy";

    public void show() {
        System.out.println("id: " + id); // this.id
        System.out.println("Name: " + name); // this.name
    }
}

public class This_Keyword1 {
    int s_id = 101;
    String s_name = "Raj";

    public static void main(String[] args) {

        /*
         * A static method does not have access to the this or super keywords because:
         * this: refers to the current instance of a class, and static methods belong to
         * the class, not to any specific instance.
         * super: is used to refer to the superclass of the current object, and since
         * there is no instance in a static context, super is not applicable.
         * >>>>>>>>>>>>>> Due to this we can't access s_id and s_name
         */

        /*
         * * Error:
         * System.out.println("id: " + s_id);
         * System.out.println("Name: " + s_name);
         */

        new Student().show();
    }
}
