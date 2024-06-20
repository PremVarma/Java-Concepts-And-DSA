package systemdesign.lld.parkinglot.parkingspot.factory;

import systemdesign.lld.parkinglot.Entrance;
import systemdesign.lld.parkinglot.parkingspot.ParkingSpot;

import java.util.Map;

public interface ParkingSpotFactory {
    ParkingSpot createParkingSpot(String spotNumber, Map<Entrance, Integer> distances);
}
