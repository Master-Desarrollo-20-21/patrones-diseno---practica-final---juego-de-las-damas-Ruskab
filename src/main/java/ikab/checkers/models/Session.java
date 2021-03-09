package ikab.checkers.models;


public class Session {

  private Game game;
  private GameRegistry registry;
  private State state;

  public Session() {
    this.state = new State();
    this.game = new Game();
  }

  public StateValue getValueState() {
    return this.state.getValueState();
  }

  public Token getToken(Coordinate coordinate) {
    return this.game.getToken(coordinate);
  }

  public void next() {
    this.state.next();
  }

  public void setUsers(int users) {
    this.game.setUsers(users);
    this.registry = new GameRegistry(this.game);
  }

  public int getMaxPlayers() {
    return this.game.getMaxPlayers();
  }

  public void reset() {
    this.game.reset();
    this.state.reset();
  }

  public boolean isRivalDefeated() {
    return this.game.isRivalDefeated();
  }

  public Token getToken() {
    return this.game.getToken();
  }

  public Error move(Movement movement) {
    Error error = this.game.move(movement);
    if (error.isNull()){
      this.registry.register();
    }
    return error;
  }

  public void undo() {
    this.registry.undo();
  }

  public boolean undoable() {
    return this.registry.isUndoable();
  }

  public void redo() {
    this.registry.redo();
  }

  public boolean redoable() {
    return this.registry.isRedoable();
  }

  public Token getActiveToken() {
    return this.game.getActiveToken();
  }

}
