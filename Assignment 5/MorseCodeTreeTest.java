import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeTreeTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testToArrayList() {
		MorseCodeTree tree = new MorseCodeTree();
		ArrayList<String> list = tree.toArrayList();
		
		StringBuilder sb = new StringBuilder();
		for (String string : list) {
			sb.append(string + " ");
		}
		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o", sb.toString().trim());
	}
	
	@Test
	void testGetRoot() {
		MorseCodeTree tree = new MorseCodeTree();
		assertEquals("", tree.getRoot().data);
	}
	
	@Test
	void testInsertAndFetch() {
		MorseCodeTree tree = new MorseCodeTree();
		tree.insert("----", "test");
		assertEquals(tree.fetch("----"), "test");
		
	}
	
	@Test
	void testUnsupportedOperation() {
		MorseCodeTree tree = new MorseCodeTree();
		try {
			tree.delete(".");
			fail("Should have caused an exception");
		} catch (Exception UnsupportedOperationException) {
			assertTrue(true);
		}
	}

}
