package courseRecommendationSystem;

import java.util.ArrayList;
import java.util.HashMap; 
/**
 * Class that creates a major object 
 * @author natmonz
 */
public class Major {
	private HashMap<String, String[]> majors = new HashMap<String, String[]>(); 

	/**
	 * function that creates a Major
	 * @param majorName String of a type of major, classes, A String array of required courses
	 */
	Major(HashMap<String, String[]> majors) {
		this.majors = majors; 
	}
}