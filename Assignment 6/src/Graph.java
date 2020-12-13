import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Graph implements GraphInterface{
	
	private HashSet<Town> towns;
	private HashSet<Road> roads;
	
	@Override
	public Object getEdge(Object sourceVertex, Object destinationVertex) {
		return null;
	}

	@Override
	public Object addEdge(Object sourceVertex, Object destinationVertex, int weight, String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addVertex(Object v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsEdge(Object sourceVertex, Object destinationVertex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsVertex(Object v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set edgeSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set edgesOf(Object vertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object removeEdge(Object sourceVertex, Object destinationVertex, int weight, String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeVertex(Object v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set vertexSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList shortestPath(Object sourceVertex, Object destinationVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dijkstraShortestPath(Object sourceVertex) {
		// TODO Auto-generated method stub
		
	}

}
