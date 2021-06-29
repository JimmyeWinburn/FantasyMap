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
/*
	private static Comparator<Point3> c = new Comparator<Entry<Point3, Point3>>()
    {
        public int compare(Entry<Point3, Point3> o1, Entry<Point3, Point3> o2)
        {
            return 1;
        } 
    };
    */
	/*
	private static Comparator<Point3> c = new Comparator<Point3, Point3>()
    {
        public int compare(Entry<Point3, Point3> o1, Entry<Point3, Point3> o2)
        {
            return 1;
        } 
    };
    */
	
	@SuppressWarnings("unchecked")
	public static void init() {
		map = new HashMap<>();
		 //map =  new TreeMap<Point3, Point3>( c);
		 //map =  new TreeMap<Point3, Point3>( new Point3Comp());
	}
	
	public static Map<Point3,Point3> getMap(){
		return map;
	}

	public static Point3 get( Point3 p) {
		return map.get(p);
	}

	public static void put( Point3 p) {
		map.put( p, p);
	}


	
}
	
/*
class Point3Comp implements Comparator<Point3>{

	@Override
	public int compare( Point3 p1, Point3 p2) {
		int x = 0;

		if (p1.getX() > p2.getX()) {
			return 1;
		} else if (p1.getX() < p2.getX()) {
			return -1;
		} else if (p1.getY() > p2.getY()) {
			return 1;
		} else if (p1.getY() < p2.getY()) {
			return -1;
		} else {
			return 0;
		}
	}
}
*/
		
