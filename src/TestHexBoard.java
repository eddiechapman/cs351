import java.util.Iterator;

import edu.uwm.cs351.HexBoard;
import edu.uwm.cs351.HexCoordinate;
import edu.uwm.cs351.HexTile;
import edu.uwm.cs351.Terrain;


public class TestHexBoard extends TestCollection<HexTile> {

	private HexBoard hb;
	
	protected HexCoordinate h(int a, int b) { return new HexCoordinate(a,b); }
	
	@Override
	protected void initCollections() {
		c = hb = new HexBoard();
		e = new HexTile[]{
				new HexTile(Terrain.INACCESSIBLE,h(0,0)),
				new HexTile(Terrain.LAND,h(1,0)),
				new HexTile(Terrain.WATER,h(2,0)),
				new HexTile(Terrain.FOREST,h(3,1)),
				new HexTile(Terrain.MOUNTAIN,h(4,2)),
				new HexTile(Terrain.DESERT,h(5,3)),
				new HexTile(Terrain.CITY,h(6,2)),
				new HexTile(Terrain.LAND,h(7,1)),
				new HexTile(Terrain.WATER,h(8,0)),
				new HexTile(Terrain.FOREST,h(9,-1))};
		permitNulls = false;
		preserveOrder = false;
		permitDuplicates = false;
		// failFast = false;
		hasRemove = false;
	}

	
	/// Locked tests
	
	public void test() {
		HexTile forest32 = new HexTile(Terrain.FOREST,h(3,2));
		HexTile city32 = new HexTile(Terrain.CITY,h(3,2));
		HexTile forest21 = new HexTile(Terrain.FOREST,h(2,1));
		// HexBoard hb starts empty
		// does this return true, false, or throw an exception (give its name)
		assertEquals("true",toString(() -> hb.add(forest32)));
		assertEquals(Ts(1899087169),toString(() -> hb.add(forest32)));
		assertEquals(Ts(221027861),toString(()->hb.add(city32)));
		assertEquals(Ti(171969021),hb.size());
		assertEquals("true",toString(()->hb.add(forest21)));
		assertEquals(Ti(890540989),hb.size());
		// can we add null?  true/false/name of exception:
		assertEquals(Ts(924173642),toString(() -> hb.add(null)));
		testMore(hb);
	}
	
	public void testMore(HexBoard hb) {
		hb.clear();
		assertEquals(0,hb.size());
		HexTile forest32 = new HexTile(Terrain.FOREST,h(3,2));
		hb.add(forest32);
		final Iterator<HexTile> it = hb.iterator();
		// does equals return true or false, or does the whole thing throw an exception?
		assertEquals(Ts(2013750705),toString(() -> forest32.equals(it.next())));
		// and again?
		assertEquals(Ts(984278095),toString(() -> forest32.equals(it.next())));
		final Iterator<HexTile> it2 = hb.iterator(); // new iterator
		// does it return the same hex tile or generate a new one?
		assertEquals(Ts(1563298685),toString(() -> forest32 == it2.next()));
		testEvenMore(hb);
	}
	
	public void testEvenMore(HexBoard hb) {
		hb.clear();
		hb.add(new HexTile(Terrain.CITY,h(2,1)));
		assertEquals("CITY",toString(() -> hb.terrainAt(h(2,1))));
		// what does terrainAt do if no terrain at location?
		// terrain/null/name of exception:
		assertEquals(Ts(363200885),toString(() -> hb.terrainAt(h(3,2))));
		testContains(hb);
	}
	
	public void testContains(HexBoard hb) {
		hb.clear();
		hb.add(new HexTile(Terrain.FOREST,h(3,2)));
		// true/false/name of exception:
		assertEquals(Ts(2097102435),toString(() -> hb.contains(h(3,2))));
		// true/false/name of exception:
		assertEquals(Ts(1502452343),toString(() -> hb.contains(null)));
		// true/false/name of exception:
		assertEquals(Ts(1318093596),toString(() -> hb.contains(new HexTile(Terrain.CITY,h(3,2)))));
		// true/false/name of exception:
		assertEquals(Ts(948342169),toString(() -> hb.contains(new HexTile(Terrain.FOREST,h(3,2)))));
	}
	
	
	/// some spot checks:
	
