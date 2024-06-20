package systemdesign.lld.parkinglot.parkingspot.factory;

import systemdesign.lld.parkinglot.Entrance;
import systemdesign.lld.parkinglot.parkingspot.FourWheelerParkingSpot;
import systemdesign.lld.parkinglot.parkingspot.ParkingSpot;

import java.util.Map;

public class FourWheelerParkingSpotFactory implements ParkingSpotFactory {
    @Override
    public ParkingSpot createParkingSpot(String spotNumber, Map<Entrance, Integer> distances) {
        return new FourWheelerParkingSpot(spotNumber, distances);
    }
}
