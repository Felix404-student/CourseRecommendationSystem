package courseRecommendationSystem;

/**
 * Class that creates a User object for the system 
 * @author natmonz
 */
public class User {
	
	protected String name; 
	protected String username; 
	protected String password; 
	protected String classification; 
	
	/**
	 * function that returns information about the details of a user 
	 * @return String 
	 */
	public String toString() {
		String privacy = null; 
		for(int i = 0; i<password.length(); i++)
		{
			privacy += "*"; 
		}
		return "Name: " + name + " Username: " + username + " Password: " + privacy + " Classification " + classification; 
	}
}