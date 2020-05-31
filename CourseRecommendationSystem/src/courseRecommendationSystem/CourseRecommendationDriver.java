package courseRecommendationSystem;
import java.util.Scanner;

/**
 * The Driver for the Course Recommendation System. It creates all the menus for the User and loads all of the courses from file
 * @author justinbrown
 */
public class CourseRecommendationDriver {
	private static final String WELCOME_MESSAGE = "Welcome to the Course Recommendation System!\n\nWould you like to log in as a:";
	private static final String PROMPT = "\nPlease select your choice by number:";
	private String[] loginMenuOptions = {"Student", "Advisor", "Admin"};
	private String[] studentLoginOptions = {"I already have a Student Account", "I need to make a Student Account"};
	private String[] studentMenuOptions = {"Add Course Taken", "Add a Current Course", "Print Courses Taken", "Print Recommended Schedule", "Rate a Professor", "Logout"};
	private String[] advisorLoginOptions = {"I already have an Advisor Account", "I need to make a Advisor Account"};
	private String[] advisorMenuOptions = {"Add a Student to your profile", "Check a Student's GPA", "Add a Student's Grade", "Logout"};
	private static final String ADMIN_PROMPT = "Please enter the Admin password";
	private static final String PASSWORD = "ADMINISTRATOR";
	private String[] adminMenuOptions = {"Add Course", "Add Course Offering", "Add Student", "Remove Student", "Add Advisor", "Remove Advisor", "Logout"};
	private static final String FILE_PROMPT = "Please enter the file name:";
	private static final String NO_FILE = "Sorry, I couldn't find that file.";
	private Scanner input;
	//private User user;
	
	public CourseRecommendationDriver() {
		input = new Scanner(System.in);
		//user = new User();
	}
	
	/**
	 * Manages the menu flow of control
	 */
	public void run() {
		int choice;
		System.out.println(WELCOME_MESSAGE);
		DisplayMenu(loginMenuOptions);
		choice = GetChoice(loginMenuOptions);
		
		switch(choice) {
		case(1):
			StudentLogin();
			break;
		case(2):
			AdvisorLogin();
			break;
		case(3):
			AdminLogin();
			break;
		default:
			System.out.println("Error in role selection");
			break;
		}
		
		//WHERE DO WE GO FROM HERE?
	}
	
	/**
	 * Prints out a formatted menu for the user to pick an option by number
	 * @param menu An array of menu options to display
	 */
	public void DisplayMenu(String[] menu) {
		for (int i = 0; i < menu.length; ++i) {
			System.out.println("(" + (i+1) + ")\t" + menu[i]);
		}
	}
	
	/**
	 * Prompts the user to pick a menu option and makes sure the User picks one of the menu options available
	 * @param menu An array of menu options to pick from
	 * @return An integer representing the User's choice from the menu
	 */
	public int GetChoice(String[] menu) {
		int choice = -1;
		input = new Scanner(System.in);
		
		while (choice < 1 || choice > menu.length) {
			System.out.println(PROMPT);
			choice = input.nextInt();
		}
		return choice;
	}
	
	public void LoadFile(String filename) {
		//TO-DO: load file
		System.out.println("Your file has loaded!\n");
	}
	
	public void StudentLogin() {
		int choice;
		DisplayMenu(studentLoginOptions);
		choice = GetChoice(studentLoginOptions);
		
		if (choice == 1) {
			System.out.println(FILE_PROMPT);
			input = new Scanner(System.in);
			String filename = input.nextLine();
			LoadFile(filename);
			
			StudentMenu();
		} else {
			NewStudent();
		}
	}
	
	public void StudentMenu() {
		int choice;
		while (true) {
			DisplayMenu(studentMenuOptions);
			choice = GetChoice(studentMenuOptions);
			
			switch(choice) {
			case(1):
				StudentAddCourseTaken();
				break;
			case(2):
				StudentAddCurrentCourse();
				break;
			case(3):
				StudentPrintCoursesTaken();
				break;
			case(4):
				StudentPrintSchedule();
				break;
			case(5):
				StudentRateProfessor();
				break;
			case(6):
				run();
				break;
			default:
				System.out.println("Error in Student Menu");
				break;
			}
		}
	}
	
