package basics.cleancode.elevator;

import java.util.LinkedList;
import java.util.Queue;

abstract class Elevator {
    private String name;
    private int currentFloor;
    private Direction direction;
    private Queue<Request> requestedFloors;
    private int totalFloors;

    public Elevator(String name, int totalFloors, int initialFloor) {
        this.name = name;
        this.currentFloor = initialFloor;
        this.direction = Direction.IDLE;
        this.requestedFloors = new LinkedList<>();
        this.totalFloors = totalFloors;
    }

    public String getName() {
        return name;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public Queue<Request> getRequestedFloors() {
        return requestedFloors;
    }

    public int getTotalFloors() {
        return totalFloors;
    }



    public void move() {
        if (!requestedFloors.isEmpty()) {
            Request request = requestedFloors.poll();
            int destination = request.getDestinationFloor();
            int source = request.getSourceFloor();
            direction = currentFloor < destination ? Direction.UP : Direction.DOWN;
            System.out.println(name + " is moving " + direction + "from floor " + source + " to floor " + destination);

            // Update the current floor
            currentFloor = destination;

            // Check for additional requests in the same direction
            while (!requestedFloors.isEmpty() && requestedFloors.peek().getDestinationFloor() * direction.ordinal() > currentFloor * direction.ordinal()) {
                request = requestedFloors.poll();
                destination = request.getDestinationFloor();
                System.out.println(name + " is picking up an additional request to floor " + destination);
            }
        } else {
            direction = Direction.IDLE;
            System.out.println(name + " is now idle");
        }
    }

    public void requestElevator(int sourceFloor, int destinationFloor) {
        if (sourceFloor != destinationFloor) {
            if (sourceFloor > 0 && sourceFloor <= totalFloors && destinationFloor > 0 && destinationFloor <= totalFloors) {
                requestedFloors.add(new Request(sourceFloor, destinationFloor));
                move(); // Trigger the elevator to move immediately to the requested floor
            } else {
                System.out.println("Invalid floor request for " + name + ". Floors should be between 1 and " + totalFloors);
            }
        } else {
            System.out.println("Source floor and destination floor cannot be the same.");
        }
    }

    public void requestFloor(int floor) {
        if (floor > 0 && floor <= totalFloors) {
            requestedFloors.add(new Request(floor, floor));
            move(); // Trigger the elevator to move immediately to the requested floor
        } else {
            System.out.println("Invalid floor request for " + name + ". Floor should be between 1 and " + totalFloors);
        }
    }
}