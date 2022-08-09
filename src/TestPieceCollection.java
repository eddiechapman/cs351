import java.util.ConcurrentModificationException;
import java.util.Iterator;

import edu.uwm.cs351.Piece;
import edu.uwm.cs351.Rank;
import edu.uwm.cs351.Team;


public class TestPieceCollection extends TestCollection<Piece> {

	private Piece.Collection pc;
	
	@Override
	protected void initCollections() {
		c = pc = new Piece.Collection();
		e = new Piece[]{
				new Piece(Team.RED,Rank.BOAT),
				new Piece(Team.BLUE,Rank.BOAT),
				new Piece(Team.GREEN,Rank.FOOT),
				new Piece(Team.RED,Rank.HORSE),
				new Piece(Team.BLUE,Rank.CAR),
				new Piece(Team.GREEN,Rank.TANK),
				new Piece(Team.RED,Rank.BOAT),
				new Piece(Team.BLUE,Rank.FOOT),
				new Piece(Team.GREEN,Rank.HORSE),
				new Piece(Team.RED,Rank.CAR)};
		permitNulls = false;
		permitDuplicates = false;
		failFast = true;
		preserveOrder = true;
	}

	
	/// Locked Tests
	
	public void test() {
		// pc is empty
		Piece rf1 = new Piece(Team.RED, Rank.FOOT);
		Piece rf2 = new Piece(Team.RED, Rank.FOOT);
		// return is true/false/name of exception
		assertEquals(Ts(330480954),toString(() -> pc.add(rf1)));
		// add it again ?
		assertEquals(Ts(434214267),toString(() -> pc.add(rf1)));
		// add it to a different piece collection?
		assertEquals(Ts(1764796602),toString(() -> new Piece.Collection().add(rf1)));
		// add something that looks the same?
		assertEquals(Ts(1442026135),toString(() -> pc.add(rf2)));
		// can we add null?  If not, which exception?
		assertEquals(Ts(1928879295),toString(() -> pc.add(null)));
		assertEquals(Ti(479813527),pc.size());
		testMore(pc);
	}
	
	private void testMore(Piece.Collection pc) {
		pc.clear();
		assertEquals(0,pc.size());
		Piece rf1 = new Piece(Team.RED, Rank.FOOT);
		Piece rf2 = new Piece(Team.RED, Rank.FOOT);
		pc.add(rf1);
		final Iterator<Piece> it = pc.iterator();
		// does equals return true or false, or does the whole thing throw an exception?
		assertEquals(Ts(263759869),toString(() -> rf2.equals(it.next())));
		// and again?
		assertEquals(Ts(636855615),toString(() -> rf2.equals(it.next())));
		final Iterator<Piece> it2 = pc.iterator(); // new iterator
		// does it return the same hex tile or generate a new one?
		assertEquals(Ts(48303607),toString(() -> rf1 == it2.next()));
	}

	
	/// Spot checks
	
	public void testN() {
		assertException(NullPointerException.class,() -> c.add(null));
	}
	
	public void testO() {
		c.add(e[0]);
		assertException(IllegalArgumentException.class,() -> c.add(e[0]));
	}
	
	public void testP() {
		c.add(e[1]);
		it = c.iterator();
		it.next();
		assertTrue(c.remove(e[1]));
		assertException(ConcurrentModificationException.class, () -> it.hasNext());
	}
	
	public void testQ() {
		pc = new Piece.Collection();
		pc.add(e[3]);
		assertException(IllegalArgumentException.class, () -> c.add(e[3]));
	}
	
	public void testR() {
		pc = new Piece.Collection();
		pc.add(e[4]);
		pc.clear();
		assertTrue(c.add(e[4]));
	}
	
	public void testS() {
		pc = new Piece.Collection();
		pc.add(e[6]);
		pc.add(e[7]);
		it = pc.iterator();
		it.next();
		it.remove();
		assertTrue(c.add(e[6]));
	}
	
	public void testT() {
		c.add(e[0]);
		c.add(e[6]);
		assertEquals(2,c.size());
		c.remove(e[0]);
		it = c.iterator();
		assertEquals(e[6],it.next());
	}
	
	public void testU() {
		c.add(e[0]);
		c.add(e[6]);
		assertEquals(2,c.size());
		c.remove(e[0]);
		assertTrue(c.add(e[0]));
	}
	
	public void testV() {
		c.add(e[1]);
		c.add(e[2]);
		c.clear();
		assertTrue(c.add(e[2]));
	}
	
	public void testW() {
		c.add(e[3]);
		it = pc.iterator();
		c.add(e[4]);
		assertTrue(c.remove(e[3]));
		assertException(ConcurrentModificationException.class,() -> it.hasNext());
	}
	
	public void testX() {
		c.add(e[5]);
		it = c.iterator();
		c.clear();
		c.add(e[6]);
		assertException(ConcurrentModificationException.class,() -> it.hasNext());		
	}
}
