package ikab.checkers.models;


public class Game {
    
    private Board board;
    private Turn turn;
    
    public Game() {
        this.reset();
    }
    
    public void reset() {
        this.board = new Board();
        this.turn = new Turn(this.board);
	}
    
    public void setUsers(int users) {
		this.turn.setUsers(users);
    }

    public Error move(Movement movement) {
        Error error = this.turn.move(movement);
        if (error.isNull() && !this.board.isRivalDefeated(this.turn.getToken())){
            this.turn.next();
        }
        return error;
    }

    public boolean isRivalDefeated() {
        return this.board.isRivalDefeated(this.turn.getToken());
    }

	public Token getToken(Coordinate coordinate) {
		return this.board.getToken(coordinate);
    }
    
    public Token getToken() {
		return this.turn.getToken();
	}

	public int getMaxPlayers() {
		return Turn.NUMBER_PLAYERS;
	}

	public GameMemento createMemento() {
        return new GameMemento(this.turn, this.board);
	}

	public void set(GameMemento memento) {
        this.turn.set(memento.getTurn().getToken().ordinal());
        for(int i=0; i<Coordinate.DIMENSION; i++){
            for(int j=0; j<Coordinate.DIMENSION; j++){
                Coordinate coordinate = new Coordinate(i,j);
                this.board.put(coordinate, memento.getBoard().getToken(coordinate));
            }
        }
        
    }

    public Token getActiveToken() {
        return this.turn.getPlayer().getToken();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Game other = (Game) obj;
        if (board == null) {
            if (other.board != null)
                return false;
        } else if (!board.equals(other.board))
            return false;
        if (turn == null) {
            if (other.turn != null)
                return false;
        } else if (!turn.equals(other.turn))
            return false;
        return true;
    }

}
