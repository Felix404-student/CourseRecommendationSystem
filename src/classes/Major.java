package classes;

import java.util.ArrayList;
/**
 * Class that creates a major object 
 * @author natmonz
 */
public class Major {
	private String intendedDegree = null; 
	private ArrayList<Course> gradReqCS = new ArrayList<Course>(); 
	private ArrayList<Course> gradReqCE = new ArrayList<Course>(); 
	private ArrayList<Course> gradReqCIS = new ArrayList<Course>(); 
	
	/**
	 * function that sets a Major based on a String parameter 
	 * @param intendedDegree String of a type of degree
	 */
	Major(String intendedDegree) {
		this.intendedDegree = intendedDegree; 
	}
	
	
}