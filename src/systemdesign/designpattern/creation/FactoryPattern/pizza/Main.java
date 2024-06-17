package systemdesign.designpattern.creation.FactoryPattern.pizza;

public class Main {
    public static void main(String[] args) {
        SimplePizzaFactory simplePizzaFactory = new SimplePizzaFactory();
        PizzaStore pizzaStore = new PizzaStore(simplePizzaFactory);
        Pizza pizza = pizzaStore.orderPizza("cheese");
        System.out.println("We ordered a " + pizza.getName() + "\n");

        pizza = pizzaStore.orderPizza("veggie");
        System.out.println("We ordered a " + pizza.getName() + "\n");
    }
}
