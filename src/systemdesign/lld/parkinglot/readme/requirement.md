
```plaintext
  +-----------------+                +-----------------+
  |    ParkingLot   |<>--------------|     ParkingSpot  |
  +-----------------+                +-----------------+
  | - name: String   | 1            * | - spotNumber: String |
  | - address: String|                | - available: boolean |
  | - parkingSpots: List<ParkingSpot>| | - vehicle: Vehicle |
  | - tickets: List<ParkingTicket>   | | - distances: Map<String, Integer> |
  +-----------------+                +-----------------+
  | + getInstance(name: String, addr |  
  | + addParkingSpot(spot: ParkingSp |
  | + issueTicket(vehicle: Vehicle,  |
  |   entrance: String): ParkingTick |
  | + closeTicket(ticket: ParkingTic |
  |   paymentStrategy: PaymentStrate |
  | + getTickets(): List<ParkingTick |
  | + getParkingSpots(): List<Parkin|
  | + getName(): String              |
  | + getAddress(): String           |
  +----------------------------------+

      +-----------------+   1    1   +-------------------+
      |   ParkingTicket |<>----------|   PricingStrategy |
      +-----------------+             +-------------------+
      | - ticketNumber: String         | + calculateCharges() |
      | - vehicle: Vehicle            |                     |
      | - entryTime: LocalDateTime    +---------------------+
      | - exitTime: LocalDateTime     |    <<interface>>    |
      | - parkingSpot: ParkingSpot    +---------------------+
      | - pricingStrategy: PricingStr |
      +-----------------+

  +-----------------+                +-----------------+
  |      Vehicle    |                |  ParkingStrategy|
  +-----------------+                +-----------------+
  | - licensePlate: String            |  <<interface>>  |
  | - type: VehicleType               | + calculateCharges() |
  | - subType: VehicleSubType         +-------------------+
  +-----------------+
```

### Explanation:

1. **ParkingLot**:
   - Manages the overall parking lot operations including parking spots, tickets, and their interactions.

2. **ParkingSpot**:
   - Represents individual parking spots with attributes like spot number, availability, assigned vehicle, and distances to entrances.

3. **PricingStrategy**:
   - Interface defining methods for different pricing strategies (`MotorbikePricingStrategy`, `ScooterPricingStrategy`, etc.) to calculate parking charges.

4. **ParkingTicket**:
   - Stores details of each issued parking ticket, including ticket number, associated vehicle, entry and exit times, assigned parking spot, and pricing strategy used.

5. **Vehicle**:
   - Represents vehicles with attributes such as license plate, type (two-wheeler or four-wheeler), and subtype (motorbike, scooter, car, truck).

This simplified class diagram removes the `User` class and focuses on the essential components directly related to the parking lot system. It maintains clarity and highlights the relationships and responsibilities of each class within the system.