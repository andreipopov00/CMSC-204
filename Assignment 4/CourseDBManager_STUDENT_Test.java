import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class CourseDBManager_STUDENT_Test {
	private CourseDBManagerInterface manager = new CourseDBManager();
	
	@Before
	public void setUp() throws Exception {
		manager = new CourseDBManager();
	}
	
	@After
	public void tearDown() throws Exception {
		manager = null;
	}
	
	@Test
	public void testAddToDB() {
		manager.add("CMSC140",37521,3,"SW230","Jessica Hernandez");
		manager.add("CMSC140",33262,3,"SW321","Jason Brown");
		
		ArrayList<String> list = manager.showAll();
		assertEquals(list.get(0),"\nCourse:CMSC140 CRN:37521 Credits:3 Instructor:Jessica Hernandez Room:SW230");
		assertEquals(list.get(1),"\nCourse:CMSC140 CRN:33262 Credits:3 Instructor:Jason Brown Room:SW321");
	}
	
	@Test
	public void testShowAll() {
		manager.add("CMSC140",37521,3,"SW230","Jessica Hernandez");
		manager.add("CMSC140",33262,3,"SW321","Jason Brown");
		manager.add("CMSC203",46212,4,"SW230","Andrew Daniels");
		manager.add("CMSC203",34682,4,"SC101","Jason Brown");
		ArrayList<String> list = manager.showAll();
		System.out.println(list.toString());
		assertEquals(list.get(0),"\nCourse:CMSC203 CRN:46212 Credits:4 Instructor:Andrew Daniels Room:SW230");
		assertEquals(list.get(1),"\nCourse:CMSC203 CRN:34682 Credits:4 Instructor:Jason Brown Room:SC101");
		assertEquals(list.get(2),"\nCourse:CMSC140 CRN:33262 Credits:3 Instructor:Jason Brown Room:SW321");
		assertEquals(list.get(3),"\nCourse:CMSC140 CRN:37521 Credits:3 Instructor:Jessica Hernandez Room:SW230");
	}
	
	@Test
	public void testGet() {
		manager.add("CMSC140",33262,3,"SW321","Jason Brown");

		CourseDBElement element1 = manager.get(33262);
		assertEquals(element1.getCRN(), 33262);
	}

	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test2.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC140 37521 3 SW230 Jessica Hernandez");
			inFile.println("CMSC140 33262 3 SW321 Jason Brown");
			inFile.println("CMSC203 46212 4 SW230 Andrew Daniels");
			inFile.println("CMSC203 34682 4 SC101 Jason Brown");
			
			inFile.close();
			manager.readFile(inputFile);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Should not have thrown an exception");
		}
	}
}
