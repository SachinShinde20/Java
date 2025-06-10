// ✅ Definition (1-liner):
// Dynamic Method Dispatch is the process where Java decides at runtime which overridden method to call 
// — based on the actual object type, not the reference type.

class Animal {
    void speak() {
        System.out.println("Animal speaks");
    }
}

class Dog extends Animal {
    void speak() {
        System.out.println("Dog barks");
    }
}

public class DynamicMethodDispatch {
    public static void main(String[] args) {
        Animal a = new Dog(); // Upcasting
        a.speak(); // Dynamic Method Dispatch
    }
}

// ✅ Output:
// Dog barks

// ✅ How to Say in Interview:
// In Java, when a superclass reference points to a subclass object and an
// overridden method is called, the JVM decides at runtime which method to
// execute.
// This is called Dynamic Method Dispatch,
// it's the core of runtime polymorphism in Java.