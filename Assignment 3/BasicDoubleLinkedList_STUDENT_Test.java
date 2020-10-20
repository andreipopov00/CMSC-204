import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

class BasicDoubleLinkedList_STUDENT_Test {
	BasicDoubleLinkedList<String> students;
	
	public String a = "James";
	public String b = "Jessica";
	public String c = "Andrew";
	public String d = "Anna";
	public String e = "Charles";
	
	public String f = "Rachel";
	public String g = "Karen";
	public String h = "Thomas";
	StringComparator comparator;

	@BeforeEach
	void setUp() throws Exception {
		students = new BasicDoubleLinkedList<String>();
		comparator = new StringComparator();
		students.addToEnd(a);
		students.addToEnd(b);
		students.addToEnd(c);
		students.addToEnd(d);
		students.addToFront(e);
	}

	@AfterEach
	void tearDown() throws Exception {
		students = null;
		comparator = null;
	}
	
	@Test
	public void testGetSize() {
		assertEquals(5,students.getSize());
	}
	
	@Test
	public void testAddToEnd() {
		assertEquals(d, students.getLast());
		students.addToEnd(f);
		assertEquals(f, students.getLast());
		students.addToEnd(g);
		assertEquals(g, students.getLast());
	}
	
	@Test
	public void testAddToFront() {
		assertEquals(e, students.getFirst());
		students.addToFront(f);
		assertEquals(f, students.getFirst());
		students.addToFront(g);
		assertEquals(g, students.getFirst());

	}
	
	@Test
	public void testGetFirst() {
		assertEquals(e, students.getFirst());
		students.addToFront(f);
		assertEquals(f, students.getFirst());

	}

	@Test
	public void testGetLast() {
		assertEquals(d, students.getLast());
		students.addToEnd(f);
		assertEquals(f, students.getLast());
	}
	
	@Test
	public void testToArrayList()
	{
		
		students.addToEnd(f);
		students.addToFront(g);
		students.addToEnd(h);
		ArrayList<String> list = students.toArrayList();
		
		assertEquals(g,list.get(0));
		assertEquals(e,list.get(1));
		assertEquals(a,list.get(2));
		assertEquals(b,list.get(3));
		assertEquals(c,list.get(4));
		assertEquals(d,list.get(5));
		assertEquals(f,list.get(6));
		assertEquals(h,list.get(7));
	}
	
	@Test
	public void testIteratorSuccessfulNext() {
		students.addToEnd(f);
		students.addToFront(g);
		ListIterator<String> iterator = students.iterator();
		
		assertEquals(true, iterator.hasNext());
		assertEquals(g, iterator.next());
		assertEquals(e, iterator.next());
		assertEquals(a, iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(b, iterator.next());
		
	}
	
	@Test
	public void testIteratorSuccessfulPrevious() {
		ListIterator<String> iterator = students.iterator();
		
		students.addToEnd(f);
		students.addToFront(g);
		students.addToEnd(h);
		
		assertEquals(true, iterator.hasNext());
		assertEquals(e, iterator.next());
		assertEquals(a, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(c, iterator.previous());
		assertEquals(b, iterator.previous());
		assertEquals(a, iterator.previous());
		assertEquals(e, iterator.previous());
		assertEquals(g, iterator.previous());
		assertEquals(false, iterator.hasPrevious());
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		students.addToEnd(f);
		students.addToFront(g);
		students.addToEnd(h);
		
		ListIterator<String> iterator = students.iterator();	
		assertEquals(g, iterator.next());
		assertEquals(e, iterator.next());
		assertEquals(a, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(d, iterator.next());
		assertEquals(f, iterator.next());
		assertEquals(h, iterator.next());
		
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
	public void testIteratorNoSuchElementExceptionPrevious() {
		students.addToEnd(f);
		students.addToFront(g);
		students.addToEnd(h);
		
		ListIterator<String> iterator = students.iterator();	
		assertEquals(g, iterator.next());
		assertEquals(e, iterator.next());
		assertEquals(e, iterator.previous());
		assertEquals(g, iterator.previous());
		
		try{
			iterator.previous();
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
	public void testIteratorUnsupportedOperationException() {
		ListIterator<String> iterator = students.iterator();		
		
		try{
			iterator.previousIndex();
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
	
	@Test
	public void testRemove() {
		
		assertEquals(d, students.getLast());
		students.addToEnd(f);
		students.remove(f, comparator);
		assertEquals(d, students.getLast());
		
	}

	@Test
	public void testRetrieveFirstElement() {
		students.addToFront(a);
		assertEquals(a, students.getFirst());
		assertEquals(a, students.retrieveFirstElement());
		assertEquals(e, students.getFirst());
	}

	@Test
	public void testRetrieveLastElement() {
		students.addToEnd(a);
		assertEquals(a, students.getLast());
		assertEquals(a, students.retrieveLastElement());
		assertEquals(d, students.getLast());
	}

	private class StringComparator implements Comparator<String> {

		@Override
		public int compare(String arg0, String arg1) {
			return arg0.compareTo(arg1);
		}
		
	}

}
