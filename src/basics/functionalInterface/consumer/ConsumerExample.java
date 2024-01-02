package basics.functionalInterface.consumer;

import java.util.Arrays;
import java.util.List;

public class ConsumerExample {
    public static void main(String[] args) {
        List<Product> productList = Arrays.asList(
                new Product("Laptop", 1200.0),
                new Product("Smartphone", 800.0),
                new Product("Headphones", 100.0)
        );

        ProductConsumer productConsumer = new ProductConsumer(productList);

        // Example 1: Print product names
        System.out.println("Product Names:");
        productConsumer.processProducts(product -> System.out.println(product.getName()));

        // Example 2: Apply a discount of 10%
        System.out.println("\\nDiscounted Prices:");
        productConsumer.processProducts(product -> {
            double discountedPrice = product.getPrice() * 0.9;
            System.out.println(product.getName() + ": " + discountedPrice);
        });

        // Example 3: Perform any other custom operation
        System.out.println("\\nCustom Operation:");
        productConsumer.processProducts(product -> {
            // Perform any custom operation here
            System.out.println("Processing: " + product.getName());
        });
    }
}
