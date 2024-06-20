package systemdesign.lld.elevator;

public class Request {
    private int fromFloor;
    private int toFloor;
    private Direction direction;

    public Request(int fromFloor, int toFloor) {
        this.fromFloor = fromFloor;
        this.toFloor = toFloor;
        this.direction = toFloor > fromFloor ? Direction.UP : Direction.DOWN;
    }

    public int getFromFloor() {
        return fromFloor;
    }

    public int getToFloor() {
        return toFloor;
    }

    public Direction getDirection() {
        return direction;
    }
}

