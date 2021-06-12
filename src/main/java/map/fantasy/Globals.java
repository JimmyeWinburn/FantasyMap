package map.fantasy;

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

	public static int getFrameSize() {
		return frameSize;
	}

	public static void setFrameSize(int size){
		frameSize = size;
	}

	
	/** 
	 * the max size a line can take before it is broken up into two sub-lines.
	 * Will throw an exception if user tries to specify a negative number. 
	 * Default: 2
	 */
	private static int maxLineSize = 2;
	
	public static int getMaxLineSize() {
		return Globals.maxLineSize;
	}
	public static void setMaxLineSize(int maxLineSize) {
		Globals.maxLineSize = maxLineSize;
	}
	
	
	
	/**
	 * randomization seed.  Default =1;
	 */
	private static long randomSeed = 1;
	
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
	



		
	public static float maxHeight;
	
	public static float minHeight;
}
