import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Road_STUDENT_Test {
	private Town town1;
	private Town town2;
	private Road road1;
	
	@BeforeEach
	void setUp() throws Exception {
		town1 = new Town("Town 1");
		town2 = new Town("Town 2");
		road1 = new Road(town1, town2, 5, "Road 1");
	}

	@AfterEach
	void tearDown() throws Exception {
		town1 = town2 = null;
		road1 = null;
	}

	@Test
	void testContains() {
		assertEquals(road1.contains(town1), true);
		assertEquals(road1.contains(town2), true);
	}
	
	@Test
	void testDestination() {
		assertEquals(road1.getDestination().equals(town2), true);
	}
	
	@Test
	void testSource() {
		assertEquals(road1.getSource().equals(town1), true);
	}
	
	@Test
	void testWeight() {
		assertEquals(road1.getWeight() == 5, true);
	}
	
	@Test
	void testCompare() {
		Road road2 = new Road(town2, town1, 7, "Road 1");
		assertEquals(road1.compareTo(road2), 0);
		
		Road road3 = new Road(town1, town2, 5, "Road 2");
		assertEquals(road1.compareTo(road3), 1);
		
	}
	
	@Test
	void testEquals() {
		Road road2 = new Road(town2, town1, 7, "Road 1");
		assertEquals(road1.equals(road2), true);
	}
}
