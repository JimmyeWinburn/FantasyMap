package map.fantasy;

import java.util.ArrayList;
import java.util.List;

public class ShapeList {
	

	/**
	 * The list of shapes to be displayed.
	 * 
	 * Note: the field is static but every time a new map is to be created,
	 * it must be initialized with a call to init().
	 * 
	 */
	private static List<MapShape>list= null; 
	
	public static void init() {		
		list = new ArrayList<>();	
	}	
	public static List<MapShape> get() {
		return list;
	} 
	

	private ShapeList() {}
}