	public void testA() {
		assertException(NullPointerException.class, () -> hb.add(null));
	}
	
	public void testB() {
		HexTile t = new HexTile(Terrain.LAND,h(0,0));
		assertTrue(hb.add(t));
		assertFalse(hb.add(t));
	}
	
	public void testC() {
		HexTile t = new HexTile(Terrain.LAND,h(0,0));
		hb.add(e[0]);
		assertTrue(hb.add(t));
		assertEquals(1,hb.size());
		assertTrue(hb.contains(t));
	}
	
	public void testD() {
		HexTile t = new HexTile(Terrain.CITY,h(5,3));
		hb.add(t);
		hb.add(e[5]);
		assertEquals(1,hb.size());
	}
	
	public void testE() {
		hb.add(e[3]);
		hb.add(e[4]);
		hb.add(e[5]);
		assertEquals(Terrain.FOREST,hb.terrainAt(h(3,1)));
	}
	
	public void testF() {
		hb.add(e[6]);
		assertFalse(hb.contains(new HexTile(Terrain.MOUNTAIN,h(6,2))));
	}
	
	public void testG() {
		HexTile t = new HexTile(Terrain.CITY,h(5,3));
		hb.add(e[5]);
		assertFalse(hb.contains(t));
		assertFalse(hb.remove(t));
		assertTrue(hb.contains(e[5]));
	}
	
	public void testH() {
		hb.add(e[1]);
		hb.add(e[2]);
		hb.add(new HexTile(Terrain.CITY,e[2].getLocation()));
		assertEquals(Terrain.CITY,hb.terrainAt(e[2].getLocation()));
		assertEquals(null,hb.terrainAt(e[3].getLocation()));
	}
	
	
	/// testing iterator using sorting order
	
	public void test90() {
		hb.add(new HexTile(Terrain.CITY,h(3,1)));
		hb.add(new HexTile(Terrain.CITY,h(5,0)));
		it = hb.iterator();
		assertEquals(h(5,0),it.next().getLocation());
	}
	
	public void test91() {
		hb.add(new HexTile(Terrain.CITY,h(3,2)));
		hb.add(new HexTile(Terrain.CITY,h(2,2)));
		it = hb.iterator();
		assertEquals(h(2,2),it.next().getLocation());
	}
	
	public void test92() {
		hb.add(new HexTile(Terrain.CITY,h(3,2)));
		hb.add(new HexTile(Terrain.CITY,h(2,2)));
		it = hb.iterator();
		it.next();
		assertEquals(h(3,2),it.next().getLocation());		
	}
	
	public void test93() {
		hb.add(new HexTile(Terrain.CITY,h(3,2)));
		hb.add(new HexTile(Terrain.CITY,h(5,2)));
		it = hb.iterator();
		assertEquals(h(3,2),it.next().getLocation());		
		assertEquals(h(5,2),it.next().getLocation());
	}
	
	public void test94() {
		hb.add(new HexTile(Terrain.CITY,h(3,2)));
		hb.add(new HexTile(Terrain.CITY,h(5,2)));
		hb.add(new HexTile(Terrain.CITY,h(2,2)));
		it = hb.iterator();
		assertEquals(h(2,2),it.next().getLocation());
		assertEquals(h(3,2),it.next().getLocation());		
		assertEquals(h(5,2),it.next().getLocation());
	}
	
	public void test95() {
		hb.add(new HexTile(Terrain.CITY,h(4,0)));
		hb.add(new HexTile(Terrain.CITY,h(3,2)));
		hb.add(new HexTile(Terrain.CITY,h(5,-1)));
		hb.add(new HexTile(Terrain.CITY,h(10,2)));
		hb.add(new HexTile(Terrain.CITY,h(5,5)));
		it = hb.iterator();
		assertEquals(h(5,-1),it.next().getLocation());
		assertEquals(h(4,0),it.next().getLocation());		
		assertEquals(h(3,2),it.next().getLocation());
		assertEquals(h(10,2),it.next().getLocation());		
		assertEquals(h(5,5),it.next().getLocation());
	}
	
	public void test96() {
		
	}
}
