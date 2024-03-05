package basics.cleancode.elevator;

public class Main {
    public static void main(String[] args) {
        int totalFloors = 10; // Adjust the total number of floors as needed
        int initialFloor = 0; // Set the initial floor for elevators
        ElevatorControlSystem ecs = new ElevatorControlSystem(3, totalFloors, initialFloor);

        // Simulate elevator requests and interactions
        ecs.requestElevator(1, 5);
        ecs.requestElevator(1, 10);
        ecs.requestElevator(1, 5);
        ecs.requestElevator(7, 5);
        ecs.requestElevator(7, 3);
        ecs.requestElevator(7, 5);


        // Additional simulation and testing as needed
    }
}