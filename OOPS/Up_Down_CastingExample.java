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

        if (parentRef instanceof Child) {
            Child childRef = (Child) parentRef;
            childRef.ChildShow();
            childRef.show();
            childRef.ParentShow();
        } else {
            System.out.println("Not a type");
        }

    }
}

/*
 * The instanceof operator in Java is a binary operator used for type
 * comparison. It checks if an object is an instance of a particular class or an
 * interface, or a subclass/implementation of that class/interface.
 * 
 * 1. Syntax: objectReference instanceof Type
 * 
 * objectReference: This is a reference to an object. It can be a variable, a
 * method call returning an object, or even null.
 * Type: This is the name of a class or an interface.
 * 
 * 
 * 
 * 2. Return Value:
 * The instanceof operator returns a boolean value:
 * 
 * true: If the objectReference is an instance of Type, or an instance of a
 * subclass of Type, or an instance of a class that implements the Type
 * interface.
 * 
 * false: Otherwise.
 * 
 * 
 * 
 * 3. How it Works (Core Concept):
 * 
 * instanceof evaluates the object's actual runtime type. It doesn't just look
 * at the declared type of the objectReference. This is crucial for
 * polymorphism.
 * 
 * Inheritance: If objectReference refers to an object of class B, and B extends
 * A, then objectReference instanceof A will return true. This is because an
 * object of a subclass is also considered an instance of its superclass.
 * 
 * Interfaces: If objectReference refers to an object of class C, and C
 * implements interface I, then objectReference instanceof I will return true.
 * 
 * null Handling: If objectReference is null, instanceof always returns false.
 * This is a useful safety feature as it prevents NullPointerExceptions.
 */