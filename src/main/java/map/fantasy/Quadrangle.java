package map.fantasy;


import java.awt.Color;
import java.awt.geom.Path2D;
import java.util.Arrays;


public class Quadrangle implements MapShape{
	
	
	public Quadrangle(Point3 p1, Point3 p2, Point3 p3, Point3 p4) {
		super();
		points = new Point3[4];
		points[0] = p1;
		points[1] = p2;
		points[2] = p3;
		points[3] = p4;
	}

	private Point3[] points = new Point3[4];
	public Point3 [] getPoints() {  //implements MapShape
		return points;
	}
	
	
	/**
	 * the color of the quad.
	 */
	private Color color; 	
	public Color getColor() {
		return color;
	}
	public void setColor( Color c) {
		color = c;
	}
	
	
	
	public static void addShapeToList(Quadrangle quad) {
		
		// note: No need to test all the lengths.  If one line should be subsected, they all must be. 
		float length = Point3.calcLength( quad.getPoints()[0], quad.getPoints()[1]);
		
		// If quad is a leaf, we can just add it to the list of displayable triangles and be done.
		if (length < FantasyMap.getMaxLineSize()) {
			quad.setColor( MapColor.getMapColor(quad));
			ShapeList.get().add(quad);	
			return;
		}

		// otherwise quad should be subsected
		Point3 [] p        =  quad.getPoints();
		Point3 [] endPoint = new Point3[4];
		Point3 [] midPoint = new Point3[4];
		for (int i=0; i<4; i++) {	
			midPoint[i] = Point3.calcMidpoint( p[i], p[(i+1) % 4] );	
				
			// If midpoint is in the Map already, use the z value of that record.
			Point3 mid = PointMap.get( midPoint[i]);
			if (mid != null) {
				midPoint[i].setZ( mid.getZ());
			}
			
			// otherwise calculate the Z value and add it to the map
			else {    
				midPoint[i].setZ ( midPoint[i].getZ() + (float)RandomAltitude.getNext( length) );
				PointMap.put( midPoint[i]); 
			}
			endPoint[i] = p[i];
		} 
		
		// calculate the center point 
		Point3 centerPoint = Point3.calcMidpoint( midPoint[0], midPoint[2] );	
		centerPoint.setZ ( centerPoint.getZ() + (float)RandomAltitude.getNext( length) );


		// create 4 new quads from endpoints, midpoints, and centerpoint 
		Quadrangle [] sub = new Quadrangle[4];
		for (int i=0; i<4; i++) {
			sub[i] = new Quadrangle( midPoint[(i+3) % 4], endPoint[i], midPoint[i], centerPoint);			
		}


		// recursively add the sub quads to the Set of triangles
		for (int i=0; i< 4; i++) {
			addShapeToList(sub[i]);	
		}					
	}


	public Path2D.Double getPath() {
		Path2D.Double path = new Path2D.Double();
        path.moveTo(points[0].getX(), points[0].getY());
        path.lineTo(points[1].getX(), points[1].getY());
        path.lineTo(points[2].getX(), points[2].getY());
        path.lineTo(points[3].getX(), points[3].getY());
        path.closePath();
        return path;
	}
	
	
	@Override
	public String toString() {
		return "quad " + Arrays.toString(this.getPoints()) + '\n';
	}
	
 

}
