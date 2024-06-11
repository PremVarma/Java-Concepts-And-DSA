package systemdesign.designpattern.structural.DecoratorDesignPattern.beverages;

public class Espresso implements Beverages{
    @Override
    public String getDescription() {
        return "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
