package basics.streams;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Order {
    private List<Item> items;

    public Order(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }
}

class Item {
    private String name;
    private BigDecimal price;
    private boolean inStock;
    private String category;

    public Item(String name, BigDecimal price, boolean inStock, String category) {
        this.name = name;
        this.price = price;
        this.inStock = inStock;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public String getCategory() {
        return category;
    }
}

public class StreamComplexExample {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order(Arrays.asList(
                        new Item("Laptop", new BigDecimal("1200.00"), true, "Electronics"),
                        new Item("Chair", new BigDecimal("100.00"), true, "Furniture"),
                        new Item("Book", new BigDecimal("20.00"), false, "Books")
                )),
                new Order(Arrays.asList(
                        new Item("Desk", new BigDecimal("300.00"), true, "Furniture"),
                        new Item("Tablet", new BigDecimal("800.00"), true, "Electronics"),
                        new Item("Book", new BigDecimal("25.00"), true, "Books")
                )),
                new Order(Arrays.asList(
                        new Item("Chair", new BigDecimal("120.00"), true, "Furniture"),
                        new Item("Laptop", new BigDecimal("1500.00"), false, "Electronics"),
                        new Item("Book", new BigDecimal("15.00"), true, "Books")
                ))
        );

        Map<String, Double> averagePriceByCategory = orders.stream()
                .flatMap(order -> order.getItems().stream())
                .filter(Item::isInStock)
                .collect(Collectors.groupingBy(Item::getCategory,
                        Collectors.averagingDouble(item -> item.getPrice().doubleValue())));

        System.out.println("Average Price by Category: " + averagePriceByCategory);
    }
}