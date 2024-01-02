package basics.functionalInterface.bicounsumer;

import java.util.List;
import java.util.function.BiConsumer;

public class PersonProcessor {
    private final List<Person> persons;

    public PersonProcessor(List<Person> persons) {
        this.persons = persons;
    }

    // Method to apply a BiConsumer to each person
    public void processPersons(BiConsumer<String, Integer> personBiConsumer) {
        for (Person person : persons) {
            personBiConsumer.accept(person.getName(), person.getAge());
        }
    }
}