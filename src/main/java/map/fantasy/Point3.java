package map.fantasy;

import javax.vecmath.Point3f;

/**
 * decorator over Point3f to allow sorting and equality on just the x and y coordinates.
 * 
 * @author Jimmye
 *
 */
//public class Point3 implements Comparator<Point3>{
public class Point3 {
	
	Point3f point = null;


	public Point3f getPoint3f() {
		return point;
	}
	
	public float getX() {
		return point.x;
	}

	public float getY() {
		return point.y;
	}

	public float getZ() {
		return point.z;
	}
	
	/**
	 * only z coordinate is mutable.
	 * @param z
	 */
	public void setZ( float z) {
		this.point.z = z;
	}
	

	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public Point3(float x, float y, float z) {
		point = new Point3f( x,y,z);
	}
	
	public Point3(double x, double y, double z) {
		point = new Point3f( (float)x,(float)y,(float)z);
	}
	
	public Point3() {
		point = new Point3f( 0.0f, 0.0f, 0.0f);		
	}
	
	 
	/**
	 * calculates the distance between the 2 supplied points.
	 * 
	 * @param p1
	 * @param p2
	 * @return
	 */
	public static float calcLength( Point3 p1, Point3 p2 ) {
		double length = 0;
		length += Math.pow( p2.getX() - p1.getX(), 2.0);
		length += Math.pow( p2.getY() - p1.getY(), 2.0);
		return (float)Math.pow( length, 0.5);
	}

	/** 
	 * calculate the midpoint between the 2 supplied points. 
	 * @param p1
	 * @param p2
	 * @return
	 */
	public static Point3 calcMidpoint (Point3 p1, Point3 p2) {
		float midX    = calcMidPointByDimension(p1.getX(), p2.getX());
		float midY    = calcMidPointByDimension(p1.getY(), p2.getY());
		float midZ    = calcMidPointByDimension(p1.getZ(), p2.getZ());
		return new Point3( midX, midY, midZ);
	}
		
	private static float calcMidPointByDimension( float d1, float d2) {
		if (d1 < d2) {
			return (d2 - d1)/2 + d1;
		} else {
			return (d1 - d2)/2 + d2;
		} 
	}


	@Override
	public String toString() {
		return "Point [x=" + this.point.x + ", y=" + this.point.y + ", z=" + this.point.z + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(point.x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(point.y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point3 other = (Point3) obj;
		if (Double.doubleToLongBits((double)point.x) != Double.doubleToLongBits((double)other.point.x))
			return false;
		if (Double.doubleToLongBits((double)point.y) != Double.doubleToLongBits((double)other.point.y))
			return false;
		return true;
	}


	/*
	@Override
	public int compare( Point3 p1, Point3 p2) {
		int x = 0;
		
		if (p1.getX() > p2.getX()) {
			return 1;
		} else if (p1.getX() < p2.getX()) {
			return -1;
		} else if (p1.getY() > p2.getY()) {
				return 1;
		} else if (p1.getY() < p2.getY()) {
				return -1;
		} else {
			return 0;
		}
	}
	*/	




}
