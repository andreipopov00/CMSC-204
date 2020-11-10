import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface {
	private int size;
	public LinkedList<CourseDBElement>[] hashTable;
	
	/**
	 * Initializes the size of the table
	 * @param n estimated number of courses
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(int size) {
		this.size = size;
		this.hashTable = new LinkedList[size];
	}
	
	/**
	 * Parameterized constructor for testing purposes
	 * @param string
	 * @param n
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(String string, int size) {
		this.size = size;
		this.hashTable = new LinkedList[size];
	}
	
	@Override
	public void add(CourseDBElement element) {
		int index = element.hashCode() % size;
		
		//Create a new linked list at determined index if null
		if (hashTable[index] == null)
			hashTable[index] = new LinkedList<CourseDBElement>();
		
		hashTable[index].add(element);
	}

	@Override
	public CourseDBElement get(int crn) throws IOException {
		int index = Integer.toString(crn).hashCode() % size;
		for (CourseDBElement element: hashTable[index]) {
			if (element.getCRN() == crn)
				return element;
		}
		throw new IOException("Element not found");
	}

	@Override
	public int getTableSize() {
		return size;
	}

}
