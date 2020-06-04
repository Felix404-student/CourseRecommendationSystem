package courseRecommendationSystem;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * A class for loading the JSON files for Course, Student, Advisor, and Major
 * @author Dongyu, Justin
 *
 */
public class CourseLoader{
	//json loaders for Course
	public static final String COURSE_FILE_NAME = "src/json_courses.json";
	public static final String COURSE_NAME = "name";
	public static final String COURSE_CODE = "courseCode";
	public static final String COURSE_CREDITS = "courseCredits";
	public static final String COURSE_PREREQ = "prerequisites";
	public static final String COURSE_COREQ = "corequisites";
	public static final String COURSE_COURSEOFFERINGFALL = "Fall";
	public static final String COURSE_COURSEOFFERINGSPRING = "Spring";
	public static final String COURSE_COURSEOFFERINGSUMMER = "Summer";
	
	//json loader for Student
	public static final String STUDENT_FILE_NAME = "src/json_student.json";
	public static final String STUDENT_NAME = "student name";
	public static final String STUDENT_ID= "student ID";
	public static final String STUDENT_MAJOR = "student major";
	
	//json loader for Advisor
	public static final String ADVISOR_FILE_NAME = "src/json_advisor.json";
	public static final String ADVISOR_NAME = "advisor name";
	
	//json loader for Major
	public static final String MAJOR_FILE_NAME = "src/json_major.json";
	public static final String MAJOR_NAME = "major name";
	public static final String MAJOR_CLASS = "major class";
	/**
	 * A method which loads the course attributes from a JSON record
	 * @return courses, an arrayList
	 */
	public static ArrayList<Course> loadCourses() {
		ArrayList<Course> courses = new ArrayList<Course>();
		/*ArrayList<Course> prerequisites = new ArrayList<Course>();
		ArrayList<Course> corequisites = new ArrayList<Course>();*/
		try {
			FileReader reader = new FileReader(COURSE_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray coursesJSON = (JSONArray)new JSONParser().parse(reader);
			for(int i=0; i < coursesJSON.size(); i++){
				JSONObject courseJSON = (JSONObject)coursesJSON.get(i);
				String name = (String)courseJSON.get(COURSE_NAME);
				String code = (String)courseJSON.get(COURSE_CODE);
				int credit = Integer.parseInt((String)courseJSON.get(COURSE_CREDITS));

				/*prerequisites = (ArrayList<Course>) courseJSON.get(PREREQ);
				corequisites = (ArrayList<Course>) courseJSON.get(COREQ);*/
				String prerequisites_s = (String)courseJSON.get(COURSE_PREREQ);
				String corequisites_s = (String) courseJSON.get(COURSE_COREQ);
				String courseOfferingFall = (String)courseJSON.get(COURSE_COURSEOFFERINGFALL);
				String courseOfferingSpring = (String)courseJSON.get(COURSE_COURSEOFFERINGSPRING);
				String courseOfferingSummer = (String)courseJSON.get(COURSE_COURSEOFFERINGSUMMER);
				//courses.add(new Course(name, code, credit,prerequisites,corequisites,courseOfferingFall,courseOfferingSpring,courseOfferingSummer));
				courses.add(new Course(name, code, credit,prerequisites_s,corequisites_s,Boolean.valueOf(courseOfferingFall),Boolean.valueOf(courseOfferingSpring),Boolean.valueOf(courseOfferingSummer)));
			}
			return courses;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * A method which loads the students attributes from a JSON record
	 * @return students, an arrayList
	 */
	public static ArrayList<Student> loadStudents() {
		ArrayList<Student> students = new ArrayList<Student>();
		try {
			FileReader reader = new FileReader(STUDENT_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray coursesJSON = (JSONArray)new JSONParser().parse(reader);
			for(int i=0; i < coursesJSON.size(); i++){
				JSONObject courseJSON = (JSONObject)coursesJSON.get(i);
				String student_name = (String)courseJSON.get(STUDENT_NAME);
				String student_id = (String)courseJSON.get(STUDENT_ID);
				String student_major = (String)courseJSON.get(STUDENT_MAJOR);
				students.add(new Student(student_name, student_id, student_major));
			}
			return students;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * A method which loads the advisor attributes from a JSON record
	 * @return advisors, an arrayList
	 */
	public static ArrayList<Advisor> loadAdvisors() {
		ArrayList<Advisor> advisors = new ArrayList<Advisor>();
		try {
			FileReader reader = new FileReader(STUDENT_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray coursesJSON = (JSONArray)new JSONParser().parse(reader);
			for(int i=0; i < coursesJSON.size(); i++){
				JSONObject courseJSON = (JSONObject)coursesJSON.get(i);
				String advisor_name = (String)courseJSON.get(ADVISOR_NAME);
				advisors.add(new Advisor(advisor_name));
			}
			return advisors;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * A method which loads the majors from a JSON record
	 * @return students, an arrayList
	 */
	public static HashMap<String, String[]> loadMajor() {
		HashMap<String,Course[]> majorList = new HashMap<String,Course[]>();
		try {
			FileReader reader = new FileReader(MAJOR_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray coursesJSON = (JSONArray)new JSONParser().parse(reader);
			for(int i=0; i < coursesJSON.size(); i++){
				JSONObject courseJSON = (JSONObject)coursesJSON.get(i);
				// not sure if this is going to work 
				String major_name = (String)courseJSON.get(MAJOR_NAME);
				String[] major_classes = (String)courseJSON.get(MAJOR_CLASS);
				majorList.put(major_name,major_classes);
				return majorList;
			}
			// can the function be void now that this instance is created? 
			Major majorList = new Major(majorList); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * A method which loads the majors from a JSON record
	 * @return students, an arrayList
	 *
	public static HashMap<String, String[]> loadMajor() {
		HashMap<String,Course[]> majorList = new HashMap<String,Course[]>();
		try {
			FileReader reader = new FileReader(MAJOR_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray coursesJSON = (JSONArray)new JSONParser().parse(reader);
			for(int i=0; i < coursesJSON.size(); i++){
				JSONObject courseJSON = (JSONObject)coursesJSON.get(i);
				// not sure if this is going to work 
				String major_name = (String)courseJSON.get(MAJOR_NAME);
				String[] major_classes = (String)courseJSON.get(MAJOR_CLASS);
				majorList.put(major_name,major_classes);
				return majorList;
			}
			// can the function be void now that this instance is created? 
			Major majorList = new Major(majorList); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}*/

}
