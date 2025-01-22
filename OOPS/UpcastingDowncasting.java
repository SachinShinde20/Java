class Animal {
    public void speak() {
        System.out.println("Inside Animal");
    }
}

class Dog extends Animal {
    public void speak() {
        System.out.println("Woof Woof");
    }

    public void growl() {
        System.out.println("Grrrrr");
    }
}

public class UpcastingDowncasting {
    public static void main(String[] args) {

        System.out.println("\n========= Upcasting =========");
        // Upcasting - 1
        Animal animal = new Dog();
        animal.speak();
        // animal.growl(); // Error- The method growl() is undefined for the type Animal

        // Upcasting - 2
        Dog dog = new Dog();
        Animal animal2 = dog;
        animal2.speak();
        // animal2.growl(); //Error- The method growl() is undefined for the type Animal

        System.out.println("\n========= Downcasting =========");
        /*
         * Not Valid -
         * Exception in thread "main" java.lang.ClassCastException: class Animal cannot
         * be cast to class Dog (Animal and Dog are in unnamed module of loader 'app')
         * 
         * Dog dog2 = (Dog) new Animal();
         * dog2.speak();
         * // dog2.growl();
         * 
         * Animal animal3 = new Animal();
         * Dog dog3 = (Dog) animal3;
         * dog3.speak();
         * // dog3.growl();
         */

        // Downcasting - 1
        Animal animal4 = new Dog(); // Upcasting - requires for downcasting
        Dog dog4 = (Dog) animal4;
        dog4.speak();
        dog4.growl();
    }
}

/*
 * Upcasting and Downcasting in Java
 * 
 * 1. Upcasting
 * Definition:
 * Upcasting is the process of converting a subclass type reference to a
 * superclass type reference. It is an implicit operation where a subclass
 * object is treated as a superclass object.
 * 
 * Key Characteristics:
 * Always Valid:
 * 
 * Upcasting is always allowed and does not require explicit casting.
 * The compiler automatically converts a subclass reference to a superclass
 * reference.
 * Implicit Casting:
 * 
 * The Java runtime system handles the casting, so no additional syntax is
 * needed.
 * Polymorphism:
 * 
 * Upcasting is primarily used to achieve runtime polymorphism.
 * It allows invoking overridden methods using a superclass reference.
 * Access Control:
 * 
 * After upcasting, only the methods and variables available in the superclass
 * are accessible.
 * If the subclass has overridden methods, the overridden versions will be
 * executed at runtime.
 * 
 * Use Cases of Upcasting:
 * Polymorphism: To treat different subclasses uniformly using superclass
 * references.
 * Collections: Store subclass objects in a collection of superclass type.
 * 
 * 
 * 
 * 
 * 2. Downcasting
 * Definition:
 * Downcasting is the process of converting a superclass type reference back to
 * a subclass type reference. It requires explicit casting and is generally used
 * to regain access to subclass-specific features.
 * 
 * Key Characteristics:
 * Requires Explicit Casting:
 * 
 * The syntax (SubclassType) is used to explicitly cast the superclass reference
 * to the subclass type.
 * Runtime Check:
 * 
 * Downcasting is checked at runtime by the Java Virtual Machine (JVM). If the
 * object being downcasted is not actually an instance of the subclass, a
 * ClassCastException is thrown.
 * Risk of Errors:
 * 
 * Improper downcasting (e.g., downcasting an object that was not originally
 * upcasted) can result in runtime exceptions.
 * Prerequisite of Upcasting:
 * 
 * A reference must first be upcasted before it can be downcasted.
 * 
 * 4. Real-World Analogy
 * Upcasting: Treating a dog as an animal. You can still identify it as an
 * animal, but you lose specific "dog" behaviors (e.g., barking).
 * Downcasting: Taking that same animal and specifying that it is a dog,
 * regaining access to its specific "dog" behaviors.
 */