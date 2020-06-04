package courseRecommendationSystem;

import java.util.ArrayList;
import java.util.Map; 
import java.util.HashMap;
/**
 * Class that creates a Student object that inherits from User 
 * @author natmonz
 */
public class Student extends User{
	private String studentID; 
	//private Major major;
	protected String major; 
	//protected String[] requiredCourses = new String[]; 
	protected ArrayList<Course> coursesTaken = new ArrayList<Course>();
	protected ArrayList<Course> coursesNow = new ArrayList<Course>(); 
	protected HashMap<Course, String> grades = new HashMap<Course, String>();
	private double cumulativeGPA; 
	
	/**
	 * function that creates a student object with values from the parameters
	 * @param name String name of Student
	 * @param studentID Integer student's ID
	 * @param major String of student's major
	 */
	Student(String name, String studentID, String major) {
		this.name = name; 
		this.studentID = studentID; 
		setMajor(major); 
		this.cumulativeGPA = 0.0; 
	}
	
	/**
	 * function that sets a Student's major and sets major to computer science default if it is anything besides 3 specific majors
	 * @param major String that is a Student's major
	 */
	public void setMajor(String major) {
		if(major.equalsIgnoreCase("cs") || (major.equalsIgnoreCase("ce")) || (major.equalsIgnoreCase("cis")) ) {
			this.major = major; 
			//this.requiredCourses = Major.get(major); 
		}
		else { 
			this.major = "cs";
			//this.requiredCourses = Major.get("cs"); 
		}
	}
	
	/**
	 * adds a course and its corresponding grade to a hashmap
	 * @param course A course a student has taken 
	 * @param grade The grade a student received in the course
	 */
	public void addGrade(Course course, String grade) {
		grades.put(course, grade);
		updateGPA(); 
	}
	
	/**
	 * function that adds a course to the Arraylist of courses taken by a student 
	 * @param course A course
	 * @param grade A String that is the grade received in a course
	 */
	public void addCourseTaken(Course course, String grade) {
		coursesTaken.add(course); 
		grades.put(course, grade);
		updateGPA(); 
	}
	
	/**
	 * function that adds a course to the Arraylist of courses currently taken by a student 
	 * @param course A course
	 */
	public void addCourseCurrent(Course course) {
		coursesNow.add(course); 
	}
	
	/**
	 * function that updates a student's GPA and changes the value of the cumulativeGPA accordingly 
	 */
	public void updateGPA() {
		double gradePoints = 0; 
		double totalCredits = 0; 
		for (Map.Entry<Course, String> entry : grades.entrySet()) {
			Course course = entry.getKey(); 
			gradePoints += qualityPoints(entry.getValue())* course.getCredits(); 
			totalCredits += course.getCredits();
			// key -> value
		}
		this.cumulativeGPA = (gradePoints/totalCredits); 
	}
	
	/**
	 * function that returns a double value of quality points based on letter grade parameter
	 * @param grade Letter grade received
	 * @return double Quality points of grade
	 */
	public double qualityPoints(String grade) {
		HashMap<String, Double> letterGrades = new HashMap<String, Double>(); 
		letterGrades.put("A", 4.0);
		letterGrades.put("B+", 3.5);
		letterGrades.put("B", 3.0);
		letterGrades.put("C+", 2.5);
		letterGrades.put("C", 2.0);
		letterGrades.put("D+", 1.5);
		letterGrades.put("D", 1.0);
		letterGrades.put("F", 0.0);
		Double points = letterGrades.get(grade); 
		return points; 
	}
	
	/**
	 * function that returns the GPA of a student
	 * @return double GPA of student
	 */
	public double getGPA() {
		return this.cumulativeGPA;
	}
	
	/**
	 * function that returns a student's name 
	 * used to search for Student in ArrayList of Students
	 * @return String Student name 
	 */
	public String getName() {
		return this.name; 
	}
	
	/**
	 * function that returns information about the details of a student user 
	 * @return String
	 */
	public String toString() {
		return super.toString() + " Major: " + major + " GPA: " + cumulativeGPA; 
	}
}