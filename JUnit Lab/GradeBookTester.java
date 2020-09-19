import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * Tests GradeBook class
 * @author Rose Griffin
 *
 */
class GradeBookTester {
	GradeBook g1;
	GradeBook g2;

	@BeforeEach
	void setUp() throws Exception {
		g1 = new GradeBook(5);
		g2 = new GradeBook(5);
		
		g1.addScore(34.9);
		g1.addScore(95.2);
		
		g2.addScore(76.8);
		g2.addScore(95.7);
		g2.addScore(74.2);
		g2.addScore(100);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = g2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(g1.toString().equals("34.9 95.2 "));
		assertTrue(g2.toString().equals("76.8 95.7 74.2 100.0 "));
		
		assertEquals(2, g1.getScoreSize(), 0);
		assertEquals(4, g2.getScoreSize(), 0);
		
		
	}
	
	@Test
	void testSum() {
		assertEquals(130.1, g1.sum(), .0001);
		assertEquals(346.7, g2.sum(), .0001);
	}
	
	@Test
	void testMinimum() {
		assertEquals(34.9, g1.minimum(), .001);
		assertEquals(74.2, g2.minimum(), .001);
	}
	
	@Test
	void testFinalScore() {
		assertEquals(95.2, g1.finalScore(), .001);
		assertEquals(272.5, g2.finalScore(), .001);
	}

}
