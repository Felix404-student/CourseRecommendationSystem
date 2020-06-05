package courseRecommendationSystem;
import java.util.HashMap;

/**
 * Singleton design pattern class for the three Major objects
 * Uses CourseLoader to load Major data from file
 * @author natmonz
 */
public class Majors {
	private static Majors majors; 
	private HashMap<String, Major> majorList = new HashMap<String, Major>();
		
	/**
	 * Private constructor to load all majors from file
	 */
	private Majors() {
		this.majorList = CourseLoader.loadMajors();
	}
	
	/**
	 * Public constructor call to ensure we don't access file twice
	 * @return the static Majors object, after majorList has been filled
	 */
	public static Majors getMajors() {
		if (majors == null) {
			majors = new Majors();
		}
		return majors;
	}
	
	/**
	 * function that returns the corresponding major from the Hashmap based on the string name of Major parameter
	 * @param major A String that represents the name of a major
	 * @return Major a Major object 
	 */
	public Major retMajor(String major) {
		return majorList.get(major); 
	}
}