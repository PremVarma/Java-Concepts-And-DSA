package systemdesign.lld.parkinglot;

import systemdesign.lld.parkinglot.parkingspot.ParkingSpot;
import systemdesign.lld.parkinglot.paymentstrategy.PaymentStrategy;
import systemdesign.lld.parkinglot.pricingstategy.PricingStrategy;
import systemdesign.lld.parkinglot.pricingstategy.factory.FourWheelerPricingStrategyFactory;
import systemdesign.lld.parkinglot.pricingstategy.factory.PricingStrategyFactory;
import systemdesign.lld.parkinglot.pricingstategy.factory.TwoWheelerPricingStrategyFactory;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static ParkingLot parkingLotInstance;
    private String name;
    private String address;
    private List<ParkingSpot> parkingSpots;
    private List<ParkingTicket> parkingTickets;

    public ParkingLot(String name, String address) {
        this.name = name;
        this.address = address;
        this.parkingSpots = new ArrayList<>();
        this.parkingTickets = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance(String name, String address) {
        if (parkingLotInstance == null) {
            parkingLotInstance = new ParkingLot(name, address);
        }
        return parkingLotInstance;
    }

    public void addParkingSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
    }

    public ParkingTicket issueTicket(Vehicle vehicle, Entrance entrance) {
        ParkingSpot parkingSpot = findNearestSpot(entrance);
        if (parkingSpot == null) {
            throw new IllegalStateException("No available parking spots at entrance " + entrance);
        }
        PricingStrategyFactory pricingStrategyFactory;
        switch (vehicle.getType()) {
            case TWO_WHEELER -> {
                pricingStrategyFactory = new TwoWheelerPricingStrategyFactory();
                break;
            }
            case FOUR_WHEELER -> {
                pricingStrategyFactory = new FourWheelerPricingStrategyFactory();
                break;
            }
            default -> throw new IllegalStateException("Unsupported vehicle type " + vehicle.getType());
        }

        PricingStrategy pricingStrategy = pricingStrategyFactory.createPricingStrategy(vehicle.getSubType());
        ParkingTicket parkingTicket = new ParkingTicket(vehicle, parkingSpot, pricingStrategy);
        parkingTickets.add(parkingTicket);
        parkingSpot.assignVehicle(vehicle);
        return parkingTicket;
    }

    public void closeTicket(ParkingTicket ticket, PaymentStrategy paymentStrategy) {
        ticket.setExitTime(1);
        int charges = ticket.calculateCharges();
        paymentStrategy.processPayment(charges);
        ticket.getParkingSpot().removeVehicle();
    }


    public List<ParkingTicket> getTickets() {
        return parkingTickets;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    private ParkingSpot findNearestSpot(Entrance entrance) {
        ParkingSpot nearestSpot = null;
        int minDistance = Integer.MAX_VALUE;

        for (ParkingSpot spot : parkingSpots) {
            int distance = spot.getDistance(entrance);
            if (spot.isAvailable() && distance < minDistance) {
                minDistance = distance;
                nearestSpot = spot;
            }
        }
        return nearestSpot;
    }
}
