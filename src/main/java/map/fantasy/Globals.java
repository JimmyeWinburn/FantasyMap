package map.fantasy;

import java.io.File;

import javax.vecmath.Vector3d;

/**
 * Globals
 * 
 * user controlled global values.  
 */
public class Globals {
	

	private Globals() {}
	
	
	
	/** 
	 * The data file used for coloring pixels.  The columns are the color for 
	 * altitude and the rows are the color for latitude.
	 */
	private static File colorFile = new File(".\\data\\latitude2.png");
	//private static File colorFile = new File(".\\data\\PlaneOfFire.png");
	//private static File colorFile = new File(".\\data\\PlaneOfAir.png");
	public static File getColorFile() {
		return colorFile;
	}
	public static void setColorFile(String s) {
		colorFile = new File(s);
	}
	
	
	/**
	 * The level of the water.  Pixels that are at a lower altitude than this value
	 * are not shaded 
	 */
	private static double waterLevel = 0;
	public static double getWaterLevel() {
		return waterLevel;
	}
	public static void setWaterLevel(double w) {
		waterLevel = w;
	}
	
	
	/**
	 * The vector of the light source (used for shading.)
	 */
	private static Vector3d lightVector = new Vector3d(-1.0, -1.0, 1.0);
	
	public static Vector3d getLightVector() {
		return lightVector;
	}
	public static void setLightVector(Vector3d v) {
		lightVector = v;
	}
	
	
	/**
	 * the number of rows and columns of the finished map.  Will throw an exception if 
	 * a user tries to specify a negative number. 
	 * Default: 512 
	 * 
	 */
	private static int frameSize = 1024;
	public static int getFrameSize() {
		return frameSize;
	}
	public static void setFrameSize(int size){
		frameSize = size;
	}

	
	/** 
	 * the max size a line can take before it is broken up into two sub-lines.
	 * Will throw an exception if user tries to specify a negative number. 
	 * Default: 1
	 */
	private static int maxLineSize = 1;	
	public static int getMaxLineSize() {
		return Globals.maxLineSize;
	}
	public static void setMaxLineSize(int maxLineSize) {
		Globals.maxLineSize = maxLineSize;
	}
	
	
	
	/**
	 * randomization seed.  Default =1;
	 */
	private static long randomSeed = 0;	
	public static long getRandomSeed() {
		return randomSeed;
	}	
	public static void setRandomSeed(long seed) {
		randomSeed = seed;
	}
	

	/**
	 * how steep the heights should be.  0.0 is flat.  
	 */
	private static double steepness = 0.5;	
	public static double getSteepness() {
		return steepness;
	}
	public static void setSteepness(double steep) {
		steepness = steep;
	}
	
}
