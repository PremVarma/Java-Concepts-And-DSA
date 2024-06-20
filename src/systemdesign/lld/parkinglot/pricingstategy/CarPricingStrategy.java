package systemdesign.lld.parkinglot.pricingstategy;

public class CarPricingStrategy implements PricingStrategy {
    @Override
    public int calculateCharges(long hours) {
        return (int) (hours * 50);
    }
}
