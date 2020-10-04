/**
 * Thrown if stack is empty
 * @author Rose Griffin
 *
 */
public class StackUnderflowException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StackUnderflowException() {
		super("The stack is empty");
	}
	
}
