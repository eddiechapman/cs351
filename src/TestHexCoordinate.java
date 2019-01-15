import java.awt.Point;
import java.awt.Polygon;

import edu.uwm.cs.junit.LockedTestCase;
import edu.uwm.cs351.HexCoordinate;

public class TestHexCoordinate extends LockedTestCase {
	protected void assertNotEquals(Object x, Object y) {
		if (x == null) {
			assertFalse(x == y);
		} else {
			assertFalse(x + " should not equal " + y, x.equals(y));
		}
	}
	
	protected void assertException(Class<? extends Throwable> c, Runnable r) {
		try {
			r.run();
			assertFalse("Exception should have been thrown",true);
		} catch (RuntimeException ex) {
			assertTrue("should throw exception of " + c + ", not of " + ex.getClass(), c.isInstance(ex));
		}
	}
	
	protected HexCoordinate h(int a, int b) { 
		return new HexCoordinate(a,b);
	}
	
	
	
	/// locked tests
	
	public void test() {
		HexCoordinate h = new HexCoordinate(2,1);
		assertEquals(Ts(572530722),h.toString());
		// Look at the picture on the first page:
		assertEquals(Ti(2091651564),h.distance(new HexCoordinate(2,2,0)));
		assertEquals(Ti(83653195),h.distance(h));
		assertEquals(Ti(330722134),h.distance(new HexCoordinate(4,2,2)));
		// no sqrt(3) stuff for this one:
		assertEquals(Ti(832991396),h.toPoint(1000).x); 
		// NB: sqrt(3)/2 = 0.8660...
		// And look at the homework page 2
		assertEquals(Ti(542975482),h.toPoint(1000).y);
	}
	
	
	/// test0X: toString tests
	
	public void test00() {
		assertEquals("<0,0,0>", new HexCoordinate(0, 0).toString());
	}
	
	public void test01() {
		assertEquals("<1,3,-2>", new HexCoordinate(1, 3).toString());
	}
	
	public void test02() {
		assertEquals("<-10,6,-16>", new HexCoordinate(-10, 6).toString());
	}
	
	public void test03() {
		assertEquals("<3,-4,7>", new HexCoordinate(3, -4).toString());
	}
	
	public void test04() {
		assertEquals("<3,2,1>", new HexCoordinate(3, 2, 1).toString());
	}
	
	public void test09() {
		assertException(IllegalArgumentException.class, () -> new HexCoordinate(1,2,3));
	}

	
	/// test1X: equals tests
	
	public void test10() {
		assertTrue(new HexCoordinate(-4,4).equals(new HexCoordinate(-4,4)));
	}
	
	public void test11() {
		assertFalse(new HexCoordinate(-4,4).equals(new HexCoordinate(4,4)));
	}
	
	public void test12() {
		assertFalse(new HexCoordinate(-4,4).equals(new HexCoordinate(4,-4)));
	}
	
	public void test13() {
		assertFalse(new HexCoordinate(-4,4).equals(null));
	}
	
	public void test14() {
		assertFalse(new HexCoordinate(-4,4).equals(new Point(-4, 4)));
	}
	
	public void test15() {
		assertFalse(new HexCoordinate(0,0).equals(null));
	}
	
	public void test16() {
		Object o1 = new HexCoordinate(2,-3);
		Object o2 = new HexCoordinate(2,-3);
		assertTrue(o1.equals(o2));
	}
	
	public void test17() {
		assertEquals(new HexCoordinate(3,2), new HexCoordinate(3,2,1));
	}
	
	public void test18() {
		// This should be an easy test to pass unless you are doing something tricky.
		HexCoordinate h1 = new HexCoordinate(16,215);
		HexCoordinate h2 = new HexCoordinate(31,-266);
		assertFalse(h1.equals(h2));
		assertFalse(h2.equals(h1));
	}
	
	public void test19() {
		HexCoordinate h1 = new HexCoordinate(7,15);
		HexCoordinate h2 = new HexCoordinate(8,-16);
		assertFalse(h1.equals(h2));
		assertFalse(h2.equals(h1));	
	}
	

