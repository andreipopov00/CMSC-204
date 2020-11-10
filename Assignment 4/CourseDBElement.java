/**
 * Course element
 * Contains the following fields: course id, room number, instructor name, crn, and credits
 * @author Rose Griffin
 *
 */
public class CourseDBElement implements Comparable {
	private String courseID;
	private String roomNum;
	private String instructorName;
	private int crn;
	private int numCredits;
	
	/**
	 * Default constructor
	 */
	public CourseDBElement() {
		this.courseID = null;
		this.roomNum = null;
		this.instructorName = null;
		this.crn = 0;
		this.numCredits = 0;
	}
	
	/**
	 * Parameterized constructor
	 */
	public CourseDBElement(String courseID, int crn, int numCredits, String roomNum, String instructorName) {
		this.courseID = courseID;
		this.roomNum = roomNum;
		this.instructorName = instructorName;
		this.crn = crn;
		this.numCredits = numCredits;
	}

	@Override
	public int compareTo(CourseDBElement element) {
		if (this.crn > element.crn) {
			return 1;
		} else if (this.crn == element.crn) {
			return 0;
		} else {
			return -1;
		}
	}
	
	//Setters
	
	/**
	 * Changes courseID to a new value
	 * @param courseID
	 */
	public void setCourseID(String courseID) {
		this.roomNum = courseID;
	}
	
	/**
	 * Changes roomNum to a new value
	 * @param roomNum
	 */
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	
	/**
	 * Changes instructorName to a new value
	 * @param instructorName
	 */
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	
	/**
	 * Changes crn to a new value
	 * @param crn
	 */
	public void setCRN(int crn) {
		this.crn = crn;
	}
	
	/**
	 * Changes numCredits to a new value
	 * @param numCredits
	 */
	public void setNumCredits(int numCredits) {
		this.numCredits = numCredits;
	}
	
	//Getters
	
	/**
	 * Gets the course ID
	 * @return courseID
	 */
	public String getCourseID() {
		return this.courseID;
	}
	
	/**
	 * Gets the name of the course's instructor
	 * @return instructorName
	 */
	public String getInstructorName() {
		return this.instructorName;
	}
	
	/**
	 * Gets the course's room number
	 * @return roomNum
	 */
	public String getRoomNum() {
		return this.roomNum;
	}
	
	/**
	 * Gets the course number
	 * @return crn
	 */
	public int getCRN() {
		return this.crn;
	}
	
	/**
	 * Gets the course's number of credits
	 * @return numCredits
	 */
	public int getNumCredits() {
		return this.numCredits;
	}

}
