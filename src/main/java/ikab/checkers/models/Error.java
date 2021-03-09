package ikab.checkers.models;

public enum Error {

	NOT_VALID,
	NOT_EMPTY,
	NOT_OWNER,
	SAME_COORDINATES,
	NULL;

	public boolean isNull(){
		return this == Error.NULL;
	}

}
