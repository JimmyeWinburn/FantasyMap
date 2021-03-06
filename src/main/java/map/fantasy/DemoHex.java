package map.fantasy;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DemoHex extends JPanel {
	
   	private static final long serialVersionUID = 1L;

    private static BufferedImage bImage = new BufferedImage( FantasyMap.getFrameSize(), FantasyMap.getFrameSize(),
            BufferedImage.TYPE_INT_RGB);

   	@Override	
   	public void paintComponent(Graphics g) {
    	
        Graphics2D g2d = (Graphics2D) g.create();
        
        drawMap( g2d);
        
        /* draw the image to a file and save it out if applicable. */
        if (FantasyMap.getSaveFile() != null) {
        	Graphics2D g2file = bImage.createGraphics();
        	drawMap( g2file);       
        	try {
        		ImageIO.write(bImage, "png", FantasyMap.getSaveFile());
        	} catch (IOException e) {
        		System.out.println( "error saving file.");
        	}
        }

   	} 
   	
        private void drawMap( Graphics2D g2d) {
            Iterator<MapShape> iter = ShapeList.get().iterator();
        	while (iter.hasNext()) {
        		Triangle triangle = (Triangle)iter.next();
          		Path2D.Double path = triangle.getPath(); 
                g2d.setPaint( triangle.getColor());
                g2d.fill(path);
                g2d.draw(path);  		
        	}  
        }
   	
    	
   	
   	public static void main (String [] args){
   		JFrame.setDefaultLookAndFeelDecorated(true);
   		JFrame frame = new JFrame("Fractal Map");
   		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   		frame.setBackground(Color.black);
   		frame.setSize(FantasyMap.getFrameSize(), FantasyMap.getFrameSize());

   		FantasyMap.init();
  		
   		Point3[] p = new Point3[7]; 
   		p[0] = new Point3 (255, 0, 0.0);
   		p[1] = new Point3 (767, 0, 0.0);
   		p[2] = new Point3 (255,883,  0.0);
   		p[3] = new Point3 (767,883,  0.0);
   		p[4] = new Point3 (0,441,  0.0);
   		p[5] = new Point3 (1023, 441,  0.0);
   		p[6] = new Point3 (511, 441,  0.0);
		
		p[6].setZ ( p[6].getZ() + (float)RandomAltitude.getNext( Point3.calcLength( p[0], p[3])) );


  		for (int i=0; i<6; i++) {
   			PointMap.put(p[i]); 			
   		}

   		Triangle.addShapeToList( new Triangle( p[0], p[4], p[6]));
   		Triangle.addShapeToList( new Triangle( p[4], p[2], p[6]));
   		Triangle.addShapeToList( new Triangle( p[2], p[3], p[6]));
  		Triangle.addShapeToList( new Triangle( p[3], p[5], p[6]));
  		Triangle.addShapeToList( new Triangle( p[5], p[1], p[6]));
  		Triangle.addShapeToList( new Triangle( p[1], p[0], p[6]));
  		  
   		frame.add(new DemoHex());
   		frame.setVisible(true);
   		
   		   		
   	}
}

