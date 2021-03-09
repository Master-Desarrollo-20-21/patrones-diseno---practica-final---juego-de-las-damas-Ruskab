package ikab.checkers;


import ikab.checkers.views.View;

class ConsoleCheckers extends Checkers {

	@Override
	protected View createView(){
		return new ikab.checkers.views.console.View();
	}

	public static void main(String[] args) {
		new ConsoleCheckers().play();
	}

}
