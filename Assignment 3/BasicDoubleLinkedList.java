import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Rose Griffin
 * Implements a generic Basic DoubleLinkedList
 * 
 * @param <T> generic type
 */
public class BasicDoubleLinkedList<T> implements Iterable<T> {
	
	protected Node head, tail;
	protected int size;
	
	/**
	 * Default constructor that initializes size to 0 and both head and tail to null
	 */
	public BasicDoubleLinkedList() {
		size = 0;
	}
	
	/**
	 * Adds a new node to the end of the DoubleLinkedList
	 * @param data data of new node
	 * 
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data) {
		Node newNode = new Node(data);
		newNode.previous = tail;
		newNode.next = null;
		
		if (tail != null) {
			tail.next = newNode;
		} else if (head == null) {
			head = newNode;
		}
		tail = newNode;

		size++;
		return this;
	}
	
	/**
	 * Adds a new node to the front of the DoubleLinkedList
	 * @param data data of new node
	 */
	public BasicDoubleLinkedList<T> addToFront(T data) {
		Node newNode = new Node(data);
		newNode.previous = null;
		newNode.next = head;
		
		if (head != null) {
			head.previous = newNode;
		} else if (tail == null) {
			tail = newNode;
		}
		head = newNode;

		size++;
		return this;
	}
	
	/**
	 * Removes specified term from the DoubleLinkedList
	 * @param targetData data to be searched for
	 * @param comparator object that compares target data to pointer data
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator) {
		Node pointer = head;
		
		//Search DoubleLinkedList for targetData
		while (pointer != null) {
			if (comparator.compare(pointer.data, targetData) == 0) {
				if (pointer.equals(head)) {
					head = head.next;
				} else if (pointer.equals(tail)) {
					tail = tail.previous;
				} else {
					pointer.previous.next = pointer.next;
				}
			}
			//Pointer moves on to next node
			pointer = pointer.next;
		}
		
        size--;
        return this;
	}
	
	/**
	 * Removes the first element of the DoubleLinkedList and returns its data.
	 * @return data from first element, if empty, returns null
	 */
	public T retrieveFirstElement() {
		
		if (size != 0) {
			Node pointer = head;
			head = head.next;
			head.previous = null;
			
			size--;
			return pointer.data;	
		} else {
			return null;
		}
		
	}
	
	/**
	 * Removes the last element of the DoubleLinkedList and returns its data.
	 * @return data from last element, if empty, returns null
	 */
	public T retrieveLastElement() {
		
		if (size != 0) {
			Node pointer = head;
			boolean done = false;
			
			while (!done) {
				if (pointer.equals(tail)) {
					tail = pointer.previous;
					done = true;
				} else {
					pointer = pointer.next;
				}
			}			
			size--;
			return pointer.data;	
		} else {
			return null;
		}
	}
	
	/**
	 * Creates an ArrayList of each term in the DoubleLinkedList
	 * @return ArrayList of items of the DoubleLinkedList
	 */
	public ArrayList<T> toArrayList() {
		ArrayList<T> temp = new ArrayList<>();
		ListIterator<T> i = new DoubleLinkedListIterator();
		
		while(i.hasNext()) {
			temp.add(i.next());
		}
		return temp;
	}
	
	/**
	 * Gets the size of the DoubleLinkedList
	 * @return size of DoubleLinkedList
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Gets the data from the first term of the DoubleLinkedList
	 * @return data of the head
	 */
	public T getFirst() {
		return head.data;
	}
	
	/**
	 * Gets the data from the last term of the DoubeLinkedList
	 * @return data of the tail
	 */
	public T getLast() {
		return tail.data;
	}
	
	@Override
	public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {
		DoubleLinkedListIterator iterator = new DoubleLinkedListIterator();
		return iterator;
	}
	
	/**
	 * Creates nodes, which are the individual terms that make up a DoubleLinkedList
	 * @author Rose Griffin
	 *
	 */
	protected class Node {
		public T data;
		public Node next, previous;
		
		/**
		 * Initializes a node with data, but references to the next and previous nodes are null
		 * @param data data of node
		 */
		public Node(T data) {
			this.data = data;
		}
		
		/**
		 * Initializes a node with data and references to the next and previous nodes.
		 * @param data	data of the node
		 * @param next	next node
		 * @param previous	previous node
		 */
		public Node(T data, Node next, Node previous) {
			this.data = data;
			this.next = next;
			this.previous = previous;
		}
		
	}
	
	/**
	 * Creates a DoubleLinkedList iterator
	 * @author Rose Griffin
	 *
	 */
	class DoubleLinkedListIterator implements ListIterator<T> {
		Node pointer = new Node(null, head, null);
		
		//Supported methods
		
		@Override
		public T next() {
			if (hasNext()) {
				pointer.previous = pointer.next;
				pointer.next = pointer.previous.next;
				return pointer.previous.data;
			} else {
				throw new NoSuchElementException();
			}
		}
		
		@Override
		public boolean hasNext() {
			return pointer.next != null;
		}
		
		@Override
		public T previous() {
			if (hasPrevious()) {
				pointer.next = pointer.previous;
				pointer.previous = pointer.next.previous;
				return pointer.next.data;
			} else {
				throw new NoSuchElementException();
			}
		}
		
		@Override
		public boolean hasPrevious() {
			return pointer.previous != null;
		}
		
		//Unsupported methods throw UnsupportedOperationException
		
		@Override
		public void add(T arg0) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		
		@Override
		public int nextIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		
		@Override
		public int previousIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(T arg0) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		
	}
	
}
