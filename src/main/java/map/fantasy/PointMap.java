package map.fantasy;

import java.util.HashMap;
import java.util.Map;


/**
 * The triangle points are held in a map (rather than a Set) to allow testing of equality based 
 * on just the x and y coordinates.
 * 
 * Note: the field is static but every time a new map is to be created,
 * it must be initialized with a call to init().
 * 
 */

public class PointMap {
	
	private static Map<Point3,Point3> map = null;
	
	private PointMap( ) {}

	public static void init() {
		map = new HashMap<>();
	}

	public static Point3 get( Point3 p) {
		return map.get(p);
	}

	public static void put( Point3 p) {
		map.put( p, p);
	}


	
}
