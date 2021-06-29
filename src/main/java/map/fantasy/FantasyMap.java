package map.fantasy;

import java.io.File;
import java.util.ArrayList;

import javax.vecmath.Vector3d;

/**
 * Globals
 * 
 * user controlled global values.  
 */
public class FantasyMap {
	

	private FantasyMap() {}
	
	/**
	 * initializes all the lists and shit.
	 */
	public static void init() {
		
		switch (biomeType) {
		case 1: 	
			colorFile = new File(".\\data\\QuadFire.png");
			shadeLevel = 0;
			break;
		case 2: 	
			colorFile = new File(".\\data\\QuadAir.png");
			shadeLevel = 150;
			break;
		case 3: 	
			colorFile = new File(".\\data\\QuadEthereal.png");
			shadeLevel = 25;
			break;
		case 4: 	
			colorFile = new File(".\\data\\QuadWater.png");
			shadeLevel = -150;
			break;
		case 5: 	
			colorFile = new File(".\\data\\QuadEarth.png");
			shadeLevel = 50;
			break;
		case 6:
			colorFile = new File(".\\data\\QuadTemperate.png");
			shadeLevel = 100;
			break;			
		default:
			//colorFile = new File(".\\data\\QuadTemperate.png");
			shadeLevel = 100;
			break;			
			
		}
		MapColor.init();
		
		PointMap.init();
		RandomAltitude.init();
		ShapeList.init();

	}
	
	
	//public static ArrayList<Integer> seedList = new ArrayList();
	
	/**
	 * general biome type supplying default parameters.
	 * default - Temperate 
	 * 1 -       Fire
	 * 
	 */
	private static int biomeType = 0;	
	public static int getBiomeType() {
		return biomeType;
	}
	public static void setBiomeType(int biomeType) {
		FantasyMap.biomeType = biomeType;
	}

	//private static File saveFile =  new File(".\\data\\saveEthereal.png");
	private static File saveFile =  null;
	public static File getSaveFile() {
		return saveFile;
	}
	public static void setSaveFile(File saveFile) {
		FantasyMap.saveFile = saveFile;
	}


	/** 
	 * The data file used for coloring pixels.  The columns are the color for 
	 * altitude and the rows are the color for latitude.
	 */
	private static File colorFile = null;
	public static File getColorFile() {
		return colorFile;
	}
	public static void setColorFile(String s) {
		colorFile = new File(s);
	}
	
	
	/**
	 * Pixels that are at a lower altitude than this value
	 * are not shaded 
	 * when FantasyMap is initialized, this value is set according
	 * to biome. 
	 */
	private static double shadeLevel = 0;  
	public static double getShadeLevel() {
		return shadeLevel;
	}
	public static void setShadeLevel(double w) {
		shadeLevel = w;
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
	 * the number of rows and columns of the finished map.  
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
	 */
	private static int maxLineSize = 1;	
	public static int getMaxLineSize() {
		return FantasyMap.maxLineSize;
	}
	public static void setMaxLineSize(int maxLineSize) {
		FantasyMap.maxLineSize = maxLineSize;
	}
	
	
	
	/**
	 * randomization seed.  
	 */
	private static long randomSeed = 7;	
	public static long getRandomSeed() {
		return randomSeed;
	}	
	public static void setRandomSeed(long seed) {
		randomSeed = seed;
	}
	

	/**
	 * how steep the heights should be.  0.0 is flat.  
	 */
	private static double steepness = 0.4;	
	public static double getSteepness() {
		return steepness;
	}
	public static void setSteepness(double steep) {
		steepness = steep;
	}
	
}
