package ikab.checkers.controllers;

import ikab.checkers.models.Movement;
import ikab.checkers.models.Session;
import ikab.checkers.models.Token;

public class PlayController extends UseCaseController implements AcceptorController {

    private ActionController actionController;
    private UndoController undoController;
    private RedoController redoController;

    public PlayController(Session session) {
        super(session);
        this.actionController = new ActionController(session);
        this.undoController = new UndoController(session);
        this.redoController = new RedoController(session);
    }

    public boolean isRivalDefeated() {
        return this.actionController.isRivalDefeated();
    }

    public Token getToken() {
        return this.actionController.getToken();
    }


    public ikab.checkers.models.Error move(Movement movement) {
        return this.actionController.move(movement);
    }

    public void undo() {
        this.undoController.undo();
    }

    public boolean undoable() {
        return this.undoController.undoable();
    }

    public void redo() {
        this.redoController.redo();
    }

    public boolean redoable() {
        return this.redoController.redoable();
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

}
