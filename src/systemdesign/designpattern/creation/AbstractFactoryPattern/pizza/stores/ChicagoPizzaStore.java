package systemdesign.designpattern.creation.AbstractFactoryPattern.pizza.stores;

import systemdesign.designpattern.creation.AbstractFactoryPattern.pizza.factory.ChicagoPizzaIngredientFactory;
import systemdesign.designpattern.creation.AbstractFactoryPattern.pizza.factory.PizzaIngredientFactory;
import systemdesign.designpattern.creation.AbstractFactoryPattern.pizza.pizza.*;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(PizzaType type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();

        switch (type) {
            case CHEESE:
                pizza = new CheesePizza(ingredientFactory);
                pizza.setName("Chicago Style Cheese Pizza");
                break;
            case VEGGIE:
                pizza = new VeggiePizza(ingredientFactory);
                pizza.setName("Chicago Style Veggie Pizza");
                break;
            case CLAM:
                pizza = new ClamPizza(ingredientFactory);
                pizza.setName("Chicago Style Clam Pizza");
                break;
            case PEPPERONI:
                pizza = new PepperoniPizza(ingredientFactory);
                pizza.setName("Chicago Style Pepperoni Pizza");
                break;
        }
        return pizza;
    }

}