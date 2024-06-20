package systemdesign.lld.parkinglot.pricingstategy.factory;

import systemdesign.lld.parkinglot.VehicleSubType;
import systemdesign.lld.parkinglot.pricingstategy.PricingStrategy;

public abstract class PricingStrategyFactory {
    public abstract PricingStrategy createPricingStrategy(VehicleSubType vehicleSubType);
}
