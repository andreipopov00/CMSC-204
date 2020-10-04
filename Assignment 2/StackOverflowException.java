/**
 * Thrown if stack is full
 * @author Rose Griffin
 *
 */
public class StackOverflowException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StackOverflowException() {
		super("The stack is full");
	}
	
}
