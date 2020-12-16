import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TownGraphManager_STUDENT_Test {
	private TownGraphManager graph;
	private String[] town;
	
	@BeforeEach
	void setUp() throws Exception {
		 graph = new TownGraphManager();
		 town = new String[6];
		 
		 for (int i = 0; i < town.length-1; i++) {
			 town[i] = "Town " + i;
			 graph.addTown(town[i]);
		 }
		 
		  graph.addRoad(town[0], town[1], 2, "Road 1");
		  graph.addRoad(town[0], town[4], 7, "Road 2");
		  graph.addRoad(town[1], town[4], 3, "Road 3");
		  graph.addRoad(town[4], town[3], 2, "Road 4");
		  graph.addRoad(town[3], town[1], 8, "Road 5");
		  graph.addRoad(town[3], town[2], 7, "Road 6");
		  graph.addRoad(town[1], town[2], 1, "Road 7");
	}

	@AfterEach
	void tearDown() throws Exception {
		graph = null;
		town = null;
	}

	@Test
	void testRoad() {
		assertEquals(graph.getRoad("Town 0", "Town 1"), "Road 1");
		graph.addRoad("Town 4", "Town 2", 4, "Road 8");
		assertEquals(graph.getRoad("Town 4", "Town 2"), "Road 8");
		
		assertEquals(graph.containsRoadConnection("Town 1", "Town 2"), true);
		assertEquals(graph.containsRoadConnection("Town 2", "Town 0"), false);
		
		assertEquals(graph.deleteRoadConnection("Town 4", "Town 2", "Road 8"), true);
		assertEquals(graph.allRoads().size(), 7);
	}
	
	@Test
	void testTown() {
		Town town1 = new Town(town[1]);
		assertEquals(graph.getTown(town[1]), town1);
		
		Town town5 = new Town("Town 5");
		graph.addTown(town5.getName());
		assertEquals(graph.getTown("Town 5"), town5);
		
		graph.deleteTown("Town 5");
		assertEquals(graph.containsTown("Town 5"), false);
		assertEquals(graph.allTowns().size(), 5);
	}
	
	@Test
	void testPath3to0() {
		ArrayList<String> path = graph.getPath("Town 3", "Town 0");
		assertEquals(path.get(0), "Town 3 via Road 4 to Town 4 2 mi");
		assertEquals(path.get(1), "Town 4 via Road 3 to Town 1 3 mi");
		assertEquals(path.get(2), "Town 1 via Road 1 to Town 0 2 mi");
	}
	
	@Test
	void testImpossiblePath() {
		graph.addTown("Town 8");
		ArrayList<String> path = graph.getPath("Town 0", "Town 8");
		assertEquals(path.size() == 0, true);
	}
	
	@Test
	void testPath1to3() {
		ArrayList<String> path = graph.getPath("Town 1", "Town 3");
		assertEquals(path.get(0), "Town 1 via Road 3 to Town 4 3 mi");
		assertEquals(path.get(1), "Town 4 via Road 4 to Town 3 2 mi");
	}
}
