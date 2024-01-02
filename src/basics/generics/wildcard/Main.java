package basics.generics.wildcard;

import java.util.ArrayList;
import java.util.List;

class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        List<? extends Animal> animals = List.of(new Dog(),new Cat());

        // You can add null since null is a valid value for any reference type.

        // You can't add instances of Animal, Dog, or Cat directly to the list.
        // animals.add(new Animal()); // This will not compile.
        // animals.add(new Dog()); // This will not compile.
        // animals.add(new Cat()); // This will not compile.

        // You can read elements from the list.
        Animal animal = animals.get(0);
        if (animal != null) {
            animal.makeSound();
        }
        List<Bus> buses =  new ArrayList<>();
        buses.add(new Bus());

        Print print =  new Print();
        print.setPrintValues(buses);
        //print.setPrintValuesWithoutWildcard(buses);  // only vehicle is alowed as vehicle can also have bus car or any other vehicles
    }
}

class Bus extends Vehicle{}

