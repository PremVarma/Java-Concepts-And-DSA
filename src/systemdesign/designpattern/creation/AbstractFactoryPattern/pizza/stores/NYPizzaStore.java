package systemdesign.designpattern.creation.AbstractFactoryPattern.pizza.stores;

import systemdesign.designpattern.creation.AbstractFactoryPattern.pizza.factory.NYPizzaIngredientFactory;
import systemdesign.designpattern.creation.AbstractFactoryPattern.pizza.factory.PizzaIngredientFactory;
import systemdesign.designpattern.creation.AbstractFactoryPattern.pizza.pizza.*;

public class NYPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(PizzaType type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        switch (type) {
            case CHEESE:
                pizza = new CheesePizza(ingredientFactory);
                pizza.setName("New York Style Cheese Pizza");
                break;
            case VEGGIE:
                pizza = new VeggiePizza(ingredientFactory);
                pizza.setName("New York Style Veggie Pizza");
                break;
            case CLAM:
                pizza = new ClamPizza(ingredientFactory);
                pizza.setName("New York Style Clam Pizza");
                break;
            case PEPPERONI:
                pizza = new PepperoniPizza(ingredientFactory);
                pizza.setName("New York Style Pepperoni Pizza");
                break;
        }
        return pizza;
    }
}