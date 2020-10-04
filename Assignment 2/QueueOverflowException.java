/**
 * Thrown if queue is full
 * @author Rose Griffin
 *
 */
public class QueueOverflowException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QueueOverflowException() {
		super("The queue is full");
	}
	
}
