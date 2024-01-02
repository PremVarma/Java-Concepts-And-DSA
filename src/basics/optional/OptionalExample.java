package basics.optional;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class OptionalExample {
    public static void main(String[] args) {
        // Example 1: Creating Optionals
        Optional<String> nonNullOptional = Optional.of("Hello");
        Optional<String> nullableOptional = Optional.ofNullable(null);

        // Example 2: Checking if a value is present
        if (nonNullOptional.isPresent()) {
            System.out.println("Value is present: " + nonNullOptional.get());
        }

        // Example 3: Executing an action if a value is present
        Consumer<String> printValue = value -> System.out.println("Value is present: " + value);
        nullableOptional.ifPresent(printValue);

        // Example 4: Providing a default value
        String result1 = nonNullOptional.orElse("Default Value");
        Supplier<String> defaultValueSupplier = () -> "Default Value";
        String result2 = nullableOptional.orElseGet(defaultValueSupplier);

        // Example 5: Transforming the value
        Optional<String> uppercased = nonNullOptional.map(String::toUpperCase);

        // Example 6: Filtering the value
        Optional<String> filtered = nonNullOptional.filter(value -> value.length() > 5);

        // Example 7: Throwing an exception if the value is not present
        String result3 = nonNullOptional.orElseThrow(() -> new IllegalArgumentException("Value is not present"));

        // Displaying results
        System.out.println("Result 1: " + result1);
        System.out.println("Result 2: " + result2);
        System.out.println("Uppercased Value: " + uppercased.orElse("No value for transformation"));
        System.out.println("Filtered Value: " + filtered.orElse("No value for filtering"));
        System.out.println("Result 3: " + result3);
    }
}

