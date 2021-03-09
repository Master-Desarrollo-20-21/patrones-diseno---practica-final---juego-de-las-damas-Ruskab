package ikab.checkers.controllers;


import ikab.checkers.models.Movement;
import ikab.checkers.models.Session;
import ikab.checkers.models.Token;
import ikab.checkers.models.Error;

public class ActionController extends UseCaseController {

	public ActionController(Session session) {
    super(session);
  }
  


	public boolean isRivalDefeated() {
		return this.session.isRivalDefeated();
	}

	public Token getToken() {
		return this.session.getToken();
	}

	public Error move(Movement movement) {
		Error error = this.session.move(movement);
		if (error.isNull() && this.session.isRivalDefeated()) {
			this.session.next();
		}
		return error;
	}

}
