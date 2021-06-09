package map.fantasy;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MeshDemo extends JPanel {
	
   	private static final long serialVersionUID = 1L;

   	@Override	
   	public void paintComponent(Graphics g) {
    	
        Graphics2D g2d = (Graphics2D) g.create();
        
        Iterator<Triangle> iter = Globals.getTriangleList().iterator();
    	while (iter.hasNext()) {
    		Triangle triangle = iter.next();
    		Point3 [] points = triangle.getPoints();
            TriangleShape triangleShape = new TriangleShape(
            		new Point2D.Double( points[0].getX() , points[0].getY() ),
               		new Point2D.Double( points[1].getX() , points[1].getY() ),
               		new Point2D.Double( points[2].getX() , points[2].getY() ));
            g2d.setPaint( MapColor.getAltitudeColor( points[0].getZ()));
            g2d.fill(triangleShape);
            g2d.draw(triangleShape);  		
    	}
    }
   	public static void main (String [] args){
   		JFrame.setDefaultLookAndFeelDecorated(true);
   		JFrame frame = new JFrame("Fractal Map");
   		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   		frame.setBackground(Color.black);
   		frame.setSize(Globals.getFrameSize(), Globals.getFrameSize());

   		PointMap.initPointMap();
   		Globals.initTriangleList();
   		Point3[] p = new Point3[4]; 
   		p[0] = new Point3 (0, 0, 0.0);
   		p[1] = new Point3 (0, Globals.getFrameSize(), 0.0);
   		p[2] = new Point3 (Globals.getFrameSize(),0,  0.0);
   		p[3] = new Point3 (Globals.getFrameSize(),Globals.getFrameSize(),  0.0);
   		for (int i=0; i<3; i++) {
   			PointMap.put(p[i]); 			
   		}

   		Triangle.addTriangleToList( new Triangle( p[0], p[1], p[2]));
   		Triangle.addTriangleToList( new Triangle( p[1], p[3], p[2]));

   		MeshDemo panel = new MeshDemo();
   		frame.add(panel);
   		frame.setVisible(true);
   		
   		System.out.println( "maxHeight=" + Globals.maxHeight);
  		System.out.println( "minHeight=" + Globals.minHeight);
  		   		
   	}
}

class TriangleShape extends Path2D.Double {
 	private static final long serialVersionUID = 1L;

	public TriangleShape(Point2D... points) {
        moveTo(points[0].getX(), points[0].getY());
        lineTo(points[1].getX(), points[1].getY());
        lineTo(points[2].getX(), points[2].getY());
        closePath();
    }
}

