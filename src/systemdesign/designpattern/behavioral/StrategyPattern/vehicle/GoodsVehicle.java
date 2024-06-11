package systemdesign.designpattern.behavioral.StrategyPattern.vehicle;

public class GoodsVehicle extends Vehicle{
    public GoodsVehicle() {
        super(new NormalDriveStrategy());
    }
}
