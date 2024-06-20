package systemdesign.lld.parkinglot.pricingstategy;

public class ScooterPricingStrategy implements PricingStrategy {
    @Override
    public int calculateCharges(long hours) {
        return (int) (hours * 4);
    }
}
