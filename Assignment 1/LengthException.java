/**
 * Thrown if a password is less than 6 characters long
 * 
 * @author Rose Griffin
 *
 */
@SuppressWarnings("serial")
public class LengthException extends Exception  {

	public LengthException (){
		super("The password must be at least 6 characters long");
	}

}
