import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import junit.framework.TestCase;
import edu.uwm.cs351.HexCoordinate;
import edu.uwm.cs351.HexTile;
import edu.uwm.cs351.Sequence;
import edu.uwm.cs351.Terrain;


public class TestEfficiency extends TestCase {

	HexTile p1 = new HexTile(Terrain.MOUNTAIN, new HexCoordinate(0,0));
	HexTile p2 = new HexTile(Terrain.WATER, new HexCoordinate(1,0));
	HexTile p3 = new HexTile(Terrain.FOREST, new HexCoordinate(1,1));
	HexTile p4 = new HexTile(Terrain.DESERT, new HexCoordinate(0,-1));
	HexTile p5 = new HexTile(Terrain.CITY, new HexCoordinate(0,1));
	HexTile p6 = new HexTile(Terrain.LAND, new HexCoordinate(2,2));
	HexTile p7 = new HexTile(Terrain.LAND, new HexCoordinate(2,1));
	HexTile p8 = new HexTile(Terrain.INACCESSIBLE, new HexCoordinate(2,0));

	HexTile p[] = {null, p1, p2, p3, p4, p5, p6, p7, p8};
	
	Sequence<HexTile> s;
	Random r;
	
	@Override
	public void setUp() {
		s = new Sequence<HexTile>();
		r = new Random();
		try {
			assert 1/(int)(p5.getLocation().a()) == 42 : "OK";
			assertTrue(true);
		} catch (ArithmeticException ex) {
			System.err.println("Assertions must NOT be enabled to use this test suite.");
			System.err.println("In Eclipse: remove -ea from the VM Arguments box under Run>Run Configurations>Arguments");
			assertFalse("Assertions must NOT be enabled while running efficiency tests.",true);
		}
	}

	private static final int MAX_LENGTH = 1000000;
	private static final int SAMPLE = 100;
	
	public void testLong() {
		for (int i=0; i < MAX_LENGTH; ++i) {
			s.addAfter(p[i%6]);
			s.advance();
		}
		
		int sum = 0;
		s.start();
		for (int j=0; j < SAMPLE; ++j) {
			int n = r.nextInt(MAX_LENGTH/SAMPLE);
			for (int i=0; i < n; ++i) {
				s.advance();
			}
			sum += n;
			assertSame(p[sum%6],s.getCurrent());
		}
	}
	
	private static final int MAX_WIDTH = 30000;
	
	@SuppressWarnings("unchecked")
	public void testWide() {
		Sequence<HexTile>[] a = new Sequence[MAX_WIDTH];
		for (int i=0; i < MAX_WIDTH; ++i) {
			a[i] = s = new Sequence<HexTile>();
			int n = r.nextInt(SAMPLE);
			for (int j=0; j < n; ++j) {
				s.addAfter(p[j%6]);
				s.advance();
			}
		}
		
		for (int j = 0; j < SAMPLE; ++j) {
			int i = r.nextInt(a.length);
			s = a[i];
			if (s.size() == 0) continue;
			int n = r.nextInt(s.size());
			s.start();
			for (int k=0; k < n; ++k) {
				s.advance();
			}
			assertSame(p[n%6],s.getCurrent());
		}
	}
	
	public void testStochastic() {
		List<Sequence<HexTile>> ss = new ArrayList<>();
		ss.add(s);
		int max = 1;
		for (int i=0; i < MAX_LENGTH; ++i) {
			if (r.nextBoolean()) {
				s = new Sequence<HexTile>();
				s.addBefore(p3);
				ss.add(s);
			} else {
				s.addAll(s); // double size of s
				if (s.size() > max) {
					max = s.size();
					// System.out.println("Reached " + max);
				}
			}
		}
	}
	
	public void testInsert() {
		Sequence<HexTile> s = new Sequence<HexTile>();
		for (int i=0; i < MAX_LENGTH; ++i) {
			HexTile h = p[i % 9];
			if (r.nextBoolean()) {
				s.addBefore(h);
			} else {
				s.addAfter(h);
			}
		}
		assertEquals(MAX_LENGTH,s.size());
	}
	
	public void testUnsort() {
		Sequence<HexTile> s = new Sequence<HexTile>();
		for (int i=0; i < MAX_LENGTH; ++i) {
			HexTile h = p[i % 9];
			if (r.nextBoolean()) {
				s.addBefore(h);
			} else {
				s.addAfter(h);
			}
		}
		s.sort((a,b) -> 0);
		assertEquals(MAX_LENGTH,s.size());
	}
	
	public void testSort() {
		Sequence<Integer> s = new Sequence<>();
		int impurity = r.nextInt(MAX_LENGTH);
		for (int i=0; i < MAX_LENGTH; ++i) {
			if (i == impurity) s.addAfter(-1);
			else s.addAfter(i);
		}
		s.sort((a,b) -> a-b);
		s.start();
		assertEquals(-1,s.getCurrent().intValue());
	}
}
