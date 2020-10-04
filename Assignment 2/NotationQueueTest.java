import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NotationQueueTest {
	public NotationQueue<String> stringQ;
	public String a="a", b="b", c="c", d="d", e="e", f="f";
	public ArrayList<String> fill = new ArrayList<String>();
	
	public NotationQueue<Double> doubleQ;
	public Double term1 = 24.4, term2 = 9.0, term3 = 5.4, term4 = .5;

	@Before
	public void setUp() throws Exception {
		stringQ = new NotationQueue<String>(5);
		stringQ.enqueue(a);
		stringQ.enqueue(b);
		stringQ.enqueue(c);
		
		doubleQ = new NotationQueue<Double>(4);
		doubleQ.enqueue(term1);
		doubleQ.enqueue(term2);
		doubleQ.enqueue(term3);
		doubleQ.enqueue(term4);
	}

	@After
	public void tearDown() throws Exception {
		stringQ = null;
		doubleQ = null;
	}

	@Test
	public void testIsEmpty() throws QueueUnderflowException {
		assertEquals(false,stringQ.isEmpty());
		stringQ.dequeue();
		stringQ.dequeue();
		stringQ.dequeue();
		assertEquals(true, stringQ.isEmpty());
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(a, stringQ.dequeue());
			assertEquals(b, stringQ.dequeue());
			assertEquals(c, stringQ.dequeue());
			//Queue is empty, next statement should cause QueueUnderFlowException
			stringQ.dequeue();
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
		catch (QueueUnderflowException e){
			assertTrue("This should have caused an QueueUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
	}
	
	@Test
	public void testDequeueStudent() {
		try {
			assertEquals(term1, doubleQ.dequeue());
			assertEquals(term2, doubleQ.dequeue());
			assertEquals(term3, doubleQ.dequeue());
			assertEquals(term4, doubleQ.dequeue());

			doubleQ.dequeue();
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
		catch (QueueUnderflowException e){
			assertTrue("This should have caused an QueueUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
	}

	@Test
	public void testSize() throws QueueUnderflowException, QueueOverflowException {
		assertEquals(3, stringQ.size());
		stringQ.enqueue(d);
		assertEquals(4, stringQ.size());
		stringQ.dequeue();
		stringQ.dequeue();
		assertEquals(2, stringQ.size());
	}

	@Test
	public void testEnqueue() {
		try {
			assertEquals(3, stringQ.size());
			assertEquals(true, stringQ.enqueue(d));
			assertEquals(4, stringQ.size());
			assertEquals(true, stringQ.enqueue(e));
			assertEquals(5, stringQ.size());
			//Queue is full, next statement should cause QueueOverFlowException
			stringQ.enqueue(f);
			assertTrue("This should have caused an QueueOverflowException", false);
		}
		catch (QueueOverflowException e){
			assertTrue("This should have caused an QueueOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueOverflowException", false);
		}
	}

	@Test
	public void testEnqueueStudent() {
		try {
			doubleQ.dequeue();
			
			assertEquals(3, doubleQ.size());
			assertEquals(true, doubleQ.enqueue(term1));
			
			doubleQ.enqueue(term2);
			assertTrue("This should have caused an QueueOverflowException", false);
		}
		catch (QueueOverflowException e){
			assertTrue("This should have caused an QueueOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueOverflowException", false);
		}
	}

	@Test
	public void testIsFull() throws QueueOverflowException {
		assertEquals(false, stringQ.isFull());
		stringQ.enqueue(d);
		stringQ.enqueue(e);
		assertEquals(true, stringQ.isFull());
	}

	@Test
	public void testToString() throws QueueOverflowException {
		assertEquals("abc", stringQ.toString());
		stringQ.enqueue(d);
		assertEquals("abcd", stringQ.toString());
		stringQ.enqueue(e);
		assertEquals("abcde", stringQ.toString());
	}

	@Test
	public void testToStringStudent() {
		try {
			assertEquals("24.49.05.40.5", doubleQ.toString());
			doubleQ.dequeue();
			assertEquals("9.05.4", doubleQ.toString());
			doubleQ.enqueue(53.0);
			assertEquals("9.05.453.0", doubleQ.toString());
		} catch (Exception e) {
			assertTrue("This should have not caused an exception", false);
		}
	}

	@Test
	public void testToStringDelimiter() throws QueueOverflowException {
		assertEquals("a%b%c", stringQ.toString("%"));
		stringQ.enqueue(d);
		assertEquals("a&b&c&d", stringQ.toString("&"));
		stringQ.enqueue(e);
		assertEquals("a/b/c/d/e", stringQ.toString("/"));
	}

	@Test
	public void testFill() throws QueueUnderflowException {
		fill.add("apple");
		fill.add("banana");
		fill.add("carrot");
		//start with an empty queue
		stringQ = new NotationQueue<String>(fill);
		//assertEquals("applebananacarrot", fill.toString());
		assertEquals(3,stringQ.size());
		assertEquals("apple", stringQ.dequeue());
		assertEquals("banana", stringQ.dequeue());
		assertEquals("carrot", stringQ.dequeue());		
	}

}