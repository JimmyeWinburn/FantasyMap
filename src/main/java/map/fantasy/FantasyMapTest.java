/**
 * 
 */
package map.fantasy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * @author Jimmye
 *
 */
class FantasyMapTest {
	


	/*
	@Test
	void testGenerateTriangle1() {
		Point[] p = new Point[4]; 
		try {
			p[0] = new Point (0, 0, 0.0);
			p[1] = new Point (0, 1, 0.0);
			p[2] = new Point (1,0,0.0);
			p[3] = new Point (1,1, 0.0);
		} catch (Exception e) {
			fail("Bad row or column specified");
		}

		PointMap.init();
		TriangleList.init();
		RandomAlt.init();
	
		Triangle.addTriangleToList( new Triangle( p[0], p[1], p[2]));
		Triangle.addTriangleToList( new Triangle( p[1], p[2], p[3]));

		List <Triangle> list = Globals.getTriangleList();
		//System.out.print( list);		
		assertEquals(2, list.size()); 
	}
	*/
	/*
	@Test
	void testGenerateTriangle2() {
		PointMap.init();
		TriangleList.init();
		RandomAlt.init();

		Point3[] p = new Point3[4]; 
		p[0] = new Point3 (0.0, 0.0, 0.0);
		p[1] = new Point3 (0.0, 2.0, 0.0);
		p[2] = new Point3 (2.0, 0.0, 0.0);
		p[3] = new Point3 (2.0, 2.0, 0.0);
		for (int i=0; i<3; i++) {
			PointMap.put(p[i]); 			
		}


		Triangle.addTriangleToList( new Triangle( p[0], p[1], p[2]));
		Triangle.addTriangleToList( new Triangle( p[1], p[2], p[3]));

		List <Triangle> list = TriangleList.get();
		System.out.println( list);		
		assertEquals(8, list.size()); 
	}
	*/
	
	@Test
	void testShading1() {
		PointMap.init();
		TriangleList.init();
		RandomAlt.init();

		Point3[] p = new Point3[3]; 
		p[0] = new Point3 (0.0, 0.0, 0.0);
		p[1] = new Point3 (0.0, 1.0, 0.0);
		p[2] = new Point3 (1.0, 0.0, 0.0);
		for (int i=0; i<3; i++) {
			PointMap.put(p[i]); 			
		}


		Triangle.addTriangleToList( new Triangle( p[0], p[1], p[2]));

		List <Triangle> list = TriangleList.get();
		System.out.println( list);		
		assertEquals(8, list.size()); 
	}
	
}
