/**
 * Thrown if two passwords do not match (case sensitive)
 * 
 * @author Rose Griffin
 *
 */
@SuppressWarnings("serial")
public class UnmatchedException extends Exception {

	public UnmatchedException() {
		super("Passwords do not match");
	}

}
