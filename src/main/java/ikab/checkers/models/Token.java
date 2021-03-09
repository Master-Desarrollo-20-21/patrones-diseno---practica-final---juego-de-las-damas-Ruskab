package ikab.checkers.models;


import ikab.checkers.utils.ClosedInterval;

public enum Token {

	WHITE,
	BLACK,
	NULL;

	public boolean isNull() {
		return this.equals(Token.NULL);
	}

	public static Token get(int ordinal){
		assert new ClosedInterval(0, Token.values().length-2).isIncluded(ordinal);
		
		return Token.values()[ordinal];
	}

	public static Token getRivalToken(Token token) {
		return WHITE.equals(token) ? BLACK : WHITE;
	}

	@Override
	public String toString(){
		if (this==Token.NULL){
			return ".";
		}
		return this.name();
	}

}
