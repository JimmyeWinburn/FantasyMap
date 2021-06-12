package map.fantasy;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DemoHex extends JPanel {
	
   	private static final long serialVersionUID = 1L;

   	@Override	
   	public void paintComponent(Graphics g) {
    	
        Graphics2D g2d = (Graphics2D) g.create();
        
        Iterator<Triangle> iter = TriangleList.get().iterator();
    	while (iter.hasNext()) {
    		Triangle triangle = iter.next();
    		Point3 [] points = triangle.getPoints();
            TriangleShape triangleShape = new TriangleShape(
            		new Point2D.Double( points[0].getX() , points[0].getY() ),
               		new Point2D.Double( points[1].getX() , points[1].getY() ),
               		new Point2D.Double( points[2].getX() , points[2].getY() ));
            float aveAlt = Triangle.averageAltitude( triangle);
            g2d.setPaint( MapColor.getAltitudeColor( aveAlt));
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

   		PointMap.init();
   		TriangleList.init();
   		RandomAlt.init();
   		Point3[] p = new Point3[7]; 
   		p[0] = new Point3 (256, 0, 0.0);
   		p[1] = new Point3 (768, 0, 0.0);
   		p[2] = new Point3 (256,884,  0.0);
   		p[3] = new Point3 (768,884,  0.0);
   		p[4] = new Point3 (0,442,  0.0);
   		p[5] = new Point3 (1024, 442,  0.0);
   		p[6] = new Point3 (512, 442,  0.0);
		
		p[6].setZ ( p[6].getZ() + (float)RandomAlt.getNext( Triangle.calcLength( p[0], p[3])) );


  		for (int i=0; i<6; i++) {
   			PointMap.put(p[i]); 			
   		}

   		Triangle.addTriangleToList( new Triangle( p[0], p[4], p[6]));
   		Triangle.addTriangleToList( new Triangle( p[4], p[2], p[6]));
   		Triangle.addTriangleToList( new Triangle( p[2], p[3], p[6]));
  		Triangle.addTriangleToList( new Triangle( p[3], p[5], p[6]));
  		Triangle.addTriangleToList( new Triangle( p[5], p[1], p[6]));
  		Triangle.addTriangleToList( new Triangle( p[1], p[0], p[6]));
  		  
   		DemoHex panel = new DemoHex();
   		frame.add(panel);
   		frame.setVisible(true);
   		
   		//System.out.println( "maxHeight=" + Globals.maxHeight);
  		//System.out.println( "minHeight=" + Globals.minHeight);
  		   		
   	}
}

/*class TrianglePath extends Path2D.Double {
 	private static final long serialVersionUID = 1L;

	public TrianglePath(Point2D... points) {
        moveTo(points[0].getX(), points[0].getY());
        lineTo(points[1].getX(), points[1].getY());
        lineTo(points[2].getX(), points[2].getY());
        closePath();
    }
   
}
*/
