package systemdesign.lld.elevator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

public class Elevator implements Runnable {
    private int id;
    private int currentFloor;
    private Direction direction;
    private final PriorityBlockingQueue<Integer> upRequests;
    private final PriorityBlockingQueue<Integer> downRequests;
    private final List<Integer> pendingTasks;
    private boolean running;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.pendingTasks = new ArrayList<>();
        this.upRequests = new PriorityBlockingQueue<>(11, (a, b) -> a - b);
        this.downRequests = new PriorityBlockingQueue<>(11, (a, b) -> b - a);
        this.running = true;
    }

    public void addRequest(Request request) {
        int toFloor = request.getToFloor();
        int fromFloor = request.getFromFloor();
        Direction reqDirection = request.getDirection();

        if (direction == Direction.IDLE && reqDirection == Direction.DOWN) {
            direction = Direction.UP;
            upRequests.offer(fromFloor);
            downRequests.offer(toFloor);
            return;
        } else if (direction == Direction.IDLE) {
            direction = reqDirection;
        }

        if (direction == Direction.UP && reqDirection == Direction.UP) {
            if (fromFloor >= currentFloor && toFloor >= currentFloor) {
                upRequests.offer(toFloor);
                upRequests.offer(fromFloor);
            } else {
                pendingTasks.add(toFloor);
                pendingTasks.add(fromFloor);
            }
        } else if (direction == Direction.UP && reqDirection == Direction.DOWN) {
            downRequests.offer(fromFloor);
            downRequests.offer(toFloor);
        } else if (direction == Direction.DOWN && reqDirection == Direction.DOWN) {
            if (fromFloor <= currentFloor) {
                downRequests.offer(fromFloor);
                downRequests.offer(toFloor);
            } else {
                pendingTasks.add(fromFloor);
                pendingTasks.add(toFloor);
            }
        } else if (direction == Direction.DOWN && reqDirection == Direction.UP) {
            upRequests.offer(fromFloor);
            upRequests.offer(toFloor);
        }
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                if (direction == Direction.UP) {
                    processUpRequests();
                } else if (direction == Direction.DOWN) {
                    processDownRequests();
                } else if (!upRequests.isEmpty()) {
                    direction = Direction.UP;
                } else if (!downRequests.isEmpty()) {
                    direction = Direction.DOWN;
                } else {
                    direction = Direction.IDLE;
                }
                Thread.sleep(1000); // Move 1 floor per second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void processUpRequests() {
        int lastElement = -1;
        while (!upRequests.isEmpty()) {
            int request = upRequests.peek();
            if (currentFloor < request) {
                currentFloor++;
                System.out.println("Elevator " + id + " moving up to floor " + currentFloor);
            } else if (currentFloor == request) {
                lastElement = upRequests.peek();
                upRequests.poll();
                System.out.println("Elevator " + id + " reached floor " + currentFloor + " and processing request to floor " + request);
            }

            if (upRequests.isEmpty() && !downRequests.isEmpty() && lastElement < downRequests.peek()) {
                upRequests.add(downRequests.poll());
            }
        }
        if (!downRequests.isEmpty()) {
            upRequests.addAll(pendingTasks);
            pendingTasks.clear();
            direction = Direction.DOWN;
        }
    }

    private void processDownRequests() {
        int lastElement = -1;
        while (!downRequests.isEmpty()) {
            int request = downRequests.peek();
            if (currentFloor > request) {
                currentFloor--;
                System.out.println("Elevator " + id + " moving down to floor " + currentFloor);
            } else if (currentFloor == request) {
                lastElement = downRequests.peek();
                downRequests.poll();
                System.out.println("Elevator " + id + " reached floor " + currentFloor + " and processing request to floor " + request);
            }

            if (downRequests.isEmpty() && !upRequests.isEmpty() && lastElement > upRequests.peek()) {
                downRequests.add(upRequests.poll());
            }
        }
        if (!upRequests.isEmpty()) {
            downRequests.addAll(pendingTasks);
            pendingTasks.clear();
            direction = Direction.UP;
        }
    }

    protected boolean isIDLE() {
        return upRequests.isEmpty() && downRequests.isEmpty();
    }

    private void sleepFor(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getStatus() {
        return "Elevator " + id + " is on floor " + currentFloor + " going " + direction;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getId() {
        return id;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
