package ikab.checkers.controllers;


import ikab.checkers.models.Session;

public class StartController extends UseCaseController implements AcceptorController {

  public StartController(Session session) {
    super(session);
  }

  public void setUsers(int users) {
    this.session.setUsers(users);
    this.session.next();
  }

  @Override
  public void accept(ControllerVisitor controllerVisitor) {
    controllerVisitor.visit(this);
  }

}
