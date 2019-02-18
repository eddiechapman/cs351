import java.util.function.Supplier;

import junit.framework.TestCase;
import edu.uwm.cs351.HexCoordinate;
import edu.uwm.cs351.HexTile;
import edu.uwm.cs351.Sequence;
import edu.uwm.cs351.Terrain;



public class TestSequence extends TestCase {
	
	protected void assertException(Class<? extends Throwable> c, Runnable r) {
		try {
			r.run();
			assertFalse("Exception should have been thrown",true);
		} catch (RuntimeException ex) {
			assertTrue("should throw exception of " + c + ", not of " + ex.getClass(), c.isInstance(ex));
		}
	}

	private Sequence<HexTile> s;
	HexTile b1 = new HexTile(Terrain.MOUNTAIN, new HexCoordinate(0,0));
	HexTile b2 = new HexTile(Terrain.WATER, new HexCoordinate(1,0));
	HexTile b2a = new HexTile(Terrain.WATER, new HexCoordinate(1,0));
	HexTile b3 = new HexTile(Terrain.FOREST, new HexCoordinate(1,1));
	HexTile b4 = new HexTile(Terrain.DESERT, new HexCoordinate(0,-1));
	HexTile b5 = new HexTile(Terrain.CITY, new HexCoordinate(0,1));
	
	HexTile b[] = { null, b1, b2, b3, b4, b5 };
	
	// Using the above array
	// convert a HexTile result to an integer:
	// 0 = null, 1 = b1, 2 = b2 etc.
	// if the expression causes an error, the index is -1.
	// If the ball is not in the array, the result "NONE OF THE ABOVE" is -2.
	int ix(Supplier<HexTile> p) {
		try {
			HexTile ball = p.get();
			if (ball == null) return 0;
			for (int i=0; i < b.length; ++i) {
				if (ball == b[i]) return i;
			}
			return -2;
		} catch (RuntimeException ex) {
			return -1;
		}
	}
	
	@Override
	public void setUp() {
		s = new Sequence<HexTile>();
		try {
			assert 3/b1.getLocation().a() == 42 : "OK";
			System.err.println("Assertions must be enabled to use this test suite.");
			System.err.println("In Eclipse: add -ea in the VM Arguments box under Run>Run Configurations>Arguments");
			assertFalse("Assertions must be -ea enabled in the Run Configuration>Arguments>VM Arguments",true);
		} catch (ArithmeticException ex) {
			return;
		}
	}

	
	/// Numbered tests
	
	public void test00() {
		assertEquals(0,s.size());
	}
	
	public void test01() {
		assertFalse(s.isCurrent());
	}
		
	public void test03() {
		assertException(IllegalStateException.class,() -> {s.getCurrent();});		
	}
	
	public void test04() {
		assertException(IllegalStateException.class, () -> {s.advance();});
	}
	
	public void test05() {
		assertException(IllegalStateException.class, () -> {s.removeCurrent();});
	}
	
	public void test06() {
		s.start();
		assertFalse(s.isCurrent());
	}
	
	public void test10() {
		s.addBefore(null);
		assertEquals(1,s.size());
		assertTrue(s.isCurrent());
		assertNull(s.getCurrent());
	}
	
	public void test11() {
		s.addBefore(b2);
		assertEquals(1,s.size());
		assertTrue(s.isCurrent());
		assertSame(b2,s.getCurrent());
	}
	
	public void test12() {
		s.addAfter(b3);
		assertEquals(1,s.size());
		assertTrue(s.isCurrent());
		assertSame(b3,s.getCurrent());
	}
	
	public void test13() {
		s.addAfter(b1);
		assertEquals(1,s.size());
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
		s.start();
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
		s.advance();
		assertEquals(1,s.size());
		assertFalse(s.isCurrent());
		s.start();
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
		assertEquals(1,s.size());
	}
	
	public void test14() {
		s.addBefore(b1);
		assertEquals(1,s.size());
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
		s.start();
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
		assertSame(b1,s.getCurrent());
		s.advance();
		assertEquals(1,s.size());
		assertFalse(s.isCurrent());
		s.start();
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
		assertEquals(1,s.size());
	}
	
	public void test15() {
		s.addBefore(b4);
		s.removeCurrent();
		assertFalse(s.isCurrent());
		assertEquals(0,s.size());
	}
	
	public void test16() {
		s.addAfter(b5);
		s.start();
		s.removeCurrent();
		assertFalse(s.isCurrent());
		assertEquals(0,s.size());
	}

	public void test17() {
		s.addBefore(b1);
		s.advance();
		assertFalse(s.isCurrent());
		assertEquals(1,s.size());
		assertException(IllegalStateException.class,() -> { s.removeCurrent(); });
	}
	
	public void test18() {
		s.addAfter(b2);
		s.advance();
		assertException(IllegalStateException.class, () -> { s.advance(); });
	}
	
	public void test19() {
		s.addBefore(b3);
		s.advance();
		assertException(IllegalStateException.class,() -> { s.getCurrent(); });
	}
	
	public void test20() {
		s.addAfter(b1);
		s.addBefore(b2);
		assertEquals(2,s.size());
		assertSame(b2,s.getCurrent());
	}
	
	public void test21() {
		s.addBefore(b3);
		s.addBefore(b4);
		s.advance();
		assertEquals(2,s.size());
		assertSame(b3,s.getCurrent());
	}
	
	public void test22() {
		s.addBefore(b1);
		s.addAfter(b2);
		assertEquals(2,s.size());
		assertSame(b2,s.getCurrent());
	}
	
	public void test23() {
		s.addAfter(b1);
		s.addAfter(b2);
		s.advance();
		assertEquals(2,s.size());
		assertFalse(s.isCurrent());
	}
	
	public void test24() {
		s.addAfter(b1);
		s.addAfter(b2);
		assertSame(b2,s.getCurrent());
	}
	
	public void test25() {
		s.addBefore(b3);
		s.addAfter(b4);
		s.start();
		assertSame(b3,s.getCurrent());
		s.advance();
		assertSame(b4,s.getCurrent());
	}
	
	public void test26() {
		s.addAfter(b5);
		s.addBefore(b1);
		s.removeCurrent();
		assertTrue(s.isCurrent());
		assertSame(b5,s.getCurrent());
	}
	
