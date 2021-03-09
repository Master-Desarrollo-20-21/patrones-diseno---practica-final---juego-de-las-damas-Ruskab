package ikab.checkers.views.console;


import ikab.checkers.controllers.AcceptorController;
import ikab.checkers.controllers.ControllerVisitor;
import ikab.checkers.controllers.PlayController;
import ikab.checkers.controllers.ResumeController;
import ikab.checkers.controllers.StartController;

public class View extends ikab.checkers.views.View implements ControllerVisitor {

	private StartView startView;
	private PlayView playView;
	private ResumeView resumeView;

	public View() {
		this.startView = new StartView();
		this.playView = new PlayView();
		this.resumeView = new ResumeView();
	}

	@Override
	public void interact(AcceptorController controller) {
		controller.accept(this);
	}

	@Override
	public void visit(StartController startController) {
		this.startView.interact(startController);
	}

	@Override
	public void visit(PlayController playController) {
		this.playView.interact(playController);	}

	@Override
	public void visit(ResumeController resumeController) {
		this.resumeView.interact(resumeController);
	}

}
