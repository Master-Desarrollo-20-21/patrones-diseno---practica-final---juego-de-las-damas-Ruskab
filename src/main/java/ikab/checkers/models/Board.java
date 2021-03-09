package ikab.checkers.models;

import java.util.Arrays;

class Board {

    private Token[][] tokens;

    Board() {
        this.tokens = new Token[Coordinate.DIMENSION][Coordinate.DIMENSION];
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                this.tokens[i][j] = Token.NULL;
            }
        }
        boolean isFillPairsInRow = true;
        for (int i = 0; i < Coordinate.DIMENSION / 2 - 1; i++) {
            fillRows(i, Token.BLACK, isFillPairsInRow = !isFillPairsInRow);
        }
        for (int i = Coordinate.DIMENSION - 1; i > Coordinate.DIMENSION / 2; i--) {
            fillRows(i, Token.WHITE, isFillPairsInRow = !isFillPairsInRow);
        }
    }

    private Board(Board board) {
        this();
        assert board != null;

        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                this.tokens[i][j] = board.tokens[i][j];
            }
        }
    }

    private void fillRows(int row, Token token, boolean isFillPairsInRow) {
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            if (isFillPairsInRow && isPair(i)) {
                this.tokens[row][i] = token;
            }
            if (!isFillPairsInRow && !isPair(i)) {
                this.tokens[row][i] = token;
            }
        }
    }

    private boolean isPair(int i) {
        return i % 2 == 0;
    }

    Board copy() {
        return new Board(this);
    }

    Token getToken(Coordinate coordinate) {
        assert coordinate != null && !coordinate.isNull();

        return this.tokens[coordinate.getRow()][coordinate.getColumn()];
    }

    void move(Movement movement) {
        Token token = this.getToken(movement.getOrigin());
        this.tokens[movement.getOrigin().getRow()][movement.getOrigin().getColumn()] = Token.NULL;
        this.put(movement.getTarget(), token);
        if (isRemoveRivalToken(movement.getOrigin(), movement.getTarget())) {
            Coordinate toRemoveCoordinate = movement.getOrigin().getBetween(movement.getTarget());
            this.tokens[toRemoveCoordinate.getRow()][toRemoveCoordinate.getColumn()] = Token.NULL;
        }
    }

    private boolean isRemoveRivalToken(Coordinate origin, Coordinate target) {
        return this.getToken(origin.getBetween(target)) != Token.NULL;
    }

    void put(Coordinate coordinate, Token token) {
        this.tokens[coordinate.getRow()][coordinate.getColumn()] = token;
    }

    boolean isOccupied(Coordinate coordinate, Token token) {
        assert coordinate != null && !coordinate.isNull();

        return this.getToken(coordinate) == token;
    }

    boolean isOccupiedBetween(Coordinate origin, Coordinate target, Token token) {
        assert origin != null && target != null && !origin.isNull() && !target.isNull();

        return this.getToken(origin.getBetween(target)) == token;
    }

    boolean isEmpty(Coordinate coordinate) {
        assert coordinate != null && !coordinate.isNull();

        return this.isOccupied(coordinate, Token.NULL);
    }

    boolean isRivalDefeated(Token token) {
        assert token != null && !token.isNull();

        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                if (this.tokens[i][j] == token) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Board other = (Board) obj;
        if (!Arrays.deepEquals(tokens, other.tokens))
            return false;
        return true;
    }

}
