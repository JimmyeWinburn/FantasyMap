package map.fantasy;

import java.util.ArrayList;
import java.util.List;

public class TriangleList {
	

	/**
	 * The list of triangles to be displayed.
	 * 
	 * Note: the field is static but every time a new map is to be created,
	 * it must be initialized with a call to init().
	 * 
	 */
	private static List<Triangle>triangleList= null; 
	
	public static void init() {		
		triangleList = new ArrayList<>();	
	}	
	public static List<Triangle> get() {
		return triangleList;
	} 
	

	private TriangleList() {}
}
