package systemdesign.lld.parkinglot;

import systemdesign.lld.parkinglot.parkingspot.ParkingSpot;
import systemdesign.lld.parkinglot.pricingstategy.PricingStrategy;

import java.time.Duration;
import java.time.LocalDateTime;

public class ParkingTicket {
    private static int counter = 0;
    private final int ticketNumber;
    private final Vehicle vehicle;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private final ParkingSpot parkingSpot;
    private final PricingStrategy pricingStrategy;

    public ParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot, PricingStrategy pricingStrategy) {
        this.ticketNumber = ++counter;
        this.vehicle = vehicle;
        this.entryTime = LocalDateTime.now();
        this.parkingSpot = parkingSpot;
        this.pricingStrategy = pricingStrategy;
    }

    public void setExitTime(int hours) {
        this.exitTime = LocalDateTime.now().plusHours(hours);
    }

    public int calculateCharges() {
        if (exitTime == null) {
            throw new IllegalStateException("Exit time not set");
        }
        long hours = Duration.between(entryTime, exitTime).toHours();
        return pricingStrategy.calculateCharges(hours);
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}

