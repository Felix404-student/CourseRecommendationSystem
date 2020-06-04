package courseRecommendationSystem;
import java.util.ArrayList;

/**
 * Singleton design pattern class for Advisor objects
 * Uses CourseLoader to load Advisor data from file
 * @author justinbrown dongyu chen
 */
public class Advisors {
	private static Advisors advisors;
	private ArrayList<Advisor> advisorList;
	
	/**
	 * Private constructor to load all students from file
	 */
	private Advisors() {
		advisorList = CourseLoader.loadAdvisors();
	}
	
	/**
	 * Public constructor call to ensure we don't access file twice
	 * @return the static Advisor object, after advisorList has been filled
	 */
	public static Advisors getAdvisors() {
		if (advisors == null) {
			advisors = new Advisors();
		}
		return advisors;
	}
	
	/**
	 * Check if the Advisor exists
	 * @param name String to search advisorList for
	 * @return Whether or not the system can find that Advisor
	 */
	public boolean haveAdvisor(String name) {
		for(int i = 0; i < advisorList.size();i++) {
			if(name.equals(advisorList.get(i).getName())){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * If Student exists, return the instance of the Student
	 * @param name String to search studentList for
	 * @return The Advisor object from ArrayList advisorList
	 */
	public Advisor getAdvisor(String name) {
		if (!haveAdvisor(name)) {
			return null;
		}else {
			for(int i = 0; i < advisorList.size();i++) {
				if(name.equals(advisorList.get(i).getName())){
					return advisorList.get(i);
				}
			}
		}
		return null;
	}
}
