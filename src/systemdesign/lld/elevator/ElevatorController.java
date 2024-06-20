package systemdesign.lld.elevator;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    private List<Elevator> elevators;

    public ElevatorController(int numElevators) {
        elevators = new ArrayList<>();
        for (int i = 0; i < numElevators; i++) {
            Elevator elevator = new Elevator(i);
            elevators.add(elevator);
            Thread thread = new Thread(elevator);
            thread.start();
        }
    }

    public void addRequest(int fromFloor, int toFloor) {
        Request request = new Request(fromFloor, toFloor);
        Elevator bestElevator = findBestElevator(request);
        bestElevator.addRequest(request);
    }

    private Elevator findBestElevator(Request request) {
        return elevators.stream()
                .min((e1, e2) -> {
                    // Check if elevator 1 is eligible
                    boolean e1Eligible = ((e1.getDirection() == Direction.IDLE) && e2.getDirection() != request.getDirection())
                            || ((e1.getDirection() == request.getDirection() && e1.getCurrentFloor() <= request.getFromFloor()));

                    // Check if elevator 2 is eligible
                    boolean e2Eligible = ((e2.getDirection() == Direction.IDLE) && e1.getDirection() != request.getDirection())
                            || ((e2.getDirection() == request.getDirection() && e2.getCurrentFloor() <= request.getFromFloor()));

                    // If e1 is eligible and e2 is not, e1 should come first
                    if (e1Eligible && !e2Eligible) return -1;
                    // If e2 is eligible and e1 is not, e2 should come first
                    if (!e1Eligible && e2Eligible) return 1;

                    // If both are eligible or both are not eligible, compare their distances to the requested floor
                    return Integer.compare(Math.abs(e1.getCurrentFloor() - request.getFromFloor()), Math.abs(e2.getCurrentFloor() - request.getFromFloor()));
                })
                .orElseThrow();
    }


    public void stopElevators() {
        for (Elevator elevator : elevators) {
            elevator.stop();
        }
    }

    public void printStatus() {
        for (Elevator elevator : elevators) {
            System.out.println(elevator.getStatus());
            if (elevator.isIDLE()) {
                elevator.setDirection(Direction.IDLE);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ElevatorController controller = new ElevatorController(2);

        // Adding initial test requests
        controller.addRequest(9, 2);
        controller.addRequest(5, 1);
        controller.addRequest(0, 6);
        controller.addRequest(7, 3);
        controller.addRequest(4, 8);
        controller.addRequest(9, 0);

        // Simulate adding new requests dynamically
        new Thread(() -> {
            try {
                Thread.sleep(5000);
                controller.addRequest(3, 7);
                controller.addRequest(6, 1);
                controller.addRequest(2, 7);
                controller.addRequest(2, 0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

//        new Thread(() -> {
//            try {
//                while (true) {
//                    Thread.sleep(10000);
//                    controller.addRequest(2, 9);
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();


        // Periodically print elevator status
        new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(1000);
                    controller.printStatus();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}


