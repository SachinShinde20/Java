class Parent {
    public void ParentShow() {
        System.out.println("Parent Method Called");
    }

    public void show() {
        System.out.println("\tIn Show of -> Parent");
    }
}

class Child extends Parent {
    public void ChildShow() {
        System.out.println("Child Method Called");
    }

    @Override
    public void show() {
        System.out.println("\tIn Show of -> Child");
    }
}

public class Up_Down_CastingExample {
    public static void main(String[] args) {
        System.out.println("\nUpCasting");
        Parent parentRef = new Child();
        parentRef.ParentShow();
        parentRef.show();
        // parentRef.ChildShow(); -> Exception

        System.out.println("\nDownCasting");
        Child childRef = (Child) parentRef;
        childRef.ChildShow();
        childRef.show();
        childRef.ParentShow();
    }
}