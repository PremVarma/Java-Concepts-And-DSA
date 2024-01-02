package basics.functionalInterface.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ProductConsumer {
    private final List<Product> products;

    public ProductConsumer(List<Product> products) {
        this.products = products;
    }

    // Method to apply a consumer to each product
    public void processProducts(Consumer<Product> productConsumer) {
        for (Product product : products) {
            productConsumer.accept(product);
        }
    }
}