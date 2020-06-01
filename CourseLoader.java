import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CourseLoader extends CourseConstants{
	public static ArrayList<Course> loadCourse() {
		ArrayList<Course> courses = new ArrayList<Course>();
		ArrayList<Course> prerequisites = new ArrayList<Course>();
		ArrayList<Course> corequisites = new ArrayList<Course>();
		try {
			FileReader reader = new FileReader(FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray coursesJSON = (JSONArray)new JSONParser().parse(reader);
			for(int i=0; i < coursesJSON.size(); i++){
				JSONObject courseJSON = (JSONObject)coursesJSON.get(i);
				String name = (String)courseJSON.get(NAME);
				String code = (String)courseJSON.get(CODE);
				int credit = (int)courseJSON.get(CREDITS);
				prerequisites = (ArrayList<Course>) courseJSON.get(PREREQ);
				corequisites = (ArrayList<Course>) courseJSON.get(COREQ);
				boolean courseOfferingFall = (boolean)courseJSON.get(COURSEOFFERINGFALL);
				boolean courseOfferingSpring = (boolean)courseJSON.get(COURSEOFFERINGSPRING);
				boolean courseOfferingSummer = (boolean)courseJSON.get(COURSEOFFERINGSUMMER);
				courses.add(new Course(name, code, credit,prerequisites,corequisites,courseOfferingFall,courseOfferingSpring,courseOfferingSummer));
			}
			return courses;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
