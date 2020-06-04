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
	private String[] studentMenuOptions = {"Add Course Taken", "Add a Current Course", "Print Courses Taken", "Print Recommended Schedule", "Logout"};
	private String[] advisorLoginOptions = {"I already have an Advisor Account", "I need to make a Advisor Account"};
	private String[] advisorMenuOptions = {"Add a Student to your profile", "Check a Student's GPA", "Add a Student's Grade", "Logout"};
	private static final String ADMIN_PROMPT = "Please enter the Admin password";
	private static final String PASSWORD = "ADMINISTRATOR";
	private String[] adminMenuOptions = {"Add Student", "Remove Student", "Add Advisor", "Remove Advisor", "Logout"};
	private String[] semesterOptions = {"Fall", "Spring", "Summer"};
	private Scanner input;
	private User user;
	
	public CourseRecommendationDriver() {
		input = new Scanner(System.in);
		user = new User();
		Courses courses = Courses.getCourses();
		Students students = Students.getStudents();
		Advisors advisors = Advisors.getAdvisors();
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
	
	/*
	 * Prompts the user for the name of their Student text file in the class path
	 * Tries to load the Student information from file. If not, go to login menu
	 */
	public void StudentLogin() {
		int choice;
		DisplayMenu(studentLoginOptions);
		choice = GetChoice(studentLoginOptions);
		
		if (choice == 1) {
			System.out.println("What is your full name, according to your profile?");
			input = new Scanner(System.in);
			String name = input.nextLine();
			Students students = Students.getStudents();
			
			if (students.haveStudent(name)) {
				user = students.getStudent(name);
				System.out.println("Welcome, "+ name + "\n");
				
				StudentMenu();
			} else {
				System.out.println("Sorry, we could not find a student by that name.\n");
				run();
			}
		} else {
			NewStudent();
		}
	}
	
	/**
	 * Once user is confirmed as a Student, manages flow of control for possible Student options
	 */
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
				//user.save();
				run();
				break;
			default:
				System.out.println("Error in Student Menu");
				break;
			}
		}
	}
	
	/**
	 * Prompts the user for the name of their Advisor text file in the class path
	 * Tries to load the Advisor information from file. If not, go to login menu
	 */
	public void AdvisorLogin() {
		int choice;
		DisplayMenu(advisorLoginOptions);
		choice = GetChoice(advisorLoginOptions);
		
		if (choice == 1) {
			System.out.println("What is your full name, according to your profile?");
			input = new Scanner(System.in);
			String name = input.nextLine();
			Advisors advisors = Advisors.getAdvisors();
			
			if (advisors.haveAdvisor(name)) {
				user = advisors.getAdvisor(name);
				System.out.println("Welcome, "+ name + "\n");
				
				AdvisorMenu();
			} else {
				System.out.println("Sorry, we could not find an Advisor by that name.\n");
				run();
			}
		} else {
			NewAdvisor();
		}
	}
	
	/**
	 * Once user is confirmed as an Advisor, manages flow of control for possible Student options
	 */
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
	
	/**
	 * Prompts the user for the Admin password
	 * If correct, user is now an Admin, go to Admin Menu
	 * If incorrect, go to login menu
	 */
	public void AdminLogin() {
		System.out.println(ADMIN_PROMPT);
		input = new Scanner(System.in);
		String password = input.nextLine();
		if (password.equals(PASSWORD)) {
			//Admin admin = new Admin();
			//user = admin;
			System.out.println("Welcome, Systems Administrator.\n");
			
			AdminMenu();
		} else {
			System.out.println("Sorry, that was not correct.\n");
			run();
		}
	}
	
	/**
	 * Once user is confirmed as an Admin, manages flow of control for possible Student options
	 */
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
	
	/**
	 * Prompts user for data entry to create a new Student object, sets user to a Student
	 * Go to Student Menu
	 */
	public void NewStudent() {
		input = new Scanner(System.in);
		System.out.println("Please enter a Student name");
		String name = input.nextLine();
		
		System.out.println("Please enter a Student ID number");
		String id = input.nextLine();
		
		String major = "";
		while (!(major.equals("ce") || major.equals("cs") || major.equals("cis"))) {
			System.out.println("Please enter a Major (CS, CE, or CIS)");
			major = input.nextLine().toLowerCase();
		}
		Student newStudent = new Student(name, id, major);
		Students students = Students.getStudents();
		students.addStudent(newStudent);
		user = newStudent;
		
		System.out.println("Welcome, " + name);
		StudentMenu();
	}
	
	/**
	 * Prompts user for a name, creates new Advisor object, sets user to an Advisor
	 * Go to Advisor Menu
	 */
	public void NewAdvisor() {
		input = new Scanner(System.in);
		System.out.println("What is your name?");
		String name = input.nextLine();
		
		Advisor newAdvisor = new Advisor(name);
		Advisors advisors = Advisors.getAdvisors();
		advisors.addAdvisor(newAdvisor);
		user = newAdvisor;
		
		System.out.println("Welcome, " + name + "\n");
		AdvisorMenu();
	}
	
	/**
	 * Finds a course in Course by user-entered Course Code
	 * Puts that course in user's (Student) coursesTaken, along with entered grade.
	 * Returns flow of control to Student Menu
	 */
	public void StudentAddCourseTaken() {
		input = new Scanner(System.in);
		System.out.println("Enter the Course Code (for example, CSCE 247):");
		String code = input.nextLine();
		
		Courses courses = Courses.getCourses();
		if (courses.haveCourse(code)) {
			System.out.println("Enter your letter grade for " + code + " (A, B+, B...):");
			String grade = input.nextLine();
		
			((Student) user).addCourseTaken(courses.getCourse(code), grade);
			System.out.println("Course Added!\n");
		} else {
			System.out.println("Sorry, we could not find a course with that code.\n");
		}
		StudentMenu();
	}
	
	/**
	 * Finds a course in Course by user-entered Course Code
	 * Puts that course in user's (Student) coursesNow
	 * Returns flow of control to Student Menu
	 */
	public void StudentAddCurrentCourse() {
		input = new Scanner(System.in);
		System.out.println("Enter the Course Code (for example, CSCE 247):");
		String code = input.nextLine();
		
		Courses courses = Courses.getCourses();
		if (courses.haveCourse(code)) {		
			((Student) user).addCourseCurrent(courses.getCourse(code));
			System.out.println("Course Added!\n");
		} else {
			System.out.println("Sorry, we could not find a course with that code.\n");
		}
		StudentMenu();
	}
	
	/**
	 * Displays all Courses in Student's CoursesTaken ArrayList
	 * Returns flow of control to Student Menu
	 */
	public void StudentPrintCoursesTaken() {
		System.out.println("Here's the courses you've taken!:\n");
		for (Course course : ((Student) user).coursesTaken) {
			System.out.println(course.toString());
		}
		StudentMenu();
	}
	
	/**
	 * Displays all Courses in Student's CoursesNow ArrayList
	 * Returns flow of control to Student Menu
	 */
	public void StudentPrintCoursesCurrent() {
		System.out.println("Here's the courses you've taken!:\n");
		for (Course course : ((Student) user).coursesNow) {
			System.out.println(course.toString());
		}
		StudentMenu();
	}
	
	/**
	 * Incomplete function to display calculated schedule
	 * Needs... someone to write that function
	 * Returns flow of control to Student Menu
	 */
	public void StudentPrintSchedule() {
		System.out.println("Here's your recommended schedule:\n");
		//((Student) user).schedule();
		StudentMenu();
	}
	
	/**
	 * Incomplete function to display all professors, allow Student to Rate one
	 * Needs... Professor to exist as a class
	 * Returns flow of control to Student Menu
	 */
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
		System.out.println("Professor rated!\n");
		StudentMenu();
	}
	
	/**
	 * Finds a Student by name in Students and add them to an Advisor's ArrayList of Advisees
	 * Returns flow of control to Advisor Menu
	 */
	public void AdvisorAddStudent() {
		input = new Scanner(System.in);
		System.out.println("What is the Student's full name?");
		String student = input.nextLine();

		Students students = Students.getStudents();
		if (students.haveStudent(student)) {
			((Advisor) user).addStudent(students.getStudent(student));
			System.out.println("Student Added!\n");
		} else {
			System.out.println("Sorry, we could not find a student by that name.\n");
		}
		AdvisorMenu();
	}
	
	/**
	 * Displays Advisor's Students in advisees ArrayList
	 * Displays chosen Student's GPA
	 * Returns flow of control to Advisor Menu
	 */
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
	
	/**
	 * Allows Advisor to add a grade for a course to a Student's file
	 * Displays Advisor's Advisees, user chooses a Student
	 * Finds Course in Courses by user-entered Course Code
	 * Adds Course to Student's CoursesTaken, along with user-entered grade
	 * Returns flow of control to Advisor Menu
	 */
	public void AdvisorAddStudentGrade() {
		input = new Scanner(System.in);
		System.out.println("Which Student would you like to add a grade for?:");
		for (int i = 0; i < ((Advisor) user).advisees.size(); ++i) {
			System.out.println("(" + i+1 + ")\t" + ((Advisor) user).advisees.get(i).getName());
		}
		int choice = input.nextInt();
		input.nextLine();
		
		System.out.println("Enter the Course Code (For example, CSCE 247)");
		String code  = input.nextLine();
		
		Courses courses = Courses.getCourses();
		if (courses.haveCourse(code)) {
			System.out.println("Enter the student's letter grade (A, B+, B...)");
			String grade = input.nextLine();
	
			((Advisor) user).addCourseTaken(((Advisor) user).advisees.get(choice-1), courses.getCourse(code), grade);
			System.out.println("Grade Added!\n");
		} else {
			System.out.println("Sorry, we could not find a course with that code\n");
		}
		AdvisorMenu();
	}
	
	/**
	 * Unused function to add a course through console input instead of manually in file
	 * Returns flow of control to Admin Menu
	 */
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
	
	/**
	 * Unused function to add a Course Offering (class deleted)
	 * Returns flow of control to Advisor Menu
	 */
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
	
	/**
	 * Allows Admin to add a Student to Students
	 * Returns flow of control to Advisor Menu
	 */
	public void AdminAddStudent() {
		input = new Scanner(System.in);
		System.out.println("Enter a Student name");
		String name = input.nextLine();
		
		System.out.println("Enter a Student ID number");
		String id = input.nextLine();
		
		String major = "";
		while (!(major.equals("ce") || major.equals("cs") || major.equals("cis"))) {
			System.out.println("Please enter a Major (CS, CE, or CIS)");
			major = input.nextLine().toLowerCase();
		}
		
		Student newStudent = new Student(name, id, major);
		Students students = Students.getStudents();
		students.addStudent(newStudent);
		
		System.out.println("Student added!");
		AdminMenu();
	}
	
	/**
	 * Finds a Student by name in studentList... and deletes them
	 * Returns flow of control to Advisor Menu
	 */
	public void AdminRemoveStudent() {
		input = new Scanner(System.in);
		System.out.println("Enter a Student name");
		String name = input.nextLine();
		
		Students students = Students.getStudents();
		if (students.haveStudent(name)) {
			students.removeStudent(students.getStudent(name));
			System.out.println("Student removed!\n");
		} else {
			System.out.println("There was no student by that name.\n");
		}
		AdminMenu();
	}
	
	/**
	 * Allows an Admin to add a new Advisor to advisorList, along with adding advisees to them
	 * Returns flow of control to Admin Menu
	 */
	public void AdminAddAdvisor() {
		input = new Scanner(System.in);
		System.out.println("Enter the Advisor's name:");
		String name = input.nextLine();
		Advisor newAdvisor = new Advisor(name);
		
		System.out.println("Would you like to add any advisees to this Advisor?");
		String response = "";
		while (response.toLowerCase().equals("yes") || response.toLowerCase().equals("y")) {
			response = input.nextLine();
			System.out.println("What is the Student's full name?");
			response = input.nextLine();
			
			Students students = Students.getStudents();
			if (students.haveStudent(response)) {
				newAdvisor.addStudent(students.getStudent(response));
				System.out.println("Advisee added!\n");
			} else {
				System.out.println("We could not find a student by that name\n");
			}
			System.out.println("Would you like to add another advisee?");
			response = input.nextLine();
		}
		Advisors advisors = Advisors.getAdvisors();
		advisors.addAdvisor(newAdvisor);
		
		System.out.println("Advisor added!\n");
		AdminMenu();
	}
	
	/**
	 * Allows Admin to delete an Advisor object from advisorList
	 * Returns flow of control to Advisor Menu
	 */
	public void AdminRemoveAdvisor() {
		input = new Scanner(System.in);
		System.out.println("Enter an Advisor name");
		String name = input.nextLine();
		
		Advisors advisors = Advisors.getAdvisors();
		if (advisors.haveAdvisor(name)) {
			advisors.removeAdvisor(advisors.getAdvisor(name));
			System.out.println("Advisor removed!\n");
		} else {
			System.out.println("There was no advisor by that name.\n");
		}
		AdminMenu();
	}
	
	public static void main(String[] args) {		
		CourseRecommendationDriver cRDriver = new CourseRecommendationDriver();
		cRDriver.run();
	}
}