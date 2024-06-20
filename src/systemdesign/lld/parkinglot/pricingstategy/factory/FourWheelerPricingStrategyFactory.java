package systemdesign.lld.parkinglot.pricingstategy.factory;

import systemdesign.lld.parkinglot.VehicleSubType;
import systemdesign.lld.parkinglot.pricingstategy.CarPricingStrategy;
import systemdesign.lld.parkinglot.pricingstategy.PricingStrategy;
import systemdesign.lld.parkinglot.pricingstategy.TruckPricingStrategy;

public class FourWheelerPricingStrategyFactory extends PricingStrategyFactory {
    @Override
    public PricingStrategy createPricingStrategy(VehicleSubType vehicleSubType) {
        return switch (vehicleSubType) {
            case CAR -> new CarPricingStrategy();
            case TRUCK -> new TruckPricingStrategy();
            default -> throw new IllegalArgumentException("Invalid sub-type for four-wheeler");
        };
    }
}
