package systemdesign.designpattern.creation.FactoryPattern.pizza;

public class ClamPizza extends Pizza{
    public ClamPizza() {
        name = "Clam Pizza";
        dough = "Thin Crust Dough";
        sauce = "White garlic sauce";
        toppings.add("Clams");
        toppings.add("Grated parmesan cheese");
    }
}
