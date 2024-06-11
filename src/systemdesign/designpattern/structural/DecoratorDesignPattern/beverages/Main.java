package systemdesign.designpattern.structural.DecoratorDesignPattern.beverages;

public class Main {
    public static void main(String[] args) {
        Beverages beverage = new Espresso();
        beverage = new Milk(beverage);
        beverage = new Soy(beverage);
        System.out.println(beverage.getDescription() + " $" + beverage.cost());
    }
}
