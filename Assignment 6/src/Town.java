import java.util.ArrayList;

/**
 * Vertex
 * 
 * @author Rose Griffin
 *
 */
public class Town implements Comparable<Town>{
	
	private String name;
	private ArrayList<Town> adjacentTowns;
	
	/**
	 * Constructor
	 * @param name - name of the town
	 */
	public Town (String name) {
		this.name = name;
		adjacentTowns = new ArrayList<Town>();
		
	}
	
	/**
	 * Copy constructor
	 * @param templateTown - an instance of Town
	 */
	public Town(Town templateTown) {
		this.name = templateTown.getName();
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Town> getTowns() {
		return adjacentTowns;
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
