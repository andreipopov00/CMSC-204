/**
 * Creates a road, which serves as an edge and holds the following: the source town, the destination town, the distance between those two towns, and
 * the name of the road
 * 
 * @author Rose Griffin
 *
 */
public class Road implements Comparable<Road>{
	private Town source;
	private Town destination;
	private int weight;
	private String name;
	
	/**
	 * Constructor
	 * 
	 * @param source - Source of road
	 * @param destination Destination of road
	 * @param weight - Distance between source and destination
	 * @param name - name of the road
	 */
	public Road(Town source, Town destination, int weight, String name) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
		this.name = name;
	}
	
	/**
	 * Constructor where weight is set to 1
	 * @param source - Source of road
	 * @param destination Destination of road
	 * @param name - name of the road
	 */
	public Road(Town source, Town destination, String name) {
		this.source = source;
		this.destination = destination;
		this.weight = 1;
		this.name = name;
	}
	
	/**
	 * Checks if the road is connected by a town
	 * @param town - town to check
	 * @return - true if the road is connected by this town, false if not.
	 */
	public boolean contains(Town town) {
		return town.equals(source) || town.equals(destination);
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	/**
	 * Gets the name of the road
	 * @return - name of the road
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the destination
	 * @return - destination
	 */
	public Town getDestination() {
		return destination;
	}
	
	/**
	 * Gets the source
	 * @return - source
	 */
	public Town getSource() {
		return source;
	}
	
	/**
	 * Gets the distance
	 * @return - distance
	 */
	public int getWeight() {
		return weight;
	}
	
	@Override
	public int compareTo(Road o) {
		return o.getName().compareTo(name);
	}
	
	@Override
	public boolean equals(Object r) {
		if (!(r instanceof Road) || !(compareTo((Road) r) == 0)) {
			return false;
		} else {
			return true;
		}
	}
	
}
