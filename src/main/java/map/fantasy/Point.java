package map.fantasy;

public class Point {
	
	

	// The position in 3 space of the point.
	private double   x;  
	private double   y;
	private double   z;
	

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}
	
	public void setZ( double z) {
		this.z = z;
	}
	
	/**
	 * add a randomly chosen value to the current z coordinate 
	 * for this point.
	 * 
	 * @param update
	 */
	public void addRandomToZ(double update) {
		z += update;
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @throws Exception if any of the parameters are less than 0.
	 */
	public Point(double x, double y, double z) throws Exception{
		super();
		
		if (x<0 || y<0 ) {
			throw new Exception();
		}
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
	 

	@Override
	public String toString() {
		return "Point [x=" + this.x + ", y=" + this.y + ", z=" + this.z + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
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
		Point other = (Point) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}


	



}
