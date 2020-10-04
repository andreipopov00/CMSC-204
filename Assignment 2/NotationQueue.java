import java.util.ArrayList;

/**
 * Creates a generic FIFO data structure
 * @author Rose Griffin
 *
 */
public class NotationQueue<T> implements QueueInterface<T> {
	
	private int size, firstTerm, numTerms;
	private Object queue[];
	
	/**
	 * Creates a default NotationQueue
	 */
	public NotationQueue() {
		size = 10;
		queue = new Object[10];
		firstTerm = 0;
		numTerms = 0;
	}
	
	/**
	 * Creates a NotationQueue with the passed size
	 * @param size size of new NotationQueue
	 */
	public NotationQueue(int size) {
		this.size = size;
		queue = new Object[size];
		firstTerm = 0;
		numTerms = 0;
	}
	
	/**
	 * Creates a NotationQueue with values from a passed ArrayList
	 * @param fill ArrayList to grab values from
	 */
	public NotationQueue(ArrayList<T> fill) {
		@SuppressWarnings("unchecked")
		ArrayList<T> copy = (ArrayList<T>)fill.clone();
		size = copy.size();
		queue = new Object[copy.size()];
		firstTerm = 0;
		for (int i = 0; i < size; i++) {
			queue[i] = copy.get(i);
			numTerms++;
		}
	}
	
	/**
	 * Determines if NotationQueue is empty
	 * @return True if NotationQueue is empty, false if otherwise
	 */
	@Override
	public boolean isEmpty() {
		return numTerms == 0;
	}
	
	/**
	 * Determines if NotationQueue is full
	 * @return True if NotationQueue is full, false if otherwise
	 */
	@Override
	public boolean isFull() {
		return numTerms >= size;
	}
	
	/**
	 * Determines size of NotationQueue
	 * @return size of NotationQueue
	 */
	@Override
	public int size() {
		return numTerms;
	}
	
	/**
	 * Adds term to NotationQueue
	 * @param e Object to add
	 * @return True if successful
	 * @throws QueueOverflowException if NotationQueue is full
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		if (!isFull()) {
			queue[numTerms] = e;
			numTerms++;
			return true;
		} else {
			throw new QueueOverflowException();
		}
	}
	
	/**
	 * Converts NotationQueue to string
	 * @return NotationQueue as a string
	 */
	@Override
	public String toString() {
		StringBuilder temp = new StringBuilder();
		for(int i = firstTerm; i < numTerms; i++) {
			temp.append(queue[i]);
		}
		return temp.toString();
	}
	
	/**
	 * Converts NotationQueue to string, inserting delimiters between each term
	 * @param delimiter
	 * @return NotationQueue as a string
	 */
	@Override
	public String toString(String delimiter) {
		StringBuilder temp = new StringBuilder();
		for(int i = firstTerm; i < numTerms; i++) {
			temp.append(queue[i] + delimiter);
		}
		temp.deleteCharAt(temp.length()-1);
		return temp.toString();
	}
	
	/**
	 * Fills NotationQueue with terms from passed ArrayList
	 * @param list ArrayList to grab terms from
	 */
	@Override
	public void fill(ArrayList<T> list) {
		@SuppressWarnings("unchecked")
		ArrayList<T> copy = (ArrayList<T>)list.clone();
		size = copy.size();
		queue = new Object[copy.size()];
		firstTerm =  0;
		for (int i = 0; i < size; i++) {
			queue[i] = copy.get(i);
			numTerms++;
		}
	}
	
	/**
	 * Removes term from the NotationQueue
	 * @return term removed
	 * @throws QueueUnderflowException if queue is empty
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		if (!isEmpty()) {
			@SuppressWarnings("unchecked")
			T front = (T)queue[firstTerm];
			queue[firstTerm] = null;
			firstTerm++;
			numTerms--;
			return front;
		} else {
			throw new QueueUnderflowException();
		}
	}
	
}
