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
		courseList = CourseLoader.loadCourses();
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
		for(int i = 0; i < courseList.size();++i) {
			if(courseCode.equals(courseList.get(i).getCode())){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * If Course exists, return the instance of the Course
	 * @param courseCode String to search courseList for
	 * @return The Course object from ArrayList courseList
	 */
	public Course getCourse(String courseCode) {
		for(int i = 0; i < courseList.size();++i) {
			if(courseCode.equals(courseList.get(i).getCode())){
				return courseList.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Test method, not used in production 
	 */
	public void printCourses() {
		for(int i = 0; i < courseList.size();++i) {
			System.out.println(courseList.get(i).getCode() + "\t" + courseList.get(i).getName());
		}
	}
}
