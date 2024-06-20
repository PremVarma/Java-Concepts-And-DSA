package systemdesign.lld.parkinglot.pricingstategy;

public class MotorbikePricingStrategy implements PricingStrategy {
    @Override
    public int calculateCharges(long hours) {
        return (int) (hours * 5);
    }
}
