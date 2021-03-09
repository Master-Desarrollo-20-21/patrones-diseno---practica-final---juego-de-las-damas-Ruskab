package ikab.checkers.views.console;


import ikab.checkers.controllers.ResumeController;
import ikab.checkers.utils.YesNoDialog;
import ikab.checkers.views.Message;

class ResumeView {

	boolean interact(ResumeController resumeController) {
		boolean isResumed = new YesNoDialog().read(Message.RESUME.toString());
		resumeController.resume(isResumed);
		return isResumed;
	}

}
