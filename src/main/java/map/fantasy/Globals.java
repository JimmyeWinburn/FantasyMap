package map.fantasy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;





/**
 * Globals
 * 
 * user controlled global values.  
 */
public class Globals {
	

	private Globals() {}
	
	/**
	 * the number of rows and columns of the finished map.  Will throw an exception if 
	 * a user tries to specify a negative number. 
	 * Default: 512 
	 * 
	 */
	private static int frameSize = 1024;

	/** 
	 * the max size a line can take before it is broken up into two sub-lines.
	 * Will throw an exception if user tries to specify a negative number. 
	 * Default: 2
	 */
	private static int maxLineSize = 2;
	
	/**
	 * randomization seed.  Default =1;
	 */
	private static long randomSeed = 165;
	
	/**
	 * how steep the heights should be.  0.0 is flat.  
	 */
	private static double steepness = 0.5;
	

	/**
	 * Points are stored in a global Set of Points because two triangles could share a Point or two 
	 * and we don't want to overwrite the z value of the midpoint if the line is respecified. 
	 * 
	 * Note: the field is static but every time the app is run the Set of lines needs to be initialed.
	 */
	private static Set<Point> pointSet = null; 
	
	public static void initPointSet() {		
		pointSet = new HashSet<>();	
	}

	public static Set<Point> getPointSet() {
		return pointSet;
	}

	
	private static Map<Point,Point> pointMap = null; 
	
	public static void initPointMap() {		
		pointMap = new HashMap<>();	
	}

	public static Map<Point,Point> getPointMap() {
		return pointMap;
	}
	
	
		
	
	/**
	 * Lines are stored in a global Set of lines because two triangles could share a single line 
	 * and we don't want to overwrite the z value of the midpoint if the line is respecified. 
	 * 
	 * Note: the field is static but every time the app is run the Set of lines needs to be initialed.
	 */
	private static Set<Line> lineSet = null; 
	
	public static void initLineSet() {		
		lineSet = new HashSet<>();	
	}

	/**
	 * Triangles are stored in a global Set of lines because two triangles could share a single line 
	 * and we don't want to overwrite the z value of the midpoint if the line is respecified. 
	 * 
	 * Note: the field is static but every time the app is run the Set of lines and triangles need to be initialed.
	 * If you call this, you don't need to also call initLineSet();
	 */
	private static List<Triangle> triangleList = null; 
	
	public static void initTriangleList() {		
		triangleList = new ArrayList<>();	
	}
	
	public static List<Triangle> getTriangleList() {
		return triangleList;
	}
	

	static Random random = new Random( Globals.getRandomSeed());

	
	//  Getters and setters
	
	public static double getNextRandomHeight() {
		return (random.nextDouble() - 0.5) * steepness;
	}

	public static double getSteepness() {
		return steepness;
	}

	public static void setSteepness(double steep) {
		steepness = steep;
	}
	
	
	public static long getRandomSeed() {
		return randomSeed;
	}
	
	public static int getFrameSize() {
		return frameSize;
	}

	public static void setFrameSize(int size) throws Exception {
		if (size < 0) {
			throw new Exception();
		}
		frameSize = size;
	}

	public static Set<Line> getLineSet() {
		return lineSet;
	}


	public static int getMaxLineSize() {
		return Globals.maxLineSize;
	}

	public static void setMaxLineSize(int maxLineSize) throws Exception{
		if (maxLineSize < 0) {
			throw new Exception();
		}
		Globals.maxLineSize = maxLineSize;
	}

		
	public static float maxHeight;
	
	public static float minHeight;
}
