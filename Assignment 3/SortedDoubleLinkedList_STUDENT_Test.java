import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortedDoubleLinkedList_STUDENT_Test {
	SortedDoubleLinkedList<String> students;
	
	public String a = "James";
	public String b = "Jessica";
	public String c = "Andrew";
	public String d = "Anna";
	public String e = "Charles";
	
	public String f = "Rachel";
	public String g = "Karen";
	public String h = "Thomas";
	StringComparator comparator;
	//Alphabetic order: c d e a b g f h
	
	@BeforeEach
	void setUp() throws Exception {
		comparator = new StringComparator();
		students = new SortedDoubleLinkedList<String>(comparator);
	}

	@AfterEach
	void tearDown() throws Exception {
		students = null;
		comparator = null;
	}
	
	@Test
	public void testAddToEnd() {
		try {
			students.addToEnd(a);
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAddToFront() {
		try {
			students.addToFront(a);
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testIteratorSuccessfulNext() {
		students.add(a);
		students.add(b);
		students.add(c);
		students.add(d);

		ListIterator<String> iterator = students.iterator();
		
		assertEquals(c, iterator.next());
		assertEquals(d, iterator.next());
		assertEquals(a, iterator.next());
		assertEquals(b, iterator.next());

	}

	@Test
	public void testIteratorSuccessfulPrevious() {
		students.add(a);
		students.add(b);
		students.add(c);
		students.add(d);

		ListIterator<String> iterator = students.iterator();
		
		assertEquals(c, iterator.next());
		assertEquals(d, iterator.next());
		assertEquals(a, iterator.next());
		assertEquals(b, iterator.next());
		
		assertEquals(b, iterator.previous());
		assertEquals(a, iterator.previous());
		assertEquals(d, iterator.previous());
	}
	
	@Test
	public void testIteratorNoSuchElementException() {
		students.add(a);
		students.add(b);
		students.add(c);
		students.add(d);
		
		ListIterator<String> iterator = students.iterator();
		
		assertEquals(c, iterator.next());
		assertEquals(d, iterator.next());
		assertEquals(a, iterator.next());
		assertEquals(b, iterator.next());
		
		try{
			iterator.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
	}
	
	@Test
	public void testIteratorUnsupportedOperationExceptionString() {
		students.add(a);
		students.add(b);
		students.add(c);
		students.add(d);
		
		ListIterator<String> iterator = students.iterator();
		
		try{
			iterator.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	private class StringComparator implements Comparator<String> {

		@Override
		public int compare(String arg0, String arg1) {
			return arg0.compareTo(arg1);
		}
		
	}

}
