/**
 * Thrown if queue is empty
 * @author Rose Griffin
 *
 */
public class QueueUnderflowException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QueueUnderflowException() {
		super("The queue is empty");
	}
	
}