	public void test27() {
		s.addBefore(b2);
		s.addAfter(b3);
		s.removeCurrent();
		assertFalse(s.isCurrent());
	}
	
	public void test28() {
		s.addBefore(b4);
		s.addBefore(b5);
		s.removeCurrent();
		assertSame(b4,s.getCurrent());
		s.advance();
		assertFalse(s.isCurrent());
	}
	
	public void test29() {
		s.addAfter(b1);
		s.addBefore(b2);
		s.removeCurrent();
		s.removeCurrent();
		assertFalse(s.isCurrent());
		assertEquals(0,s.size());
	}
	
	public void test30() {
		s.addBefore(b1);
		s.addBefore(null);
		s.addBefore(b2);
		assertSame(b2,s.getCurrent());
		s.advance();
		assertTrue(s.isCurrent());
		assertNull(s.getCurrent());
	}
	
	public void test31() {
		s.addBefore(b3);
		s.addBefore(b4);
		s.addAfter(b5);
		s.advance();
		assertSame(b3,s.getCurrent());
		assertEquals(3,s.size());
	}
	
	public void test32() {
		s.addBefore(b1);
		s.addAfter(b2);
		s.advance();
		s.addAfter(b3);
		assertSame(b3,s.getCurrent());
	}
	
	public void test33() {
		s.addAfter(b4);
		s.addAfter(b5);
		s.start();
		s.addAfter(null);
		assertNull(s.getCurrent());
		assertEquals(3,s.size());
		s.advance();
		assertSame(b5,s.getCurrent());
	}
	
	public void test34() {
		s.addAfter(b1);
		s.addAfter(b2);
		s.addBefore(b3);
		s.start();
		s.addAfter(b4);
		assertSame(b4,s.getCurrent());
		s.advance();
		assertSame(b3,s.getCurrent());
		s.advance();
		assertSame(b2,s.getCurrent());
		s.advance();
		assertException(IllegalStateException.class,() -> { s.getCurrent(); });
	}
	
	public void test35() {
		s.addAfter(null);
		s.addBefore(b4);
		s.addAfter(b5);
		s.advance();
		assertNull(s.getCurrent());
		s.removeCurrent();
	}
	
	public void test36() {
		s.addAfter(b4);
		s.addAfter(b5);
		s.start();
		s.addAfter(b1);
		s.start();
		s.removeCurrent();
		s.advance();
		assertSame(b5,s.getCurrent());
	}
	
	public void test37() {
		s.addAfter(b2);
		s.addBefore(b3);
		s.addBefore(b4);
		s.removeCurrent();
		assertTrue(s.isCurrent());
		s.advance();
		s.removeCurrent();
		assertEquals(1,s.size());
	}
	
	public void test38() {
		s.addAfter(b5);
		s.addBefore(b1);
		s.removeCurrent();
		s.addAfter(b2);
		s.advance();
		assertFalse(s.isCurrent());
	}
	
