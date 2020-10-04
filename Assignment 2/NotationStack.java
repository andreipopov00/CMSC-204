import java.util.ArrayList;

/**
 * Creates a generic LIFO data structure
 * @author Rose Griffin
 *
 */
public class NotationStack<T> implements StackInterface<T> {
	
	private int size, firstTerm, numTerms;
	private Object stack[];
	
	/**
	 * Creates a default NotationStack
	 */
	public NotationStack() {
		size = 10;
		stack = new Object[10];
		firstTerm = -1;
		numTerms = 0;
	}
	
	/**
	 * Creates a NotationStack with a passed size
	 * @param size	size of the NotationStack
	 */
	public NotationStack(int size) {
		this.size = size;
		stack = new Object[size];
		firstTerm = -1;
		numTerms = 0;
	}
	
	/**
	 * Creates a NotationStack with values from a passed ArrayList
	 * @param fill	ArrayList to copy terms from
	 */
	public NotationStack(ArrayList<T> fill) {
		@SuppressWarnings("unchecked")
		ArrayList<T> copy = (ArrayList<T>)fill.clone();
		size = copy.size();
		stack = new Object[copy.size()];
		firstTerm = -1;
		for (int i = 0; i < size; i++) {
			stack[i] = copy.get(i);
			firstTerm++;
			numTerms++;
		}
	}
	
	/**
	 * Determines whether or not the NotationStack is empty
	 * @return Returns true is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		return numTerms == 0;
	}
	
	/**
	 * Determines whether or not the the NotationStack is full
	 * @return Returns true if full, false if not
	 */
	@Override
	public boolean isFull() {
		return numTerms >= size;
	}
	
	/**
	 * Removes top value of the NotationStack, removes it, then returns it.
	 * @return top value
	 * @throws StackUnderflowException if NotationStack is empty
	 */
	@Override
	public T pop() throws StackUnderflowException {
		if (!isEmpty() && firstTerm != -1) {
			@SuppressWarnings("unchecked")
			T front = (T)stack[firstTerm];	
			stack[firstTerm] = null;
			firstTerm--;
			numTerms--;
			return front;
		} else {
			throw new StackUnderflowException();
		}
	}
	
	/**
	 * Determines top value of the Notation Stack and return it
	 * @return top value
	 * @throws StackUnderflowException if NotationStack is empty
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T top() throws StackUnderflowException {
		if (!isEmpty()) {
			return (T)stack[firstTerm];
		}

		else
			throw new StackUnderflowException();
	}
	
	/**
	 * Determines size of NotationStack
	 * @return size
	 */
	@Override
	public int size() {
		return numTerms;
	}
	
	/**
	 * Adds a new value to the NotationStack
	 * @param e Term to add
	 * @return True if successful
	 * @throws StackOverflowException if NotationStack is full
	 */
	@Override
	public boolean push(T e) throws StackOverflowException {
		if (!isFull()) {
			stack[numTerms] = e;
			numTerms++;
			firstTerm++;
			return true;
		} else {
			throw new StackOverflowException();
		}
	}
	
	/**
	 * Converts NotationStack to string
	 * @return NotationStack as a string
	 */
	@Override
	public String toString() {
		StringBuilder temp = new StringBuilder();
		for(int i = 0; i <= firstTerm; i++) {
			temp.append(stack[i]);
		}

		return temp.toString();
	}
	
	/**
	 * Converts NotationStack to string, inserting delimiters between each term
	 * @param delimiter delimiter
	 * @return NotationStack as a string
	 */
	@Override
	public String toString(String delimiter) {
		StringBuilder temp = new StringBuilder();
		for(int i = 0; i <= firstTerm; i++) {
			temp.append(stack[i] + delimiter);
		}
		temp.deleteCharAt(temp.length()-1);
		return temp.toString();
	}

}