	/// test2X: hash code
	
	public void test20() {
		assertEquals(new HexCoordinate(-4,4).hashCode(), new HexCoordinate(-4,4).hashCode());
	}
	
	public void test21() {
		assertEquals(new HexCoordinate(2,-3).hashCode(), new HexCoordinate(2,-3).hashCode());
	}
	
	public void test22() {
		assertNotEquals(new HexCoordinate(1,0),new HexCoordinate(0,0));
		assertNotEquals(new HexCoordinate(1,0),new HexCoordinate(0,1));
		assertNotEquals(new HexCoordinate(1,0),new HexCoordinate(-1,0));
		assertNotEquals(new HexCoordinate(0,1),new HexCoordinate(0,0));
		assertNotEquals(new HexCoordinate(0,1),new HexCoordinate(-1,0));
		assertNotEquals(new HexCoordinate(0,1),new HexCoordinate(0,-1));
		assertNotEquals(new HexCoordinate(-1,0),new HexCoordinate(0,-1));
		assertNotEquals(new HexCoordinate(-1,0),new HexCoordinate(0,0));
		assertNotEquals(new HexCoordinate(0,-1),new HexCoordinate(0,0));
		assertNotEquals(new HexCoordinate(0,-1),new HexCoordinate(1,0));
	}
	
	public void test23() {
		assertNotEquals(new HexCoordinate(1,1),new HexCoordinate(0,2));
		assertNotEquals(new HexCoordinate(1,1),new HexCoordinate(0,1));
		assertNotEquals(new HexCoordinate(1,1),new HexCoordinate(1,0));
		assertNotEquals(new HexCoordinate(1,1),new HexCoordinate(0,2));
		assertNotEquals(new HexCoordinate(1,1),new HexCoordinate(0,0));
		assertNotEquals(new HexCoordinate(1,1),new HexCoordinate(0,-1));
		assertNotEquals(new HexCoordinate(1,1),new HexCoordinate(-1,0));
		assertNotEquals(new HexCoordinate(1,1),new HexCoordinate(-1,-1));
	}

	public void test29() {
		for (int a1=-5; a1 <= 5; ++a1) {
			for (int a2 = -5; a2 <= 5; ++a2) {
				for (int b1 = -5; b1 <= 5; ++b1) {
					for (int b2 = -5; b2 <= 5; ++b2) {
						if (a1 == a2 && b1 == b2) continue;
						HexCoordinate h1 = new HexCoordinate(a1,b1);
						HexCoordinate h2 = new HexCoordinate(a2,b2);
						int c1 = h1.hashCode();
						int c2 = h2.hashCode();
						if (c1 == c2) {
							assertFalse(h1 + " code of " + c1 + " should not collide with " + h2 + " code of " + c2, true);
						}						
					}
				}
			}
		}
	}
	
	
	/// test3X: toPoint tests.
	
	public void test30() {
		assertEquals(new Point(0, 0), new HexCoordinate(0, 0).toPoint(10));
	}
	
	public void test31() {
		assertEquals(new Point(10, 0), new HexCoordinate(1, 0).toPoint(10));
	}
	
	public void test32() {
		assertEquals(new Point(-10, 0), new HexCoordinate(-1, 0).toPoint(10));
	}
	
	public void test33() {
		assertEquals(new Point(-5, 9), new HexCoordinate(0, 1).toPoint(10));
	}
	
	public void test34() {
		assertEquals(new Point(-15, 9), new HexCoordinate(-1, 1).toPoint(10));
	}
	
	public void test35() {
		assertEquals(new Point(-10, 17), new HexCoordinate(0, 2).toPoint(10));
		assertEquals(new Point(0, 17), new HexCoordinate(1, 2).toPoint(10));
		assertEquals(new Point(10, 17), new HexCoordinate(2, 2).toPoint(10));
	}
	
	public void test36() {
		assertEquals(new Point(5, -9), new HexCoordinate(0, -1).toPoint(10));
		assertEquals(new Point(15, -9), new HexCoordinate(1, -1).toPoint(10));
		assertEquals(new Point(-5, -9), new HexCoordinate(-1, -1).toPoint(10));
	}
	
