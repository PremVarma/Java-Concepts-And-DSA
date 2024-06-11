package systemdesign.designpattern.behavioral.StrategyPattern.vehicle;

public class SportsVehicle extends Vehicle {
    public SportsVehicle() {
        super(new SportDriveStrategy());
    }
}
