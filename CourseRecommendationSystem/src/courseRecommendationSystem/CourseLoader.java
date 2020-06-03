package courseRecommendationSystem;

import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * A class for loading the JSON file for Course
 * @author Dongyu
 *
 */
public class CourseLoader extends CourseConstants{
	/**
	 * A method which loads the course attributes from a JSON record
	 * @return courses, an arrayList
	 */
	public static ArrayList<Course> loadCourses() {
		ArrayList<Course> courses = new ArrayList<Course>();
		/*ArrayList<Course> prerequisites = new ArrayList<Course>();
		ArrayList<Course> corequisites = new ArrayList<Course>();*/
		try {
			FileReader reader = new FileReader(FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray coursesJSON = (JSONArray)new JSONParser().parse(reader);
			for(int i=0; i < coursesJSON.size(); i++){
				JSONObject courseJSON = (JSONObject)coursesJSON.get(i);
				String name = (String)courseJSON.get(NAME);
				String code = (String)courseJSON.get(CODE);
				int credit = Integer.parseInt((String)courseJSON.get(CREDITS));

				/*prerequisites = (ArrayList<Course>) courseJSON.get(PREREQ);
				corequisites = (ArrayList<Course>) courseJSON.get(COREQ);*/
				String prerequisites_s = (String)courseJSON.get(PREREQ);
				String corequisites_s = (String) courseJSON.get(COREQ);
				String courseOfferingFall = (String)courseJSON.get(COURSEOFFERINGFALL);
				String courseOfferingSpring = (String)courseJSON.get(COURSEOFFERINGSPRING);
				String courseOfferingSummer = (String)courseJSON.get(COURSEOFFERINGSUMMER);
				//courses.add(new Course(name, code, credit,prerequisites,corequisites,courseOfferingFall,courseOfferingSpring,courseOfferingSummer));
				courses.add(new Course(name, code, credit,prerequisites_s,corequisites_s,Boolean.valueOf(courseOfferingFall),Boolean.valueOf(courseOfferingSpring),Boolean.valueOf(courseOfferingSummer)));
			}
			return courses;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Student> loadStudents() {
		//load students from file
		
		return null;
	}
	
	public static ArrayList<Advisor> loadAdvisors() {
		//load advisors from file
		
		return null;
	}

}
