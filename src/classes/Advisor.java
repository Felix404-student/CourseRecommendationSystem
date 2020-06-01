package classes;

import java.util.ArrayList;

/**
 * class that creates and Advisor object that inherits from User
 * @author natmonz
 */
public class Advisor extends User{
	private ArrayList<Student> advisees = new ArrayList<Student>(); 
	
	public void addStudentGrade(Student student, Course course, String grade) {
		student.addGrade(course, grade); 
	}
}
