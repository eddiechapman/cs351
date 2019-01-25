package edu.uwm.cs351;

import java.awt.Point;
import java.awt.Polygon;

/**
 * Coordinates on a hexagon-filled game board.
 * <dl>
 * <dt>a<dd> left to right (0 = left edge, moving left half a hex each line down)
 * <dt>b<dd> top to bottom (0 = top edge)
 * <dt>c<dd> left to right (0 = top edge, moving right half a hex each line down)
 * </dl>
 * The {@link #c()} coordinate is always the difference of the first two.
 */
public class HexCoordinate {
	private final int a, b, c;
	
	/**
	 * Create a hexagonal coordinate by specifying the first two coordinates
	 * and computing the third.
	 * @param a first coordinate
	 * @param b second coordinate
	 */
	public HexCoordinate(int a, int b) {
        this.a = a;
        this.b = b;
        this.c = a - b;
	}

	
	/**
	 * Create a hexagonal coordinate by specifying all three coordinates,
	 * which must be consistent.
	 * @param a
	 * @param b
	 * @param c
	 * @exception IllegalArgumentException if the coordinates are not consistent.
	 */
	public HexCoordinate(int a, int b, int c) throws IllegalArgumentException {
		if (!(c == a - b)) {
			throw new IllegalArgumentException("the third coordinate must equal the first minus the second.")
		}
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	/// three simple accessors
	
	/** Return the first coordinate (how far from left
	 * plus more every line).
	 * @return the first coordinate
	 */
	public int a() { return a; }
	
	/**
	 * Return the second coordinate (how far from top).
	 * @return the second coordinate
	 */
	public int b() { return b; }

	/**
	 * Return the third coordinate (how far from left
	 * minus more very line).
	 * @return the third coordinate
	 */
	public int c() { return c; }
	
	
	/// Overrides
	// no need to give a documentation comment if overridden documentation still is valid.
	
	@Override
	public boolean equals(Object x) {
		// TODO
	}
	
	@Override
	public int hashCode() {
		// TODO: Return some combination of a, b and c that distinguishes similar coordinates
	}
	
	
	@Override
	public String toString() {
		// TODO: Return a string of the form <3,2,1>
	}

	/**
	 * Return the closest hex coordinate to this point.
	 * If two are equally close, either may be returned.
	 * @param p
	 * @param width width of grid (must NOT be negative or zero)
	 * @return closest hex coordinate
	 */
	public static HexCoordinate fromPoint(Point p, int width) {
		float height = width * HEIGHT_RATIO;
		float db = p.y/height;
		float da = (float)p.x/width + db/2.0f;
		float dc = da - db;
		
		int ac = (int)Math.floor((da+dc));
		int ab = (int)Math.floor((da+db));
		int bc = (int)Math.floor((db-dc));
		
		int a = (int)Math.ceil((ab+ac)/3.0);
		int b = (int)Math.ceil((ab+bc)/3.0);
		return new HexCoordinate(a,b);
	}


	/// Other accessors
	
	// TODO: define HEIGHT_RATIO, the amount down each row is from the last.  (Not the height of a hexagon!)
	
	
	// TODO: Add more public methods here.
	// Each should have a documentation comment.
	// You may also wish to add private methods and static final fields (named constants). 
	// In particular you should avoids performing very similar computations over and over.
	// (We use a private static method to generalize {@link #toPoint()}
	// that can be used when making the polygon.)
}
