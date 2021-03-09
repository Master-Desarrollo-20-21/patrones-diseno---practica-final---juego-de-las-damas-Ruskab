package ikab.checkers.models;

import ikab.checkers.utils.Direction;

import static ikab.checkers.models.Token.BLACK;
import static ikab.checkers.models.Token.WHITE;
import static ikab.checkers.utils.Direction.DOWN_TO_UP_LEFT;
import static ikab.checkers.utils.Direction.DOWN_TO_UP_RIGHT;
import static ikab.checkers.utils.Direction.UP_TO_DOWN_LEFT;
import static ikab.checkers.utils.Direction.UP_TO_DOWN_RIGHT;

public class SimpleMovementAnalyzer extends MovementAnalyzer {
    private Board board;

    public SimpleMovementAnalyzer(Board board, MovementAnalyzer nextAnalyzer) {
        super(nextAnalyzer);
        this.board = board;
    }

    @Override
    public Error handle(Movement movement) {
        if (!this.board.isOccupied(movement.getOrigin(), this.board.getToken(movement.getOrigin()))) {
            return Error.NOT_OWNER;
        }
        if (!this.board.isEmpty(movement.getTarget())) {
            return Error.NOT_EMPTY;
        }
        if (movement.samePosition()) {
            return Error.SAME_COORDINATES;
        }
        if (movement.getHorizontalAbsDistance() == 1 || movement.getVerticalAbsDistance() == 1) {
            Direction direction = movement.getDirection();
            if (WHITE.equals(this.board.getToken(movement.getOrigin())) && direction.equals(DOWN_TO_UP_LEFT) || direction.equals(DOWN_TO_UP_RIGHT)) {
                return Error.NULL;
            }
            if (BLACK.equals(this.board.getToken(movement.getOrigin())) && direction.equals(UP_TO_DOWN_LEFT) || direction.equals(UP_TO_DOWN_RIGHT)) {
                return Error.NULL;
            }
        }
        return nextAnalyzer.handle(movement);
    }


}
