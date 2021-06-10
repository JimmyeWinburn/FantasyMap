package map.fantasy;


import java.util.Arrays;


public class Triangle {
	
	
	/**
	 * A triangle is defined by 3 Points
	 */
	public Triangle(Point3 p1, Point3 p2, Point3 p3) {
		super();
		points = new Point3[3];
		points[0] = p1;
		points[1] = p2;
		points[2] = p3;
	}

	private Point3[] points = new Point3[3];

	public Point3 [] getPoints() {
		return points;
	}
	
	
	
	/**
	 * recursively add 4 sub-triangles to the Set of Triangles if it is bigger than the global maxLineSize. 
	 */
	public static void addTriangleToList(Triangle triangle) {
		

		// if triangle should be subsected...
		// note: No need to test all the lengths.  If one line should be subsected, they all must be. 
		// Since the triangles are mostly equilateral, so this shouldn't be a problem.
		float length = calcLength( triangle.getPoints()[0], triangle.getPoints()[1]);
		
		// If triangle is a leaf, we can just add it to the list of displayable triangles and be done.
		if (length < Globals.getMaxLineSize()) {
				TriangleList.get().add(triangle);	
				return;
		}

		// otherwise triangle needs to be subsected. 
		
		// get mid and end points for all new lines
		Point3 [] p        = triangle.getPoints();
		Point3 [] endPoint = new Point3[3];
		Point3 [] midPoint = new Point3[3];
		for (int i=0; i<3; i++) {	
			midPoint[i] = calcMidpoint( p[i], p[(i+1) % 3] );	
			
		
			Point3 mid = PointMap.get( midPoint[i]);
			if (mid != null) {
				midPoint[i].setZ( mid.getZ());
			}
			// if midpoint is not in the Point Set, create a new one and add it to the Map
			else {    
				// otherwise calculate new Z coordinate and add the point to the Point Map
				midPoint[i].setZ ( midPoint[i].getZ() + (float)RandomAlt.getNext( length) );
				//midPoint[i].setZ( MapColor.borderRuleFilter( midPoint[i]) );
				Globals.maxHeight = midPoint[i].getZ() > Globals.maxHeight ? midPoint[i].getZ() : Globals.maxHeight;
				Globals.minHeight = midPoint[i].getZ() < Globals.minHeight ? midPoint[i].getZ() : Globals.minHeight;
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
			addTriangleToList(subTri[i]);	
		}					
	}

	
	private static Point3 calcMidpoint (Point3 p1, Point3 p2) {
		float midX    = calcMidPointByDimension(p1.getX(), p2.getX());
		float midY    = calcMidPointByDimension(p1.getY(), p2.getY());
		float midZ    = calcMidPointByDimension(p1.getZ(), p2.getZ());
		try {
			return new Point3( midX, midY, midZ);
		}catch (Exception e) {
			return null;
		}
	}
		
	private static float calcMidPointByDimension( float d1, float d2) {
		if (d1 < d2) {
			return (d2 - d1)/2 + d1;
		} else {
			return (d1 - d2)/2 + d2;
		} 
	}

	private static float calcLength( Point3 p1, Point3 p2 ) {
		double length = 0;
		length += Math.pow( p2.getX() - p1.getX(), 2.0);
		length += Math.pow( p2.getY() - p1.getY(), 2.0);
		return (float)Math.pow( length, 0.5);
	}
	
	

	@Override
	public String toString() {
		return "triangle " + Arrays.toString(this.getPoints()) + '\n';
	}
	
 

}
