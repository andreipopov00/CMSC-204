/**
 * Thrown if a password contains more than two of the same character in a sequence.
 * 
 * @author Rose Griffin
 *
 */
@SuppressWarnings("serial")
public class InvalidSequenceException extends Exception  {

	public InvalidSequenceException(){
		super("The password cannot contain more than two of the same character in sequence");
	}

}
