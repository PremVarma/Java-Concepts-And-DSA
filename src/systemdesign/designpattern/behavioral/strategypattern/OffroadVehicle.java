package systemdesign.designpattern.behavioral.strategypattern;

import systemdesign.designpattern.behavioral.strategypattern.strategy.SportDriveStrategy;

public class OffroadVehicle extends Vehicle{
    public OffroadVehicle() {
        super(new SportDriveStrategy());
    }
}
