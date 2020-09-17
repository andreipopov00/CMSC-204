/**
 * Thrown if a password does not contain at least one special character
 * 
 * @author Rose Griffin
 *
 */
@SuppressWarnings("serial")
public class NoSpecialCharacterException extends Exception  {

	public NoSpecialCharacterException() {
		super("The password must contain at least one special character");
	}

}
