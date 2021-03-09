package ikab.checkers.models;

class Player {

    Board board;
    private Token token;

    Player(Token token, Board board) {
        this.token = token;
        this.board = board;
    }

    Error move(Movement movement) {
        assert movement.getOrigin() != null && !movement.getOrigin().isNull();
        assert movement.getTarget() != null && !movement.getTarget().isNull();

        MovementAnalyzer movementAnalyzer = new SimpleMovementAnalyzer(board, new AttackMovementAnalyzer(board));
        Error error = movementAnalyzer.handle(movement);
        if (!error.isNull()) {
            return error;
        }
        this.board.move(movement);
        return Error.NULL;
    }

    Token getToken() {
        return this.token;
    }

    public Player copy(Board board) {
        return new Player(this.token, board);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Player other = (Player) obj;
        if (board == null) {
            if (other.board != null)
                return false;
        } else if (!board.equals(other.board))
            return false;
        if (token != other.token)
            return false;
        return true;
    }

}
