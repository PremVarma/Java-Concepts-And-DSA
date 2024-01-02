package basics.functionalInterface.bicounsumer;

import java.util.Arrays;
import java.util.List;

public class BiConsumerExample {
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 22)
        );

        PersonProcessor personProcessor = new PersonProcessor(personList);

        // Example 1: Print person details
        System.out.println("Person Details:");
        personProcessor.processPersons((name, age) ->
                System.out.println("Name: " + name + ", Age: " + age));

        // Example 2: Validate age (custom operation)
        System.out.println("\\nValidate Age:");
        personProcessor.processPersons((name, age) -> {
            if (age >= 18) {
                System.out.println(name + " is an adult.");
            } else {
                System.out.println(name + " is not an adult.");
            }
        });

    }
}
