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

		Globals.initPointSet();
		Globals.initTriangleList();
	
		Triangle.addTriangleToList( new Triangle( p[0], p[1], p[2]));
		Triangle.addTriangleToList( new Triangle( p[1], p[2], p[3]));

		List <Triangle> list = Globals.getTriangleList();
		//System.out.print( list);		
		assertEquals(2, list.size()); 
	}
	*/
	
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
	
	/*
	@Test
	void testGenerateTriangle4() {
		Point[] p = new Point[4]; 
		try {
			p[0] = new Point (0, 0, 0.0);
			p[1] = new Point (0, 4, 0.0);
			p[2] = new Point (4,0,0.0);
			p[3] = new Point (4,4, 0.0);
		} catch (Exception e) {
			fail("Bad row or column specified");
		}

		Globals.initPointSet();
		Globals.initTriangleList();
	
		Triangle.addTriangleToList( new Triangle( p[0], p[1], p[2]));
		Triangle.addTriangleToList( new Triangle( p[1], p[2], p[3]));

		List <Triangle> list = Globals.getTriangleList();
		System.out.print( list);		
		assertEquals(42, list.size()); 
	}
	*/
	
	
		/*
	@Test
	void testGenerateTriangle2() {
		Point[] p = new Point[3]; 
		try {
			p[0] = new Point (0, 0, 0.0);
			p[1] = new Point (0, 2, 0.0);
			p[2] = new Point (2,0,0.0);
		} catch (Exception e) {
			fail("Bad row or column specified");
		}

		Globals.initLineAndTriangleSets(); 
		Line [] line = {
				new Line( p[0], p[1]),
				new Line( p[1], p[2]),
				new Line( p[2], p[0])
			};
		
		Triangle.addTriangleToSet( new Triangle( line[0], line[1], line[2]));

		Set <Triangle> triSet = Globals.getTriangleSet();
		assertEquals(5, triSet.size()); 
		//System.out.print(triSet);		
	}
	*/	
	
	/*
		@Test
		void testGenerateTriangle2_2() {
			Point[] p = new Point[4]; 
			try {
				p[0] = new Point (0, 0, 0.0);
				p[1] = new Point (0, 2, 0.0);
				p[2] = new Point (2,0,0.0);
				p[3] = new Point (2,2,0.0);
			} catch (Exception e) {
				fail("Bad row or column specified");
			}

			Globals.initLineAndTriangleSets(); 
			Line [] line = {
					new Line( p[0], p[1]),
					new Line( p[1], p[2]),
					new Line( p[2], p[0]),
					new Line( p[3], p[2]),
					new Line( p[1], p[3])
				};
			
			Triangle.addTriangleToSet( new Triangle( line[0], line[1], line[2]));
			Triangle.addTriangleToSet( new Triangle( line[3], line[1], line[4]));
			Set <Triangle> triSet = Globals.getTriangleSet();
			assertEquals(10, triSet.size()); 
			System.out.print(triSet);		
	}
*/	
	
/*
		@Test
		void testGenerateTriangle2_4() {
			Point[] p = new Point[4]; 
			try {
				p[0] = new Point (0, 0, 0.0);
				p[1] = new Point (0, 4, 0.0);
				p[2] = new Point (4,0,0.0);
				p[3] = new Point (4,4,0.0);
			} catch (Exception e) {
				fail("Bad row or column specified");
			}

			Globals.initLineAndTriangleSets(); 
			Line [] line = {
					new Line( p[0], p[1]),
					new Line( p[1], p[2]),
					new Line( p[2], p[0]),
					new Line( p[3], p[2]),
					new Line( p[1], p[3])
				};
			
			Triangle.addTriangleToSet( new Triangle( line[0], line[1], line[2]));
			Triangle.addTriangleToSet( new Triangle( line[3], line[1], line[4]));
			Set <Triangle> triSet = Globals.getTriangleSet();
			System.out.print(triSet);		
			assertEquals(42, triSet.size()); 
	}
*/
	/*	
		@Test
		void testGenerateTriangle2_4line() {
			Globals.initLineAndTriangleSets(); 

			Point[] p = new Point[4]; 
			try {
				p[0] = new Point (0, 0, 0.0);
				p[1] = new Point (0, 2, 0.0);
				p[2] = new Point (2,0,0.0);
				p[3] = new Point (2,2,0.0);
			} catch (Exception e) {}
			Line [] line = {
					new Line( p[0], p[1]),
					new Line( p[1], p[2]),
					new Line( p[2], p[0]),
					new Line( p[3], p[2]),
					new Line( p[1], p[3])
				};
			
			Triangle.addTriangleToSet( new Triangle( line[0], line[1], line[2]));
			Triangle.addTriangleToSet( new Triangle( line[3], line[1], line[4]));
			Set <Line> lineSet = Globals.getLineSet();
			System.out.print(lineSet);		
			
			assertEquals(32, lineSet.size()); 
		}
		*/
}
