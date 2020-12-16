import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Town_STUDENT_Test {
	private Town town1;
	private Town town2;
	
	@BeforeEach
	void setUp() throws Exception {
		town1 = new Town("Town1");
		town2 = new Town("Town2");
		
		//town1 and town 2 are connected
		town1.addAdjacentTown(town2);
		town2.addAdjacentTown(town1);
	}

	@AfterEach
	void tearDown() throws Exception {
		town1 = town2 = null;
	}

	@Test
	void testVisited() {
		assertEquals(town1.wasVisited(), false);
		town2.setVisited(true);
		assertEquals(town2.wasVisited(), true);
	}
	
	@Test
	void testWeight() {
		assertEquals(town1.getWeight(), Integer.MAX_VALUE);
		town2.setWeight(5);
		assertEquals(town2.getWeight(), 5);
	}
	
	@Test
	void testPreviousTown() {
		town2.setPrevTown(town1);
		assertEquals(town2.getPrevTown(), town1);
	}
	
	@Test
	void testAdjacentTowns() {
		assertEquals(town1.getTowns().contains(town2), true);
	}
	
	@Test
	void testCompareTo() {
		assertEquals(town1.compareTo(town2), 1);
		Town copyTown1 = new Town(town1);
		assertEquals(town1.compareTo(copyTown1), 0);
	}
	
	@Test
	void testEquals() {
		assertEquals(town1.equals(town2), false);
		Town copyTown1 = new Town(town1);
		assertEquals(town1.equals(copyTown1), true);
	}
	
	@Test
	void testHashCode() {
		assertEquals(town1.hashCode() == town2.hashCode(), false);
		Town town3 = new Town("Town1");
		assertEquals(town1.hashCode() == town3.hashCode(), true);
	}
	
}
