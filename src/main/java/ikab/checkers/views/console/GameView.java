package ikab.checkers.views.console;


import ikab.checkers.models.Coordinate;
import ikab.checkers.controllers.UseCaseController;
import ikab.checkers.utils.Console;
import ikab.checkers.views.Message;

class GameView {
    
  private UseCaseController controller;

  GameView(UseCaseController controller) {
    this.controller = controller;
  }

	void write() {
		Message.SEPARATOR.writeln();
		for (int i = 0; i< Coordinate.DIMENSION; i++) {
			Console.instance().write(i + 1);
			Message.VERTICAL_LINE_LEFT.write();
			for (int j = 0; j<Coordinate.DIMENSION; j++) {
				new TokenView(this.controller.getToken(new Coordinate(i, j))).write();;
				Message.VERTICAL_LINE_CENTERED.write();
			}
			Message.VERTICAL_LINE_RIGHT.writeln();
		}
		Console.instance().writeln("   1   2   3   4   5   6   7   8");
		Message.SEPARATOR.writeln();


		Message.ACTIVE_TOKEN.write();
		new TokenView(this.controller.getActiveToken()).write();
	}

}
