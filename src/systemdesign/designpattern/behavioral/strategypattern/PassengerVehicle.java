package systemdesign.designpattern.behavioral.strategypattern;

import systemdesign.designpattern.behavioral.strategypattern.strategy.NormalDriveStrategy;

public class PassengerVehicle extends Vehicle {
    public PassengerVehicle() {
        super(new NormalDriveStrategy());
    }
}
