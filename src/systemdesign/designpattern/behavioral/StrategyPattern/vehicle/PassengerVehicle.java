package systemdesign.designpattern.behavioral.StrategyPattern.vehicle;

public class PassengerVehicle extends Vehicle {
    public PassengerVehicle() {
        super(new NormalDriveStrategy());
    }
}
