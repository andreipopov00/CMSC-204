import java.util.Comparator;


/**
 * 
 * @author Rose Griffin
 * Implements a sorted DoubleLinkedList. Extends BasicDoubleLinkedList
 * @param <T>	Generic type
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	private Comparator<T> comparator;
	
	/**
	 * Initializes comparator
	 * @param comparator2 comparator
	 */
	SortedDoubleLinkedList(Comparator<T> comparator2) {
		comparator = comparator2;
	}
	
	/**
	 * Adds new node to the SortedDoubleLinkedList at the appropriate, sorted position.
	 * @param data data of new node
	 */
	public SortedDoubleLinkedList<T> add(T data) {
		Node addNode = new Node(data);
		
		if (size == 0) {
			head = addNode;
			tail = addNode;
		} else if (comparator.compare(head.data, data) > 0) {
			head.previous = addNode;
			addNode.next = head;
			head = addNode;
		} else if (comparator.compare(tail.data, data) < 0) {
			tail.next = addNode;
			addNode.previous = tail;
			tail = addNode;
		} else {
			Node pointer = head;
			
			while (pointer != null) {
				if (comparator.compare(pointer.data, data) <= 0) {
					Node temp = pointer.next;
					pointer.next.previous = pointer.next = addNode;
					addNode.next = temp;
					addNode.previous = pointer;
				}
				//Pointer moves to next node
				pointer = pointer.next;
			}
		}
		
        size++;
        return this;
	}
	
	/**
	 * Unsupported method
	 * @throws UnsupportedOperationException
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}
	
	/**
	 * Unsupported method
	 * @throws UnsupportedOperationException
	 */
	public BasicDoubleLinkedList<T> addToFront(T data) throws java.lang.UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}
	
	/**
	 * Implements iterator by calling super class iterator method
	 */
	public java.util.ListIterator<T> iterator() {
		return super.iterator();
	}
	
	/**
	 * Implements remove by calling super class remove method
	 */
	public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator) {
		return (SortedDoubleLinkedList<T>) super.remove(data, comparator);
	}
	
}
