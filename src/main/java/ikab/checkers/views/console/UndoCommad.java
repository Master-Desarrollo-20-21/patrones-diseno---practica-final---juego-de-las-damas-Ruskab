package ikab.checkers.views.console;


import ikab.checkers.controllers.PlayController;
import ikab.checkers.views.Message;

class UndoCommand extends Command {

  UndoCommand(PlayController playController) {
    super(Message.UNDO_COMMAND.getMessage(), playController);
  }

  protected void execute() {
    this.playController.undo();
  }

  protected boolean isActive() {
    return this.playController.undoable();
  }

}
