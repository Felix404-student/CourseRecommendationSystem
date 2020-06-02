package classes;

import java.util.ArrayList;
/**
 * Class that creates a Course object 
 * @author natmonz
 */
public class Course {
	private String name = null; 
	private String code = null; 
	private int credits = 0; 
	private ArrayList<Course> prerequisites = new ArrayList<Course>();
	private ArrayList<Course> corequisites = new ArrayList<Course>();
	private boolean courseSpring = false; 
	private boolean courseSummer = false; 
	private boolean courseFall = false; 
	
	/**
	 * function that creates a course based on parameters of specific name, course code, and credit 
	 * @param name Name of a course
	 * @param code Course code for a  course
	 * @param credits Amount of credits a course is worth
	 */
	Course(String name, String code, int credits) {
		this.name = name; 
		this.code = code; 
		this.credits = credits; 
	}
	
	/**
	 * function that returns the name of a course
	 * @return String Name of a course
	 */
	public String getName() {
		return this.name; 
	}
	
	/**
	 * function that returns the number of credits of a course
	 * @return int Number of credits of a course
	 */
	public int getCredits() {
		return this.credits; 
	}
	
	/**
	 * function that adds a corequisite to the Arraylist of corequisites for a course
	 * @param prerequisite A course
	 */
	public void setCorequisite(Course corequisite) {
		corequisites.add(corequisite); 
	}
	
	/**
	 * function that adds a prerequisite to the Arraylist of prerequisites for a course
	 * @param prerequisite A course
	 */
	public void setPrerequisite(Course prerequisite) {
		prerequisites.add(prerequisite); 
	}
	
	/**
	 * function that removes a prerequisite to the ArrayList of prerequisites for a course
	 * @param prerequisite
	 */
	public void removePrerequisite(Course prerequisite) {
		prerequisites.remove(prerequisite); 
	}
	
	/**
	 * function that sets the value of courseSpring to true
	 */
	public void courseOfferedSpring() {
		this.courseSpring = true; 
	}
	
	/**
	 * function that sets the value of courseSummer to true
	 */
	public void courseOfferedSummer() {
		this.courseSummer = true; 
	}
	
	/**
	 * function that sets the value of courseFall to true
	 */
	public void courseOfferedFall() {
		this.courseFall= true; 
	}
	
	/**
	 * function that returns a string representation of the course information 
	 * @return String 
	 */
	public String toString() {
		return "Course: " + name + " Code: " + " Credits: " + credits; 
	}
}