
package courseRecommendationSystem;

/**
 * Allows casting of User to Admin, granting extra privileges to user
 * @author natmonz
 */
public class Admin extends User{
	private static final String PASSWORD = "ADMINISTRATOR";
	
	/**
	 * Check password to login as Admin
	 * @param guess A string to check against the password
	 * @return whether or not the guess matches
	 */
	public boolean checkPassword(String guess) {
		return (guess.equals(PASSWORD));
	}
	
	/**
	 * This function will add a student to the Arraylist of students in the system
	 * @param student A student
	 */
	public void addStudent(Student student) {
		Students students = Students.getStudents();
		students.addStudent(student);
	}
	
	/**
	 * This function will remove a student from the Arraylist of students in the system
	 * @param student A student
	 */
	public void removeStudent(Student student) {
		Students students = Students.getStudents();
		students.removeStudent(student);
	}
	
	/**
	 * This function will add an advisor to the Arraylist of advisors in the system
	 * @param advisor An advisor
	 */
	public void addAdvisor(Advisor advisor) {
		Advisors advisors = Advisors.getAdvisors();
		advisors.addAdvisor(advisor);
	}
	
	/**
	 * This function will remove an advisor from the Arraylist of advisors in the system
	 * @param advisor An advisor
	 */
	public void removeAdvisor(Advisor advisor) {
		Advisors advisors = Advisors.getAdvisors();
		advisors.removeAdvisor(advisor);
	}
}
