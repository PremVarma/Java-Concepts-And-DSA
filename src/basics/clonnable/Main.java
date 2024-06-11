package basics.clonnable;

class Person implements Cloneable {
    String name;
    int age;
    Address address;

    Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // Overriding the clone method to make a shallow copy
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Address {
    String city;
    String country;

    Address(String city, String country) {
        this.city = city;
        this.country = country;
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Address address = new Address("New York", "USA");
            Person original = new Person("John", 25, address);
            Person copy = (Person) original.clone();

            // Display original and cloned objects
            System.out.println("Original Person: " + original.name + ", " + original.age + ", " + original.address.city);
            System.out.println("Cloned Person: " + copy.name + ", " + copy.age + ", " + copy.address.city);

            // Modify the address of the original person
            original.address.city = "Los Angeles";

            // Display again to see if clone is affected
            System.out.println("After modifying the original's address:");
            System.out.println("Original Person: " + original.name + ", " + original.age + ", " + original.address.city);
            System.out.println("Cloned Person: " + copy.name + ", " + copy.age + ", " + copy.address.city);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

