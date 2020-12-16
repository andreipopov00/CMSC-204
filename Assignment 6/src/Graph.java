import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Creates a weighted graph, where towns are the vertices and roads are the edges.
 * 
 * @author Rose Griffin
 *
 */
public class Graph implements GraphInterface<Town, Road>{
	
	private HashSet<Town> towns = new HashSet<Town>();
	private HashSet<Road> roads = new HashSet<Road>();
	
	//For dijkstraShortestPath
	private ArrayList<Town> unvisited;
	private ArrayList<Town> visited;
	
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		for (Road road : roads) {
			if (road.contains(sourceVertex) && road.contains(destinationVertex))
				return road;
		}
		return null;
	}
	
	/**
	 * Finds the town given the name
	 * @param name - name of town
	 * @return - corresponding town object
	 */
	public Town getTown(String name) {
		Town findTown = null;
		for (Town town : towns) {
			if (town.getName().equals(name)) {
				findTown = town;
				break;
			}
		}
		return findTown;
	}
	
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if (sourceVertex == null || destinationVertex == null) {
			throw new NullPointerException();
		} else if (!containsVertex(sourceVertex) || !containsVertex(destinationVertex)) {
			throw new IllegalArgumentException();
		} else {
			Road road = new Road(sourceVertex, destinationVertex, weight, description);
			sourceVertex.addAdjacentTown(destinationVertex);
			destinationVertex.addAdjacentTown(sourceVertex);
			roads.add(road);
			return road;
		}
	}
	
	@Override
	public boolean addVertex(Town v) {
		if (v == null) {
			throw new NullPointerException();
		} else if (containsVertex(v)) {
			return false;
		} else {
			towns.add(v);
			return true;
		}
	}
	
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		for (Road road : roads) {
			if (road.getSource().equals(sourceVertex) && road.getDestination().equals(destinationVertex))
				return true;
		}
		return false;
	}
	
	@Override
	public boolean containsVertex(Town v) {
		for (Town town : towns) {
			if (town.equals(v)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public Set<Road> edgeSet() {
		return roads;
	}
	
	@Override
	public Set<Road> edgesOf(Town vertex) {
		if (vertex == null) {
			throw new NullPointerException();
		} else if (!containsVertex(vertex)) {
			throw new IllegalArgumentException();
		} else {
			Set<Road> set = new HashSet<Road>();
			for (Road road : roads) {
				if (road.contains(vertex))
					set.add(road);
			}
			return set;
		}
	}
	
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if (weight >- 1  || description != null) {
			for (Road road : roads) {
				if (road.contains(sourceVertex) && road.contains(destinationVertex)) {
					Road temp = road;
					roads.remove(road);
					return temp;
				}
			}
		}
		return null;
	}
	
	@Override
	public boolean removeVertex(Town v) {
		if (v != null) {
			for(Town town : towns) {
				if(town.equals(v)) {
					//First remove road
					ArrayList<Town> adjacentTowns = town.getTowns();
					for (Town adjacentTown : adjacentTowns) {
						roads.remove(getEdge(v, adjacentTown));
					}
					towns.remove(v);
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public Set<Town> vertexSet() {
		return towns;
	}
	
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		dijkstraShortestPath(sourceVertex);
		ArrayList<String> shortestPath = new ArrayList<String>();
		Town destTown = destinationVertex;
		Town prevTown = destTown.getPrevTown();
		
		//If only one town was visited, the previous town will be null
		if (visited.size() == 1) {
			prevTown = visited.get(0);
		}
		
		//Loop until source is reached
		while (prevTown != null) {
			Road road = getEdge(prevTown, destTown);
			shortestPath.add(prevTown.getName() + " via " + road.getName() + " to " + destTown.getName() + " " + road.getWeight() + " mi");
			destTown = prevTown;
			prevTown = destTown.getPrevTown();
		}
		Collections.reverse(shortestPath);
		return shortestPath;
	}
	
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		unvisited = new ArrayList<Town>();
		for (Town town : towns) {
			unvisited.add(town);
		}
		visited = new ArrayList<Town>();
		
		sourceVertex.setWeight(0);
		
		while(!unvisited.isEmpty()) {
			int weight = 0;
			
			//Find unvisited vertex with smallest known distance
			int smallestDistance = Integer.MAX_VALUE;
			Town currentTown = null;
			for(int i = 0; i < unvisited.size(); i++) {
				if (unvisited.get(i).getWeight() < smallestDistance) {
					currentTown = unvisited.get(i);
					smallestDistance = unvisited.get(i).getWeight();
				}
			}
			if (currentTown != null) {
				currentTown.setVisited(true);
				weight += smallestDistance;
				System.out.println("Source is now: " + currentTown);
			
				//Visit each unvisited neighbor of currentTown
				ArrayList<Town> adjacentTowns = currentTown.getTowns();
				for (Town adjacentTown : adjacentTowns) {
					if (!adjacentTown.wasVisited()) {
						int distance = getEdge(currentTown, adjacentTown).getWeight() + weight;
						if (distance < adjacentTown.getWeight()) {
							adjacentTown.setWeight(distance);
							adjacentTown.setPrevTown(currentTown);
							System.out.println("Distance from " + currentTown + " and " + adjacentTown + " is " + distance);
						}	
					}
				}
				visited.add(currentTown);
				unvisited.remove(currentTown);
				System.out.println(visited + " vs " + unvisited + "\n");
			} else {
				break;
			}
		}
	}

}