	public void AdvisorLogin() {
		int choice;
		DisplayMenu(advisorLoginOptions);
		choice = GetChoice(advisorLoginOptions);
		
		if (choice == 1) {
			System.out.println(FILE_PROMPT);
			input = new Scanner(System.in);
			String filename = input.nextLine();
			LoadFile(filename);
			
			AdvisorMenu();
		} else {
			NewAdvisor();
		}
	}
	
	public void AdvisorMenu() {
		int choice;
		while (true) {
			DisplayMenu(advisorMenuOptions);
			choice = GetChoice(advisorMenuOptions);
			
			if (choice == advisorMenuOptions.length) {
				run();
			}
		}
	}
	
	public void AdminLogin() {
		System.out.println(ADMIN_PROMPT);
		input = new Scanner(System.in);
		String password = input.nextLine();
		if (password.equals(PASSWORD)) {
			AdminMenu();
		} else {
			run();
		}
	}
	
	public void AdminMenu() {
		int choice;
		while (true) {
			DisplayMenu(adminMenuOptions);
			choice = GetChoice(adminMenuOptions);
			
			if (choice == adminMenuOptions.length) {
				run();
			}
		}
	}
	
	public void NewStudent() {
		input = new Scanner(System.in);
		System.out.println("Please enter a Student name");
		String name = input.nextLine();
		
		System.out.println("Please enter a Student ID number");
		int id = input.nextInt();
		input.nextLine();
		
		String major = "";
		while (!(major.equals("CE") || major.equals("CS") || major.equals("CIS"))) {
			System.out.println("Please enter a Major (CS, CE, or CIS)");
			major = input.nextLine();
		}
		
		//Student newStudent = new Student(name, id, major);
		System.out.println("Welcome, " + name);
		StudentMenu();
	}
	
	public void NewAdvisor() {
		input = new Scanner(System.in);
		System.out.println("What is your name?");
		String name = input.nextLine();
		
		//Advisor newAdvisor = new Advisor(name);
		System.out.println("Welcome, " + name);
		AdvisorMenu();
	}
	
	public void StudentAddCourseTaken() {
		input = new Scanner(System.in);
		System.out.println("Enter the Course Code (for example, CSCE247):");
		String code = input.nextLine();
		
		//newStudent.addCourseTaken(code);
		System.out.println("Course Added!");
	}
	
	public void StudentAddCurrentCourse() {
		input = new Scanner(System.in);
		System.out.println("Enter the Course Code (for example, CSCE247):");
		String code = input.nextLine();
		
		//newStudent.addCourseCurrent(code);
		System.out.println("Course Added!");
	}
	
	public void StudentPrintCoursesTaken() {
		System.out.println("Here's the courses you've taken!:\n");
		//for (Course : newStudent.CoursesTaken){System.out.println(this.toString())}
	}
	
	public void StudentPrintSchedule() {
		System.out.println("Here's your recommended schedule:\n");
		//newStudent.schedule();
	}
	
	public void StudentRateProfessor() {
		input = new Scanner(System.in);
		//ArrayList<Professor> professors = new ArrayList<Professor>
		//TO-DO: load professors from file
		System.out.println("Here are the professors you've had, please select one by number to rate:");
		//for (int i = 0; i < professors.size(); ++i) {System.out.println("(" + i+1 + ")\t ArrayList[i].name")};
		
		int choice = input.nextInt();
		int rating = -1;
		while (rating < 1 || rating > 5) {
			System.out.println("Please enter a rating (1-5) for "); //professors[choice+1].name);
			rating = input.nextInt();
			input.nextLine();
		}
		//professors[choice+1].rate(rating);
		System.out.println("Professor rated");
	}
	
	public static void main(String[] args) {
		//Load courses from file
		
		CourseRecommendationDriver cRDriver = new CourseRecommendationDriver();
		cRDriver.run();
	}
}
