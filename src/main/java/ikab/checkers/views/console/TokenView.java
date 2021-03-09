package ikab.checkers.views.console;


import ikab.checkers.models.Token;
import ikab.checkers.utils.Console;

public class TokenView {

	public static final char[] SYMBOLS = {'W', 'B', ' ' };
	private Token token;

	TokenView(Token token){
		this.token = token;
	}

	void write() {
		Console.instance().write(TokenView.SYMBOLS[token.ordinal()]);
	}

}
