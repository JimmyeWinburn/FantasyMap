package map.fantasy;

import java.util.HashMap;
import java.util.Map;


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
