import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
/**
 * Reads courses from file or input from GUI
 * @author Rose Griffin
 *
 */
public class CourseDBManager implements CourseDBManagerInterface{
	CourseDBStructure structure = new CourseDBStructure(4);
	
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement newElement = new CourseDBElement(id, crn, credits, roomNum, instructor);
		structure.add(newElement);
	}

	@Override
	public CourseDBElement get(int crn) {
		try {
			return structure.get(crn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void readFile(File input) throws FileNotFoundException {
		Scanner scanner;
		try {
			scanner = new Scanner(input);
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("The file was not found.");
		}
		
		while (scanner.hasNextLine()) {
			//Splits each term in the line into an array
			String[] args = scanner.nextLine().split(" ");
			
			//Determine name
			String name = "";
			for (int i = 4; i < args.length; i++) {
				name += args[i] + " ";
			}
			add(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3], name);
		}
		scanner.close();
	}

	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> list = new ArrayList<String>();

		//Loop for each list in the hash table
		for (LinkedList<CourseDBElement> elementList: structure.hashTable) {
			
			//Check if index is null before attempting to loop
			if (elementList != null) {
				
				//Loop for each element in the list
				for (CourseDBElement element: elementList) {
					String temp = 
							"\nCourse:" + element.getCourseID() + " CRN:" + element.getCRN() +
							" Credits:" + element.getNumCredits() + " Instructor:" + element.getInstructorName() +
							" Room:" + element.getRoomNum();
					list.add(temp);
				}
			}
		}
		return list;
	}

}
