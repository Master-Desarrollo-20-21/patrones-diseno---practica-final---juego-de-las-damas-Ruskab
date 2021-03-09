package ikab.checkers.controllers;


import ikab.checkers.models.Coordinate;
import ikab.checkers.models.Session;
import ikab.checkers.models.Token;

public abstract class UseCaseController {

	protected Session session;

	UseCaseController(Session session) {
		this.session = session;
	}

	public Token getToken(Coordinate coordinate) {
		return this.session.getToken(coordinate);
	}

	public Token getActiveToken() {
		return this.session.getActiveToken();
	}

}
