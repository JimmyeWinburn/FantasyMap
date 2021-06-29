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

public class DemoQuad extends JPanel {
	
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
        		Quadrangle   quad = (Quadrangle)iter.next();
                g2d.setPaint( quad.getColor());
           		Path2D.Double path = quad.getPath(); 
           	    g2d.fill(path);
                g2d.draw(path);  		
        	}  
        }
   	
    	
   	
   	public static void main (String [] args){
   		JFrame.setDefaultLookAndFeelDecorated(true);
   		JFrame frame = new JFrame("seed =" + FantasyMap.getRandomSeed());
   		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   		frame.setBackground(Color.black);
   		frame.setSize(FantasyMap.getFrameSize(), FantasyMap.getFrameSize());

   		FantasyMap.init();
   		Point3[] p = new Point3[4]; 
   		p[0] = new Point3 (0, 0, 0.0);
   		p[1] = new Point3 (0, 1023, 0.0);
   		p[2] = new Point3 (1023,1023,  0.0);
   		p[3] = new Point3 (1023,0,  0.0);
  		for (int i=0; i<4; i++) {
   			PointMap.put(p[i]); 			
   		}
   		Quadrangle.addShapeToList( new Quadrangle( p[0], p[1], p[2],p[3]));
   		  
   		DemoQuad panel = new DemoQuad();
   		frame.add(panel);
   		frame.setVisible(true);
   		/*
   		Collections.sort(FantasyMap.seedList);
   		for(Integer i: FantasyMap.seedList) {
   			System.out.println( i);
   		}
   		*/
   /*		
   	 Set<Point3> ks = PointMap.getMap().keySet();
     for(Point3 key:ks){
         System.out.println(PointMap.getMap().get(key));
     }
 */
   	}
}

