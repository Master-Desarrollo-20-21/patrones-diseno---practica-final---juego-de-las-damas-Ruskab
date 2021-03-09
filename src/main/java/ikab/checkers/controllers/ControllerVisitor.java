package ikab.checkers.controllers;

public interface ControllerVisitor {
  
  void visit(StartController startController);
  void visit(PlayController playController);
  void visit(ResumeController resumeController);
}