	public void test39() {
		s.addAfter(b1);
		s.addAfter(b2);
		s.addAfter(b3);
		s.addAfter(b4);
		s.addAfter(b5);
		assertSame(b5,s.getCurrent());
		s.addAfter(b1);
		s.addAfter(b2);
		s.addAfter(b3);
		s.addAfter(b4);
		s.addAfter(b5);
		s.addAfter(b1);
		s.addAfter(b2);
		assertEquals(12,s.size());
		s.removeCurrent();
		assertFalse(s.isCurrent());
		s.start();
		s.removeCurrent();
		assertEquals(10,s.size());
		s.start();
		assertSame(b2,s.getCurrent()); s.advance();
		assertSame(b3,s.getCurrent()); s.advance();
		assertSame(b4,s.getCurrent()); s.advance();
		assertSame(b5,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertSame(b3,s.getCurrent()); s.advance();
		assertSame(b4,s.getCurrent()); s.advance();
		assertSame(b5,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertFalse(s.isCurrent());
	}

	public void test40() {
		Sequence<HexTile> se = new Sequence<HexTile>();
		s.addAll(se);
		assertEquals(0,s.size());
	}

	public void test41() {
		Sequence<HexTile> se = new Sequence<HexTile>();
		s.addBefore(b1);
		s.addAll(se);
		assertEquals(b1,s.getCurrent());
	}

	public void test42() {
		Sequence<HexTile> se = new Sequence<HexTile>();
		s.addAfter(b2);
		s.advance();
		s.addAll(se);
		assertFalse(s.isCurrent());
	}

	public void test43() {
		Sequence<HexTile> se = new Sequence<HexTile>();
		s.addBefore(b3);
		s.addAfter(b4);
		s.addAll(se);
		assertSame(b4,s.getCurrent());
	}

	public void test44() {
		Sequence<HexTile> se = new Sequence<HexTile>();
		se.addBefore(b1);
		s.addAll(se);
		assertFalse(s.isCurrent());
		assertTrue(se.isCurrent());
		assertEquals(1,s.size());
		assertEquals(1,se.size());
		s.start();
		assertSame(b1,s.getCurrent());
		assertSame(b1,se.getCurrent());
	}
	
	public void test45() {
		Sequence<HexTile> se = new Sequence<HexTile>();
		se.addAfter(b1);
		s.addAfter(b2);
		s.addAll(se);
		assertTrue(s.isCurrent());
		assertEquals(2,s.size());
		assertEquals(1,se.size());
		assertSame(b2,s.getCurrent());
		s.advance();
		assertSame(b1,s.getCurrent());
	}
	
	public void test46() {
		Sequence<HexTile> se = new Sequence<HexTile>();
		se.addAfter(b1);
		s.addAfter(b2);
		s.advance();
		s.addAll(se);
		assertFalse(s.isCurrent());
		assertEquals(2,s.size());
		assertEquals(1,se.size());
		assertTrue(se.isCurrent());
		assertSame(b1,se.getCurrent());
		s.start();
		assertSame(b2,s.getCurrent());
		s.advance();
		assertSame(b1,s.getCurrent());
	}
	
	public void test47() {
		Sequence<HexTile> se = new Sequence<HexTile>();
		se.addAfter(b1);
		se.advance();
		s.addAfter(b3);
		s.addBefore(b2);
		s.addAll(se);
		assertTrue(s.isCurrent());
		assertSame(b2,s.getCurrent());
		assertEquals(3,s.size());
		assertEquals(1,se.size());
		assertFalse(se.isCurrent());
		s.advance();
		assertSame(b3,s.getCurrent());
		s.advance();
		assertSame(b1,s.getCurrent());
		s.advance();
		assertFalse(s.isCurrent());	
	}
	
	public void test48() {
		Sequence<HexTile> se = new Sequence<HexTile>();
		se.addAfter(b1);
		s.addAfter(b2);
		s.addAfter(b3);
		s.addAll(se);
		assertTrue(s.isCurrent());
		assertEquals(3,s.size());
		assertEquals(1,se.size());
		assertSame(b3,s.getCurrent());
		s.advance();
		assertSame(b1,s.getCurrent());
		s.advance();
		assertFalse(s.isCurrent());
		s.start();
		assertSame(b2,s.getCurrent());
	}
	
	public void test49() {
		Sequence<HexTile> se = new Sequence<HexTile>();
		se.addAfter(b1);
		s.addAfter(b2);
		s.addAfter(b3);
		s.advance();
		assertFalse(s.isCurrent());
		s.addAll(se);
		assertFalse(s.isCurrent());
		assertEquals(3,s.size());
		assertEquals(1,se.size());
		assertSame(b1,se.getCurrent());
		s.start();
		assertSame(b2,s.getCurrent());
		s.advance();
		assertSame(b3,s.getCurrent());
		s.advance();
		assertSame(b1,s.getCurrent());
	}

	public void test50() {
		Sequence<HexTile> se = new Sequence<HexTile>();
		se.addAfter(b2);
		se.addBefore(b1);	
		s.addAfter(b4);
		s.addBefore(b3);
		s.addAll(se);
		assertTrue(s.isCurrent());
		assertEquals(4,s.size());
		assertEquals(2,se.size());
		assertSame(b3,s.getCurrent()); s.advance();
		assertSame(b4,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertFalse(s.isCurrent());	
	}

	public void test51() {
		Sequence<HexTile> se = new Sequence<HexTile>();
		se.addAfter(b2);
		se.addBefore(b1);
		se.advance();
		s.addAfter(b3);
		s.addAfter(b4);
		s.addAll(se);
		assertTrue(s.isCurrent());
		assertEquals(4,s.size());
		assertEquals(2,se.size());
		assertSame(b2,se.getCurrent()); se.advance();
		assertFalse(se.isCurrent());
		// check s
		assertSame(b4,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertFalse(s.isCurrent());	
		s.start();
		assertSame(b3,s.getCurrent());
	}

	public void test52() {
		Sequence<HexTile> se = new Sequence<HexTile>();
		se.addBefore(b2);
		se.addBefore(b1);
		se.advance();
		se.advance();
		s.addAfter(b3);
		s.addAfter(b4);
		s.advance();
		assertFalse(s.isCurrent());
		assertFalse(se.isCurrent());
		s.addAll(se);
		assertFalse(s.isCurrent());
		assertFalse(se.isCurrent());
		assertEquals(4,s.size());
		assertEquals(2,se.size());
		s.start();
		assertSame(b3,s.getCurrent()); s.advance();
		assertSame(b4,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertFalse(s.isCurrent());	
	}

	public void test53() {
		Sequence<HexTile> se = new Sequence<HexTile>();
		se.addAfter(b3);
		se.addAfter(b4);
		se.addAfter(b5);
		se.addAfter(b3);
		se.addAfter(b4);
		se.addAfter(b5);
		se.addAfter(b3);
		se.addAfter(b4);
		se.addAfter(b5);
		se.addAfter(b3);
		se.addAfter(b4);
		se.addAfter(b5);
		se.addAfter(b3);
		se.addAfter(b4);
		se.addAfter(b5);
		se.addAfter(b3);
		se.addAfter(b4);
		se.addAfter(b5);
		se.addAfter(b3);
		se.addAfter(b4);
		se.addAfter(b5);
		se.addAfter(b3);
		se.addAfter(b4);
		se.addAfter(b5);
		// se has 24 elements
		s.addAfter(b1);
		s.addAfter(b2);
		s.addAll(se);
		assertEquals(26,s.size());
		assertSame(b2,s.getCurrent()); s.advance();
		assertSame(b3,s.getCurrent()); s.advance();
		s.addAll(se);
		assertEquals(50,s.size());
		s.start();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertSame(b3,s.getCurrent()); s.advance();
		assertSame(b4,s.getCurrent()); s.advance();
		assertSame(b5,s.getCurrent()); s.advance();
		assertSame(b3,s.getCurrent()); s.advance();
		assertSame(b4,s.getCurrent());
	}
	
	public void test55() {
		s.addBefore(b1);
		s.addAfter(b2);
		s.addBefore(b3);
		s.addAfter(b4);
		s.start();
		s.addAfter(b5);
		s.start();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b5,s.getCurrent()); s.advance();
		assertSame(b3,s.getCurrent()); s.advance();
		assertSame(b4,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
	}
	
	public void test60() {
		s.addAll(s);
		assertFalse(s.isCurrent());
		assertEquals(0,s.size());
	}
	
	
	public void test61() {
		s.addAfter(b1);
		s.addAll(s);
		assertEquals(2,s.size());
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
		s.advance();
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
		s.advance();
		assertFalse(s.isCurrent());
	}
	
	public void test62() {
		s.addAfter(b1);
		s.advance();
		s.addAll(s);
		assertEquals(2,s.size());
		assertFalse(s.isCurrent());
	}
	
	public void test63() {
		s.addAfter(b1);
		s.removeCurrent();
		assertEquals(0,s.size());
		assertFalse(s.isCurrent());
	}
	
	public void test64() {
		s.addAfter(b2);
		s.addBefore(b1);
		s.addAll(s);
		assertEquals(4,s.size());
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertFalse(s.isCurrent());		
	}
	
	public void test65() {
		s.addAfter(b1);
		s.addAfter(b2);
		s.addAll(s);
		assertEquals(4,s.size());
		assertTrue(s.isCurrent());
		assertSame(b2,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertFalse(s.isCurrent());		
	}

	public void test66() {
		s.addAfter(b1);
		s.addAfter(b2);
		s.advance();
		assertFalse(s.isCurrent());
		s.addAll(s);
		assertFalse(s.isCurrent());
		assertEquals(4,s.size());
		s.start();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertFalse(s.isCurrent());		
	}

	public void test67() {
		s.addAfter(b1);
		s.addAfter(b2);
		s.addAll(s);
		s.removeCurrent();
		s.addBefore(b3);
		assertSame(b3,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertFalse(s.isCurrent());
		s.start();
		assertSame(b1,s.getCurrent()); s.advance();
		s.advance();
		s.addAll(s);
		assertEquals(8,s.size());
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b3,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertFalse(s.isCurrent());		
	}
	
	public void test68() {
		Sequence<HexTile> se = new Sequence<HexTile>();
		se.addAfter(b1);
		se.addAfter(b2);	
		s.addAfter(b3);
		s.addAfter(b4);
		s.addAll(se);
		s.advance();
		s.addAfter(b5);
		s.advance();
		assertTrue(s.isCurrent());
		assertSame(b2,s.getCurrent());
		assertEquals(5,s.size());
		assertEquals(2,se.size());
		assertSame(b2,se.getCurrent());
		se.advance();
		assertFalse(se.isCurrent());
		se.start();
		assertSame(b1,se.getCurrent());
	}
	
	public void test70() {
		Sequence<HexTile> c = s.clone();
		assertFalse(c.isCurrent());
		assertEquals(0, c.size());
	}
	
	public void test71() {
		s.addAfter(b1);
		Sequence<HexTile> c = s.clone();
		
		assertTrue(s.isCurrent());
		assertTrue(c.isCurrent());
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b1,c.getCurrent()); c.advance();
		assertFalse(s.isCurrent());
		assertFalse(c.isCurrent());
	}
	
	public void test72() {
		s.addAfter(b1);
		s.advance();
		Sequence<HexTile> c = s.clone();
		
		assertFalse(s.isCurrent());
		assertFalse(c.isCurrent());
	}

	public void test73() {
		s.addAfter(b1);
		s.addAfter(b2);
		Sequence<HexTile> c = s.clone();
		
		assertTrue(s.isCurrent());
		assertTrue(c.isCurrent());
		assertSame(b2,s.getCurrent());
		assertSame(b2,c.getCurrent());
		s.advance();
		c.advance();
		assertFalse(s.isCurrent());
		assertFalse(c.isCurrent());
	}
	
	public void test74() {
		s.addBefore(b2);
		s.addBefore(b1);
		s.advance();
		s.addAfter(b3);
		Sequence<HexTile> c = s.clone();
		assertSame(b3,s.getCurrent());
		assertSame(b3,c.getCurrent());
		s.advance();
		c.advance();
		assertFalse(s.isCurrent());
		assertFalse(c.isCurrent());
		s.start();
		c.start();
		assertTrue(s.isCurrent());
		assertTrue(c.isCurrent());
		assertSame(b1,s.getCurrent());
		assertSame(b1,c.getCurrent());
		s.advance();
		c.advance();
		assertTrue(s.isCurrent());
		assertTrue(c.isCurrent());
		assertSame(b2,s.getCurrent());
		assertSame(b2,c.getCurrent());
	}
	
	public void test75() {
		s.addBefore(b1);
		Sequence<HexTile> c = s.clone();
		s.addBefore(b2);
		assertSame(b2,s.getCurrent());
		assertSame(b1,c.getCurrent());
		c = s.clone();
		s.addBefore(b3);
		assertSame(b3,s.getCurrent());
		assertSame(b2,c.getCurrent());
		assertEquals(2,c.size());
	}
	
	public void test76() {
		s.addAfter(b1);
		s.addAfter(b3);
		s.addBefore(b2);
		s.removeCurrent();
		
		Sequence<HexTile> c = s.clone();
		
		assertEquals(2,c.size());
		
		assertSame(b3,s.getCurrent());
		assertSame(b3,c.getCurrent());
	}

	public void test77() {
		s.addAfter(b4);
		s.addBefore(b5);
		s.addAfter(b1);
		s.removeCurrent();
		
		Sequence<HexTile> c = s.clone();
		assertSame(b4,c.getCurrent());
	}
	
	public void test78() {
		s.addBefore(b2);
		s.addAfter(b3);
		
		Sequence<HexTile> c = s.clone();
		assertEquals(b3,c.getCurrent());
		c.advance();
	}
	
	public void test79() {
		s.addBefore(b4);
		s.addBefore(b5);
		
		Sequence<HexTile> c = s.clone();
		c.removeCurrent();
		
		assertEquals(b4,c.getCurrent());
		assertEquals(b5,s.getCurrent());
	}
	
	public void test88() {
		s.addAfter(b1);
		s.addAfter(b2);
		
		Sequence<HexTile> c = s.clone();
		s.addBefore(b3);
		c.addBefore(b4);
		
		assertSame(b3,s.getCurrent());
		assertSame(b4,c.getCurrent());
		s.advance();
		c.advance();
		assertSame(b2,s.getCurrent());
		assertSame(b2,c.getCurrent());
		s.advance();
		c.advance();
		assertFalse(s.isCurrent());
		assertFalse(c.isCurrent());
		
		s.start();
		c.start();
		assertSame(b1,s.getCurrent());
		assertSame(b1,c.getCurrent());
		s.advance();
		c.advance();
		assertSame(b3,s.getCurrent());
		assertSame(b4,c.getCurrent());
	}

	
	/// test9X: generic tests
	// If these tests how up with raw or unchecked cast warnings
	// you didn't declare things correctly
	
	public void test90() {
		Sequence<Integer> s = new Sequence<>();
		s.addAfter(42);
		assertEquals(42,s.getCurrent().intValue());
	}
	
	public void test91() {
		Sequence<String> s = new Sequence<>();
		s.addBefore("hello");
		assertEquals("hello",s.getCurrent());
	}
	
	public void test92() {
		Sequence<Object> s = new Sequence<>();
		s.addAfter("hello");
		Sequence<Object> s2 = new Sequence<>();
		s2.addBefore(42);
		s.addAll(s2);
		s.advance();
		assertEquals(new Integer(42),s.getCurrent());
	}
	
	public void test93() {
		Sequence<Boolean> s = new Sequence<>();
		s.addAfter(true);
		s.addAfter(null);
		Sequence<Boolean> s2 = s.clone();
		s.removeCurrent();
		assertNull(s2.getCurrent());
		assertFalse(s.isCurrent());
	}
	
	
	/// Named tests
	
	public void testEmpty() {
		assertEquals(0,s.size());
		assertFalse(s.isCurrent());
		s.start();
		assertFalse(s.isCurrent());
	}
	
	public void testEmptyNext() {
		s.start();
		try {
			s.getCurrent();
			assertFalse("s.getCurrent() should not return",true);
		} catch (RuntimeException ex) {
			assertTrue("wrong exception thrown: " + ex,ex instanceof IllegalStateException);
		}
	}
	
	public void testEmptyRemove() {
		s.start();
		try {
			s.removeCurrent();
			assertFalse("empty.removeCurrent() should not return",true);
		} catch (RuntimeException ex) {
			assertTrue("wrong exception thrown: " + ex,ex instanceof IllegalStateException);
		}
	}
	
	public void testEmptyAdvance() {
		try {
			s.advance();
			assertFalse("s.advance() should not return",true);
		} catch (RuntimeException ex) {
			assertTrue("wrong exception thrown: " + ex,ex instanceof IllegalStateException);
		}
	}
	
	public void testOneSeq() {
		s.addAfter(b1);
		assertEquals(1,s.size());
		assertTrue(s.isCurrent());
		assertSame(b[1],s.getCurrent());
		s.start();
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
		assertSame(b1,s.getCurrent());
		s.advance();
		assertEquals(1,s.size());
		assertFalse(s.isCurrent());
		s.start();
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
		assertEquals(1,s.size());
	}
	
	public void testOneSeqAgain() {
		s.addBefore(b1);
		assertEquals(1,s.size());
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
		s.start();
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
		assertSame(b1,s.getCurrent());
		s.advance();
		assertEquals(1,s.size());
		assertFalse(s.isCurrent());
		s.start();
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
		assertEquals(1,s.size());
	}
	
	public void testOneSeqRemove() {
		s.addAfter(b1);
		s.removeCurrent();
		// For "ix" give 1, 2, 3 etc for b1, b2, b3 etc
		// give 0 for null, -1 for error and -2 for "none of the above"
		assertEquals(-1,ix(()->s.getCurrent()));
		assertEquals(0,s.size());	
		s.addAfter(b2);
		s.start();
		assertSame(b2,s.getCurrent());
		assertEquals(1,s.size());
	}
	
	public void testOneSeqNextError() {
		s.addAfter(b2);
		s.start();
		s.advance();
		try {
			s.advance();
			assertFalse("it.next() should not return",true);
		} catch (RuntimeException ex) {
			assertTrue("wrong exception thrown: " + ex,ex instanceof IllegalStateException);
		}
		assertFalse(s.isCurrent());
		assertEquals(1,s.size());
	}


	public void testOneSeqRemoveError() {
		s.addAfter(b2);
		s.advance();
		try {
			s.removeCurrent();
			assertFalse("it.removeCurrent() should not return",true);
		} catch (RuntimeException ex) {
			assertTrue("wrong exception thrown: " + ex,ex instanceof IllegalStateException);
		}
		assertFalse(s.isCurrent());
		assertEquals(1,s.size());
	}

	public void testOneSeqCurrentError() {
		s.addAfter(b2);
		s.advance();
		try {
			s.getCurrent();
			assertFalse("s.getCurrent() should not return",true);
		} catch (RuntimeException ex) {
			assertTrue("wrong exception thrown: " + ex,ex instanceof IllegalStateException);
		}
		assertFalse(s.isCurrent());
		assertEquals(1,s.size());
	}
	
	public void testSeq21() {
		s.addAfter(b1);
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
		s.addBefore(b2);
		assertTrue(s.isCurrent());
		assertSame(b2,s.getCurrent());
		assertEquals(2,s.size());
		s.start();
		assertTrue(s.isCurrent());
		assertSame(b2,s.getCurrent());
		s.advance();
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
		s.advance();
		assertFalse(s.isCurrent());
		assertEquals(2,s.size());
		s.start();
		assertSame(b2,s.getCurrent());
		s.advance();
		s.start();
		assertSame(b2,s.getCurrent());
	}
	
	public void testSeq12() {
		s.addAfter(b1);
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
		s.addAfter(b2);
		assertTrue(s.isCurrent());
		assertSame(b2,s.getCurrent());
		assertEquals(2,s.size());
		s.start();
		assertSame(b1,s.getCurrent());
		s.advance();
		assertSame(b2,s.getCurrent());
		assertTrue(s.isCurrent());
	}
	
	public void testSeq2Remove1() {
		s.addAfter(b1);
		s.addAfter(b2);
		s.start();
		s.removeCurrent();
		assertTrue(s.isCurrent());
		assertEquals(1,s.size());
		assertEquals(b2,s.getCurrent());
		s.addAfter(b3);
		assertTrue(s.isCurrent());
		assertEquals(2,s.size());
		assertSame(b3,s.getCurrent());
		s.start();
		assertSame(b2,s.getCurrent());
	}

	public void testSeq2Remove2() {
		s.addAfter(b1);
		s.addAfter(b2);
		s.start();
		s.advance();
		s.removeCurrent();
		assertFalse(s.isCurrent());
		assertEquals(1,s.size());
		try {
			s.getCurrent();
			assertFalse("s.getCurrent() should not return",true);
		} catch (RuntimeException ex) {
			assertTrue("wrong exception thrown: " + ex,ex instanceof IllegalStateException);
		}
		s.addAfter(b3);
		assertTrue(s.isCurrent());
		assertEquals(2,s.size());
		assertSame(b3,s.getCurrent());
		s.advance();
		assertFalse(s.isCurrent());
		s.start();
		assertTrue(s.isCurrent());
		assertEquals(b1,s.getCurrent());
	}
	
	public void testSeq321() {
		s.addBefore(b1);
		s.addBefore(b2);
		s.addBefore(b3);
		assertEquals(3,s.size());
		s.start();
		assertTrue(s.isCurrent());
		assertSame(b3,s.getCurrent());
		assertTrue(s.isCurrent());
		assertSame(b3,s.getCurrent());
		s.advance();
		assertSame(b2,s.getCurrent());
		assertTrue(s.isCurrent());
		assertSame(b2,s.getCurrent());
		s.advance();
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
		s.advance();
		assertFalse(s.isCurrent());
		assertEquals(3,s.size());
		s.start();
		assertSame(b3,s.getCurrent());
		s.advance();
		s.start();
		assertSame(b3,s.getCurrent());
	}
	
	public void test132() {
		s.addAfter(b1);
		s.addAfter(b2);
		s.addBefore(b3);
		assertEquals(3,s.size());
		s.start();
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
		s.advance();
		assertTrue(s.isCurrent());
		assertSame(b3,s.getCurrent());
		s.advance();
		assertTrue(s.isCurrent());
		assertSame(b2,s.getCurrent());
		s.advance();
		assertFalse(s.isCurrent());
		assertEquals(3,s.size());
		s.start();
		assertSame(b1,s.getCurrent());
	}

	public void test123() {
		s.addAfter(b2);
		s.advance(); // at end, no current
		s.addBefore(b1);
		s.advance();
		s.addAfter(b3);
		assertEquals(3,s.size());
		s.start();
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
		s.advance();
		assertTrue(s.isCurrent());
		assertSame(b2,s.getCurrent());
		s.advance();
		assertTrue(s.isCurrent());
		assertSame(b3,s.getCurrent());
		s.advance();
		assertFalse(s.isCurrent());
		assertEquals(3,s.size());
	}
	
	public void testSeq3Remove1() {
		s.addBefore(b3);
		s.addBefore(b2);
		s.addBefore(b1);
		s.start();
		assertEquals(b1,s.getCurrent());
		s.removeCurrent();
		assertEquals(2,s.size());
		assertTrue(s.isCurrent());
		assertSame(b2,s.getCurrent());
		s.advance();
		assertSame(b3,s.getCurrent());
	}

	public void testSeq3Remove2() {
		s.addAfter(b3);
		s.addBefore(b2);
		s.addBefore(b1);
		s.start();
		s.advance();
		assertSame(b2,s.getCurrent());
		s.removeCurrent();
		assertEquals(2,s.size());
		assertTrue(s.isCurrent());
		assertSame(b3,s.getCurrent());
	}
	
	public void testSeq3Remove3() {
		s.addBefore(b3);
		s.addBefore(b2);
		s.addBefore(b1);
		s.start();
		s.advance();
		s.advance();
		assertSame(b3,s.getCurrent());
		s.removeCurrent();
		assertEquals(2,s.size());
		assertFalse(s.isCurrent());
		try {
			s.getCurrent();
			assertFalse("s.getCurrent() should not return",true);
		} catch (RuntimeException ex) {
			assertTrue("wrong exception thrown: " + ex, ex instanceof IllegalStateException);
		}
		try {
			s.advance();
			assertFalse("s.advance() should not return",true);
		} catch (RuntimeException ex) {
			assertTrue("wrong exception thrown: " + ex, ex instanceof IllegalStateException);
		}
		s.start();
		assertSame(b1,s.getCurrent());
	}

	public void testAddAfterLots() {
		s.addAfter(b1);
		s.addAfter(b2);
		s.addAfter(b3);
		s.addAfter(b4);
		s.addAfter(b5);
		assertSame(b5,s.getCurrent());
		s.addAfter(b1);
		s.addAfter(b2);
		s.addAfter(b3);
		s.addAfter(b4);
		s.addAfter(b5);
		s.addAfter(b1);
		s.addAfter(b2);
		assertEquals(12,s.size());
		s.removeCurrent();
		assertFalse(s.isCurrent());
		s.start();
		s.removeCurrent();
		assertSame(b2,s.getCurrent());
		assertEquals(10,s.size());
		s.start();
		assertSame(b2,s.getCurrent()); s.advance();
		assertSame(b3,s.getCurrent()); s.advance();
		assertSame(b4,s.getCurrent()); s.advance();
		assertSame(b5,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertSame(b3,s.getCurrent()); s.advance();
		assertSame(b4,s.getCurrent()); s.advance();
		assertSame(b5,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertFalse(s.isCurrent());
	}
	
	public void testNull() {
		s.addAfter(null);
		s.addAfter(b2);
		s.addAfter(null);
		
		assertEquals(3,s.size());
		assertTrue(s.isCurrent());
		assertSame(null,s.getCurrent());
		s.start();
		assertTrue(s.isCurrent());
		assertSame(null,s.getCurrent());
		s.removeCurrent();
		assertEquals(2,s.size());
		assertTrue(s.isCurrent());
		assertSame(b2,s.getCurrent());
		s.advance();
		assertTrue(s.isCurrent());
		assertSame(null,s.getCurrent());
		s.advance();
		assertFalse(s.isCurrent());
	}
	
	public void testAddAllEmpty() {
		Sequence<HexTile> se = new Sequence<HexTile>();
		s.addAll(se);
		assertFalse(s.isCurrent());
		assertEquals(0,s.size());
		s.addAfter(b1);
		s.addAll(se);
		assertTrue(s.isCurrent());
		assertEquals(1,s.size());
		assertEquals(0,se.size());
		assertSame(b1,s.getCurrent());
		s.advance();
		s.addAll(se);
		assertFalse(s.isCurrent());
		assertEquals(1,s.size());
		assertEquals(0,se.size());
		s.addAfter(b2);
		s.addAll(se);
		assertTrue(s.isCurrent());
		assertSame(b2,s.getCurrent());
		assertEquals(2,s.size());
		assertEquals(0,se.size());
		s.start();
		s.addAll(se);
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
		assertEquals(2,s.size());
		assertEquals(0,se.size());
	}
	
	public void testAddAll01() {
		Sequence<HexTile> se = new Sequence<HexTile>();
		se.addAfter(b1);
		s.addAll(se);
		assertFalse(s.isCurrent());
		assertTrue(se.isCurrent());
		assertEquals(1,s.size());
		assertEquals(1,se.size());
		s.start();
		assertSame(b1,s.getCurrent());
		assertSame(b1,se.getCurrent());
	}
	
	public void testAddAll11A() {
		Sequence<HexTile> se = new Sequence<HexTile>();
		se.addAfter(b1);
		s.addAfter(b2);
		s.addAll(se);
		assertTrue(s.isCurrent());
		assertEquals(2,s.size());
		assertEquals(1,se.size());
		assertSame(b2,s.getCurrent());
		s.advance();
		assertSame(b1,s.getCurrent());
	}
	
	public void testAddAll11B() {
		Sequence<HexTile> se = new Sequence<HexTile>();
		se.addAfter(b1);
		s.addAfter(b2);
		s.advance();
		s.addAll(se);
		assertFalse(s.isCurrent());
		assertEquals(2,s.size());
		assertEquals(1,se.size());
		assertTrue(se.isCurrent());
		assertSame(b1,se.getCurrent());
		s.start();
		assertSame(b2,s.getCurrent());
		s.advance();
		assertSame(b1,s.getCurrent());
	}
	
	public void testAddAll21A() {
		Sequence<HexTile> se = new Sequence<HexTile>();
		se.addAfter(b1);
		se.advance();
		s.addAfter(b3);
		s.addBefore(b2);
		s.addAll(se);
		assertTrue(s.isCurrent());
		assertSame(b2,s.getCurrent());
		assertEquals(3,s.size());
		assertEquals(1,se.size());
		assertFalse(se.isCurrent());
		s.advance();
		assertSame(b3,s.getCurrent());
		s.advance();
		assertSame(b1,s.getCurrent());
		s.advance();
		assertFalse(s.isCurrent());	
	}
	
	public void testAddAll21B() {
		Sequence<HexTile> se = new Sequence<HexTile>();
		se.addAfter(b1);
		s.addAfter(b2);
		s.addAfter(b3);
		s.addAll(se);
		assertTrue(s.isCurrent());
		assertEquals(3,s.size());
		assertEquals(1,se.size());
		assertSame(b3,s.getCurrent());
		s.advance();
		assertSame(b1,s.getCurrent());
		s.advance();
		assertFalse(s.isCurrent());
		s.start();
		assertSame(b2,s.getCurrent());
	}
	
	public void testAddAll21C() {
		Sequence<HexTile> se = new Sequence<HexTile>();
		se.addAfter(b1);
		s.addAfter(b2);
		s.addAfter(b3);
		s.advance();
		assertFalse(s.isCurrent());
		s.addAll(se);
		assertFalse(s.isCurrent());
		assertEquals(3,s.size());
		assertEquals(1,se.size());
		assertSame(b1,se.getCurrent());
		s.start();
		assertSame(b2,s.getCurrent());
		s.advance();
		assertSame(b3,s.getCurrent());
		s.advance();
		assertSame(b1,s.getCurrent());
	}

	public void testAddAll22A() {
		Sequence<HexTile> se = new Sequence<HexTile>();
		se.addAfter(b2);
		se.addBefore(b1);	
		s.addAfter(b4);
		s.addBefore(b3);
		s.addAll(se);
		assertTrue(s.isCurrent());
		assertEquals(4,s.size());
		assertEquals(2,se.size());
		assertSame(b3,s.getCurrent()); s.advance();
		assertSame(b4,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertFalse(s.isCurrent());	
	}

	public void testAddAll22B() {
		Sequence<HexTile> se = new Sequence<HexTile>();
		se.addAfter(b2);
		se.addBefore(b1);
		se.advance();
		s.addAfter(b3);
		s.addAfter(b4);
		s.addAll(se);
		assertTrue(s.isCurrent());
		assertEquals(4,s.size());
		assertEquals(2,se.size());
		assertSame(b2,se.getCurrent()); se.advance();
		assertFalse(se.isCurrent());
		// check s
		assertSame(b4,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertFalse(s.isCurrent());	
		s.start();
		assertSame(b3,s.getCurrent());
	}

	public void testAddAll22C() {
		Sequence<HexTile> se = new Sequence<HexTile>();
		se.addBefore(b2);
		se.addBefore(b1);
		se.advance();
		se.advance();
		s.addAfter(b3);
		s.addAfter(b4);
		s.advance();
		assertFalse(s.isCurrent());
		assertFalse(se.isCurrent());
		s.addAll(se);
		assertFalse(s.isCurrent());
		assertFalse(se.isCurrent());
		assertEquals(4,s.size());
		assertEquals(2,se.size());
		s.start();
		assertSame(b3,s.getCurrent()); s.advance();
		assertSame(b4,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertFalse(s.isCurrent());	
	}

	public void testAddAllLots() {
		Sequence<HexTile> se = new Sequence<HexTile>();
		se.addAfter(b3);
		se.addAfter(b4);
		se.addAfter(b5);
		se.addAfter(b3);
		se.addAfter(b4);
		se.addAfter(b5);
		se.addAfter(b3);
		se.addAfter(b4);
		se.addAfter(b5);
		se.addAfter(b3);
		se.addAfter(b4);
		se.addAfter(b5);
		se.addAfter(b3);
		se.addAfter(b4);
		se.addAfter(b5);
		se.addAfter(b3);
		se.addAfter(b4);
		se.addAfter(b5);
		se.addAfter(b3);
		se.addAfter(b4);
		se.addAfter(b5);
		se.addAfter(b3);
		se.addAfter(b4);
		se.addAfter(b5);
		// se has 24 elements
		s.addAfter(b1);
		s.addAfter(b2);
		s.addAll(se);
		assertEquals(26,s.size());
		assertSame(b2,s.getCurrent()); s.advance();
		assertSame(b3,s.getCurrent()); s.advance();
		s.addAll(se);
		assertEquals(50,s.size());
		s.start();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertSame(b3,s.getCurrent()); s.advance();
		assertSame(b4,s.getCurrent()); s.advance();
		assertSame(b5,s.getCurrent()); s.advance();
		assertSame(b3,s.getCurrent()); s.advance();
		assertSame(b4,s.getCurrent());
	}
	
	public void testAddAllSelf0() {
		s.addAll(s);
		assertFalse(s.isCurrent());
		assertEquals(0,s.size());
	}
	
	
	public void testAddAllSelf1A() {
		s.addAfter(b1);
		s.addAll(s);
		assertEquals(2,s.size());
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
		s.advance();
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
		s.advance();
		assertFalse(s.isCurrent());
	}
	
	public void testAddAllSelf1B() {
		s.addAfter(b1);
		s.advance();
		s.addAll(s);
		assertEquals(2,s.size());
		assertFalse(s.isCurrent());
	}
	
	public void testAddAllSelf1Removed() {
		s.addAfter(b1);
		s.removeCurrent();
		assertEquals(0,s.size());
		assertFalse(s.isCurrent());
	}
	
	public void testAddAllSelf2A() {
		s.addAfter(b2);
		s.addBefore(b1);
		s.addAll(s);
		assertEquals(4,s.size());
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertFalse(s.isCurrent());		
	}
	
	public void testAddAllSelf2B() {
		s.addAfter(b1);
		s.addAfter(b2);
		s.addAll(s);
		assertEquals(4,s.size());
		assertTrue(s.isCurrent());
		assertSame(b2,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertFalse(s.isCurrent());		
	}

	public void testAddAllSelf2C() {
		s.addAfter(b1);
		s.addAfter(b2);
		s.advance();
		assertFalse(s.isCurrent());
		s.addAll(s);
		assertFalse(s.isCurrent());
		assertEquals(4,s.size());
		s.start();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertFalse(s.isCurrent());		
	}

	public void testAddAllSelf() {
		s.addAfter(b1);
		s.addAfter(b2);
		s.addAll(s);
		s.removeCurrent();
		s.addBefore(b3);
		assertSame(b3,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertFalse(s.isCurrent());
		s.start();
		assertSame(b1,s.getCurrent()); s.advance();
		s.advance();
		s.addAll(s);
		assertEquals(8,s.size());
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b3,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertFalse(s.isCurrent());		
	}
	
	public void testAddAllAlias() {
		Sequence<HexTile> se = new Sequence<HexTile>();
		se.addAfter(b1);
		se.addAfter(b2);	
		s.addAfter(b3);
		s.addAfter(b4);
		s.addAll(se);
		s.advance();
		s.addAfter(b5);
		s.advance();
		assertTrue(s.isCurrent());
		assertSame(b2,s.getCurrent());
		assertEquals(5,s.size());
		assertEquals(2,se.size());
		assertSame(b2,se.getCurrent());
		se.advance();
		assertFalse(se.isCurrent());
		se.start();
		assertSame(b1,se.getCurrent());
	}
	
	public void testClone0() {
		Sequence<HexTile> c = s.clone();
		assertFalse(c.isCurrent());
		assertEquals(0, c.size());
	}
	
	public void testClone1A() {
		s.addAfter(b1);
		Sequence<HexTile> c = s.clone();
		
		assertTrue(s.isCurrent());
		assertTrue(c.isCurrent());
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b1,c.getCurrent()); c.advance();
		assertFalse(s.isCurrent());
		assertFalse(c.isCurrent());
	}
	
	public void testClone1B() {
		s.addAfter(b1);
		s.advance();
		Sequence<HexTile> c = s.clone();
		
		assertFalse(s.isCurrent());
		assertFalse(c.isCurrent());
	}

	public void testClone() {
		Sequence<HexTile> c = s.clone();
		assertFalse(c.isCurrent());
		
		s.addAfter(b1);
		c = s.clone();
		assertTrue(s.isCurrent());
		assertTrue(c.isCurrent());
		assertSame(b1,s.getCurrent());
		assertSame(b1,c.getCurrent());
		
		s.addAfter(b2);
		c = s.clone();
		assertTrue(s.isCurrent());
		assertTrue(c.isCurrent());
		assertSame(b2,s.getCurrent());
		assertSame(b2,c.getCurrent());
		s.advance();
		c.advance();
		assertFalse(s.isCurrent());
		assertFalse(c.isCurrent());
		
		s.addAfter(b3);
		c = s.clone();
		assertSame(b3,s.getCurrent());
		assertSame(b3,c.getCurrent());
		s.advance();
		c.advance();
		assertFalse(s.isCurrent());
		assertFalse(c.isCurrent());
		s.start();
		c.start();
		assertTrue(s.isCurrent());
		assertTrue(c.isCurrent());
		assertSame(b1,s.getCurrent());
		assertSame(b1,c.getCurrent());
		s.advance();
		c.advance();
		assertTrue(s.isCurrent());
		assertTrue(c.isCurrent());
		assertSame(b2,s.getCurrent());
		assertSame(b2,c.getCurrent());
		
		s.start();
		c = s.clone();
		assertTrue(s.isCurrent());
		assertTrue(c.isCurrent());
		assertSame(b1,s.getCurrent());
		assertSame(b1,c.getCurrent());
		s.advance();
		c.advance();
		assertTrue(s.isCurrent());
		assertTrue(c.isCurrent());
		assertSame(b2,s.getCurrent());
		assertSame(b2,c.getCurrent());
		s.advance();
		c.advance();
		assertTrue(s.isCurrent());
		assertTrue(c.isCurrent());
		assertSame(b3,s.getCurrent());
		assertSame(b3,c.getCurrent());		
	}
	
	public void testCloneRemove() {
		s.addAfter(b1);
		s.addAfter(b3);
		s.addBefore(b2);
		s.removeCurrent();
		
		Sequence<HexTile> c = s.clone();
		
		assertEquals(2,c.size());
		
		assertTrue(s.isCurrent());
		assertTrue(c.isCurrent());
		
		assertSame(b3,s.getCurrent());
		assertSame(b3,c.getCurrent());
	}

	public void testCloneAlias() {
		s.addAfter(b1);
		s.addAfter(b2);
		
		Sequence<HexTile> c = s.clone();
		s.addBefore(b3);
		c.addBefore(b4);
		
		assertSame(b3,s.getCurrent());
		assertSame(b4,c.getCurrent());
		s.advance();
		c.advance();
		assertSame(b2,s.getCurrent());
		assertSame(b2,c.getCurrent());
		s.advance();
		c.advance();
		assertFalse(s.isCurrent());
		assertFalse(c.isCurrent());
		
		s.start();
		c.start();
		assertSame(b1,s.getCurrent());
		assertSame(b1,c.getCurrent());
		s.advance();
		c.advance();
		assertSame(b3,s.getCurrent());
		assertSame(b4,c.getCurrent());
	}

}
