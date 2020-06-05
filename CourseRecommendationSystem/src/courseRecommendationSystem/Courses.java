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
	public boolean haveCourse(String code) {
		for(int i = 0; i < courseList.size();++i) {
			if(code.equals(courseList.get(i).getCode())){
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
	public Course getCourse(String code) {
		for(int i = 0; i < courseList.size();++i) {
			if(code.equals(courseList.get(i).getCode())){
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
	
	/**
	 * Iterates through courseList and connects all courses to their prerequisites (if it can find them in courseList)
	 * Call after all courses are loaded.
	 */
	public void connectPrerequisites() {
		for(int i = 0; i < courseList.size();++i) {
			String[] prereqArray = courseList.get(i).prerequisites_s.split(",");
			for (int j = 0; j < prereqArray.length; ++j) {
				if (courses.haveCourse(prereqArray[j])) {
					courseList.get(i).setPrerequisite(courses.getCourse(prereqArray[j]));
				}
			}
			// Tests to see if it worked
			/*
			System.out.print(courseList.get(i).getCode() + "\t");
			for (int k = 0; k < courseList.get(i).prerequisites.size(); ++k) {
				System.out.print(courseList.get(i).prerequisites.get(k).getCode() + " ");
			}
			System.out.println();*/
		}
	}
	
	/**
	 * Iterates through courseList and connects all courses to their COrequisites (if it can find them in courseList)
	 * Call after all courses are loaded.
	 */
	public void connectCorequisites() {
		for(int i = 0; i < courseList.size();++i) {
			String[] coreqArray = courseList.get(i).corequisites_s.split(",");
			for (int j = 0; j < coreqArray.length; ++j) {
				if (courses.haveCourse(coreqArray[j])) {
					courseList.get(i).setCorequisite(courses.getCourse(coreqArray[j]));
				}
			}
			/* Tests to see if it worked
			System.out.print(courseList.get(i).getCode() + "\t");
			for (int k = 0; k < courseList.get(i).corequisites.size(); ++k) {
				System.out.print(courseList.get(i).corequisites.get(k).getCode() + " ");
			}
			System.out.println();*/
		}
	}
	
	
}