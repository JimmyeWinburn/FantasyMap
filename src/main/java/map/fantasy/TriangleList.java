package map.fantasy;

import java.util.ArrayList;
import java.util.List;

public class TriangleList {
	

	/**
	 * Triangles are stored in a global Set of lines because two triangles could share a single line 
	 * and we don't want to overwrite the z value of the midpoint if the line is respecified. 
	 * 
	 * Note: the field is static but every time the app is run the Set of lines and triangles need to be initialed.
	 * If you call this, you don't need to also call initLineSet();
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
