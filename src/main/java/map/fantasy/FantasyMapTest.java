/**
 * 
 */
package map.fantasy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Jimmye
 *
 */
class FantasyMapTest {
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}


	@Test
	void testPointArrayCreation() {
		
		Point p;
		
		try {
			p = new Point (0, 0, 1066.0);
			assertEquals( 1066.0, p.getZ());
		} catch (Exception e) {
			fail("Bad row or column specified");
		}
		

		try {
			p = new Point (-1, 0, 0.0);
		} catch (Exception e) {
			return;
		}
		fail("bad parameter specified and not caught");
	}
	
	
	@Test
	void testRecursiveLineGeneration1() {
		Point[] p = new Point[2]; 

		try {
			p[0] = new Point (0, 0, 0.0);
			p[1] = new Point (2, 0, 0.0);
		} catch (Exception e) {
			fail("Bad row or column specified");
		}

		Globals.initLineSet();
		Line line = new Line( p[0], p[1]);
		Line.addLineToSet(line); 

		Set<Line> lineSet = Globals.getLineSet();
		assertEquals(1, lineSet.size());
		//System.out.print(lineSet);
		
		
	}

	@Test
	void testRecursiveLineGeneration2() {
		Point[] p = new Point[2]; 

		try {
			p[0] = new Point (0, 0, 0.0);
			p[1] = new Point (4, 0, 0.0);
		} catch (Exception e) {
			fail("Bad row or column specified");
		}

		Globals.initLineSet();
		Line line = new Line( p[0], p[1]);
		Line.addLineToSet(line); 

		Set<Line> lineSet = Globals.getLineSet();
		assertEquals(3, lineSet.size());

		//System.out.print(lineSet);		
	}

	@Test
	void testRecursiveLineGeneration3() {
		Point[] p = new Point[2]; 

		try {
			p[0] = new Point (0, 0, 0.0);
			p[1] = new Point (8, 0, 0.0);
		} catch (Exception e) {
			fail("Bad row or column specified");
		}

		Globals.initLineSet();
		Line line = new Line( p[0], p[1]);
		Line.addLineToSet(line); 

		Set<Line> lineSet = Globals.getLineSet();
		assertEquals(7, lineSet.size());

		//System.out.print(lineSet);		
	}

	
	@Test
	void testGenerateDisplayableLineList() {
		Point[] p = new Point[2]; 

		try {
			p[0] = new Point (0, 256, 0.0);
			p[1] = new Point (8, 256, 0.0);
		} catch (Exception e) {
			fail("Bad row or column specified");
		}

		Globals.initLineSet();
		Line line = new Line( p[0], p[1]);
		Line.addLineToSet(line); 

		Set<Line> lineSet = Globals.getLineSet();
		List<Line> displayableLineList = Line.setDisplayableLineList( lineSet);
		assertEquals(4, displayableLineList.size());
		//System.out.print(displayableLineList);		
	}

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
		//Globals.initPointSet();
		PointMap.initPointMap();
		Globals.initTriangleList();

		Point3[] p = new Point3[4]; 
		try {
			p[0] = new Point3 (0.0, 0.0, 0.0);
			p[1] = new Point3 (0.0, 2.0, 0.0);
			p[2] = new Point3 (2.0, 0.0, 0.0);
			p[3] = new Point3 (2.0, 2.0, 0.0);
		} catch (Exception e) {
			fail("Bad row or column specified");
		}
		for (int i=0; i<3; i++) {
			PointMap.put(p[i]); 			
		}
		
	
		Triangle.addTriangleToList( new Triangle( p[0], p[1], p[2]));
		Triangle.addTriangleToList( new Triangle( p[1], p[2], p[3]));

		List <Triangle> list = Globals.getTriangleList();
		System.out.print( list);		
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
