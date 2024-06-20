package systemdesign.lld.parkinglot.parkingspot;

import systemdesign.lld.parkinglot.Entrance;
import systemdesign.lld.parkinglot.Vehicle;

public interface ParkingSpot {
    String getSpotNumber();
    boolean isAvailable();
    void assignVehicle(Vehicle vehicle);
    void removeVehicle();
    int getDistance(Entrance entrance);
}
