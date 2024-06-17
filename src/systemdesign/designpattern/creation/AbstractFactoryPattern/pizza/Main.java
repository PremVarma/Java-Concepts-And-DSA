package systemdesign.designpattern.creation.AbstractFactoryPattern.pizza;

import systemdesign.designpattern.creation.AbstractFactoryPattern.pizza.pizza.Pizza;
import systemdesign.designpattern.creation.AbstractFactoryPattern.pizza.stores.PizzaStore;
import systemdesign.designpattern.creation.AbstractFactoryPattern.pizza.pizza.PizzaType;
import systemdesign.designpattern.creation.AbstractFactoryPattern.pizza.stores.ChicagoPizzaStore;
import systemdesign.designpattern.creation.AbstractFactoryPattern.pizza.stores.NYPizzaStore;

public class Main {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyStore.orderPizza(PizzaType.CHEESE);
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = chicagoStore.orderPizza(PizzaType.CHEESE);
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
    }
}
