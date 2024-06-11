package systemdesign.designpattern.structural.DecoratorDesignPattern.beverages;

public class Milk extends CondimentDecorator {
    public Milk(Beverages beverages) {
        super(beverages);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.10;
    }
}
