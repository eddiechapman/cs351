package edu.uwm.cs351;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import junit.framework.TestCase;


/**
 * <p>An immutable class that represents a path on a HexBoard.</p>
 * 
 * <p>We represent paths in a way that permit efficient "growing" of 
 * paths at the end; each path is either an initial path, ending at the 
 * same place it starts, or is an extension of a shorter path.</p>
 * 
 * <p>This class is <i>immutable</i> which means that once created, none 
 * of the fields can change.  As a result, we don't need to check the 
 * invariant after checking it in the constructor.</p>
 */
public class HexPath {
	private final HexPath previous;
	private final HexCoordinate last;
	private final int size;
	
	private static boolean doReport = true;
	
	private boolean report(String s) {
		if (doReport) System.err.println("Invariant error: " + s);
		else System.out.println("Caught invariant error: " + s);
		return false;
	}
	
	/**
	 * Check the invariant of the ADT.
	 * <p>
	 * Since the class is immutable, we only need to check the invariant 
	 * at the end of the constructor.
	 * <ol>
	 * <li>The last location is never null.</li>
	 * <li>If the previous path is null, then size is 0.</li>
	 * <li>If the previous path is not null, then:
	 *     <ul>
	 *     <li>the previous path must be well formed</li>
	 *     <li>this size is one more than that of the previous path</li>
	 *     <li>the last coordinate of the previous path is next to the 
	 *         last coordinate.</li>
	 *     </ul>
	 * </li>
	 * </ol>
	 *   
	 * @return         <code>true</code> if the invariant is intact,
	 *                 <code>false</code> otherwise.
	 */
	private boolean wellFormed() {
	    HexPath path = this;
	    HexPath next = null;
	    while (path != null) {
	        if (path.last == null) return report("The last location cannot be null");
	        if ((path.previous == null) && (path.size != 0)) return report("A path without a previous path must have size 0");
	        if (next != null) {
	            if (path.size != (next.size - 1)) return report("Path size must decrease by one at each location");
	            if (path.last.distance(next.last) != 1) return report("Path locations must be adjacent");
	        }
	        next = path;
	        path = path.previous;
	    }
		return true;
	}
	
	/// Testing the invariant: do not change this code:
	private HexPath(HexPath p, HexCoordinate l, int s) {
		previous = p;
		last = l;
		size = s;
		// don't check here (see TestInvariant)
	}
	
	/** 
	 * Create an initial HexPath, starting and stopping at one location 
	 * (size = 0).
	 * 
	 * @param initial      the initial HexCoordinate location, must not 
	 *                     be null.
	 */
	public HexPath(HexCoordinate initial) {
		// NB: The following constructor calls the other constructor.
		// Therefore we don't need to check the invariant.
		this(null, initial);
	}
	
	/**
	 * Create a path that extends an existing path with another 
	 * location. 
	 * <p>
	 * The new location must be next to the last location of the 
	 * previous path (if any).
	 * 
	 * @param p        previous HexPath, may be null.
	 * @param next     next HexCoordinate location, must not be null, 
	 *                 and must be adjacent to last location of 
	 *                 previous HexPath.
	 * @throws         IllegalArgumentException when given a null 
	 *                 HexCoordinate for the <code>next</code> 
	 *                 argument.
	 * @throws         IllegalArgumentException when the HexPath
	 *                 <code>p</code> argument does not end in an
	 *                 adjacent coordinate to the <code>next</code>
	 *                 HexCoordinate argument. 
	 */
	public HexPath(HexPath p, HexCoordinate next) {
	    if (next == null) throw new IllegalArgumentException("No null HexCoordinates");
	    if ((p != null) && (p.last.distance(next) != 1)) throw new IllegalArgumentException("No non-adjacent path locations.");
	    last = next;
	    previous = p;
	    if (previous == null) size = 0;
	    else size = previous.size() + 1;
		assert wellFormed() : "invariant failed after constructor";
	}
	
	/**
	 * The distance required to traverse the path from end to end.
	 * <p>
	 * The distance is measured in lengths between coordinates, so
	 * a path with only a single coordinate has a length of 0.
	 * 
	 * @return         the size of the path in lengths between 
	 *                 coordinates.         
	 */
	public int size() { return size; }
	
	/**
	 * The location of the coordinates at the end of the path.
	 * 
	 * @return         HexCoordinate of the path's destination.
	 */
	public HexCoordinate last() { return last; }
	
