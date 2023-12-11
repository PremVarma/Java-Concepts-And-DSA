package systemdesign.designpattern.behavioral.strategypattern;

import systemdesign.designpattern.behavioral.strategypattern.strategy.SportDriveStrategy;

public class SportsVehicle extends Vehicle {
    public SportsVehicle() {
        super(new SportDriveStrategy());
    }
}
