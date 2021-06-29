package map.fantasy;

import java.util.Random;

public class RandomAltitude {
	
	private static Random random = null;
	
	
	public static void init() {
		random = new Random( FantasyMap.getRandomSeed());
	}

	
	public static double getNext(double length) {
		return (random.nextDouble() - 0.5) * FantasyMap.getSteepness() * length;
	}
	
	
	/**
	 * difference is that the random altitude is the first random number returned for a randomization
	 * seed based on the X and Y coordinates (plus the global random seed.)  This way the random 
	 * altitude will always be the same in every instance of the application, no matter how many 
	 * shapes have been clipped from the list.  
	 * 
	 * @param length
	 * @param p
	 * @return
	 */
	/*
	public static float getNextAltitude(double length,  Point3 p) {
		long seed = (long)(p.getX() * p.getX() * p.getY() + FantasyMap.getRandomSeed());
		random = new Random( seed);
		return getNext( length);
	}
	*/

	// private const ructor to prevent someone from instanciating this class
	private RandomAltitude() {}
}
