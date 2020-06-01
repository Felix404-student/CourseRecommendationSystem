package classes;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * Class that creates a Student object that inherits from User 
 * @author natmonz
 */
public class Student extends User{
	private int studentID = 0; 
	private Major major = null;
	protected ArrayList<Course> coursesTaken = new ArrayList<Course>();
	protected ArrayList<Course> coursesNow = new ArrayList<Course>();; 
	protected HashMap<Course, String> grades = new HashMap<Course, String>();
	private double cumulativeGPA = 0; 
	
	/**
	 * function that creates a student object with values from the parameters
	 * @param name String name of Student
	 * @param studentID Integer student's ID
	 * @param major String of student's major
	 * @param cumulativeGPA Double of Student's overall GPA
	 */
	Student(String name, int studentID, String major, double cumulativeGPA) {
		this.name = name; 
		this.classification = "Student"; 
		this.studentID = studentID; 
		setMajor(major); 
		this.cumulativeGPA = cumulativeGPA; 
	}
	
	/**
	 * function that sets a Student's major and sets major to computer science default if it is anything besides 3 specific majors
	 * @param major String that is a Student's major
	 */
	public void setMajor(String major) {
		if(major != "cs" && major != "ce" && major != "cis") {
			System.out.println("The system only works for computer science, computer engineering, "
								+ "and computer information system majors. The major will default to cs");
			this.major = new Major("cs"); 
		}
		else { 
			this.major = new Major(major); 
		}
	}
	
	/**
	 * adds a course and its corresponding grade to a hashmap
	 * @param course A course a student has taken 
	 * @param grade The grade a student received in the course
	 */
	public void addGrade(Course course, String grade) {
		grades.put(course, grade); 
	}
	
	/**
	 * function that adds a course to the Arraylist of courses taken by a student 
	 * @param course A course
	 * @param grade A String that is the grade received in a course
	 */
	public void addCourseTaken(Course course, String grade) {
		coursesTaken.add(course); 
		grades.put(course, grade);
	}
	
	/**
	 * function that adds a course to the Arraylist of courses currently taken by a student 
	 * @param course A course
	 */
	public void addCourseCurrent(Course course) {
		coursesNow.add(course); 
	}
	
	/**
	 * function that returns the GPA of a student
	 * @return double GPA of student
	 */
	public double getGPA() {
		// traverse through hashmap and for each mapping, evaluate the grade, and then based on that assign quality points to 
		// that grade, add them all up and divide by number of credits
		return this.cumulativeGPA;
	}
	
	/**
	 * function that returns information about the details of a student user 
	 * @return String
	 */
	public String toString() {
		return super.toString() + " Major: " + major + " GPA: " + cumulativeGPA; 
	}
}