	public void test37() {
		assertEquals(new Point(50, 87), new HexCoordinate(2, 2).toPoint(50));
	}
	
	public void test38() {
		assertEquals(new Point(-1250, 433), new HexCoordinate(-10, 5).toPoint(100));
	}
	
	public void test39() {
		assertEquals(new Point(-12, 4), new HexCoordinate(-10, 5).toPoint(1));
	}

	
	/// test4X: testing distance
	
	public void test40() {
		assertEquals(0,h(1,2).distance(h(1,2)));
	}
	
	public void test41() {
		assertEquals(1,h(2,1).distance(h(1,0)));
	}
	
	public void test42() {
		assertEquals(1,h(2,1).distance(h(3,1)));
	}
	
	public void test43() {
		assertEquals(2,h(2,1).distance(h(3,0)));
	}
	
	public void test44() {
		assertEquals(2,h(2,1).distance(h(0,0)));
	}
	
	public void test45() {
		assertEquals(3,h(2,1).distance(h(5,3)));
	}
	
	public void test46() {
		assertEquals(4,h(2,1).distance(h(3,5)));
	}
	
	public void test47() {
		assertEquals(5,h(2,1).distance(h(0,4)));
	}
	
	public void test48() {
		assertEquals(6,h(2,1).distance(h(-4,0)));
	}
	
	public void test49() {
		assertEquals(7,h(2,1).distance(h(-1,-6)));
	}
	
	
	/// text5X: exhaustive distance tests + bigger tests
	
	public void test50() {
		assertEquals(0, new HexCoordinate(3, 3).distance(new HexCoordinate(3, 3)));
	}
	
	public void test51() {
		assertEquals(1, new HexCoordinate(3, 3).distance(new HexCoordinate(3, 2)));
		assertEquals(1, new HexCoordinate(3, 3).distance(new HexCoordinate(3, 4)));
		assertEquals(1, new HexCoordinate(3, 3).distance(new HexCoordinate(2, 3)));
		assertEquals(1, new HexCoordinate(3, 3).distance(new HexCoordinate(4, 3)));
		assertEquals(1, new HexCoordinate(3, 3).distance(new HexCoordinate(2, 2)));
		assertEquals(1, new HexCoordinate(3, 3).distance(new HexCoordinate(4, 4)));
	}
	
	public void test52() {
		assertEquals(2, new HexCoordinate(3, 3).distance(new HexCoordinate(1, 1)));
		assertEquals(2, new HexCoordinate(3, 3).distance(new HexCoordinate(2, 1)));
		assertEquals(2, new HexCoordinate(3, 3).distance(new HexCoordinate(3, 1)));
		assertEquals(2, new HexCoordinate(3, 3).distance(new HexCoordinate(4, 2)));
		assertEquals(2, new HexCoordinate(3, 3).distance(new HexCoordinate(5, 3)));
		assertEquals(2, new HexCoordinate(3, 3).distance(new HexCoordinate(5, 4)));
		assertEquals(2, new HexCoordinate(3, 3).distance(new HexCoordinate(5, 5)));
		assertEquals(2, new HexCoordinate(3, 3).distance(new HexCoordinate(4, 5)));
		assertEquals(2, new HexCoordinate(3, 3).distance(new HexCoordinate(3, 5)));
		assertEquals(2, new HexCoordinate(3, 3).distance(new HexCoordinate(2, 4)));
		assertEquals(2, new HexCoordinate(3, 3).distance(new HexCoordinate(1, 3)));
		assertEquals(2, new HexCoordinate(3, 3).distance(new HexCoordinate(1, 2)));
	}
	
