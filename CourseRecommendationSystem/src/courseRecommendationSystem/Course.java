package courseRecommendationSystem;
import java.util.ArrayList;
/**

 * Class that creates a Course object 

 * @author natmonz, dongyu chen

 */
public class Course {
	private String name; 
	private String code; 
	private int credits; 
	protected ArrayList<Course> prerequisites = new ArrayList<Course>();
	protected ArrayList<Course> corequisites = new ArrayList<Course>();
	private boolean courseSpring = false; 
	private boolean courseSummer = false; 
	private boolean courseFall = false; 
	protected String prerequisites_s = "null";
	protected String corequisites_s = "null";
	
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
	 * function that creates a course based on parameters of specific name, course code, and credit 
	 * @param name Name of a course
	 * @param code Course code for a  course
	 * @param credits Amount of credits a course is worth
	 * @param corequisites2 arraylist
	 * @param prerequisites2 arraylist
	 * @param courseOfferingSummer 
	 * @param courseOfferingSpring 
	 * @param courseOfferingFall 
	 */
	Course(String name, String code, int credits, ArrayList<Course> prerequisites2, ArrayList<Course> corequisites2, boolean courseOfferingFall, boolean courseOfferingSpring, boolean courseOfferingSummer) {
		this.name = name; 
		this.code = code; 
		this.credits = credits; 
		this.prerequisites = prerequisites2;
		this.corequisites = corequisites2;
		this.courseSpring = courseOfferingSpring;
		this.courseSummer = courseOfferingSummer;
		this.courseFall = courseOfferingFall;
	}

	/**
	 * 2nd constructor
	 * function that creates a course based on parameters of specific name, course code, and credit 
	 * @param name Name of a course
	 * @param code Course code for a  course
	 * @param credits Amount of credits a course is worth
	 * @param corequisites2 string
	 * @param prerequisites2 
	 * @param courseOfferingSummer 
	 * @param courseOfferingSpring 
	 * @param courseOfferingFall 
	 */
	Course(String name, String code, int credits, String prerequisites_s, String corequisites_s, boolean courseOfferingFall, boolean courseOfferingSpring, boolean courseOfferingSummer) {
		this.name = name; 
		this.code = code; 
		this.credits = credits; 
		this.prerequisites_s = prerequisites_s;
		this.corequisites_s = corequisites_s;
		this.courseSpring = courseOfferingFall;
		this.courseSummer = courseOfferingSummer;
		this.courseFall = courseOfferingFall;
	}
	
	/**
	 * function that returns the name of a course
	 * @return String Name of a course
	 */
	public String getName() {
		return this.name; 
	}
	
	/**
	 * function that returns the Course Code of the course
	 * Used for searching through courses
	 * @return Course Code for the course
	 */
	public String getCode() {
		return this.code;
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
		return "Course: " + name + "\tCode: " + code + "\tCredits: " + credits; 
	}
}
