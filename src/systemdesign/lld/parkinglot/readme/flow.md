
### Flow Diagram

```plaintext
+--------------------+          +------------------+          +-----------------+
|     Vehicle        |          |  ParkingLot      |          |  ParkingSpot    |
+--------------------+          +------------------+          +-----------------+
        |                              |                          |
        |--Enters--------------------->|                          |
        |                              |                          |
        |                              |--FindAvailableSpot------>|--CheckAvailability
        |                              |                          |  |
        |                              |<------AssignSpot---------|  |
        |                              |                          |  |
        |<-----IssueTicket-------------|                          |  |
        |      (contains)              |                          |  |
        |       TicketNumber, EntryTime|                          |  |
        |                              |                          |  |
        |                              |                          |  |
        |                              |                          |  |
        |                              |                          |  |
        |--Exit------------------------|                          |  |
        |                              |                          |  |
        |                              |--FindTicket--------------|  |
        |                              |                          |  |
        |                              |--SetExitTime             |  |
        |                              |                          |  |
        |                              |--CalculateCharges        |  |
        |                              |                          |  |
        |                              |--ProcessPayment          |  |
        |                              |                          |  |
        |                              |--RemoveVehicleFromSpot-->|--ReleaseSpot
        |                              |                          |  |
        |<--CloseTicket----------------|                          |  |
        |                              |                          |  |
+--------------------+          +------------------+          +-----------------+
|   ParkingTicket    |          |    Payment       |          |     User        |
+--------------------+          +------------------+          +-----------------+
|   TicketNumber     |          |   Amount         |          |  Name           |
|   EntryTime        |          |   PaymentMethod  |          |  Role           |
|   ExitTime         |          |   ProcessPayment |          +-----------------+
+--------------------+          +------------------+          
```

### Flow Steps

1. **Vehicle Enters:**
    - A vehicle enters the parking lot.
    - The `ParkingLot` checks for an available spot suitable for the vehicle's type.

2. **Assign Spot:**
    - The `ParkingLot` assigns an available parking spot to the vehicle.
    - A `ParkingTicket` is issued containing the ticket number, entry time, and assigned parking spot details.

3. **Vehicle Exit:**
    - The vehicle exits the parking lot.
    - The `ParkingLot` finds the ticket associated with the vehicle.
    - The exit time is set on the ticket.

4. **Calculate Charges:**
    - The `ParkingLot` calculates the parking charges based on the entry and exit times.
    - A `Payment` is processed using the specified payment method.

5. **Release Spot:**
    - The vehicle is removed from the parking spot.
    - The parking spot is marked as available.

### Explanation of Components

- **Vehicle:** Represents the vehicle entering and exiting the parking lot.
- **ParkingLot:** Manages parking spots, tickets, and overall operations of the parking lot.
- **ParkingSpot:** Represents individual parking spots and their availability.
- **ParkingTicket:** Represents the ticket issued to a vehicle with entry and exit times.
- **Payment:** Manages the processing of parking charges.
- **User:** Represents different roles (e.g., Admin, Attendant) who interact with the system.

This flow diagram visually represents the interactions between different components of the parking lot system and provides a clear view of the sequence of operations for vehicle entry and exit.