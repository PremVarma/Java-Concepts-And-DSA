package systemdesign.designpattern.behavioral.strategypattern;

import systemdesign.designpattern.behavioral.strategypattern.strategy.DriveStrategy;

public class Vehicle {

    DriveStrategy driveStrategy;

    public Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void drive() {
        driveStrategy.drive();
    }
}
