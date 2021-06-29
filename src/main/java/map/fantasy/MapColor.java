package map.fantasy;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.vecmath.Vector3d;

/**
 * A singleton that defines the color of the triangle based on altitude and latitude (y component.)
 * Values for different altitudes and latitudes can be taken from a color data file. 
 * If no color file exists, colors are determined by altitude only and chosen from a default 
 * list of colors.  
 *  
 * @author Jimmye
 *
 */
public class MapColor {
	
	public static final Color FIELDS = new Color(147,178,102, 255);
	public static final Color FORESTS = new Color(0,128,0, 255);
	public static final Color MOUNTAINS = new Color(128,128,128, 255);
	public static final Color ICE_MOUNTAINS = new Color(255,255,255, 255);
	public static final Color WATER = Color.blue;
	public static final Color SHALLOW_WATER = Color.cyan;
	public static final Color DEEP_WATER = Color.black; 
	
	
	private MapColor() {}   // singleton constructor 
	
	private static BufferedImage colorImage = null;
	
	/**
	 * every time a new map is created, MapColor must be initialized. 
	 */
	public static void init() {	
		if (FantasyMap.getColorFile()!=null) {
			try {
			    colorImage = ImageIO.read( FantasyMap.getColorFile());
			} catch (IOException e) {}
		}
	}
	
	
	/**
	 * returns the color of the supplied shape based on altitude and optionally a color file. 
	 * @param t
	 * @return
	 */
	public static Color getMapColor(MapShape t) {
	       float aveAlt = averageAltitude( t);
	       Color color;
	       if ( colorImage == null) {
	    	   color  = getAltitudeColor( aveAlt);
	       } else {
	    	   color = getAltitudeLatitudeColor( (int)aveAlt, (int)t.getPoints()[0].getY());
	       }
	        if (aveAlt > FantasyMap.getShadeLevel()) {
	        	double angle = getCosAngle( t, FantasyMap.getLightVector());
	        	color = new Color(
	        		(int)(color.getRed() * angle ), 
	        		(int)(color.getGreen() * angle),
	        		(int)(color.getBlue() * angle)
	        		);
	        }
	        return color;   	
		}

	
	private static float averageAltitude( MapShape t) {
		return (t.getPoints()[0].getZ() + t.getPoints()[1].getZ() + t.getPoints()[2].getZ()) / 3;
	}

	
	private static Color getAltitudeLatitudeColor( int altitude, int latitude) {
		if (altitude <= -150 ) {
			return new Color( colorImage.getRGB( latitude, 0));
		} else if (altitude >= 150){
			return new Color( colorImage.getRGB( latitude, 299));
		} else {
			return new Color( colorImage.getRGB( latitude, altitude +150));			
		}
	}
	
	
	private static Color getAltitudeColor( float alt) {
		if (alt < -150 ) {
			return MapColor.DEEP_WATER;
		} else if (alt < -2){
			return MapColor.WATER;
		} else if (alt < 0){
			return MapColor.SHALLOW_WATER;
		} else if (alt < 50){
			return MapColor.FIELDS;
		} else if (alt < 100){
			return MapColor.FORESTS;
		} else if (alt <150){
			return MapColor.MOUNTAINS;
		}
		return MapColor.ICE_MOUNTAINS;
	}

	
	private static Vector3d [] getVectors( MapShape t) {
		Point3 [] p = t.getPoints();
		Vector3d [] vec = new Vector3d[2];
		vec[0] = new Vector3d( 
				p[0].getX() - p[1].getX(),
				p[0].getY() - p[1].getY(),
				p[0].getZ() - p[1].getZ());
		vec[1] = new Vector3d( 
				p[2].getX() - p[1].getX(),
				p[2].getY() - p[1].getY(),
				p[2].getZ() - p[1].getZ());
		return vec;
	}
	
	private static double getCosAngle( MapShape t, Vector3d light) {
		Vector3d [] vec = getVectors(t);
		Vector3d normal = getNormal(vec);
		double angle = normal.angle(light) /2.0;  // angle is devided by 2 to simulate ambient light.
		return Math.cos(angle);
		
	}
	
	private static Vector3d getNormal( Vector3d [] vec) {
		Vector3d normal = new Vector3d();
		normal.cross(vec[0], vec[1]);
		return normal;
	}
	

}
