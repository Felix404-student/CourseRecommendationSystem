package courseRecommendationSystem;
import java.util.ArrayList;

/**
 * Singleton design pattern class for Student objects
 * Uses CourseLoader to load Student data from file
 * @author justinbrown
 */
public class Students {
	private static Students students;
	private ArrayList<Student> studentList;
	
	/**
	 * Private constructor to load all students from file
	 */
	private Students() {
		studentList = CourseLoader.loadStudents();
	}
	
	/**
	 * Public constructor call to ensure we don't access file twice
	 * @return the static Student object, after studentList has been filled
	 */
	public static Students getStudents() {
		if (students == null) {
			students = new Students();
		}
		return students;
	}
	
	/**
	 * Check if the Student exists
	 * @param name String to search studentList for
	 * @return Whether or not the system can find that Student
	 */
	public boolean haveStudent(String name) {
		return true;
	}
	
	/**
	 * If Student exists, return the instance of the Student
	 * @param name String to search studentList for
	 * @return The Student object from ArrayList studentList
	 */
	public Student getStudent(String name) {
		if (!haveStudent(name)) {
			return null;
		}
		return null;
	}
}
