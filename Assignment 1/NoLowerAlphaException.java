/**
 * Thrown if a password does not contain at least one lowercase character
 * @author Rose Griffin
 *
 */
@SuppressWarnings("serial")
public class NoLowerAlphaException extends Exception  {

	public NoLowerAlphaException (){
		super("The password must contain at least one lower case alphabetic character");
	}

}