	public void test53() {
		assertEquals(3,h(3,3).distance(h(0,0)));
		assertEquals(3,h(3,3).distance(h(1,0)));
		assertEquals(3,h(3,3).distance(h(2,0)));
		assertEquals(3,h(3,3).distance(h(3,0)));
		assertEquals(3,h(3,3).distance(h(4,1)));
		assertEquals(3,h(3,3).distance(h(5,2)));
		assertEquals(3,h(3,3).distance(h(6,3)));
		assertEquals(3,h(3,3).distance(h(6,4)));
		assertEquals(3,h(3,3).distance(h(6,5)));
		assertEquals(3,h(3,3).distance(h(6,6)));
		assertEquals(3,h(3,3).distance(h(5,6)));
		assertEquals(3,h(3,3).distance(h(4,6)));
		assertEquals(3,h(3,3).distance(h(3,6)));
		assertEquals(3,h(3,3).distance(h(2,5)));
		assertEquals(3,h(3,3).distance(h(1,4)));
		assertEquals(3,h(3,3).distance(h(0,3)));
		assertEquals(3,h(3,3).distance(h(0,2)));
		assertEquals(3,h(3,3).distance(h(0,1)));
	}
	
	public void test54() {
		assertEquals(10, new HexCoordinate(3, 3).distance(new HexCoordinate(10, 0)));
	}
	
	public void test55() {
		assertEquals(13, new HexCoordinate(3, 3).distance(new HexCoordinate(-10, 0)));
	}
	
	public void test56() {
		assertEquals(20, new HexCoordinate(3, 3).distance(new HexCoordinate(-10, 10)));
	}
	
	public void test57() {
		assertEquals(10, new HexCoordinate(3, 3).distance(new HexCoordinate(0, 10)));
	}
	
	public void test58() {
		assertEquals(7, new HexCoordinate(3, 3).distance(new HexCoordinate(10, 10)));
	}
	
	public void test59() {
		assertEquals(28, new HexCoordinate(-10, 4).distance(new HexCoordinate(10, -4)));
	}

	
	/// test 6X: test polygon
	
	public void test60() {
		Polygon p1 = h(0,0).toPolygon(10);
		assertEquals(6,p1.npoints);
	}
	
	public void test61() {
		Polygon p1 = h(0,0).toPolygon(10);
		assertEquals(0,p1.xpoints[0]);
	}
	
	public void test62() {
		Polygon p1 = h(0,0).toPolygon(10);
		assertEquals(-6,p1.ypoints[0]);
	}
	
	public void test63() {
		Polygon p1 = h(0,0).toPolygon(10);
		assertEquals(5,p1.xpoints[1]);
		assertEquals(-3,p1.ypoints[1]);
	}
	
	public void test64() {
		Polygon p1 = h(0,0).toPolygon(10);
		assertEquals(5,p1.xpoints[2]);
		assertEquals(3,p1.ypoints[2]);
		assertEquals(0,p1.xpoints[3]);
		assertEquals(6,p1.ypoints[3]);
	}
	
	public void test65() {
		Polygon p1 = new HexCoordinate(0, 0).toPolygon(100);
		assertEquals(0,p1.xpoints[0]);
		assertEquals(-58,p1.ypoints[0]);
		assertEquals(50,p1.xpoints[1]);
		assertEquals(-29,p1.ypoints[1]);
		assertEquals(50,p1.xpoints[2]);
		assertEquals(29,p1.ypoints[2]);
		assertEquals(0,p1.xpoints[3]);
		assertEquals(58,p1.ypoints[3]);
		assertEquals(-50,p1.xpoints[4]);
		assertEquals(29,p1.ypoints[4]);
		assertEquals(-50,p1.xpoints[5]);
		assertEquals(-29,p1.ypoints[5]);
	}
	
