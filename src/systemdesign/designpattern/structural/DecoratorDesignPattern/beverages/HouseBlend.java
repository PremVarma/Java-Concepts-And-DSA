package systemdesign.designpattern.structural.DecoratorDesignPattern.beverages;

public class HouseBlend implements Beverages{
    @Override
    public String getDescription() {
        return "HouseBlend";
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
