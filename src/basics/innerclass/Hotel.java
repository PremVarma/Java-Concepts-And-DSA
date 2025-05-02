package basics.innerclass;

public class Hotel {
    private String name;
    private int totalRooms;
    private int reservedRooms;

    public Hotel(String name, int totalRooms, int reservedRooms) {
        this.name = name;
        this.totalRooms = totalRooms;
        this.reservedRooms = reservedRooms;
    }

    public void reserveRoom(String guestName, int numberOfRooms) {
        class ReservationValidator {
            boolean validate() {
                if (guestName == null || guestName.isBlank()) {
                    System.out.println("Guest Name cannot be empty");
                    return false;
                }
                if (numberOfRooms <= 0) {
                    System.out.println("Rooms should be positive");
                    return false;
                }
                if (reservedRooms + numberOfRooms > totalRooms) {
                    System.out.println("Not enough rooms available");
                    return false;
                }
                return true;
            }
        }
        ReservationValidator reservationValidator = new ReservationValidator();
        if (reservationValidator.validate()) {
            reservedRooms += numberOfRooms;
            System.out.println("Reservation Confirmed for " + guestName + " for " + numberOfRooms + " rooms");
        } else {
            System.out.println("Reservation failed");
        }
    }
}
