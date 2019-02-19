import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.IntFunction;
import java.util.function.Supplier;

import junit.framework.TestCase;
import edu.uwm.cs351.HexBoard;
import edu.uwm.cs351.HexCoordinate;
import edu.uwm.cs351.HexTile;
import edu.uwm.cs351.Piece;
import edu.uwm.cs351.Rank;
import edu.uwm.cs351.Team;
import edu.uwm.cs351.Terrain;


public class TestEfficiency extends TestCase {
	Collection<HexTile> hb;
	Collection<Piece> pc;
	Random r;
	
	@Override
	public void setUp() {
		hb = new HexBoard();
		pc = new Piece.Collection();
		r = new Random();
		try {
			assert r.nextInt(hb.size()) == 42;
			assertTrue(true);
		} catch (IllegalArgumentException ex) {
			System.err.println("You must disable assertions to run this test.");
			System.err.println("Go to Run > Run Configurations. Select the 'Arguments' tab");
			System.err.println("Then remove '-ea' from the VM Arguments box.");
			assertFalse("Assertions must NOT be enabled while running efficiency tests.",true);
		}
	}

	protected final Terrain[] terrains = Terrain.values();
	private static final int MAX_A = 128;
	
	protected HexTile makeHexTile(int i) {
		int t = i % terrains.length;
		// i /= terrains.length; (HexBoard cannot have two terrains on same coord
		int a = i % MAX_A;
		i /= MAX_A;
		return new HexTile(terrains[t],new HexCoordinate(a,i));
	}
	
	protected final Team[] teams = Team.values();
	protected final Rank[] ranks = Rank.values();
	
	protected Piece makePiece(int i) {
		int t = i % teams.length;
		i /= teams.length;
		int r = i % ranks.length;
		i /= ranks.length;
		return new Piece(teams[t], ranks[r]);
	}
	
	
	private static final int MAX_LENGTH = 1000000;
	private static final int SAMPLE = 100;
	
	protected <T> void testLong(Collection<T> col, IntFunction<T> maker, boolean preservesOrder) {
		int sampleIndices[] = new int[SAMPLE];
		Object samples[] = new Object[SAMPLE];

		int j = 0;
		int sam = r.nextInt(MAX_LENGTH/SAMPLE);
		for (int i=0; i < MAX_LENGTH; ++i) {
			T obj = maker.apply(i);
			if (i == sam) {
				sampleIndices[j] = i;
				samples[j] = obj;
				++j;
				if (j < SAMPLE) sam += 1 + r.nextInt((MAX_LENGTH-i)/(SAMPLE-j));
			}
			col.add(obj);
		}

		Iterator<T> it = col.iterator();
		int sum = 0;
		for (j=0; j < SAMPLE; ++j) {
			int n = sampleIndices[j] - sum;
			Object obj = null;
			for (int i=0; i < n; ++i) {
				it.next();
			}
			obj = it.next();
			sum += n;
			++sum;
			if (preservesOrder) assertEquals(samples[j],obj);
		}
	}
	
	public void testALLong() {
		testLong(new ArrayList<Integer>(), (i) -> i, true);
	}
	
	public void testHBLong() {
		testLong(hb,(i) -> makeHexTile(i),false);
		hb.clear();
	}
	
	public void testPCLong() {
		testLong(pc, (i) -> makePiece(i),true);
		pc.clear();
	}

	
	private static final int MAX_WIDTH = 100000;

	protected <T> void testWide(Supplier<Collection<T>> makeCol, IntFunction<T> maker) {
		Collection<?>[] a = new Collection<?>[MAX_WIDTH];
		List<?>[] b = new List<?>[MAX_WIDTH];
		Collection<T> col;
		List<T> colp;
		
		for (int i=0; i < MAX_WIDTH; ++i) {
			int n = r.nextInt(SAMPLE);
			a[i] = col = makeCol.get();
			b[i] = colp = new ArrayList<>(n);
			for (int j=0; j < n; ++j) {
				T obj = maker.apply(j);
				col.add(obj);
				colp.add(obj);
			}
		}
		
		for (int j = 0; j < SAMPLE; ++j) {
			int i = r.nextInt(a.length);
			Collection<?> c = a[i];
			List<?> cp = b[i];
			if (c.size() == 0) continue;
			int n = r.nextInt(c.size());
			Iterator<?> it = c.iterator();
			for (int k=0; k < n; ++k) {
				it.next();
			}
			assertEquals(cp.get(n),it.next());
		}
	}
	
	public void testHBWide() {
		testWide(() -> new HexBoard(), (i) -> makeHexTile(i));
	}
	
	public void testPCWide() {
		testWide(() -> new Piece.Collection(), (i) -> makePiece(i));
	}
	

	protected <T> void testStochastic(Supplier<Collection<T>> makeCol, IntFunction<T> maker) {
		List<Collection<T>> ss = new ArrayList<>();
		Collection<T> col = makeCol.get();
		ss.add(col);
		int max = 1;
		for (int i=0; i < MAX_LENGTH; ++i) {
			if (r.nextBoolean()) {
				col = makeCol.get();
				col.add(maker.apply(i));
				ss.add(col);
			} else {
				col.addAll(new ArrayList<>(col)); // double size of s
				if (col.size() > max) {
					max = col.size();
					// System.out.println("Reached " + max);
				}
			}
		}
	}
	
	public void testHBStochastic() {
		testStochastic(() -> new HexBoard(), (i) -> makeHexTile(i));
	}
	
	// PC cannot do stochastic because of no duplicates.

	
	protected <T> void testMiddle(Collection<T> col, IntFunction<T> maker) {
		// this would be too slow with dynamic arrays
		for (int i=0; i < MAX_LENGTH; ++i) {
			col.add(maker.apply(i));
		}
		
		Iterator<T> it = col.iterator();
		int removed = 0;
		for (int i=0; i < MAX_LENGTH; ++i) {
			it.next();
			if (r.nextBoolean()) {
				it.remove();
				++removed;
			}
		}
		
		assertEquals(MAX_LENGTH-removed,col.size());
	}
	
	public void testHBMiddle() {
		testMiddle(hb,(i) -> makeHexTile(i));
		hb.clear();
	}
	
	public void testPCMiddle() {
		testMiddle(pc, (i) -> makePiece(i));
		pc.clear();
	}
	
	protected <T> void testContains(Collection<T> col, IntFunction<T> maker) {
		ArrayList<T> samples = new ArrayList<>();
		for (int i=0; i < MAX_LENGTH; ++i) {
			T obj = maker.apply(i);
			samples.add(obj);
			col.add(obj);
		}
		for (T obj : samples) {
			assertTrue(col.contains(obj));
		}
	}
	
	public void testHBContains() {
		testContains(hb,(i)->makeHexTile(i));
		hb.clear();
	}
	
	// currently there's no way to check contains efficiently for Piece.Collection
	
	protected <T> void testRemove(Collection<T> col, IntFunction<T> maker) {
		ArrayList<T> samples = new ArrayList<>();
		for (int i=0; i < MAX_LENGTH; ++i) {
			T obj = maker.apply(i);
			if ((i & 1) == 0) samples.add(obj);
			col.add(obj);
		}
		for (T obj : samples) {
			assertTrue(col.remove(obj));
		}
		assertEquals(MAX_LENGTH-samples.size(),col.size());
	}
	
	public void testHBRemove() {
		testRemove(hb,(i)->makeHexTile(i));
		hb.clear();
	}
}
