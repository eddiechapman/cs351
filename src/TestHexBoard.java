import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import edu.uwm.cs351.HexBoard;
import edu.uwm.cs351.HexCoordinate;
import edu.uwm.cs351.HexTile;
import edu.uwm.cs351.Terrain;
import edu.uwm.cs351.util.DefaultEntry;


public class TestHexBoard extends TestCollection<HexTile> {

	private HexBoard hb;
	private Map<HexCoordinate,Terrain> map;
	private Set<Map.Entry<HexCoordinate,Terrain>> set;
	private Iterator<Map.Entry<HexCoordinate,Terrain>> setit;
	private Set<HexTile> row;
	
	protected HexCoordinate h(int a, int b) { return new HexCoordinate(a,b); }
	
	protected <K,V> Map.Entry<K,V> e(K k, V v) { return new DefaultEntry<K,V>(k,v); }
	
	protected Map.Entry<HexCoordinate, Terrain> asEntry(HexTile t) {
		return e(t.getLocation(),t.getTerrain());
	}

	/**
	 * Return a terrain different than the argument.
	 * @param t terrain, must not be null
	 * @return different terrain (never null)
	 */
	private Terrain not(Terrain t) {
		int i = t.ordinal();
		++i;
		Terrain[] terrains = Terrain.values();
		return terrains[i % terrains.length];
	}
	
	@Override
	protected void initCollections() {
		c = hb = new HexBoard();
		map = hb.asMap();
		set = map.entrySet();
		e = new HexTile[]{
				new HexTile(Terrain.INACCESSIBLE,h(0,0)),
				new HexTile(Terrain.LAND,h(1,0)),
				new HexTile(Terrain.WATER,h(2,0)),
				new HexTile(Terrain.FOREST,h(3,1)),
				new HexTile(Terrain.MOUNTAIN,h(4,2)),
				new HexTile(Terrain.DESERT,h(5,3)),
				new HexTile(Terrain.CITY,h(6,3)),
				new HexTile(Terrain.LAND,h(7,3)),
				new HexTile(Terrain.WATER,h(8,4)),
				new HexTile(Terrain.FOREST,h(9,4)),
				new HexTile(Terrain.MOUNTAIN,h(0,5)),
				new HexTile(Terrain.DESERT,h(1,6)),
				new HexTile(Terrain.CITY,h(2,6)),
				new HexTile(Terrain.LAND,h(3,7))};
		permitNulls = false;
		preserveOrder = false;
		permitDuplicates = false;
		// failFast = false;
		// hasRemove = false;
	}

	
	/// Locked tests
	
