import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Graph_STUDENT_Test {
	private Graph graph;
	private Town[] town;
	
	@BeforeEach
	void setUp() throws Exception {
		 graph = new Graph();
		 town = new Town[6];
		 
		 for (int i = 0; i < town.length-1; i++) {
			 town[i] = new Town("Town " + i);
			 graph.addVertex(town[i]);
		 }
		 
		  graph.addEdge(town[0], town[1], 2, "Road 1");
		  graph.addEdge(town[0], town[4], 7, "Road 2");
		  graph.addEdge(town[1], town[4], 3, "Road 3");
		  graph.addEdge(town[4], town[3], 2, "Road 4");
		  graph.addEdge(town[3], town[1], 8, "Road 5");
		  graph.addEdge(town[3], town[2], 7, "Road 6");
		  graph.addEdge(town[1], town[2], 1, "Road 7");
	}

	@AfterEach
	void tearDown() throws Exception {
		graph = null;
		town = null;
	}

	@Test
	void testEdge() {
		assertEquals(graph.getEdge(town[1], town[4]).getName(), "Road 3");
		
		graph.addEdge(town[3], town[0], 2, "Road 8");
		assertEquals(graph.getEdge(town[3], town[0]).getName(), "Road 8");
		assertEquals(graph.containsEdge(town[3], town[0]), true);
		assertEquals(graph.containsEdge(town[0], town[2]), false);
		
		graph.removeEdge(town[3], town[0], 2, "Road 8");
		assertEquals(graph.containsEdge(town[3], town[0]), false);
		assertEquals(graph.edgesOf(town[0]).size(), 2);
		assertEquals(graph.edgeSet().size(), 7);
	}
	
	@Test
	void testVertex() {
		assertEquals(graph.getTown("Town 0"), town[0]);
		
		town[5] = new Town("Town 5");
		graph.addVertex(town[5]);
		assertEquals(graph.getTown("Town 5"), town[5]);
		assertEquals(graph.containsVertex(town[3]), true);
		
		graph.removeVertex(town[5]);
		assertEquals(graph.containsVertex(town[5]), false);
		assertEquals(graph.vertexSet().size(), 5);
	}
	
	@Test
	void testFrom0To4() {
		ArrayList<String> path = graph.shortestPath(town[0], town[4]);
		assertEquals(path.get(0), "Town 0 via Road 1 to Town 1 2 mi");
		assertEquals(path.get(1), "Town 1 via Road 3 to Town 4 3 mi");
	}
	
	@Test
	void testFrom4To2() {
		ArrayList<String> path = graph.shortestPath(town[4], town[2]);
		assertEquals(path.get(0), "Town 4 via Road 3 to Town 1 3 mi");
		assertEquals(path.get(1), "Town 1 via Road 7 to Town 2 1 mi");
	}
	
	@Test
	void testFrom2To3() {
		ArrayList<String> path = graph.shortestPath(town[2], town[3]);
		assertEquals(path.get(0), "Town 2 via Road 7 to Town 1 1 mi");
		assertEquals(path.get(1), "Town 1 via Road 3 to Town 4 3 mi");
		assertEquals(path.get(2), "Town 4 via Road 4 to Town 3 2 mi");
	}
}
