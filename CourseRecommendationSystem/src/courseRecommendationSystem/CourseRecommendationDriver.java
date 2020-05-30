package courseRecommendationSystem;
import java.util.Scanner;

/**
 * The Driver for the Course Recommendation System. It creates all the menus for the User and loads all of the courses from file
 * @author justinbrown
 */
public class CourseRecommendationDriver {
	
	public static void main(String[] args) {
		//Load courses from file
		
		//Create User
		//User user = new User();

		CourseRecommendationDriver cRDriver = new CourseRecommendationDriver();
		//Menu1: Choose role
		cRDriver.runMenu1(cRDriver);
		
	}
	
	public CourseRecommendationDriver() {
		//blank
	}
	
	/**
	 * Menu 1: User selects their role to log in or set up a profile (Student, Advisor, or Admin)
	 * @param cRDriver A Driver object used to run non-static methods and make the menus work
	 */
	public void runMenu1(CourseRecommendationDriver cRDriver) {
		Scanner input = new Scanner(System.in);
		int choice;
		
		System.out.println("Welcome to the Course Recommendation System!\n\nWould you like to log in as a:");

		do {
		System.out.println("(1)\tStudent\n(2)\tAdvisor\n(3)\tAdmin\n\nPlease select your choice by number:");
		choice = input.nextInt();
		} while (choice < 1 || choice > 3);
		
		switch(choice) {
		case 1:
			cRDriver.runMenu2StudentLogin(cRDriver);
			break;
		case 2:
			cRDriver.runMenu2Advisor(cRDriver);
			break;
		case 3:
			cRDriver.runMenu2Admin(cRDriver);
			break;
		default:
			System.out.println("Error in menu 1");
			break;
		}
	}
	
	/**
	 * Student Login Menu: either finds the file and switches to loadStudentProfile(), or switches to createNewStudentProfile()
	 * @param cRDriver A Driver object used to run non-static methods and make the menus work
	 */
	public void runMenu2StudentLogin(CourseRecommendationDriver cRDriver) {
		Scanner input = new Scanner(System.in);
		String answer;
		boolean flag;
		do {
			flag = false;
			System.out.println("Do you have a profile already set up?");
			answer = input.nextLine();
			
			if (answer.toLowerCase().equals("yes") || answer.toLowerCase().equals("y")) {
				System.out.println("What is the file name?");
				answer = input.nextLine();
				try {
					loadStudentProfile(answer);
				} catch(Exception e) {
					System.out.println("Sorry, I couldn't find that file.");
					flag = true;
				}
			} else if (answer.toLowerCase().equals("no") || answer.toLowerCase().equals("n")) {
				createNewStudentProfile();
			} else {
				System.out.println("Sorry, I didn't understand your answer.\n");
				flag = true;
			}
		} while (flag);
	}
	
	public void runMenu2Advisor(CourseRecommendationDriver cRDriver) {
		System.out.println("Advisor Menu");
	}
	
	public void runMenu2Admin(CourseRecommendationDriver cRDriver) {
		System.out.println("Admin Menu");
	}
	
	public void loadStudentProfile(String filename) {
		System.out.println("Load Student Profile from file");
	}
	
	public void createNewStudentProfile() {
		System.out.println("Prompt for Student info, create file");
	}

}
