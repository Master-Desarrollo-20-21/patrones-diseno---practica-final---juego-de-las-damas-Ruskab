package ikab.checkers.views.console;


import ikab.checkers.controllers.PlayController;

abstract class Command extends ikab.checkers.utils.Command {

  protected PlayController playController;

  protected Command(String title, PlayController playController) {
    super(title);
    this.playController = playController;
  }

}
