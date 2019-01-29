import junit.framework.TestCase;
import edu.uwm.cs351.FormatException;
import edu.uwm.cs351.HexCoordinate;
import edu.uwm.cs351.HexTile;
import edu.uwm.cs351.Terrain;


public class TestFromString extends TestCase {
	
	protected void assertException(Class<? extends Throwable> c, Runnable r) {
		try {
			r.run();
			assertFalse("Exception should have been thrown",true);
		} catch (RuntimeException ex) {
			assertTrue("should throw exception of " + c + ", not of " + ex.getClass(), c.isInstance(ex));
		}
	}

	protected static HexCoordinate h(int a, int b) { return new HexCoordinate(a,b); }
	
	
	/// test1X: testing HexCoordinate.fromString
	
	public void test10() {
		assertEquals(h(0,0),HexCoordinate.fromString("<0,0,0>"));
	}
	
	public void test11() {
		assertEquals(h(1,1),HexCoordinate.fromString("<1,1,0>"));
	}
	
	public void test12() {
		assertEquals(h(-2,0),HexCoordinate.fromString("<-2,0,-2>"));
	}
	
	public void test13() {
		assertEquals(h(0,-2),HexCoordinate.fromString("<0,-2,2>"));
	}
	
	public void test14() {
		assertEquals(h(100,67),HexCoordinate.fromString("<100,67,33>"));
	}
	
	public void test19() {
		for (int a : new int[]{-4,-1,0,1,2,7,20,3000}) {
			for (int b : new int[]{-10,-5,-2,1,3,6,9,57,688}) {
				HexCoordinate h = h(a,b);
				assertEquals(h,HexCoordinate.fromString(h.toString()));
			}
		}
	}
	
	
	/// test2X: error tests for HexCoordinate.fromString
	
	public void test20() {
		assertException(FormatException.class,() -> HexCoordinate.fromString("(3,2,1)"));
	}
	
	public void test21() {
		assertException(FormatException.class,() -> HexCoordinate.fromString("<3,2>"));
	}
	
	public void test22() {
		assertException(FormatException.class,() -> HexCoordinate.fromString("<3,2,1,0>"));
	}
	
	public void test23() {
		assertException(FormatException.class, () -> HexCoordinate.fromString("<3,2.0,1.0>"));
	}
	
	public void test24() {
		assertException(IllegalArgumentException.class, () -> HexCoordinate.fromString("<1,2,3>"));
	}
	
	public void test25() {
		assertException(FormatException.class, () -> HexCoordinate.fromString("<1a1,0,0>"));
	}
	
	public void test26() {
		assertException(FormatException.class, () -> HexCoordinate.fromString("<21,2 4, 17>"));
	}
	
	public void test27() {
		assertException(FormatException.class, () -> HexCoordinate.fromString("<>"));
	}
	
	public void test28() {
		assertException(FormatException.class, () -> HexCoordinate.fromString("<3,2,1>@42"));
	}
	
	public void test29() {
		assertException(FormatException.class, () -> HexCoordinate.fromString(""));
	}
	
	
	/// test3X: testing HexTile.fromString
	
	public void test30() {
		HexTile ht = HexTile.fromString("INACCESSIBLE<3,2,1>");
		assertEquals(Terrain.INACCESSIBLE,ht.getTerrain());
		assertEquals(h(3,2),ht.getLocation());
	}
	
	public void test31() {
		HexTile ht = HexTile.fromString("WATER<-1,2,-3>");
		assertEquals(Terrain.WATER,ht.getTerrain());
		assertEquals(h(-1,2),ht.getLocation());
	}
	
	public void test32() {
		HexTile ht = HexTile.fromString("LAND<2,3,-1>");
		assertEquals(Terrain.LAND,ht.getTerrain());
		assertEquals(h(2,3),ht.getLocation());
	}
	
	public void test33() {
		HexTile ht = HexTile.fromString("FOREST<5,3,2>");
		assertEquals(Terrain.FOREST,ht.getTerrain());
		assertEquals(h(5,3),ht.getLocation());
	}
	
	public void test34() {
		HexTile ht = HexTile.fromString("MOUNTAIN<-1,0,-1>");
		assertEquals(Terrain.MOUNTAIN,ht.getTerrain());
		assertEquals(h(-1,0),ht.getLocation());
	}
	
	public void test35() {
		HexTile ht = HexTile.fromString("CITY<10,5,5>");
		assertEquals(Terrain.CITY,ht.getTerrain());
		assertEquals(h(10,5),ht.getLocation());
	}
	
	public void test36() {
		HexTile ht = HexTile.fromString("DESERT<-300,-4,-296>");
		assertEquals(Terrain.DESERT,ht.getTerrain());
		assertEquals(h(-300,-4),ht.getLocation());
	}

	
	public void test39() {
		for (int a : new int[]{-4,-1,0,1,2,7,20,3000}) {
			for (int b : new int[]{-10,-5,-2,1,3,6,9,57,688}) {
				HexCoordinate h = h(a,b);
				for (Terrain t : Terrain.values()) {
					HexTile ht = HexTile.fromString(t+h.toString());
					assertEquals(t,ht.getTerrain());
					assertEquals(h,ht.getLocation());
				}
			}
		}
	}
	
	
	/// test4X: errors from HexTile.fromString
	
	public void test40() {
		assertException(IllegalArgumentException.class,() -> HexTile.fromString("PASTURE<2,1,1>"));
	}
	
	public void test41() {
		assertException(FormatException.class, () -> HexTile.fromString("WATER(1,1,0)"));
	}
	
	public void test42() {
		assertException(FormatException.class, () -> HexTile.fromString("LAND"));
	}
	
	public void test43() {
		assertException(IllegalArgumentException.class, () -> HexTile.fromString("<3,2,1>"));
	}
	
	public void test44() {
		assertException(IllegalArgumentException.class, () -> HexTile.fromString("LAND<1,2,3>"));
	}
	
	public void test45() {
		assertException(FormatException.class, () -> HexTile.fromString("FOREST<"));
	}
}
