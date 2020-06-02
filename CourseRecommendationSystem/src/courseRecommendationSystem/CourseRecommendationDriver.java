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
	private String[] adminMenuOptions = {"Add Student", "Remove Student", "Add Advisor", "Remove Advisor", "Logout"};
	private static final String FILE_PROMPT = "Please enter the file name:";
	private static final String NO_FILE = "Sorry, I couldn't find that file.";
	private String[] semesterOptions = {"Fall", "Spring", "Summer"};
	private Scanner input;
	private User user;
	
	public CourseRecommendationDriver() {
		input = new Scanner(System.in);
		user = new User();
		//user.loadCourses();
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
			//TO-DO: load file

			Student student = new Student("", 0, "cs", 0.0);
			user = student;
			
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
				//user.save();
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
			//TO-DO: load file

			Advisor advisor = new Advisor();
			user = advisor;
			
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
			
			switch(choice) {
			case(1):
				AdvisorAddStudent();
				break;
			case(2):
				AdvisorGetStudentGPA();
				break;
			case(3):
				AdvisorAddStudentGrade();
				break;
			case(4):
				//user.save();
				run();
				break;
			default:
				System.out.println("Error in Advisor Menu");
				break;
			}
		}
	}
	
	public void AdminLogin() {
		System.out.println(ADMIN_PROMPT);
		input = new Scanner(System.in);
		String password = input.nextLine();
		if (password.equals(PASSWORD)) {
			//Admin admin = new Admin();
			//user = admin;
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
			
			switch(choice) {
			case(1):
				AdminAddStudent();
				break;
			case(2):
				AdminRemoveStudent();
				break;
			case(3):
				AdminAddAdvisor();
				break;
			case(4):
				AdminRemoveAdvisor();
				break;
			case(5):
				//user.save();
				run();
				break;
			default:
				System.out.println("Error in Admin Menu");
				break;
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
		while (!(major.equals("ce") || major.equals("cs") || major.equals("cis"))) {
			System.out.println("Please enter a Major (CS, CE, or CIS)");
			major = input.nextLine().toLowerCase();
		}
		
		Student newStudent = new Student(name, id, major, 0.0);
		user = newStudent;
		System.out.println("Welcome, " + name);
		StudentMenu();
	}
	
	public void NewAdvisor() {
		input = new Scanner(System.in);
		System.out.println("What is your name?");
		String name = input.nextLine();
		
		Advisor newAdvisor = new Advisor();
		user = newAdvisor;
		System.out.println("Welcome, " + name);
		AdvisorMenu();
	}
	
	public void StudentAddCourseTaken() {
		input = new Scanner(System.in);
		System.out.println("Enter the Course Code (for example, CSCE247):");
		String code = input.nextLine();
		//TO-DO: find course by code in courses
		
		Course course = new Course("", code, 0);
		
		System.out.println("Enter your letter grade in that course (A, B+,...):");
		code = input.nextLine();
		
		((Student) user).addCourseTaken(course, code);
		System.out.println("Course Added!");
		StudentMenu();
	}
	
	public void StudentAddCurrentCourse() {
		input = new Scanner(System.in);
		System.out.println("Enter the Course Code (for example, CSCE247):");
		String code = input.nextLine();
		//TO-DO: find course by code in courses
		
		Course course = new Course("", code, 0);
		
		((Student) user).addCourseCurrent(course);
		System.out.println("Course Added!");
		StudentMenu();
	}
	
	public void StudentPrintCoursesTaken() {
		System.out.println("Here's the courses you've taken!:\n");
		for (Course course : ((Student) user).coursesTaken) {
			System.out.println(course.toString());
		}
		StudentMenu();
	}
	
	public void StudentPrintSchedule() {
		System.out.println("Here's your recommended schedule:\n");
		//((Student) user).schedule();
		StudentMenu();
	}
	
	public void StudentRateProfessor() {
		input = new Scanner(System.in);
		//ArrayList<Professor> professors = new ArrayList<Professor>
		//TO-DO: load professors from file
		System.out.println("Here are the professors you've had, please select one by number to rate:");
		//for (int i = 0; i < professors.size(); ++i) {System.out.println("(" + i+1 + ")\t professors[i].name")};
		
		int choice = input.nextInt();
		int rating = -1;
		while (rating < 1 || rating > 5) {
			System.out.println("Please enter a rating (1-5) for "); //professors[choice+1].name);
			rating = input.nextInt();
			input.nextLine();
		}
		//professors[choice-1].rate(rating);
		System.out.println("Professor rated");
		StudentMenu();
	}
	
	public void AdvisorAddStudent() {
		input = new Scanner(System.in);
		System.out.println("What is the Student's full name?");
		String student = input.nextLine();
		//TO-DO: find student in students file
		//TO-DO: load student from file
		
		//((Advisor) user).AddStudent(student);
		
		System.out.println("Student Added!");
		AdvisorMenu();
	}
	
	public void AdvisorGetStudentGPA() {
		input = new Scanner(System.in);
		System.out.println("Which Student's GPA would you like to see?:");
		for (int i = 0; i < ((Advisor) user).advisees.size(); ++i) {
			System.out.println("(" + i+1 + ")\t" + ((Advisor) user).advisees.get(i).getName());
		}
		int choice = input.nextInt();
		input.nextLine();
		
		((Advisor) user).checkGPA(((Advisor) user).advisees.get(choice-1));
		
		AdvisorMenu();
	}
	
	public void AdvisorAddStudentGrade() {
		input = new Scanner(System.in);
		System.out.println("Which Student would you like to add a grade for?:");
		for (int i = 0; i < ((Advisor) user).advisees.size(); ++i) {
			System.out.println("(" + i+1 + ")\t" + ((Advisor) user).advisees.get(i).getName());
		}
		int choice = input.nextInt();
		input.nextLine();
		
		System.out.println("Enter the Course Code (For example, CSCE247)");
		String code  = input.nextLine();
		//TO-DO: find course by code in courses
		Course course = new Course("", code, 3);
		
		System.out.println("Enter the student's letter grade (A, B+,...)");
		String grade = input.nextLine();
	
		((Advisor) user).addStudentGrade(((Advisor) user).advisees.get(choice-1), course, grade);
		System.out.println("Grade Added!");
		AdvisorMenu();
	}
	
	public void AdminAddCourse() {
		input = new Scanner(System.in);
		System.out.println("Enter the Course Code (for example, CSCE247):");
		String code = input.nextLine();
		
		System.out.println("Enter the Course Title (for example, Software Engineering):");
		String name = input.nextLine();
		
		int credits = -1;
		while (credits < 1 || credits > 4) {
			System.out.println("Enter the number of Course Credits (1-4):");
			credits = input.nextInt();
			input.nextLine();
		}
		Course course = new Course(name, code, credits);
		
		System.out.println("Is this course offered in the Fall?");
		String response = input.nextLine();
		if (response.toLowerCase().equals("yes") || response.toLowerCase().equals("y")) {
			course.courseOfferedFall();
		}
		
		System.out.println("Is this course offered in the Spring?");
		response = input.nextLine();
		if (response.toLowerCase().equals("yes") || response.toLowerCase().equals("y")) {
			course.courseOfferedSpring();
		}
		
		System.out.println("Is this course offered in the Summer?");
		response = input.nextLine();
		if (response.toLowerCase().equals("yes") || response.toLowerCase().equals("y")) {
			course.courseOfferedSummer();
		}
		
		response = "";
		do {
			System.out.println("Would you like to add a Prerequisite to this Course?");
			response = input.nextLine();
			if (response.toLowerCase().equals("yes") || response.toLowerCase().equals("y")) {
				System.out.println("Enter the Course Code (for example, CSCE247) for the Prerequisite Course:");
				code = input.nextLine();
				//TO-DO: find course with courseCode code in courses file
				//course.prerequisites.add(code);
				System.out.println("Prerequisite added!");
			} else {
				continue;
			}
		} while (response.toLowerCase().equals("yes") || response.toLowerCase().equals("y"));
		
		response = "";
		do {
			System.out.println("Would you like to add a Corequisite to this Course?");
			response = input.nextLine();
			if (response.toLowerCase().equals("yes") || response.toLowerCase().equals("y")) {
				System.out.println("Enter the Course Code (for example, CSCE247) for the Corequisite Course:");
				code = input.nextLine();
				//TO-DO: find course with courseCode code in courses file
				//course.corequisites.add(code);
				System.out.println("Corequisite added!");
			} else {
				continue;
			}
		} while (response.toLowerCase().equals("yes") || response.toLowerCase().equals("y"));
		
		AdminMenu();
	}
	
	public void AdminAddCourseOffering() {
		input = new Scanner(System.in);
		System.out.println("Enter the Course Code (for example, CSCE247):");
		String code = input.nextLine();
		//TO-DO: find course with courseCode code in courses file
		Course course = new Course ("", code, 0);
		
		System.out.println("Which semester would you like to add a Course Offering to?\n");
		DisplayMenu(semesterOptions);
		int choice = GetChoice(semesterOptions);
		
		switch(choice) {
		case(1):
			course.courseOfferedFall();
			break;
		case(2):
			course.courseOfferedSpring();
			break;
		case(3):
			course.courseOfferedSummer();
			break;
		default:
			System.out.println("Error in semester selection");
			break;
		}
		
		AdminMenu();
	}
	
	public void AdminAddStudent() {
		input = new Scanner(System.in);
		System.out.println("Enter a Student name");
		String name = input.nextLine();
		
		System.out.println("Enter a Student ID number");
		int id = input.nextInt();
		input.nextLine();
		
		String major = "";
		while (!(major.equals("ce") || major.equals("cs") || major.equals("cis"))) {
			System.out.println("Please enter a Major (CS, CE, or CIS)");
			major = input.nextLine().toLowerCase();
		}
		
		Student newStudent = new Student(name, id, major, 0.0);
		//studentfile.addStudent(newStudent);
		
		System.out.println("Student added!");
		AdminMenu();
	}
	
	public void AdminRemoveStudent() {
		input = new Scanner(System.in);
		System.out.println("Enter a Student name");
		String name = input.nextLine();
		//TO_DO: find student name in students file
		//studentfile.delete(name);
		
		System.out.println("Student removed!");
		AdminMenu();
	}
	
	public void AdminAddAdvisor() {
		input = new Scanner(System.in);
		System.out.println("Enter the Advisor's name:");
		String name = input.nextLine();
		Advisor newAdvisor = new Advisor();
		
		System.out.println("Would you like to add any advisees to this Advisor?");
		String response = "";
		while (response.toLowerCase().equals("yes") || response.toLowerCase().equals("y")) {
			response = input.nextLine();
			System.out.println("What is the Student's full name?");
			response = input.nextLine();
			Student student = new Student (response, 0, "", 0.0);
			
			//TO_DO: find student in students file
			newAdvisor.advisees.add(student);
			System.out.println("Would you like to add another advisee?");
			response = input.nextLine();
		}
		
		//advisorfile.addAdvisor(newAdvisor);
		System.out.println("Advisor added!");
		AdminMenu();
	}
	
	public void AdminRemoveAdvisor() {
		input = new Scanner(System.in);
		System.out.println("Enter an Advisor name");
		String name = input.nextLine();
		//TO_DO: find advisor name in advisor file
		//advisorfile.delete(name);
		
		System.out.println("Advisor removed!");
		AdminMenu();
	}
	
	public static void main(String[] args) {		
		CourseRecommendationDriver cRDriver = new CourseRecommendationDriver();
		cRDriver.run();
	}
}