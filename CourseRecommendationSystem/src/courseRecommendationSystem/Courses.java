package courseRecommendationSystem;
import java.util.ArrayList;

/**
 * Singleton design pattern class for Course objects
 * Uses CourseLoader to load Course data from file
 * @author justinbrown
 */
public class Courses {
	private static Courses courses;
	private ArrayList<Course> courseList;
	
	/**
	 * Private constructor to load all courses from file
	 */
	private Courses() {
		courseList = CourseLoader.loadCourse();
	}
	
	/**
	 * Public constructor call to ensure we don't access file twice
	 * @return the static courses object, after courseList has been filled
	 */
	public static Courses getCourses() {
		if (courses == null) {
			courses = new Courses();
		}
		return courses;
	}
	
	/**
	 * Check if the Course exists
	 * @param courseCode String to search courseList for
	 * @return Whether or not the system can find that course
	 */
	public boolean haveCourse(String courseCode) {
		return true;
	}
	
	/**
	 * If Course exists, return the instance of the Course
	 * @param courseCode String to search courseList for
	 * @return The Course from
	 */
	public Course getCourse(String courseCode) {
		if (!haveCourse(courseCode)) {
			return null;
		}
		return null;
	}
}
