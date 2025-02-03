class Animal {

    class Dog {
        public void show() {
            System.out.println("Inside Dog");
        }
    }

    private class Cat {
        public void show() {
            System.out.println("Inside Cat");
        }
    }

    public void show() {
        System.out.println("Inside Animal");
    }

    public void callCat() {
        System.out.println("\nAnimal is calling... -> Cat");
        Cat cat = new Cat();
        cat.show();
    }
}

public class MemberClass {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.show(); // Outputs: Inside Animal

        Animal.Dog dog = animal.new Dog();
        dog.show(); // Outputs: Inside Dog

        // Animal.Cat cat = animal.new Cat(); // Not possible -> Cat is private
        // cat.show();

        animal.callCat(); // Outputs: Inside Cat
    }
}
