package ikab.checkers.views.console;


import ikab.checkers.controllers.StartController;
import ikab.checkers.views.Message;

class StartView {

	void interact(StartController startController) {
		Message.TITTLE.writeln();
		startController.setUsers(2);
		new GameView(startController).write();
	}

}