	public void test() {
		HexTile forest23 = new HexTile(Terrain.FOREST,h(2,3));
		HexTile forest33 = new HexTile(Terrain.FOREST,h(3,3));
		// hb/map/set start empty
		assertEquals(Ts(990435279),toString(() -> map.put(h(3,2),Terrain.DESERT)));
		assertEquals(Ts(349645244),toString(() -> map.put(h(3,2),Terrain.FOREST)));
		assertEquals(Ts(1361484314),toString(() -> set.add(e(h(3,2),Terrain.WATER))));
		Map.Entry<HexCoordinate,Terrain> entry = set.iterator().next();
		// Entries print as key=value:
		assertEquals(Ts(1914280505),entry.toString());
		hb.add(forest23);
		hb.add(forest33);
		row = hb.row(3);
		assertEquals(Ti(701246749),row.size());
		// HexTiles print as TERRAIN<a,b,c>
		assertEquals(Ts(662212),toString(() -> row.iterator().next()));
		row.add(new HexTile(Terrain.WATER,h(4,3)));
		assertEquals(Ti(374059176),set.size());
		assertEquals(Ti(34733118),row.size());
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
	
	private static final int BIG = 13;
	
    private void makeBigTree() {
        // (((1)2(((3(4))5)6((7(8))9)))10((11)12(13)))
    	hb.add(e[10]);
		hb.add(e[6]);
        hb.add(e[2]);
        hb.add(e[1]);
        hb.add(e[10]);
        hb.add(e[5]);
        hb.add(e[3]);
        hb.add(e[4]);
        hb.add(e[9]);
        hb.add(e[7]);
        hb.add(e[8]);
        hb.add(e[12]);
        hb.add(e[11]);
        hb.add(e[13]);
    }


    /// intense testing of remove
    
	public void testI() {
		for (int i=1; i <= BIG; ++i) {
			makeBigTree();
			assertTrue("Removing e[" + i + "]",hb.remove(e[i]));
			assertFalse("Removed e[" + i + "]",hb.contains(e[i]));
			assertEquals(BIG-1,hb.size());
			hb.clear();
		}
	}
	
	public void testJ() {
		for (int i=1; i <= BIG; ++i) {
			makeBigTree();
			it = hb.iterator();
			for (int j=1; j <= BIG; ++j) {
				assertEquals("While removing e[" + i + "], checking e[" + j + "]",e[j],it.next());
				if (i == j) it.remove();
			}
			assertFalse("Removed e[" + i + "]",hb.contains(e[i]));
			assertEquals(BIG-1,hb.size());
			hb.clear();
		}
	}
	
	public void testK() {
		makeBigTree();
		it = hb.iterator();
		for (int j=1; j <= BIG; ++j) {
			assertEquals("While removing ODD, checking e[" + j + "]",e[j],it.next());
			if ((j%2) == 1) it.remove();
		}
		assertEquals(BIG/2,hb.size());
	}
	
	public void testL() {
		makeBigTree();
		for (int j=1; j <= BIG; ++j) {
			assertTrue("Removing e[" + j + "]",hb.remove(e[j]));
		}
		assertTrue(hb.isEmpty());
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
	
	
	
	//// testMNN: Testing maps
	
	/// testM0X: testing size
	
	public void testM00() {
		assertEquals(0,map.size());
	}
	
	public void testM01() {
		hb.add(e[2]);
		assertEquals(1,map.size());
	}
	
	public void testM02() {
		hb.add(e[3]);
		hb.add(e[4]);
		hb = new HexBoard();
		hb.add(e[5]);
		assertEquals(2,map.size());
	}
	
	public void testM03() {
		hb.add(e[7]);
		hb.add(e[6]);
		hb.add(e[8]);
		hb.add(e[9]);
		it = hb.iterator();
		it.next();
		it.next();
		it.remove();
		assertEquals(3,map.size());
	}
	
	public void testM04() {
		hb.add(e[0]);
		hb.add(e[1]);
		hb.add(e[2]);
		hb.add(e[3]);
		hb.add(e[4]);
		hb.clear();
		assertEquals(0,map.size());
	}
	
	
	/// testM1X: tests of get
	
	public void testM10() {
		assertNull(map.get(e[0].getLocation()));
		assertNull(map.get(e[0].getTerrain()));
	}
	
	public void testM11() {
		hb.add(e[1]);
		assertNull(map.get(e[0].getLocation()));
		assertEquals(e[1].getTerrain(),map.get(e[1].getLocation()));
		assertNull(map.get(e[1]));
	}
	
	public void testM12() {
		hb.add(e[2]);
		hb.add(e[3]);
		assertNull(map.get(e[1].getLocation()));
		assertEquals(e[2].getTerrain(),map.get(e[2].getLocation()));
		assertEquals(e[3].getTerrain(),map.get(e[3].getLocation()));
		assertNull(map.get(e[2].getLocation().toString()));
	}
	
	public void testM13() {
		hb.add(e[4]);
		hb.add(e[5]);
		hb.add(e[6]);
		assertNull(map.get(e[3].getLocation()));
		assertEquals(e[4].getTerrain(),map.get(e[4].getLocation()));
		assertEquals(e[5].getTerrain(),map.get(e[5].getLocation()));
		assertEquals(e[6].getTerrain(),map.get(e[6].getLocation()));
		assertNull(map.get(hb));
	}
	
	public void testM14() {
		hb.add(e[7]);
		hb.add(e[8]);
		hb.add(e[9]);
		hb.add(e[0]);
		assertNull(map.get(e[3].getLocation()));
		assertEquals(e[7].getTerrain(),map.get(e[7].getLocation()));
		assertEquals(e[8].getTerrain(),map.get(e[8].getLocation()));
		assertEquals(e[9].getTerrain(),map.get(e[9].getLocation()));
		assertEquals(e[0].getTerrain(),map.get(e[0].getLocation()));
		assertNull(map.get(null));
	}
	
	public void testM15() {
		hb.add(e[5]);
		hb.add(e[3]);
		hb.add(e[7]);
		hb.add(e[1]);
		hb.add(e[9]);
		assertNull(map.get(e[0].getLocation()));
		assertEquals(e[1].getTerrain(),map.get(e[1].getLocation()));
		assertNull(map.get(e[2].getLocation()));
		assertEquals(e[3].getTerrain(),map.get(e[3].getLocation()));
		assertNull(map.get(e[4].getLocation()));
		assertEquals(e[5].getTerrain(),map.get(e[5].getLocation()));
		assertNull(map.get(e[6].getLocation()));
		assertEquals(e[7].getTerrain(),map.get(e[7].getLocation()));
		assertNull(map.get(e[8].getLocation()));
		assertEquals(e[9].getTerrain(),map.get(e[9].getLocation()));
		assertNull(map.get(e[10].getLocation()));		
	}
	
	public void testM19() {
		makeBigTree();
		assertEquals(e[1].getTerrain(),map.get(e[1].getLocation()));
		assertEquals(e[2].getTerrain(),map.get(e[2].getLocation()));
		assertEquals(e[3].getTerrain(),map.get(e[3].getLocation()));
		assertEquals(e[4].getTerrain(),map.get(e[4].getLocation()));
		assertEquals(e[5].getTerrain(),map.get(e[5].getLocation()));
		assertEquals(e[6].getTerrain(),map.get(e[6].getLocation()));
		assertEquals(e[7].getTerrain(),map.get(e[7].getLocation()));
		assertEquals(e[8].getTerrain(),map.get(e[8].getLocation()));
		assertEquals(e[9].getTerrain(),map.get(e[9].getLocation()));
		assertEquals(e[10].getTerrain(),map.get(e[10].getLocation()));
		assertEquals(e[11].getTerrain(),map.get(e[11].getLocation()));
		assertEquals(e[12].getTerrain(),map.get(e[12].getLocation()));
		assertEquals(e[13].getTerrain(),map.get(e[13].getLocation()));
	}
	
	
	/// testM2X: testing containsKey
	
	public void testM20() {
		assertFalse(map.containsKey(e[0].getLocation()));
		assertFalse(map.containsKey(e[0].getTerrain()));
	}
	
	public void testM21() {
		hb.add(e[1]);
		assertFalse(map.containsKey(e[0].getLocation()));
		assertTrue(map.containsKey(e[1].getLocation()));
		assertFalse(map.containsKey(e[1]));
	}
	
	public void testM22() {
		hb.add(e[2]);
		hb.add(e[3]);
		assertFalse(map.containsKey(e[1].getLocation()));
		assertTrue(map.containsKey(e[2].getLocation()));
		assertTrue(map.containsKey(e[3].getLocation()));
		assertFalse(map.containsKey(e[2].getLocation().toString()));
	}
	
	public void testM23() {
		hb.add(e[4]);
		hb.add(e[5]);
		hb.add(e[6]);
		assertFalse(map.containsKey(e[3].getLocation()));
		assertTrue(map.containsKey(e[4].getLocation()));
		assertTrue(map.containsKey(e[5].getLocation()));
		assertTrue(map.containsKey(e[6].getLocation()));
		assertFalse(map.containsKey(hb));
	}
	
	public void testM24() {
		hb.add(e[7]);
		hb.add(e[8]);
		hb.add(e[9]);
		hb.add(e[0]);
		assertFalse(map.containsKey(e[3].getLocation()));
		assertTrue(map.containsKey(e[7].getLocation()));
		assertTrue(map.containsKey(e[8].getLocation()));
		assertTrue(map.containsKey(e[9].getLocation()));
		assertTrue(map.containsKey(e[0].getLocation()));
		assertFalse(map.containsKey(null));
	}
	
	public void testM25() {
		hb.add(e[5]);
		hb.add(e[3]);
		hb.add(e[7]);
		hb.add(e[1]);
		hb.add(e[9]);
		assertFalse(map.containsKey(e[0].getLocation()));
		assertTrue(map.containsKey(e[1].getLocation()));
		assertFalse(map.containsKey(e[2].getLocation()));
		assertTrue(map.containsKey(e[3].getLocation()));
		assertFalse(map.containsKey(e[4].getLocation()));
		assertTrue(map.containsKey(e[5].getLocation()));
		assertFalse(map.containsKey(e[6].getLocation()));
		assertTrue(map.containsKey(e[7].getLocation()));
		assertFalse(map.containsKey(e[8].getLocation()));
		assertTrue(map.containsKey(e[9].getLocation()));
		assertFalse(map.containsKey(e[10].getLocation()));		
	}
	
	public void testM29() {
		makeBigTree();
		assertTrue(map.containsKey(e[1].getLocation()));
		assertTrue(map.containsKey(e[2].getLocation()));
		assertTrue(map.containsKey(e[3].getLocation()));
		assertTrue(map.containsKey(e[4].getLocation()));
		assertTrue(map.containsKey(e[5].getLocation()));
		assertTrue(map.containsKey(e[6].getLocation()));
		assertTrue(map.containsKey(e[7].getLocation()));
		assertTrue(map.containsKey(e[8].getLocation()));
		assertTrue(map.containsKey(e[9].getLocation()));
		assertTrue(map.containsKey(e[10].getLocation()));
		assertTrue(map.containsKey(e[11].getLocation()));
		assertTrue(map.containsKey(e[12].getLocation()));
		assertTrue(map.containsKey(e[13].getLocation()));
	}

	
	/// testM3X: testing put
	
	public void testM30() {
		assertNull(map.put(h(3,2),Terrain.WATER));
		assertEquals(1,hb.size());
		assertTrue(hb.contains(new HexTile(Terrain.WATER,h(3,2))));
	}
	
	public void testM31() {
		map.put(h(4,3),Terrain.CITY);
		assertEquals(Terrain.CITY,map.put(h(4,3),Terrain.DESERT));
		assertEquals(1,hb.size());
	}
	
	public void testM32() {
		map.put(h(2,3),Terrain.FOREST);
		assertNull(map.put(h(3,1),Terrain.LAND));
		assertEquals(2,hb.size());
	}
	
	public void testM33() {
		map.put(h(3,3),Terrain.INACCESSIBLE);
		map.put(h(2,3),Terrain.MOUNTAIN);
		assertEquals(Terrain.MOUNTAIN,map.put(h(2,3),Terrain.CITY));
		assertNull(map.put(h(5,3),Terrain.LAND));
		assertEquals(3,hb.size());
	}
	
	public void testM34() {
		map.put(h(3,4),Terrain.WATER);
		map.put(h(4,3),Terrain.LAND);
		map.put(h(3,2),Terrain.CITY);
		assertNull(map.put(h(5,5),Terrain.DESERT));
		assertEquals(Terrain.LAND,map.put(h(4,3),Terrain.FOREST));
		assertEquals(4,hb.size());
	}
	
	public void testM35() {
		assertException(IllegalArgumentException.class,() -> map.put(null,Terrain.LAND));
	}
	
	public void testM36() {
		assertException(IllegalArgumentException.class, () -> map.put(h(3,2),null));
	}
	
	// no more "put" tests, assuming you didn't write this from scratch.
	// You should NOT have two methods which both have code
	// to add things to a binary search tree.
	
	
	/// testM4X: testing remove
	
	public void testM40() {
		assertNull(map.remove(h(3,2)));
		assertNull(map.remove(Terrain.CITY));
	}
	
	public void testM41() {
		hb.add(e[1]);
		assertNull(map.remove(e[0].getLocation()));
		assertEquals(e[1].getTerrain(),map.remove(e[1].getLocation()));
		assertNull(map.remove(e[1].getLocation()));
		assertEquals(0,hb.size());
	}
	
	public void testM42() {
		hb.add(e[2]);
		hb.add(e[3]);
		assertNull(map.remove(e[1].getLocation()));
		assertEquals(e[2].getTerrain(),map.remove(e[2].getLocation()));
		assertNull(map.get(e[2].getLocation()));
		assertEquals(1,map.size());
		assertEquals(e[3].getTerrain(),map.remove(e[3].getLocation()));
		assertNull(map.remove(e[2].getLocation().toString()));
		assertNull(map.get(e[3].getLocation()));
		assertEquals(0,hb.size());
	}
	
	public void testM43() {
		hb.add(e[4]);
		hb.add(e[5]);
		hb.add(e[6]);
		assertNull(map.remove(e[3].getLocation()));
		assertEquals(e[4].getTerrain(),map.remove(e[4].getLocation()));
		assertNull(map.get(e[4].getLocation()));
		assertEquals(2,hb.size());
		assertEquals(e[5].getTerrain(),map.remove(e[5].getLocation()));
		assertNull(map.get(e[5].getLocation()));
		assertNull(map.get(e[4].getLocation()));
		assertEquals(e[6].getTerrain(),map.remove(e[6].getLocation()));
		assertNull(map.get(e[6].getLocation()));
		assertNull(map.get(e[5].getLocation()));
		assertNull(map.get(e[4].getLocation()));
		assertNull(map.remove(hb));
	}
	
	public void testM44() {
		hb.add(e[7]);
		hb.add(e[8]);
		hb.add(e[9]);
		hb.add(e[0]);
		assertNull(map.remove(e[3].getLocation()));
		assertEquals(e[7].getTerrain(),map.remove(e[7].getLocation()));
		assertNull(map.get(e[7].getLocation()));
		assertEquals(e[8].getTerrain(),map.remove(e[8].getLocation()));
		assertNull(map.get(e[7].getLocation()));
		assertNull(map.get(e[8].getLocation()));
		assertEquals(e[9].getTerrain(),map.remove(e[9].getLocation()));
		assertNull(map.get(e[7].getLocation()));
		assertNull(map.get(e[8].getLocation()));
		assertNull(map.get(e[9].getLocation()));
		assertEquals(e[0].getTerrain(),map.remove(e[0].getLocation()));
		assertNull(map.get(e[7].getLocation()));
		assertNull(map.get(e[8].getLocation()));
		assertNull(map.get(e[9].getLocation()));
		assertNull(map.get(e[0].getLocation()));
		assertNull(map.remove(null));
	}
	
	public void testM45() {
		hb.add(e[5]);
		hb.add(e[3]);
		hb.add(e[7]);
		hb.add(e[1]);
		hb.add(e[9]);
		assertNull(map.remove(e[0].getLocation()));
		assertEquals(e[1].getTerrain(),map.remove(e[1].getLocation()));
		assertNull(map.remove(e[2].getLocation()));
		assertNull(map.get(e[1].getLocation()));
		assertEquals(e[3].getTerrain(),map.remove(e[3].getLocation()));
		assertNull(map.remove(e[4].getLocation()));
		assertNull(map.get(e[3].getLocation()));
		assertEquals(e[5].getTerrain(),map.get(e[5].getLocation()));
		assertEquals(e[5].getTerrain(),map.remove(e[5].getLocation()));
		assertNull(map.remove(e[5].getLocation()));
		assertNull(map.remove(e[6].getLocation()));
		assertEquals(e[7].getTerrain(),map.get(e[7].getLocation()));
		assertEquals(e[9].getTerrain(),map.get(e[9].getLocation()));
		assertEquals(e[7].getTerrain(),map.remove(e[7].getLocation()));
		assertNull(map.remove(e[7].getLocation()));
		assertNull(map.remove(e[8].getLocation()));
		assertEquals(1,hb.size());
		assertEquals(e[9].getTerrain(),map.remove(e[9].getLocation()));
		assertNull(map.remove(e[10].getLocation()));		
	}
	
	public void testM49() {
		makeBigTree();
		assertEquals(e[6].getTerrain(),map.remove(e[6].getLocation()));
		assertEquals(e[7].getTerrain(),map.remove(e[7].getLocation()));
		assertEquals(e[1].getTerrain(),map.remove(e[1].getLocation()));
		assertEquals(e[2].getTerrain(),map.remove(e[2].getLocation()));
		assertEquals(e[3].getTerrain(),map.remove(e[3].getLocation()));
		assertEquals(e[4].getTerrain(),map.remove(e[4].getLocation()));
		assertEquals(e[5].getTerrain(),map.remove(e[5].getLocation()));
		// pause
		assertEquals(e[8].getTerrain(),map.get(e[8].getLocation()));
		assertEquals(e[9].getTerrain(),map.get(e[9].getLocation()));
		assertEquals(e[10].getTerrain(),map.get(e[10].getLocation()));
		assertEquals(e[11].getTerrain(),map.get(e[11].getLocation()));
		assertEquals(e[12].getTerrain(),map.get(e[12].getLocation()));
		assertEquals(e[13].getTerrain(),map.get(e[13].getLocation()));
		assertEquals(6,hb.size());
		assertNull(map.remove(e[1].getLocation()));
		assertNull(map.remove(e[2].getLocation()));
		assertNull(map.remove(e[3].getLocation()));
		assertNull(map.remove(e[4].getLocation()));
		assertNull(map.remove(e[5].getLocation()));
		assertNull(map.remove(e[6].getLocation()));
		assertNull(map.remove(e[7].getLocation()));
		// continue
		assertEquals(e[8].getTerrain(),map.remove(e[8].getLocation()));
		assertEquals(e[9].getTerrain(),map.remove(e[9].getLocation()));
		assertEquals(e[10].getTerrain(),map.remove(e[10].getLocation()));
		assertEquals(e[11].getTerrain(),map.remove(e[11].getLocation()));
		assertEquals(e[12].getTerrain(),map.remove(e[12].getLocation()));
		assertEquals(e[13].getTerrain(),map.remove(e[13].getLocation()));
	}
	
	
	/// testM5X: entry-set tests: add, size, isEmpty, contains
	
	public void testM50() {
		assertEquals(0,set.size());
		assertTrue(set.isEmpty());
		assertException(UnsupportedOperationException.class,() -> set.add(asEntry(e[0])));
	}
	
	public void testM51() {
		hb.add(e[1]);
		assertEquals(1,set.size());
		assertFalse(set.isEmpty());
	}
	
	public void testM52() {
		makeBigTree();
		assertEquals(13,set.size());
		assertFalse(set.isEmpty());
	}
	
	public void testM53() {
		assertFalse(set.contains(e(h(0,1),Terrain.CITY)));
	}
	
	public void testM54() {
		hb.add(e[2]);
		assertTrue(set.contains(asEntry(e[2])));
		assertFalse(set.contains(asEntry(e[3])));
		assertFalse(set.contains(e(e[2].getLocation(),not(e[2].getTerrain()))));
	}
	
	public void testM55() {
		hb.add(e[3]);
		assertFalse(set.contains(e(e[3].getLocation().toString(),e[3].getTerrain())));
		assertFalse(set.contains(e(e[3].getLocation(),null)));
		assertFalse(set.contains(e(new Object(),e[3].getTerrain())));
	}
	
	public void testM56() {
		// your code should not be checking for instanceof
		// AbstractEntry or DefaultEntry.
		Map<HexCoordinate,Terrain> m = new HashMap<>();
		m.put(e[4].getLocation(), e[4].getTerrain());
		Map.Entry<HexCoordinate, Terrain> entry = m.entrySet().iterator().next();
		hb.add(e[4]);
		assertTrue(set.contains(entry));
	}
	
	public void testM57() {
		hb.add(e[5]);
		hb.add(e[8]);
		assertFalse(set.contains(e[8].toString()));
		assertFalse(set.contains(e[8].getLocation()));
		assertFalse(set.contains(e[8].getTerrain()));
		assertFalse(set.contains(null));
	}
	
	public void testM58() {
		hb.add(e[5]);
		hb.add(e[3]);
		hb.add(e[7]);
		hb.add(e[1]);
		hb.add(e[9]);
		assertFalse(set.contains(asEntry(e[0])));
		assertTrue(set.contains(asEntry(e[1])));
		assertFalse(set.contains(asEntry(e[2])));
		assertTrue(set.contains(asEntry(e[3])));
		assertFalse(set.contains(asEntry(e[4])));
		assertTrue(set.contains(asEntry(e[5])));
		assertFalse(set.contains(asEntry(e[6])));
		assertTrue(set.contains(asEntry(e[7])));
		assertFalse(set.contains(asEntry(e[8])));
		assertTrue(set.contains(asEntry(e[9])));
		assertFalse(set.contains(asEntry(e[10])));	
		for (int i=0; i <= 10; ++i) {
			assertFalse("shouldn't contain modified e[" + i + "]",set.contains(e(e[i].getLocation(),not(e[i].getTerrain()))));
		}
	}
	
	public void testM59() {
		makeBigTree();
		for (int i=1; i <= 13; ++i) {
			assertTrue("should contain e[" + i + "]",set.contains(asEntry(e[i])));
			assertFalse("shouldn't contain modified e[" + i + "]",set.contains(e(e[i].getLocation(),not(e[i].getTerrain()))));			
		}
	}
	
	
	/// testM6X: testing clear and remove
	
	public void testM60() {
		assertFalse(set.remove(asEntry(e[0])));
		set.clear();
		assertEquals(0,hb.size());
	}
	
	public void testM61() {
		hb.add(e[1]);
		assertFalse(set.remove(asEntry(e[0])));
		assertTrue(set.remove(asEntry(e[1])));
		assertEquals(0,hb.size());
		assertFalse(set.remove(asEntry(e[1])));
	}
	
	public void testM62() {
		hb.add(e[2]);
		hb.add(e[3]);
		set.clear();
		assertEquals(0,hb.size());
	}
	
	public void testM63() {
		hb.add(e[4]);
		hb.add(e[5]);
		hb.add(e[6]);
		assertFalse(set.remove(null));
		assertFalse(set.remove(e[5]));
		assertFalse(set.remove(e(e[5].getLocation(),not(e[5].getTerrain()))));
		assertFalse(set.remove(e(e[5].getLocation(),null)));
		assertFalse(set.remove(e(null,e[5].getTerrain())));
		assertEquals(3,hb.size());
	}
	
	public void testM64() {
		hb.add(e[7]);
		hb.add(e[8]);
		hb.add(e[9]);
		hb.add(e[0]);
		assertFalse(set.remove(asEntry(e[3])));
		assertEquals(true,set.remove(asEntry(e[7])));
		assertNull(hb.terrainAt(e[7].getLocation()));
		assertEquals(true,set.remove(asEntry(e[8])));
		assertNull(hb.terrainAt(e[7].getLocation()));
		assertNull(hb.terrainAt(e[8].getLocation()));
		assertEquals(true,set.remove(asEntry(e[9])));
		assertNull(hb.terrainAt(e[7].getLocation()));
		assertNull(hb.terrainAt(e[8].getLocation()));
		assertNull(hb.terrainAt(e[9].getLocation()));
		assertEquals(true,set.remove(asEntry(e[0])));
		assertNull(hb.terrainAt(e[7].getLocation()));
		assertNull(hb.terrainAt(e[8].getLocation()));
		assertNull(hb.terrainAt(e[9].getLocation()));
		assertNull(hb.terrainAt(e[0].getLocation()));
		assertEquals(0,hb.size());
	}
	
	public void testM65() {
		hb.add(e[2]);
		// your code should not be checking for instanceof
		// AbstractEntry or DefaultEntry.
		Map<HexCoordinate,Terrain> m = new HashMap<>();
		m.put(e[4].getLocation(), e[4].getTerrain());
		Map.Entry<HexCoordinate, Terrain> entry = m.entrySet().iterator().next();
		hb.add(e[4]);
		assertTrue(set.remove(entry));
		assertEquals(1,set.size());
	}
	
	public void testM69() {
		for (int i=1; i < 10; ++i) {
			makeBigTree();
			assertTrue("should be able to remove e[" + i + "]",set.remove(asEntry(e[i])));
			for (int j=1; j <= 13; ++j) {
				assertEquals("after removing e[" + i + "] looking for e[" + j + "]",i!=j, set.contains(asEntry(e[j])));
			}
			set.clear();
		}
	}
	
	
	/// testM7X: testing entry set iterator without remove
	
	public void testM70() {
		assertFalse(set.iterator().hasNext());
	}
	
	public void testM71() {
		hb.add(e[3]);
		setit = set.iterator();
		assertTrue(setit.hasNext());
		assertEquals(asEntry(e[3]),setit.next());
		assertFalse(setit.hasNext());
	}
	
	public void testM72() {
		hb.add(e[4]);
		hb.add(e[5]);
		setit = set.iterator();
		assertEquals(asEntry(e[4]),setit.next());
		assertEquals(asEntry(e[5]),setit.next());
		assertException(NoSuchElementException.class,() -> setit.next());
	}
	
	public void testM73() {
		hb.add(e[5]);
		hb.add(e[1]);
		hb.add(e[3]);
		hb.add(e[9]);
		hb.add(e[7]);
		setit = set.iterator();
		assertTrue(setit.hasNext());
		assertEquals(asEntry(e[1]),setit.next());
		assertTrue(setit.hasNext());
		assertEquals(asEntry(e[3]),setit.next());
		assertTrue(setit.hasNext());
		assertEquals(asEntry(e[5]),setit.next());
		assertTrue(setit.hasNext());
		assertEquals(asEntry(e[7]),setit.next());
		assertTrue(setit.hasNext());
		assertEquals(asEntry(e[9]),setit.next());
		assertFalse(setit.hasNext());
	}
	
	public void testM74() {
		makeBigTree();
		setit = set.iterator();
		for (int i=1; i <= 13; ++i) {
			assertEquals(asEntry(e[i]),setit.next());
		}
		assertFalse(setit.hasNext());
	}
	
	public void testM75() {
		setit = set.iterator();
		set.clear();
		assertFalse(setit.hasNext());
	}
	
	public void testM76() {
		setit = set.iterator();
		hb.add(e[4]);
		assertException(ConcurrentModificationException.class,() -> setit.hasNext());
	}
	
	public void testM77() {
		makeBigTree();
		setit = set.iterator();
		set.clear();
		assertException(ConcurrentModificationException.class,() -> setit.hasNext());
	}
	
	public void testM78() {
		makeBigTree();
		setit = set.iterator();
		set.remove(asEntry(e[0]));
		assertEquals(asEntry(e[1]),setit.next());
		set.remove(asEntry(e[10]));
		assertException(ConcurrentModificationException.class,() -> setit.next());
	}
	
	public void testM79() {
		makeBigTree();
		setit = set.iterator();
		hb.remove(e[5]);
		assertException(ConcurrentModificationException.class,() -> setit.hasNext());
	}
	
	
	/// testM8X: testing iterators and remove
	
	public void testM80() {
		hb.add(e[0]);
		setit = set.iterator();
		setit.next();
		setit.remove();
		assertEquals(0,hb.size());
		assertFalse(setit.hasNext());
	}
	
	public void testM81() {
		hb.add(e[1]);
		hb.add(e[2]);
		setit = set.iterator();
		setit.next();
		setit.remove();
		assertEquals(1,hb.size());
		assertEquals(asEntry(e[2]),setit.next());
		assertTrue(hb.contains(e[2]));
	}
	
	public void testM82() {
		hb.add(e[3]);
		hb.add(e[4]);
		hb.add(e[5]);
		setit = set.iterator();
		setit.next();
		setit.next();
		setit.remove();
		assertEquals(2,map.size());
		assertTrue(setit.hasNext());
		assertEquals(asEntry(e[5]),setit.next());
		assertTrue(map.containsKey(e[3].getLocation()));
	}
	
	public void testM83() {
		hb.add(e[5]);
		hb.add(e[1]);
		hb.add(e[3]);
		hb.add(e[9]);
		hb.add(e[7]);
		setit = set.iterator();
		setit.next();
		setit.next();
		setit.next();
		setit.remove();
		assertEquals(asEntry(e[7]),setit.next());
		assertTrue(setit.hasNext());
		assertEquals(4,map.size());
	}
	
	public void testM84() {
		makeBigTree();
		setit = set.iterator();
		Iterator<?> other = set.iterator();
		other.next();
		other.next();
		other.remove();
		assertException(ConcurrentModificationException.class, () -> setit.hasNext());
	}
	
	public void testM85() {
		makeBigTree();
		setit = set.iterator();
		assertException(IllegalStateException.class, () -> setit.remove());
	}
	
	public void testM86() {
		makeBigTree();
		setit = set.iterator();
		setit.next();
		setit.next();
		setit.next();
		setit.remove();
		assertException(IllegalStateException.class,() -> setit.remove());
	}
	
	public void testM87() {
		makeBigTree();
		setit = set.iterator();
		setit.next();
		setit.next();
		setit.next();
		setit.remove();
		Iterator<?> other = hb.iterator();
		setit.next();
		setit.next();
		setit.remove();
		setit.next();
		assertException(ConcurrentModificationException.class, () -> other.hasNext());
	}
	
	public void testM88() {
		makeBigTree();
		setit = set.iterator();
		setit.next(); setit.remove();
		setit.next();
		setit.next(); setit.remove();
		setit.next(); setit.remove();
		setit.next(); setit.remove();
		setit.next();
		setit.next(); setit.remove();
		setit.next(); setit.remove();
		setit.next(); setit.remove();
		setit.next();
		setit.next(); setit.remove();
		setit.next(); setit.remove();
		setit.next(); setit.remove();
		assertFalse(setit.hasNext());
	}

	public void testM89() {
		setit = set.iterator();
		assertException(IllegalStateException.class, () -> setit.remove());
	}
	
	
	/// testM9X: testing entry methods
	
	public void testM90() {
		hb.add(e[0]);
		setit = set.iterator();
		Map.Entry<?,?> entry = setit.next();
		assertTrue(entry.equals(asEntry(e[0])));
		assertFalse(entry.equals(e(e[0].getLocation(),not(e[0].getTerrain()))));
		assertFalse(entry.equals(e(null,e[0].getTerrain())));
		assertFalse(entry.equals(e(e[0].getLocation(),null)));
		assertFalse(entry.equals(e(e[0].getLocation().toString(),e[0].getTerrain().toString())));
		assertFalse(entry.equals(null));
	}
	
	public void testM91() {
		hb.add(e[1]);
		setit = set.iterator();
		Map.Entry<?,?> entry = setit.next();
		assertEquals(e[1].getLocation(),entry.getKey());
	}
	
	public void testM92() {
		hb.add(e[2]);
		hb.add(e[3]);
		setit = set.iterator();
		Map.Entry<?,?> entry = setit.next();
		assertEquals(e[2].getTerrain(),entry.getValue());
	}
	
	public void testM93() {
		hb.add(e[5]);
		hb.add(e[4]);
		hb.add(e[6]);
		setit = set.iterator();
		Map.Entry<HexCoordinate,Terrain> entry = setit.next();
		assertEquals(e[4].getTerrain(),entry.setValue(Terrain.LAND));
	}
	
	public void testM94() {
		hb.add(e[7]);
		hb.add(e[8]);
		hb.add(e[9]);
		setit = set.iterator();
		Map.Entry<HexCoordinate,Terrain> entry = setit.next();
		entry.setValue(Terrain.WATER);
		assertFalse(hb.contains(e[7]));
		assertEquals(Terrain.WATER,hb.terrainAt(e[7].getLocation()));
	}
	
	public void testM95() {
		makeBigTree();
		setit = set.iterator();
		setit.next();
		setit.next();
		Map.Entry<HexCoordinate,Terrain> entry = setit.next();
		// setValue doesn't make iterators stale!
		entry.setValue(Terrain.CITY);
		assertEquals(asEntry(e[4]),setit.next());
	}
	
	public void testM96() {
		makeBigTree();
		setit = set.iterator();
		Iterator<?> other = set.iterator();
		Map.Entry<HexCoordinate,Terrain> entry = setit.next();
		entry.setValue(Terrain.FOREST);
		assertEquals(e(e[1].getLocation(),Terrain.FOREST),other.next());
	}
	
	public void testM97() {
		makeBigTree();
		setit = set.iterator();
		assertEquals("<1,0,1>=LAND",setit.next().toString());
	}
	
	public void testM98() {
		makeBigTree();
		setit = set.iterator();
		Map.Entry<?,?> entry = setit.next();
		assertException(IllegalArgumentException.class, () -> entry.setValue(null));
	}
	
	
	
	//// testRNN: testing rows
	
	
	/// testR0X: testing row isEmpty 
	
	public void testR00() {
		row = hb.row(3);
		assertTrue(row.isEmpty());
	}
	
	public void testR01() {
		hb.add(e[1]); // e[1].getLocation() = <1,0,1>
		assertTrue(hb.row(1).isEmpty());
		assertFalse(hb.row(0).isEmpty());
		assertTrue(hb.row(-1).isEmpty());
	}
	
	public void testR02() {
		hb.add(e[2]); // WATER<2,0,2>
		hb.add(e[3]); // FOREST<3,1,2>
		assertFalse(hb.row(0).isEmpty());
		assertFalse(hb.row(1).isEmpty());
		assertTrue(hb.row(2).isEmpty());
	}
	
	public void testR03() {
		map.put(h(2,-1),Terrain.CITY);
		map.put(h(4,-1),Terrain.WATER);
		assertFalse(hb.row(-1).isEmpty());
		assertTrue(hb.row(0).isEmpty());
	}
	
	public void testR09() {
		makeBigTree();
		map.put(h(16,12),Terrain.CITY);
		map.put(h(10,10),Terrain.WATER);
		assertTrue(hb.row(-1).isEmpty());
		assertFalse(hb.row(0).isEmpty());
		assertFalse(hb.row(1).isEmpty());
		assertFalse(hb.row(2).isEmpty());
		assertFalse(hb.row(3).isEmpty());
		assertFalse(hb.row(4).isEmpty());
		assertFalse(hb.row(5).isEmpty());
		assertFalse(hb.row(6).isEmpty());
		assertFalse(hb.row(7).isEmpty());
		assertTrue(hb.row(8).isEmpty());
		assertTrue(hb.row(9).isEmpty());
		assertFalse(hb.row(10).isEmpty());
		assertTrue(hb.row(11).isEmpty());
		assertFalse(hb.row(12).isEmpty());
	}
	
	
	/// testR1X: testing row size
	
	public void testR10() {
		row = hb.row(1);
		assertEquals(0,row.size());
	}
	
	public void testR11() {
		hb.add(e[4]); // MOUNTAIN<4,2,2>
		assertEquals(0,hb.row(0).size());
		assertEquals(0,hb.row(1).size());
		assertEquals(1,hb.row(2).size());
		assertEquals(0,hb.row(3).size());
	}
	
	public void testR12() {
		hb.add(e[5]); // DESERT<5,3,2>
		hb.add(e[6]); // CITY<6,3,3>
		assertEquals(0,hb.row(2).size());
		assertEquals(2,hb.row(3).size());
		assertEquals(0,hb.row(4).size());
	}
	
	public void testR13() {
		hb.add(e[3]); // FOREST<3,1,0>
		hb.add(e[7]); // LAND<7,3,4>
		hb.add(e[8]); // WATER<8,4,4>
		assertEquals(0,hb.row(0).size());
		assertEquals(1,hb.row(1).size());
		assertEquals(0,hb.row(2).size());
		assertEquals(1,hb.row(3).size());
		assertEquals(1,hb.row(4).size());
	}
	
	public void testR14() {
		map.put(h(0,5),Terrain.CITY);
		map.put(h(908,5),Terrain.CITY);
		map.put(h(-3058,5),Terrain.CITY);
		map.put(h(-100007,6),Terrain.CITY);
		assertEquals(0,hb.row(4).size());
		assertEquals(3,hb.row(5).size());
		assertEquals(1,hb.row(6).size());
	}
	
	public void testR17() {
		// example from Q&A page for Homework #8
		map.put(h(4,2),Terrain.LAND);
		map.put(h(3,1),Terrain.LAND);
		map.put(h(5,3),Terrain.LAND);
		map.put(h(5,0),Terrain.LAND);
		map.put(h(2,2),Terrain.LAND);
		map.put(h(6,2),Terrain.LAND);
		map.put(h(10,3),Terrain.LAND);
		map.put(h(5,1),Terrain.LAND);
		map.put(h(3,3),Terrain.LAND);
		map.put(h(7,1),Terrain.LAND);
		map.put(h(0,2),Terrain.LAND);
		map.put(h(10,1),Terrain.LAND);
		assertEquals(1,hb.row(0).size());
		assertEquals(4,hb.row(1).size());
		assertEquals(4,hb.row(2).size());
		assertEquals(3,hb.row(3).size());
	}
	
	public void testR18() {
		makeBigTree();
		assertEquals(2,hb.row(0).size());
		assertEquals(1,hb.row(1).size());
		assertEquals(1,hb.row(2).size());
		assertEquals(3,hb.row(3).size());
		assertEquals(2,hb.row(4).size());
		assertEquals(1,hb.row(5).size());
		assertEquals(2,hb.row(6).size());
		assertEquals(1,hb.row(7).size());
		assertEquals(0,hb.row(8).size());
		assertEquals(0,hb.row(-1).size());
	}
	
	public void testR19() {
		int[] permute = { 8, 3, 1, 7, 4, 5, 0, 9, 6, 2 }; 
		for (int a = 0; a < 10; ++a) {
			for (int b= 0; b < 10; ++b) {
				map.put(h(permute[a],permute[b]),Terrain.INACCESSIBLE);
			}
		}
		for (int b = 0; b < 10; ++b) {
			assertEquals(10,hb.row(b).size());
		}
	}
	
	
	/// testR2X: testing row contains
	
	public void testR20() {
		row = hb.row(2);
		assertFalse(row.contains(e[0]));
	}
	
	public void testR21() {
		hb.add(e[1]);
		assertTrue(hb.row(0).contains(e[1]));
		assertFalse(hb.row(1).contains(e[1]));
		assertFalse(hb.row(0).contains(e[0]));
	}
	
	public void testR22() {
		hb.add(e[2]); // WATER<2,0,2>
		hb.add(e[3]); // FOREST<3,1,2>
		assertTrue(hb.row(0).contains(e[2]));
		assertTrue(hb.row(1).contains(e[3]));
		assertFalse(hb.row(0).contains(e[3]));
		assertFalse(hb.row(1).contains(e[2]));
	}
	
	public void testR23() {
		hb.add(e[4]); // MOUNTAIN<4,2,2>
		hb.add(e[5]); // DESERT<5,3,2>
		hb.add(e[6]); // CITY<6,3,3>
		assertFalse(hb.row(3).contains(new HexTile(Terrain.CITY,h(5,3))));
	}
	
	public void testR24() {
		hb.add(e[7]);
		hb.add(e[9]);
		hb.add(e[0]);
		hb.add(e[8]);
		assertFalse(hb.row(4).contains(null));
		assertFalse(hb.row(4).contains(e[8].toString()));
		assertFalse(hb.row(4).contains(asEntry(e[7])));
		assertFalse(hb.row(4).contains(Terrain.WATER));
		assertFalse(hb.row(4).contains(hb.row(4)));
	}
	
	public void testR28() {
		makeBigTree();
		int[] row = { -99, 0, 0, 1, 2, 3, 3, 3, 4, 4, 5, 6, 6, 7 };
		for (int i=0; i <= 13; ++i) {
			for (int r = 0; r < 10; ++r) {
				if (row[i] == r) {
					assertTrue("e[" + i + "]=" + e[i] + " should be in row(" + r + ")",
							hb.row(r).contains(e[i]));
				} else {
					assertFalse("e[" + i + "]=" + e[i] + " should NOT be in row(" + r + ")",
							hb.row(r).contains(e[i]));
				}
			}
		}
	}
	
	
	/// testR3X: testing add
	
	public void testR30() {
		row = hb.row(0);
		assertTrue(row.add(e[0]));
		assertEquals(1,hb.size());
	}
	
	public void testR31() {
		row = hb.row(1);
		assertException(IllegalArgumentException.class,() -> row.add(e[1]));
	}
	
	public void testR32() {
		row = hb.row(2);
		row.add(e[4]);
		assertFalse(row.add(e[4]));
	}
	
	public void testR33() {
		row = hb.row(3);
		row.add(e[5]);
		assertTrue(row.add(e[6]));
	}
	
	public void testR34() {
		row = hb.row(4);
		row.add(e[8]);
		assertException(IllegalArgumentException.class, () -> row.add(e[7]));
	}
	
	public void testR35() {
		row = hb.row(5);
		row.add(e[10]);
		assertTrue(row.add(new HexTile(e[9].getTerrain(),e[10].getLocation())));
	}
	
	public void testR36() {
		hb.add(e[8]);
		row  = hb.row(3);
		row.add(e[6]);
		assertTrue(row.add(e[7]));
		assertEquals(3,hb.size());
	}
	
	public void testR37() {
		hb.add(e[0]);
		row = hb.row(0);
		row.add(e[1]);
		row.add(e[2]);
		assertTrue(row.add(new HexTile(not(e[0].getTerrain()),e[0].getLocation())));
		assertEquals(3,hb.size());
	}
	
	public void testR38() {
		makeBigTree();
		row = hb.row(2);
		assertTrue(row.add(new HexTile(Terrain.WATER,h(2,2))));
	}
	
	public void testR39() {
		makeBigTree();
		row = hb.row(3);
		assertException(IllegalArgumentException.class,() -> row.add(null));
	}
	
	
	/// testR4X: testing row remove & clear
	
	public void testR40() {
		assertFalse(hb.row(1).remove(e[3]));
	}
	
	public void testR41() {
		hb.add(e[1]);
		assertFalse(hb.row(0).remove(e[0]));
		assertTrue(hb.row(0).remove(e[1]));
	}
	
	public void testR42() {
		hb.add(e[2]);
		hb.add(e[3]);
		assertFalse(hb.row(1).remove(e[2]));
		assertFalse(hb.row(0).remove(e[3]));
	}
	
	public void testR43() {
		hb.add(e[5]);
		hb.add(e[4]);
		hb.add(e[6]);
		assertTrue(hb.row(3).remove(e[6]));
		assertEquals(2,hb.size());
	}
	
	public void testR44() {
		hb.add(e[7]);
		hb.add(e[8]);
		hb.add(e[0]);
		hb.add(e[4]);
		assertFalse(hb.row(4).remove(e[9]));
		assertTrue(hb.row(4).remove(e[8]));
		assertEquals(3,hb.size());
	}
	
	public void testR45() {
		hb.add(e[5]);
		hb.add(e[4]);
		hb.add(e[10]);
		hb.add(e[7]);
		hb.add(e[0]);
		assertFalse(hb.row(5).remove(e[10].toString()));
		assertFalse(hb.row(5).remove(null));
		assertFalse(hb.row(5).remove(hb.row(5)));
	}
	
	public void testR46() {
		hb.add(e[4]);
		hb.row(2).clear();
		assertEquals(0,hb.size());
	}
	
	public void testR47() {
		hb.add(e[7]);
		it = hb.iterator();
		hb.row(2).clear();
		assertEquals(1,hb.size());
		assertEquals(e[7],it.next()); // nothing changed, so iterator isn't stale
	}
	
	public void testR48() {
		hb.add(e[6]);
		hb.add(e[12]);
		hb.row(6).clear();
		assertEquals(1,hb.size());
	}
	
	public void testR49() {
		makeBigTree();
		hb.row(0).clear();
		hb.row(4).clear();
		hb.row(10).clear();
		assertEquals(9,hb.size());
	}
	
	
	/// testR5X: testing row iterators (without remove)
	
	public void testR50() {
		row = hb.row(0);
		it = row.iterator();
		assertFalse(it.hasNext());
	}
	
	public void testR51() {
		row = hb.row(1);
		hb.add(e[1]);
		hb.add(e[5]);
		it = row.iterator();
		assertFalse(it.hasNext());
	}
	
	public void testR52() {
		row = hb.row(2);
		hb.add(e[5]);
		hb.add(e[6]);
		it = row.iterator();
		assertFalse(it.hasNext());
	}
	
	public void testR53() {
		row = hb.row(3);
		hb.add(e[8]);
		hb.add(e[7]);
		hb.add(e[9]);
		it = row.iterator();
		assertTrue(it.hasNext());
		assertEquals(e[7],it.next());
		assertFalse(it.hasNext());
	}
	
	public void testR54() {
		row = hb.row(4);
		hb.add(e[9]);
		hb.add(e[6]);
		hb.add(e[8]);
		hb.add(e[1]);
		it = row.iterator();
		assertEquals(e[8],it.next());
		assertEquals(e[9],it.next());
		assertFalse(it.hasNext());
	}
	
	public void testR55() {
		makeBigTree();
		hb.add(e[0]);
		it = hb.row(0).iterator();
		assertEquals(e[0],it.next());
		assertEquals(e[1],it.next());
		assertEquals(e[2],it.next());
		assertException(NoSuchElementException.class,() -> it.next());
	}
	
	public void testR56() {
		makeBigTree();
		hb.add(new HexTile(Terrain.WATER,h(4,-2)));
		hb.remove(e[3]);
		it = hb.row(-1).iterator();
		assertFalse(it.hasNext());
		it = hb.row(1).iterator();
		assertFalse(it.hasNext());
		it = hb.row(10).iterator();
		assertFalse(it.hasNext());
		it = hb.row(-3).iterator();
		assertFalse(it.hasNext());
	}
	
	public void testR57() {
		row = hb.row(3);
		makeBigTree();
		it = row.iterator();
		assertEquals(e[5],it.next());
		assertEquals(e[6],it.next());
		assertEquals(e[7],it.next());
	}
	
	public void testR58() {
		makeBigTree();
		it = hb.row(6).iterator();
		hb.remove(e[2]);
		assertException(ConcurrentModificationException.class,() -> it.next());
	}
	
	public void testR59() {
		makeBigTree();
		it = hb.row(10).iterator();
		hb.remove(e[10]);
		assertException(ConcurrentModificationException.class,() -> it.hasNext());
	}
	
	
	/// testR6X: testing row iterator remove
	
	public void testR60() {
		it = hb.row(0).iterator();
		assertException(IllegalStateException.class,() -> it.remove());
	}
	
	public void testR61() {
		hb.add(e[1]);
		it = hb.row(0).iterator();
		it.next();
		it.remove();
		assertEquals(0,hb.size());
		assertFalse(it.hasNext());
	}
	
	public void testR62() {
		hb.add(e[2]);
		hb.add(e[3]);
		it = hb.row(0).iterator();
		it.next();
		it.remove();
		assertException(IllegalStateException.class, () -> it.remove());
	}
	
	public void testR63() {
		hb.add(e[5]);
		hb.add(e[4]);
		hb.add(e[6]);
		it = hb.row(3).iterator();
		it.next();
		it.remove();
		assertFalse(hb.contains(e[5]));
		it.next();
		it.remove();
		assertFalse(hb.contains(e[6]));
		assertEquals(1,hb.size());
		assertFalse(it.hasNext());
	}
	
	public void testR64() {
		hb.add(e[8]);
		hb.add(e[7]);
		hb.add(e[0]);
		hb.add(e[10]);
		it = hb.row(4).iterator();
		it.next();
		it.remove();
		assertFalse(it.hasNext());
	}
	
	public void testR65() {
		makeBigTree();
		it = hb.row(3).iterator();
		it.next();
		it.remove();
		it.next();
		it.next();
		it.remove();
		assertEquals(11,hb.size());
		assertTrue(hb.contains(e[6]));
		assertFalse(it.hasNext());
	}
	
	public void testR66() {
		makeBigTree();
		it = hb.row(0).iterator();
		Iterator<?> it2 = hb.row(4).iterator();
		assertEquals(e[8],it2.next());
		assertTrue(it.hasNext());
		it2.remove();
		assertException(ConcurrentModificationException.class,() -> it.next());
		assertEquals(e[9],it2.next());
	}
	
	public void testR67() {
		makeBigTree();
		it = hb.row(1).iterator();
		Iterator<?> it2 = hb.row(5).iterator();
		assertEquals(e[3],it.next());
		assertEquals(e[10],it2.next());
		it.remove();
		assertException(ConcurrentModificationException.class, () -> it2.remove());
	}
	
	public void testR68() {
		makeBigTree();
		it = hb.row(10).iterator();
		Iterator<?> it2 = hb.row(2).iterator();
		assertEquals(e[4],it2.next());
		it2.remove();
		assertException(ConcurrentModificationException.class, () -> it.remove());
	}
	
	public void testR69() {
		makeBigTree();
		it = hb.row(3).iterator();
		Iterator<?> it2 = hb.row(4).iterator();
		it.next();
		it2.next();
		it.remove();
		it2 = hb.row(4).iterator();
		assertEquals(e[8],it2.next());
		it2.remove();
		assertException(ConcurrentModificationException.class, () -> it.remove());
	}
}
