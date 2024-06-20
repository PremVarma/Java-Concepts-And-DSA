package systemdesign.lld.parkinglot.pricingstategy.factory;

import systemdesign.lld.parkinglot.VehicleSubType;
import systemdesign.lld.parkinglot.pricingstategy.MotorbikePricingStrategy;
import systemdesign.lld.parkinglot.pricingstategy.PricingStrategy;
import systemdesign.lld.parkinglot.pricingstategy.ScooterPricingStrategy;

public class TwoWheelerPricingStrategyFactory extends PricingStrategyFactory {
    @Override
    public PricingStrategy createPricingStrategy(VehicleSubType vehicleSubType) {
        return switch (vehicleSubType) {
            case MOTORBIKE -> new MotorbikePricingStrategy();
            case SCOOTER -> new ScooterPricingStrategy();
            default -> throw new IllegalArgumentException("Invalid sub-type for two-wheeler");
        };
    }
}
