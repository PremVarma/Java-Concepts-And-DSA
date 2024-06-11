package systemdesign.designpattern.structural.DecoratorDesignPattern.beverages;

public abstract class CondimentDecorator implements Beverages{
    protected Beverages beverage;

    public CondimentDecorator(Beverages beverage) {
        this.beverage = beverage;
    }
    public abstract String getDescription();
}
