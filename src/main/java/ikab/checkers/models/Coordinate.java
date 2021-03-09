package ikab.checkers.models;

import ikab.checkers.utils.ClosedInterval;
import ikab.checkers.utils.ConcreteCoordinate;
import ikab.checkers.utils.Direction;

public class Coordinate extends ConcreteCoordinate {

    public static final int DIMENSION = 8;
    static final Coordinate NULL_COORDINATE = new Coordinate();
    static final ClosedInterval LIMITS = new ClosedInterval(0, Coordinate.DIMENSION - 1);

    public Coordinate() {
        super();
    }

    public Coordinate(int row, int column) {
        super(row, column);
    }

    @Override
    public boolean isNull() {
        return this == Coordinate.NULL_COORDINATE;
    }

    @Override
    public Direction getDirection(ikab.checkers.utils.Coordinate coordinate) {
        assert coordinate != null;

        if (coordinate.isNull()) {
            return Direction.NULL;
        }
        if (this.row + this.column == ((Coordinate) coordinate).row + ((Coordinate) coordinate).column) {
            if (this.column > ((Coordinate) coordinate).column && this.row > ((Coordinate) coordinate).row) {
                return Direction.UP_TO_DOWN_RIGHT;
            }
            if (this.column > ((Coordinate) coordinate).column && this.row < ((Coordinate) coordinate).row) {
                return Direction.UP_TO_DOWN_LEFT;
            }
            if (this.column < ((Coordinate) coordinate).column && this.row > ((Coordinate) coordinate).row) {
                return Direction.DOWN_TO_UP_RIGHT;
            }
            if (this.column < ((Coordinate) coordinate).column && this.row < ((Coordinate) coordinate).row) {
                return Direction.DOWN_TO_UP_LEFT;
            }
        }
        return Direction.NULL;
    }

    public Error isValid() {
        if (!LIMITS.isIncluded(this.row) || !LIMITS.isIncluded(this.column)) {
            return Error.NOT_VALID;
        }
        return Error.NULL;
    }

    public Coordinate getBetween(Coordinate coordinate) {
        return new Coordinate((this.row + coordinate.row) / 2, (this.column + coordinate.column) / 2);
    }

    public int getAbsHorizontalDistance(Coordinate coordinate) {
        return Math.abs(this.row - coordinate.row);
    }

    public int getAbsVerticalDistance(Coordinate coordinate) {
        return Math.abs(this.column - coordinate.column);
    }
}
