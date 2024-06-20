package systemdesign.lld.parkinglot;

public class Vehicle {
    private final String licensePlate;
    private final VehicleType type;
    private VehicleSubType subType;

    public Vehicle(String licensePlate, VehicleType type, VehicleSubType vehicleSubType) {
        this.licensePlate = licensePlate;
        this.type = type;
        this.subType = vehicleSubType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getType() {
        return type;
    }

    public VehicleSubType getSubType() {
        return subType;
    }
}