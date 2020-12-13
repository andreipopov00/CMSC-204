/**
 * Edge
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
	
	public boolean contains(Town town) {
		return false;
	}
	
	public String toString() {
		return name;
	}
	
	public String getName() {
		return name;
	}
	
	public Town getDestination() {
		return destination;
	}
	
	public Town getSource() {
		return source;
	}
	
	public int getWeight() {
		return weight;
	}
	
	@Override
	public int compareTo(Road o) {
		return o.getName().compareTo(name);
	}
	
	public boolean equals(Object r) {
		if (!(r instanceof Road) || !(compareTo((Road) r) == 0)) {
			return false;
		} else {
			return true;
		}
	}
	
}
