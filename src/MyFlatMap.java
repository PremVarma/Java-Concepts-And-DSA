import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class MyFlatMap {
    public static <T, R> List<R> flatMap(List<T> source, Function<T, List<R>> mapper) {
        List<R> result = new ArrayList<>();

        // Iterate over each element in the source
        for (T element : source) {
            // Apply the mapper to get a List<R>
            List<R> mappedList = mapper.apply(element);
            // Add all elements of the mappedList to the result
            result.addAll(mappedList);
        }

        return result;
    }

    public static void main(String[] args) {
        // Create the first category
        Category category1 = new Category();
        category1.name = "Shirts";

        SubCategory subCategory1 = new SubCategory();
        subCategory1.name = "Allen Solly";

        Product subProduct1 = new Product();
        subProduct1.name = "Red Shirt";
        subProduct1.price = 1000;

        Product subProduct2 = new Product();
        subProduct2.name = "White Shirt";
        subProduct2.price = 1100;

        subCategory1.products = Arrays.asList(subProduct1, subProduct2);

        Product product1 = new Product();
        product1.name = "Sweat Shirt";
        product1.price = 900;

        Product product2 = new Product();
        product2.name = "Casual Shirt";
        product2.price = 800;

        category1.products = Arrays.asList(product1, product2);
        category1.subCategories = Collections.singletonList(subCategory1);

        // Create the second category
        Category category2 = new Category();
        category2.name = "Pants";

        SubCategory subCategory2 = new SubCategory();
        subCategory2.name = "Levi's";

        Product subProduct3 = new Product();
        subProduct3.name = "Black Jeans";
        subProduct3.price = 1500;

        Product subProduct4 = new Product();
        subProduct4.name = "Blue Jeans";
        subProduct4.price = 1400;

        subCategory2.products = Arrays.asList(subProduct3, subProduct4);

        Product product3 = new Product();
        product3.name = "Cargo Pants";
        product3.price = 1200;

        Product product4 = new Product();
        product4.name = "Chinos";
        product4.price = 1100;

        category2.products = Arrays.asList(product3, product4);
        category2.subCategories = Collections.singletonList(subCategory2);

        // Add categories to a list
        List<Category> categories = Arrays.asList(category1, category2);

        // Using the custom flatMap
//        flatMap(categories, Function.identity());

//        System.out.println(flatList); // Output: [A, B, C, D, E, F]
    }
}

class Category {
    String name;
    List<Product> products = new ArrayList<>();
    List<SubCategory> subCategories = new ArrayList<>();
}

class SubCategory {
    String name;
    List<Product> products = new ArrayList<>();
}

class Product {
    String name;
    Integer price;
}
