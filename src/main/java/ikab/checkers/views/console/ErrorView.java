package ikab.checkers.views.console;


import ikab.checkers.utils.Console;

class ErrorView extends ikab.checkers.views.ErrorView {

	ErrorView(ikab.checkers.models.Error error) {
		super(error);
	}
	
	void writeln() {
		if (!error.isNull()){
			Console.instance().writeln(ErrorView.MESSAGES[this.error.ordinal()]);
		}
	}

}
