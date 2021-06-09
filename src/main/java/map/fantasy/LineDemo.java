package map.fantasy;


import java.awt.BasicStroke;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;



class Surface extends JPanel {
 	private static final long serialVersionUID = 2L;

 
 	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(4));
       
    	Point[] p = new Point[2]; 

    	try {
    		p[0] = new Point (0, 0, 0.0);
    		p[1] = new Point (512, 0, 0.0);
    	} catch (Exception e) {
    		return;
    	}

    	Globals.initLineSet();
    	Line line = new Line( p[0], p[1]);
    	Line.addLineToSet(line); 

    	Set<Line> lineSet = Globals.getLineSet();
    	List<Line> displayableLineList = Line.setDisplayableLineList( lineSet);
    	if (displayableLineList ==null) {
    		return;
    	}
	    Iterator<Line> iter = displayableLineList.iterator();
	    while (iter.hasNext()) {
	    	Line ln = iter.next();
	    	Point [] pt = ln.getPoints(); 
	    	g2d.drawLine(
	    			(int)(pt[Line.P1].getX()), 
	    			(int)(pt[Line.P1].getZ()) + 256, 
	    			(int)(pt[Line.P2].getX()), 
	    			(int)(pt[Line.P2].getZ()) + 256
	    			);
	    }

    }
}

public class LineDemo extends JFrame {
 	private static final long serialVersionUID = 1L;
	public LineDemo() {
        add(new Surface());
        setSize(512, 512);      
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                LineDemo ex = new LineDemo();
                ex.setVisible(true);
            }
        });
    }
}