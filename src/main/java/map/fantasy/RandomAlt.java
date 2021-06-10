package map.fantasy;

import java.util.Random;

public class RandomAlt {
	
	private static Random random = null;
	
	
	public static void init() {
		random = new Random( Globals.getRandomSeed());
	}

	
	public static double getNext(double length) {
		return (random.nextDouble() - 0.5) * Globals.getSteepness() * length;
	}


}
