package ikab.checkers.models;

import static ikab.checkers.models.Token.getRivalToken;

public class AttackMovementAnalyzer extends MovementAnalyzer {

    private Board board;

    public AttackMovementAnalyzer(Board board) {
        super(null);
        this.board = board;
    }

    @Override
    public Error handle(Movement movement) {
        if (movement.getHorizontalAbsDistance() == 2 && movement.getVerticalAbsDistance() == 2) {
            if (this.board.isOccupiedBetween(movement.getOrigin(), movement.getTarget(), getRivalToken(this.board.getToken(movement.getOrigin())))) {
                return Error.NULL;
            }
            return Error.NOT_VALID;
        }
        return Error.NOT_VALID;
    }
}
