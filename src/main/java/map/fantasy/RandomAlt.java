package map.fantasy;

import java.util.Random;

public class RandomAlt {
	
	private static Random random = null;
	
	
	public static void init() {
		random = new Random( Globals.getRandomSeed());
	}

	
	public static double getNext(double length) {
		return (random.nextDouble() - 0.5) * Globals.getSteepness() * length;
		//return (random.nextGaussian() / 4.0) * Globals.getSteepness() * length;
	}
	
	public static float getNextAltitude(double length, double altitude) {
		return (float)(altitude + ((random.nextDouble() - 0.5) * calcSteepness(altitude) * length));
		//return (random.nextGaussian() / 4.0) * Globals.getSteepness() * length;
	}
	
	private static double calcSteepness(double z) {
		return (z * z) / 20000 + z / 200 + .1; 
	}


	private RandomAlt() {}
}
