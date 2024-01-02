package basics.streams.IntermediateOperations;

import java.util.Arrays;
import java.util.List;

public class FlatMapExample {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Java Fundamentals", Arrays.asList("Alice", "Bob")),
                new Book("Data Structures in Python", List.of("Charlie")),
                new Book("Web Development with JavaScript", Arrays.asList("Alice", "David")),
                new Book("Machine Learning Basics", Arrays.asList("Eva", "Frank"))
        );

        List<String> uniqueAuthors = books.stream()
                .flatMap(book -> book.getAuthors().stream())
                .distinct().toList();

        // Print the result
        System.out.println("Unique Authors: " + uniqueAuthors);
    }
}
