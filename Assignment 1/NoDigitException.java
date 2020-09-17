/**
 * Thrown if a password does not contain at least one digit
 * 
 * @author Rose Griffin
 *
 */
@SuppressWarnings("serial")
public class NoDigitException extends Exception  {

	public NoDigitException() {
		super("The password must contain at least one digit");
	}

}
