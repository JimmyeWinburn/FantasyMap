package map.fantasy;

import javax.vecmath.Point3f;

/**
 * decorator over Point3f to allow sorting and equality on just the x and y coordinates.
 * 
 * @author Jimmye
 *
 */
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
	 * @throws Exception if any of the parameters are less than 0.
	 */
	public Point3(float x, float y, float z) {
		super();		
		point = new Point3f( x,y,z);
	}
	
	public Point3(double x, double y, double z) {
		super();		
		point = new Point3f( (float)x,(float)y,(float)z);
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





}
