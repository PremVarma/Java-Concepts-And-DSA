package systemdesign.designpattern.behavioral.strategypattern;

import systemdesign.designpattern.behavioral.strategypattern.strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle{
    public GoodsVehicle() {
        super(new NormalDriveStrategy());
    }
}
