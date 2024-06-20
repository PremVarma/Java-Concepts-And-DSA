package systemdesign.lld.parkinglot.pricingstategy;

public class TruckPricingStrategy implements PricingStrategy {
    @Override
    public int calculateCharges(long hours) {
        return (int) (hours * 100);
    }
}
