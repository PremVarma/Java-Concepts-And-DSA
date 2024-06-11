package systemdesign.designpattern.behavioral.StrategyPattern.vehicle;

public class OffroadVehicle extends Vehicle{
    public OffroadVehicle() {
        super(new SportDriveStrategy());
    }
}
