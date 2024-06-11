package systemdesign.designpattern.behavioral.StrategyPattern.vehicle;

public class SportDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Sports Drive Capability");
    }
}
