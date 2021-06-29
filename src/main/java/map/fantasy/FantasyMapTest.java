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
	
	
	@Test
	void testShading1() {
		FantasyMap.init();

		Point3[] p = new Point3[3]; 
		p[0] = new Point3 (0.0, 0.0, 0.0);
		p[1] = new Point3 (0.0, 1.0, 0.0);
		p[2] = new Point3 (1.0, 0.0, 0.0);
		for (int i=0; i<3; i++) {
			PointMap.put(p[i]); 			
		}


		Triangle.addShapeToList( new Triangle( p[0], p[1], p[2]));

		List <MapShape> list = ShapeList.get();
		System.out.println( list);		
		assertEquals(8, list.size()); 
	}
	
}
