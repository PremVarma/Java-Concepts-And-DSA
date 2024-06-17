package systemdesign.designpattern.creation.FactoryPattern.pizza;

public class CheesePizza extends Pizza {
    public CheesePizza(){
        name = "Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        toppings.add("Fresh Mozzarella");
        toppings.add("Parmesan");
    }


}