	/**
	 * Return a string of the form XX -> XX -> XX where each XX is a 
	 * HexCoordinate. 
	 * <p>
	 * A size=1 path consists just of a single HexCoordinate location.
	 * 
	 * @return         String representing the HexPath.
	 */
	@Override
	public String toString() {
	    String[] result = new String[size + 1];
	    for (HexPath p = this; p != null;) {
            result[p.size()] = p.last().toString();
            p = p.previous;
        }
	    return String.join(" -> ", result);
	}

	/**
	 * Draw a HexPath on a HexBoard (already rendered).
	 * <p>
	 * The path is drawn as a series of line segments between the 
	 * centers of HexTiles on the path. A size=0 HexPath doesn't show 
	 * up. 
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		if (size == 0) return;
		HexCoordinate[] path = toArray();
		int[] xPoints = new int[path.length];
		int[] yPoints = new int[path.length];
		for (int i = 0; i < size; ++i) {
		    Point p = path[i].toPoint(HexTile.WIDTH);
		    xPoints[i] = p.x;
		    yPoints[i] = p.y;
		}
		g.drawPolyline(xPoints, yPoints, size);
	}
	
	/**
	 * Create an array representing the HexCoordinates in the path.
	 * 
	 * @return         An array of adjacent HexCoordinates from the
	 *                 start of the path to the destination.
	 */
	public HexCoordinate[] toArray() {
		HexCoordinate[] result = new HexCoordinate[size+1];
		for (HexPath p = this; p != null;) {
		    result[p.size()] = p.last();
		    p = p.previous;
		}
		return result;
	}
	
	public static class TestInvariant extends TestCase {
		HexPath self;
		
		HexPath previous;
		HexCoordinate last;
		int size;

		protected void assertInvariant(boolean good) {
			self = new HexPath(previous, last, size);
			doReport = good;
			assertEquals("Expected invariant detected " + (good ? "good" :"bad"),good,self.wellFormed());
		}

		public void testA() {
			last = new HexCoordinate(1,1,0);
			previous = null;
			size = 0;
			assertInvariant(true);
		}

		public void testB() {
			last = new HexCoordinate(1,1,0);
			previous = null;
			size = 1;
			assertInvariant(false);
		}

		public void testC() {
			last = null;
			previous = null;
			size = 0;
			assertInvariant(false);
		}
		
		public void testD() {
			last = new HexCoordinate(1,1);
			previous = new HexPath(null,new HexCoordinate(2,2),0);
			size = 1;
			assertInvariant(true);
		}
		
		public void testE() {
			last = null;
			previous = new HexPath(null,new HexCoordinate(2,2),0);
			size = 1;
			assertInvariant(false);			
		}
		
		public void testF() {
			last = new HexCoordinate(2,2);
			previous = new HexPath(null,new HexCoordinate(3,1),0);
			size = 1;
			assertInvariant(false);
		}
		
		public void testG() {
			last = new HexCoordinate(2,2);
			previous = new HexPath(null,new HexCoordinate(1,3),0);
			size = 1;
			assertInvariant(false);
		}
		
		public void testH() {
			last = new HexCoordinate(1,1);
			previous = new HexPath(null,new HexCoordinate(2,2),1);
			size = 2;
			assertInvariant(false);
		}
		
		public void testI() {
			last = new HexCoordinate(1,1);
			previous = new HexPath(null,new HexCoordinate(2,2),1);
			size = 1;
			assertInvariant(false);
		}
		
		public void testJ() {
			last = new HexCoordinate(1,1);
			previous = new HexPath(null,new HexCoordinate(2,2),0);
			size = 2;
			assertInvariant(false);
		}
		
		public void testK() {
			last = new HexCoordinate(2,2);
			previous = new HexPath(null,new HexCoordinate(2,2),0);
			size = 1;
			assertInvariant(false);
		}
		
		public void testL() {
			last = new HexCoordinate(3,2);
			HexPath first = new HexPath(null,new HexCoordinate(3,2),0);
			previous = new HexPath(first,new HexCoordinate(2,1),1);
			size = 2;
			assertInvariant(true);
		}
		
		public void testM() {
			last = new HexCoordinate(1,1);
			HexPath first = new HexPath(null,new HexCoordinate(3,2),0);
			previous = new HexPath(first,new HexCoordinate(2,1),1);
			size = 2;
			assertInvariant(true);
		}
		
		public void testN() {
			last = new HexCoordinate(1,1);
			HexPath first = new HexPath(null,new HexCoordinate(4,2),0);
			previous = new HexPath(first,new HexCoordinate(2,1),1);
			size = 2;
			assertInvariant(false);
		}
	}
}
