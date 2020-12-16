import java.util.ArrayList;

/**
 * Creates a Town, which serves as a vertex and holds the following: a name, an arraylist of adjacent towns, a reference to the previous town visited,
 * the distance between this town and the previous, and a boolean that holds if the town has already been visited.
 * 
 * @author Rose Griffin
 *
 */
public class Town implements Comparable<Town>{
	
	private String name;
	private ArrayList<Town> adjacentTowns;
	private Town prevTown;
	private int weight;
	private boolean visited;
	
	/**
	 * Constructor
	 * @param name - name of the town
	 */
	public Town (String name) {
		this.name = name;
		adjacentTowns = new ArrayList<Town>();
		weight = Integer.MAX_VALUE;
		visited = false;
	}
	
	/**
	 * Copy constructor
	 * @param templateTown - an instance of Town
	 */
	public Town(Town templateTown) {
		this.name = templateTown.getName();
		adjacentTowns = templateTown.getTowns();
		weight = templateTown.getWeight();
		visited = templateTown.wasVisited();
	}
	
	/**
	 * Sets if the town has been visited or not
	 * @param b - if town was visited
	 */
	public void setVisited(boolean b) {
		visited = b;
	}
	
	/**
	 * Returns if the town was visited or not
	 * @return - value of visited
	 */
	public boolean wasVisited() {
		return visited;
	}
	
	/**
	 * Sets the distance between current town and previous town
	 * @param weight - distance
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	/**
	 * Gets the distance of the town
	 * @return - distance
	 */
	public int getWeight() {
		return weight;
	}
	
	/**
	 * Sets the previous town
	 * @param prevTown - previous town
	 */
	public void setPrevTown(Town prevTown) {
		this.prevTown = prevTown;
	}
	
	/**
	 * Gets the previous town
	 * @return - previous town
	 */
	public Town getPrevTown(){
		return prevTown;
	}
	
	/**
	 * Gets the name of the town
	 * @return - name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets list of adjacent towns
	 * @return - adjacent towns
	 */
	public ArrayList<Town> getTowns() {
		return adjacentTowns;
	}
	
	/**
	 * Adds a town to the adjacent town list
	 * @param town - adjacent town
	 */
	public void addAdjacentTown(Town town) {
		adjacentTowns.add(town);
	}
	
	@Override
	public int compareTo(Town o) {
		return o.getName().compareTo(name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Town) || !(compareTo((Town) obj) == 0)) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	/**
	 * hashCode method for Town. Two towns are considered equal if they have the same name.
	 */
	public int hashCode() {
		return name.hashCode();
	}
	
}
