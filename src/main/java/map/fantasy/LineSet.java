package map.fantasy;

import java.util.HashSet;
import java.util.Set;

public class LineSet {
	/**
	 * Lines are stored in a global Set of lines because two triangles could share a single line 
	 * and we don't want to overwrite the z value of the midpoint if the line is respecified. 
	 * 
	 * Note: the field is static but every time the app is run the Set of lines needs to be initialed.
	 */
	private static Set<Line> lineSet= null; 
	
	public static void init() {		
		lineSet= new HashSet<>();	
	}
	
	Set<Line> get() {
		return lineSet;
	}


	private LineSet() {}
}
