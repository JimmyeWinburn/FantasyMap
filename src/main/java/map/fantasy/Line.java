package map.fantasy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Line {
	
	/**
	 * A line is defined by its two end points.
	 */
	public static final byte  P1  = 0;
	public static final byte  P2  = 1;
	private Point [] points = { null, null};
	
	/**
	 * If a line is sufficiently large enough, it is broken up into 
	 * 2 sub lines.  	
	 */
	public static final byte  L1  = 0;
	public static final byte  L2  = 1;
	private Line [] subLines = null;
	
	// The midpoint of the line. used for subsecting a line.
	private Point midPoint = null;
	
			
	/**
	 * @param p1
	 * @param p2
	 */
	public Line(Point p1, Point p2) {
		super();
		points[P1] = p1;
		points[P2] = p2;	
	}
	

	public void setMidPoint(Point p) {
		this.midPoint = p;
	}

	public Point getMidPoint() {
		return midPoint;
	}

	public Point [] getPoints() {
		return points;
	}
	
	public Line [] getSubLines() {
		return subLines;
	}
	
	public void setSublines( Line [] lines) {
		subLines = lines;
	}
	
	
	public static Point calcMidpoint (Point p1, Point p2) {
		double midX    = calcMidPointByDimension(p1.getX(), p2.getX());
		double midY    = calcMidPointByDimension(p1.getY(), p2.getY());
		double midZ    = calcMidPointByDimension(p1.getZ(), p2.getZ());
		try {
			return new Point( midX, midY, midZ);
		}catch (Exception e) {
			return null;
		}
	}
		
	private static double calcMidPointByDimension( double d1, double d2) {
		if (d1 < d2) {
			return (d2 - d1)/2 + d1;
		} else {
			return (d1 - d2)/2 + d2;
		} 
	}

	public static double calcLength( Point p1, Point p2 ) {
		double length = 0;
		length += Math.pow( p2.getX() - p1.getX(), 2.0);
		length += Math.pow( p2.getY() - p1.getY(), 2.0);
		return Math.pow( length, 0.5);
	}
	
	
	
	/**
	 * Will break a line in two if it is bigger than the global maxLineSize. recursively add two sub-lines to the Set of Lines if applicable. 
	 * Otherwise will add the current line to the Set. 
	 *   
	 */
	public static void addLineToSet(Line line) {
		double length = calcLength( line.points[P1], line.points[P2]);
		Globals.getLineSet().add(line); 
		if (length > Globals.getMaxLineSize() ) {
			Point mid = calcMidpoint( line.points[P1], line.points[P2] );
			mid.addRandomToZ( Globals.getNextRandomHeight() * length);
			line.setMidPoint( mid);
			Line [] sub = { 
					new Line( line.points[P1], mid),
					new Line( mid, line.points[P2])
			};
			line.setSublines(sub);
			addLineToSet( sub[L1]);
			addLineToSet( sub[L2]);
		}		
	}
	
	

	/**
	 * calculates which lines of the Set of lines are to be displayed. 
	 * Note:  only leaf nodes should be displayed.
	 * @param lines
	 * @return
	 */
	public static 		List<Line> setDisplayableLineList( Set<Line> lines){
		List<Line> lineList = new ArrayList<Line> ();
	    Iterator<Line> iter = lines.iterator();
	    while (iter.hasNext()) {
	    	Line line = iter.next();
	    	if (line.getSubLines() == null) {
	    		lineList.add( line); 
	    	}
	    }
		return lineList;
	}


	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Line other = (Line) obj;
		if ( (points[0] == other.points[0] && points[1] == other.points[1])  ||
		     (points[0] == other.points[1] && points[1] == other.points[0]) ) {
			return true;
		}
		if (!Arrays.equals(points, other.points))
			return false;
		if (!Arrays.equals(subLines, other.subLines))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Line " + Arrays.toString(points) + '\n';
	}
	


	

}
