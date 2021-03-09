package ikab.checkers.views.console;


import ikab.checkers.models.Coordinate;
import ikab.checkers.controllers.PlayController;
import ikab.checkers.models.Movement;
import ikab.checkers.views.Message;

class PlayCommand extends Command {

  PlayCommand(PlayController playController) {
    super(Message.ACTION_COMMAND.getMessage(), playController);
  }

  @Override
  protected void execute() {
    this.move(playController);
    if (playController.isRivalDefeated()) {
      new TokenView(playController.getToken()).write();
      Message.PLAYER_WIN.writeln();
    }
  }

  private void move(PlayController playController) {
    Coordinate origin;
    Coordinate target;
    ikab.checkers.models.Error error;
    do {
      origin = new CoordinateView().read(Message.COORDINATE_TO_REMOVE.toString());
      target = new CoordinateView().read(Message.COORDINATE_TO_MOVE.toString());
      error = playController.move(new Movement(origin, target));
      new ErrorView(error).writeln();
    } while (!error.isNull());
  }

  @Override
  protected boolean isActive() {
    return true;
  }

}
