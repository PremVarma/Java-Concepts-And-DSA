package basics.cleancode.elevator;

import java.util.ArrayList;
import java.util.List;

class ElevatorControlSystem {
    private final List<Elevator> elevators;

    public ElevatorControlSystem(int numElevators, int totalFloors, int initialFloor) {
        elevators = new ArrayList<>();
        for (int i = 1; i <= numElevators; i++) {
            elevators.add(new StandardElevator("Elevator " + i, totalFloors, initialFloor));
        }
    }

    public void requestElevator(int sourceFloor, int destinationFloor) {
        int minDistance = Integer.MAX_VALUE;
        Elevator selectedElevator = null;

        for (Elevator elevator : elevators) {
            if (elevator.getDirection() == Direction.IDLE) {
                int distance = Math.abs(elevator.getCurrentFloor() - sourceFloor);
                if (distance < minDistance) {
                    minDistance = distance;
                    selectedElevator = elevator;
                }
            }
        }

        if (selectedElevator != null) {
            selectedElevator.requestElevator(sourceFloor, destinationFloor);
            selectedElevator.move();
        } else {
            System.out.println("No available elevators. Please wait.");
        }
    }

    public void requestFloor(int elevatorIndex, int floor) {
        if (elevatorIndex >= 0 && elevatorIndex < elevators.size()) {
            Elevator elevator = elevators.get(elevatorIndex);
            elevator.requestFloor(floor);
            elevator.move();
        } else {
            System.out.println("Invalid elevator index.");
        }
    }
}
