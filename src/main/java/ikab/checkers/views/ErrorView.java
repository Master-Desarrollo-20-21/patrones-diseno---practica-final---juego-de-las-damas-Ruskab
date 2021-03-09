package ikab.checkers.views;

public class ErrorView {

	public  static final String[] MESSAGES = {
		"The coordinates are wrong",
		"The square is not empty",
		"There is not a token of yours", 
		"The origin and target squares are the same",
		"Wrong number of users" };

	protected ikab.checkers.models.Error error;

	public ErrorView(ikab.checkers.models.Error error) {
		this.error = error;
	}

}
