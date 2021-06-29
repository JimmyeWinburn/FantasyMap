package map.fantasy;


import java.awt.Color;
import java.awt.geom.Path2D;
import java.util.Arrays;


public class Triangle implements MapShape{
	
	
	/**
	 * A triangle is defined by 3 Points and a color
	 */
	public Triangle(Point3 p1, Point3 p2, Point3 p3) {
		super();
		points = new Point3[3];
		points[0] = p1;
		points[1] = p2;
		points[2] = p3;
	}

	/**
	 * A triangle is defined by three Point3
	 */
	private Point3[] points = new Point3[3];
	public Point3 [] getPoints() {
		return points;
	}
	
	
	/**
	 * the color of the triangle.
	 */
	private Color color; 	
	public Color getColor() {
		return color;
	}
	private void setColor( Color c) {
		color = c;
	}
	
	
	
	/**
	 * adds the triangle to the list of displayable triangles if it is a leaf.  
	 * Is called recursively on 4 sub-triangles otherwise.
	 */
	public static void addShapeToList(Triangle triangle) {
		

		// if triangle should be subsected...
		// note: No need to test all the lengths.  If one line should be subsected, they all must be. 
		// Since the triangles are mostly equilateral, this shouldn't be a problem.
		float length = Point3.calcLength( triangle.getPoints()[0], triangle.getPoints()[1]);
		
		// If triangle is a leaf, we can just add it to the list of displayable triangles and be done.
		if (length < FantasyMap.getMaxLineSize()) {
			triangle.setColor( MapColor.getMapColor(triangle));
			ShapeList.get().add(triangle);	
			return;
		}

		// otherwise triangle needs to be subsected. 
		
		// get mid and end points for all new lines
		Point3 [] p        = triangle.getPoints();
		Point3 [] endPoint = new Point3[3];
		Point3 [] midPoint = new Point3[3];
		for (int i=0; i<3; i++) {	
			midPoint[i] = Point3.calcMidpoint( p[i], p[(i+1) % 3] );	
			
		
			Point3 mid = PointMap.get( midPoint[i]);
			if (mid != null) {
				midPoint[i].setZ( mid.getZ());
			}
			// if midpoint is not in the Point Map, create a new one and add it to the map
			else {    
				// otherwise calculate new Z coordinate and add the point to the Point Map
				midPoint[i].setZ ( midPoint[i].getZ() + (float)RandomAltitude.getNext( length) );
				PointMap.put( midPoint[i]); 
			}
			endPoint[i] = p[i];
		} 


		// create 4 new triangles from endpoints and midpoints 
		Triangle [] subTri = new Triangle[4];
		for (int i=0; i<3; i++) {
			subTri[i] = new Triangle( endPoint[i], midPoint[i], midPoint[  (i+2) % 3]);			
		}

		// create 4th new triangle from the midpoints of all the other triangles
		subTri[3] = new Triangle( subTri[0].getPoints()[1], subTri[1].getPoints()[1], subTri[2].getPoints()[1]);


		// recursively add the sub triangles to the Set of triangles
		for (int i=0; i< 4; i++) {
			addShapeToList(subTri[i]);	
		}					
	}

	public Path2D.Double getPath() {
		Path2D.Double path = new Path2D.Double();
        path.moveTo(points[0].getX(), points[0].getY());
        path.lineTo(points[1].getX(), points[1].getY());
        path.lineTo(points[2].getX(), points[2].getY());
        path.closePath();
        return path;
	}
	

	
	
	
	@Override
	public String toString() {
		return "triangle " + Arrays.toString(this.getPoints()) + '\n';
	}
	
 

}
