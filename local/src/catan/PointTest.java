package catan;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointTest {

	@Test
	void test_upwards() {
		Point point1 = new Point(100, 200);
		Point point2 = new Point(105, 205);
		assertTrue(point1.isPointNearby(point2));
		
		point1 = new Point(100, 200);
		point2 = new Point(110, 210);
		assertTrue(point1.isPointNearby(point2));
		
		point1 = new Point(100, 200);
		point2 = new Point(110, 211);
		assertFalse(point1.isPointNearby(point2));
		
		point1 = new Point(100, 200);
		point2 = new Point(111, 211);
		assertFalse(point1.isPointNearby(point2));
		
		point1 = new Point(100, 200);
		point2 = new Point(100, 200);
		assertTrue(point1.isPointNearby(point2));
		
		point1 = new Point(100, 200);
		point2 = new Point(100, 211);
		assertFalse(point1.isPointNearby(point2));
		
		point1 = new Point(100, 200);
		point2 = new Point(111, 200);
		assertFalse(point1.isPointNearby(point2));
		
		point1 = new Point(100, 200);
		point2 = new Point(105, 205);
		assertTrue(point1.isPointNearby(point2));
		
		point1 = new Point(100, 200);
		point2 = new Point(111, 211);
		assertFalse(point1.isPointNearby(point2));
	}
	
	@Test
	 void test_downwards() {
		Point point1 = new Point(100, 200);
		Point point2 = new Point(90, 200);
		assertTrue(point1.isPointNearby(point2));
		
		point1 = new Point(100, 200);
		point2 = new Point(89, 200);
		assertFalse(point1.isPointNearby(point2));
		
		point1 = new Point(100, 200);
		point2 = new Point(100, 80);
		assertFalse(point1.isPointNearby(point2));
		
		point1 = new Point(100, 200);
		point2 = new Point(95, 205);
		assertTrue(point1.isPointNearby(point2));
	}
}