	public void test66() {
		Polygon p1 = new HexCoordinate(0, 0).toPolygon(100);
		Polygon p2 = new HexCoordinate(1, 1).toPolygon(50);
		Polygon p3 = new HexCoordinate(2, 2).toPolygon(50);
		Polygon p4 = new HexCoordinate(-10, 5).toPolygon(1);

		assertEquals(6, p1.npoints);
		assertEquals(6, p1.npoints);
		assertEquals(6, p1.npoints);
		assertEquals(6, p1.npoints);

		int[] expectedPoints1 = { 0, -58, 50, -29, 50, 29, 0, 58, -50, 29, -50, -29 };
		int[] expectedPoints2 = { 25, 14, 50, 29, 50, 58, 25, 72, 0, 58, 0, 29 };
		int[] expectedPoints3 = { 50, 58, 75, 72, 75, 101, 50, 115, 25, 101, 25, 72 };
		int[] expectedPoints4 = { -12, 4, -12, 4, -12, 5, -12, 5, -13, 5, -13, 4 };

		for (int i = 0; i < 6; ++i) {
			assertEquals(expectedPoints1[i * 2], p1.xpoints[i]);
			assertEquals(expectedPoints1[i * 2 + 1], p1.ypoints[i]);

			assertEquals(expectedPoints2[i * 2], p2.xpoints[i]);
			assertEquals(expectedPoints2[i * 2 + 1], p2.ypoints[i]);

			assertEquals(expectedPoints3[i * 2], p3.xpoints[i]);
			assertEquals(expectedPoints3[i * 2 + 1], p3.ypoints[i]);

			assertEquals(expectedPoints4[i * 2], p4.xpoints[i]);
			assertEquals(expectedPoints4[i * 2 + 1], p4.ypoints[i]);
		}
	}

	
	/// test7X: test fromPoint
	// If these fail, perhaps it means you didn't correctly define
	// HEIGHT_RATIO
	
	public void test70() {
		assertEquals(new HexCoordinate(-1, 0), HexCoordinate.fromPoint(new Point(-2, 0), 3));
	}
	
	public void test71() {
		assertEquals(new HexCoordinate(0, 0), HexCoordinate.fromPoint(new Point(-1, 0), 3));
	}
	
	public void test72() {
		assertEquals(new HexCoordinate(0, 0), HexCoordinate.fromPoint(new Point(0, 0), 3));
	}
	
	public void test73() {
		assertEquals(new HexCoordinate(0, 0), HexCoordinate.fromPoint(new Point(1, 0), 3));
	}
	
	public void test74() {
		assertEquals(new HexCoordinate(1, 0), HexCoordinate.fromPoint(new Point(2, 0), 3));
	}
	
	public void test75() {
		assertEquals(new HexCoordinate(1, 0), HexCoordinate.fromPoint(new Point(3, 0), 3));
		assertEquals(new HexCoordinate(1, 0), HexCoordinate.fromPoint(new Point(4, 0), 3));
	}
	
	public void test76() {
		assertEquals(new HexCoordinate(-1, 0), HexCoordinate.fromPoint(new Point(-2, 1), 3));
		assertEquals(new HexCoordinate(0, 0), HexCoordinate.fromPoint(new Point(-1, 1), 3));
		assertEquals(new HexCoordinate(0, 0), HexCoordinate.fromPoint(new Point(0, 1), 3));
	}
	
	public void test77() {
		assertEquals(new HexCoordinate(0, 0), HexCoordinate.fromPoint(new Point(1, 1), 3));
		assertEquals(new HexCoordinate(1, 0), HexCoordinate.fromPoint(new Point(2, 1), 3));
		assertEquals(new HexCoordinate(1, 0), HexCoordinate.fromPoint(new Point(3, 1), 3));
		assertEquals(new HexCoordinate(1, 0), HexCoordinate.fromPoint(new Point(4, 1), 3));
	}
	
	public void test78() {
		assertEquals(new HexCoordinate(0, 1), HexCoordinate.fromPoint(new Point(-2, 2), 3));
		assertEquals(new HexCoordinate(0, 1), HexCoordinate.fromPoint(new Point(-1, 2), 3));
		assertEquals(new HexCoordinate(1, 1), HexCoordinate.fromPoint(new Point(1, 2), 3));
		assertEquals(new HexCoordinate(1, 1), HexCoordinate.fromPoint(new Point(2, 2), 3));
		assertEquals(new HexCoordinate(2, 1), HexCoordinate.fromPoint(new Point(4, 2), 3));
	}
	
	public void test79() {
		assertEquals(new HexCoordinate(0, 0), HexCoordinate.fromPoint(new Point(0, 9), 20));
	}
}
