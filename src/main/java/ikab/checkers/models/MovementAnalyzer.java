package ikab.checkers.models;

abstract class MovementAnalyzer {

	protected MovementAnalyzer nextAnalyzer;

	public MovementAnalyzer(MovementAnalyzer nextAnalyzer) {
		this.nextAnalyzer = nextAnalyzer;
	}

	public abstract Error handle(Movement movement);



}
