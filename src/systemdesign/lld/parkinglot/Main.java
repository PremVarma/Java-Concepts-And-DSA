package systemdesign.lld.parkinglot;

import systemdesign.lld.parkinglot.parkingspot.factory.*;
import systemdesign.lld.parkinglot.paymentstrategy.CashPayment;
import systemdesign.lld.parkinglot.paymentstrategy.CreditCardPayment;

import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        // Initialize the parking lot
        ParkingLot parkingLot = ParkingLot.getInstance("Main Street Parking", "Borivali West");

        // Create factories for parking spots
        ParkingSpotFactory twoWheelerFactory = new TwoWheelerParkingSpotFactory();
        ParkingSpotFactory fourWheelerFactory = new FourWheelerParkingSpotFactory();

        // Add parking spots with distances from entrances
        Map<Entrance, Integer> distances1 = new HashMap<>();
        distances1.put(Entrance.ENTRANCE_1, 10);
        distances1.put(Entrance.ENTRANCE_2, 20);
        parkingLot.addParkingSpot(twoWheelerFactory.createParkingSpot("A1", distances1));

        Map<Entrance, Integer> distances2 = new HashMap<>();
        distances2.put(Entrance.ENTRANCE_1, 5);
        distances2.put(Entrance.ENTRANCE_2, 15);
        parkingLot.addParkingSpot(fourWheelerFactory.createParkingSpot("B1", distances2));

        Map<Entrance, Integer> distances3 = new HashMap<>();
        distances2.put(Entrance.ENTRANCE_1, 7);
        distances2.put(Entrance.ENTRANCE_2, 7);
        parkingLot.addParkingSpot(fourWheelerFactory.createParkingSpot("C1", distances2));

        simulateParking(parkingLot);
    }

    private static void simulateParking(ParkingLot parkingLot) {
        // Vehicle enters the parking lot
        Vehicle vehicle1 = new Vehicle("ABC123", VehicleType.TWO_WHEELER, VehicleSubType.MOTORBIKE);
        ParkingTicket ticket1 = parkingLot.issueTicket(vehicle1, Entrance.ENTRANCE_1);
        System.out.println("Issued ticket number: " + ticket1.getTicketNumber());

        // Simulate some time passing (e.g., 2 hours)
        try {
            Thread.sleep(2000); // Simulate 2 hours of parking
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // Another vehicle enters the parking lot
        Vehicle vehicle2 = new Vehicle("XYZ789", VehicleType.FOUR_WHEELER, VehicleSubType.CAR);
        ParkingTicket ticket2 = parkingLot.issueTicket(vehicle2, Entrance.ENTRANCE_2);
        System.out.println("Issued ticket number: " + ticket2.getTicketNumber());

        // Simulate some time passing (e.g., 3 hours)
        try {
            Thread.sleep(3000); // Simulate 3 hours of parking
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Vehicle 2 exits the parking lot
        parkingLot.closeTicket(ticket2, new CashPayment());
        System.out.println("Vehicle " + vehicle2.getLicensePlate() + " has exited.");

        // Vehicle 1 exits the parking lot
        parkingLot.closeTicket(ticket1, new CreditCardPayment());
        System.out.println("Vehicle " + vehicle1.getLicensePlate() + " has exited.");
    }
}
