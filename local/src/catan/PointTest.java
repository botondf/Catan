package catan;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointTest {

	@Test
	void test() {
		Point point1 = new Point(100, 200);
		Point point2 = new Point(105, 205);
		assertTrue(point1.isPointNearby(point2));
		
		point1 = new Point(100, 200);
		point2 = new Point(111, 211);
		assertFalse(point1.isPointNearby(point2));
	}
}
