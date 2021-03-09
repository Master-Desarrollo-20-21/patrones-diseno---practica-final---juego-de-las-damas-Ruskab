package ikab.checkers;


import ikab.checkers.controllers.AcceptorController;
import ikab.checkers.controllers.Logic;
import ikab.checkers.views.View;

public abstract class Checkers {

    private Logic logic;
    private View view;

    protected Checkers() {
        this.logic = new Logic();
        this.view = this.createView();
    }

    protected abstract View createView();

    protected void play() {
        AcceptorController controller;
		do {
            controller = this.logic.getController();
            if (controller != null) {
                this.view.interact(controller);
            }
		} while (controller != null);
    }

}
