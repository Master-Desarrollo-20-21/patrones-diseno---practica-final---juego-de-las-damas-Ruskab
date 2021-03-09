package ikab.checkers.models;

import ikab.checkers.utils.Direction;

public class Movement {

    private final Coordinate origin;
    private final Coordinate target;

    public Movement(Coordinate origin, Coordinate target) {
        this.origin = origin;
        this.target = target;
    }

    public Coordinate getOrigin() {
        return origin;
    }

    public Coordinate getTarget() {
        return target;
    }


    public boolean samePosition() {
        return origin.equals(target);
    }

    public int getHorizontalAbsDistance() {
        return origin.getAbsHorizontalDistance(target);
    }

    public int getVerticalAbsDistance() {
        return origin.getAbsVerticalDistance(target);
    }

    public Direction getDirection() {
        return origin.getDirection(target);
    }
}
