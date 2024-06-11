package systemdesign.designpattern.structural.DecoratorDesignPattern.beverages;

public class Soy extends CondimentDecorator {

    public Soy(Beverages beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.9;
    }
}
