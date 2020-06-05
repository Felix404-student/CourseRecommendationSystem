
package courseRecommendationSystem;

/**
 * Allows casting of User to Admin, granting extra privileges to user
 * @author natmonz
 */
public class Admin extends User{
	/**
	 * This function will add a student to the Arraylist of students in the system
	 * @param student A student
	 */
	public void addStudent(Student student) {
		//Students.add(student); 
	}
	
	/**
	 * This function will remove a student from the Arraylist of students in the system
	 * @param student A student
	 */
	public void removeStudent(Student student) {
		//Students.remove(student);
	}
	
	/**
	 * This function will add an advisor to the Arraylist of advisors in the system
	 * @param advisor An advisor
	 */
	public void addAdvisor(Advisor advisor) {
		//Advisors.add(advisor);
	}
	
	/**
	 * This function will remove an advisor from the Arraylist of advisors in the system
	 * @param advisor An advisor
	 */
	public void removeAdvisor(Advisor advisor) {
		//Advisors.remove(advisor);
	}
}
