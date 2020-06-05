package courseRecommendationSystem;

import java.util.ArrayList;
import java.util.HashMap; 
/**
 * Class that creates a major object 
 * @author natmonz
 */
public class Major {
	private String majorName; 
	private ArrayList<String> courses = new ArrayList<String>(); 
	/**
	 * function that creates a Major
	 * @param majorName String of a type of major, classes, A String ArrayList of required courses
	 */
	Major(String majorName, ArrayList<String> courses) {
		this.majorName = majorName; 
		this.courses = courses; 
	}
	
	/**
	 * function that returns the name of the major
	 * @return String A major name 
	 */
	public String getName() {
		return this.majorName; 
	}
	/**
	 * function that returns the ArrayList of required courses for a major
	 * @return ArrayList<String> of required courses
	 */
	public ArrayList<String> getCourses() {
		return this.courses; 
	}
}