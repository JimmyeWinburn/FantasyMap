package map.fantasy;

import java.awt.Color;

public class MapColor {
	
	public static final Color FIELDS = new Color(57, 181, 74, 255);
	public static final Color FORESTS = new Color(0,94,32, 255);
	public static final Color MOUNTAINS = new Color(128,128,128, 255);
	public static final Color ICE_MOUNTAINS = new Color(255,255,255, 255);
	public static final Color SAND = new Color(253,198,137, 255);
	public static final Color WATER = Color.blue;
	public static final Color SHALLOW_WATER = Color.cyan;
	public static final Color DEEP_WATER = Color.black; 
	
	
	private MapColor() {}
	
	public static Color getAltitudeColor( float alt) {
		if (alt < -150 ) {
			return MapColor.DEEP_WATER;
		} else if (alt < -10){
			return MapColor.WATER;
		} else if (alt < 0){
			return MapColor.SHALLOW_WATER;
		//} else if (alt < 5){
		//	return MapColor.SAND;
		} else if (alt < 50){
			return MapColor.FIELDS;
		} else if (alt < 100){
			return MapColor.FORESTS;
		} else if (alt <150){
			return MapColor.MOUNTAINS;
		}
		return MapColor.ICE_MOUNTAINS;
	}
	

}
