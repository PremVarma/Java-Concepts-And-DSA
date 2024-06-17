package systemdesign.designpattern.creation.AbstractFactoryPattern.pizza.factory;


import systemdesign.designpattern.creation.AbstractFactoryPattern.pizza.models.*;

public interface PizzaIngredientFactory {
    Dough createDough();

    Sauce createSauce();

    Cheese createCheese();

    Veggies[] createVeggies();

    Pepperoni createPepperoni();

    Clams createClam();
}

