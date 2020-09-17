/**
 * Thrown if a password does not contain at least one uppercase character
 * 
 * @author Rose Griffin
 *
 */
@SuppressWarnings("serial")
public class NoUpperAlphaException extends Exception  {

	public NoUpperAlphaException() {
		super("The password must contain at least one uppercase alphabetic character");
	}

}
