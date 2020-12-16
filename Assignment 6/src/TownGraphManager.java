import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Holds and manages a graph object
 * 
 * @author Rose Griffin
 *
 */
public class TownGraphManager implements TownGraphManagerInterface{
	private Graph graph = new Graph();
	
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		try{
			graph.addEdge(graph.getTown(town1), graph.getTown(town2), weight, roadName);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String getRoad(String town1, String town2) {
		return graph.getEdge(graph.getTown(town1), graph.getTown(town2)).getName();
	}

	@Override
	public boolean addTown(String v) {
		try {
			Town town = new Town(v);
			graph.addVertex(town);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Town getTown(String name) {
		return graph.getTown(name);
	}

	@Override
	public boolean containsTown(String v) {
		if (graph.getTown(v) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		if (graph.getEdge(graph.getTown(town1), graph.getTown(town2)) != null){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> allRoads = new ArrayList<String>();
		for (Road road : graph.edgeSet()) {
			allRoads.add(road.getName());
		}
		Collections.sort(allRoads);
		return allRoads;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Road remove = graph.removeEdge(graph.getTown(town1), graph.getTown(town2), 0, road);
		if (remove != null)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteTown(String v) {
		return graph.removeVertex(graph.getTown(v));
	}

	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> allTowns = new ArrayList<String>();
		for (Town town : graph.vertexSet()) {
			allTowns.add(town.getName());
		}
		Collections.sort(allTowns);
		return allTowns;
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		Town sourceVertex = graph.getTown(town1);
		Town destinationVertex = graph.getTown(town2);
		if (sourceVertex != null && destinationVertex != null)
			return graph.shortestPath(graph.getTown(town1), graph.getTown(town2));
		else
			return null;
	}

	/**
	 * Populates the graph using towns and roads from a selected file
	 * 
	 * @param selectedFile
	 * @throws FileNotFoundException
	 */
	public void populateTownGraph(File selectedFile) throws FileNotFoundException {
		try {
			Scanner scanner = new Scanner(selectedFile);
			
			while(scanner.hasNextLine()) {
				String[] vertex = scanner.nextLine().split(";");
				String[] edge = vertex[0].split(",");
				
				Town source = new Town(vertex[1]);
				Town destination = new Town(vertex[2]);
				
				graph.addVertex(source);
				graph.addVertex(destination);
				graph.addEdge(source, destination, Integer.parseInt(edge[1]), edge[0]);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		}
	}

}
