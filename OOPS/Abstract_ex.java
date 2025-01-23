abstract class Animal {
    public void show() {
        System.out.println("Is Animal");
    }

    Animal() {
        System.out.println("In Constructor of Animal");
    }

    // Abstract Class Can have both abstract and concrete methods.
    abstract void makeSound();
}

class Dog extends Animal {

    public void show() {
        System.out.println("Is Dog");
    }

    public void makeSound() {
        System.out.println("Woof Woof");
    }
}

class Cat extends Animal {
    public void makeSound() {
        System.out.println("Meow Meow");
    }
}

public class Abstract_ex {
    public static void main(String[] args) {
        Animal animal;

        System.out.println("DOG: ");
        animal = new Dog();
        animal.makeSound();
        animal.show();

        System.out.println("\nCAT");
        animal = new Cat();
        animal.makeSound();
        animal.show(); // super
    }
}