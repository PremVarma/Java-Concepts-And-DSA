package systemdesign.lld.parkinglot.parkingspot.factory;

import systemdesign.lld.parkinglot.Entrance;
import systemdesign.lld.parkinglot.parkingspot.ParkingSpot;
import systemdesign.lld.parkinglot.parkingspot.TwoWheelerParkingSpot;

import java.util.Map;

public class TwoWheelerParkingSpotFactory implements ParkingSpotFactory {
    @Override
    public ParkingSpot createParkingSpot(String spotNumber, Map<Entrance, Integer> distances) {
        return new TwoWheelerParkingSpot(spotNumber, distances);
    }
}
