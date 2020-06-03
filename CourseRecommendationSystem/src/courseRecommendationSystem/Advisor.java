package courseRecommendationSystem;

import java.util.ArrayList;

/**
 * class that creates and Advisor object that inherits from User
 * @author natmonz
 */
public class Advisor extends User{
	private String name;
	protected ArrayList<Student> advisees; 
	
	public Advisor(String name) {
		this.name = name;
		advisees = new ArrayList<Student>();
	}
	
	/**
	 * function that adds a student grade to the student grade Hashmap
	 * @param student A student
	 * @param course A course a student has taken
	 * @param grade A grade a student has received
	 */
	public void addStudentGrade(Student student, Course course, String grade) {
		student.addGrade(course, grade); 
		student.updateGPA();
	}
	
	/**
	 * this function checks the GPA of a student and displays a message regarding their academic standing. 
	 * @param student A student of an advisor 
	 */
	public void checkGPA(Student student) {
		System.out.println(student.getName() + "'s GPA is: " + student.getGPA()); 
		if(student.getGPA() < 2.0)
			System.out.println("They are at risk of academic suspension."); 
		else if(student.getGPA() >= 3.95) {
			System.out.println("They are doing the best and on track for graduating Summa Cum Laude!"); 
		}
		else if(student.getGPA() > 3.75 && student.getGPA() < 3.949) {
			System.out.println("They are doing great and on track for graduating Magna Cum Laude!"); 
		}
		else if(student.getGPA() > 3.5 && student.getGPA() < 3.749) {
			System.out.println("They are doing well and on track for graduating Cum Laude!"); 
		}
		else {
			System.out.println("System error: Student has incorrectly formatted GPA"); 
		}
	}
	
	/**
	 * function that adds a student to Advisor's advisees ArrayList
	 * @param student A Student object
	 */
	public void addStudent(Student student) {
		this.advisees.add(student);
	}
	
	/**
	 * function that adds a course to a specific students takenCourses ArrayList
	 * @param student A Student
	 * @param course A course
	 */
	public void addCourseTaken(Student student, Course course, String grade) {
		student.addCourseTaken(course, grade);
	}
	
	/**
	 * function that takes a parameter of a student and 2 courses and deletes prerequisite of a specific course
	 * @param student A Student
	 * @param course1 A course
	 * @param course2 A course
	 * @return boolean value 
	 */
	public void override(Student student, Course course, Course prereq) {
		course.removePrerequisite(prereq); 
	}
	
}