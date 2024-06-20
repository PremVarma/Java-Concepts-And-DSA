package systemdesign.lld.parkinglot.parkingspot;

import systemdesign.lld.parkinglot.Entrance;
import systemdesign.lld.parkinglot.Vehicle;

import java.util.Map;

public class FourWheelerParkingSpot implements ParkingSpot {
    private String spotNumber;
    private boolean available;
    private Vehicle vehicle;
    private Map<Entrance, Integer> distances;

    public FourWheelerParkingSpot(String spotNumber, Map<Entrance, Integer> distances) {
        this.spotNumber = spotNumber;
        this.available = true;
        this.distances = distances;
    }

    @Override
    public String getSpotNumber() {
        return spotNumber;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.available = false;
        System.out.println("Vehicle " + vehicle.getLicensePlate() + " assigned to spot " + spotNumber);
    }

    @Override
    public void removeVehicle() {
        this.vehicle = null;
        this.available = true;
        System.out.println("Spot " + spotNumber + " is now available");
    }

    @Override
    public int getDistance(Entrance entrance) {
        if (distances.containsKey(entrance)) {
            return distances.get(entrance);
        }
        throw new IllegalArgumentException("Entrance '" + entrance + "' not found for spot " + spotNumber);
    }
}
