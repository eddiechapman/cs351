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
		if (a - b != c) throw new IllegalArgumentException("c coordindate must be the difference of a and b: " + c + " != " + a + " + " + b);
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
		if (x instanceof HexCoordinate) {
			HexCoordinate other = (HexCoordinate)x;
			if (other.a == a && other.b == b) return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return a ^ (b << 8);
	}
	
	
	@Override
	public String toString() {
		return "<"+a+","+b+","+c+">";
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
	
	public static final float HEIGHT_RATIO = (float) (Math.sqrt(3.0)/2.0); // height of a row, given width = 1.0
	
	/**
	 * Return center of hexagon as a point on the two-dimensional AWT plane.
	 * @param width width of hexagon
	 * @return Point in the center of the hexagon
	 */
	public Point toPoint(int width) {
		return toPoint(width,a,b);
	}
	
	/**
	 * A generalization of {@link #toPoint(int)} that takes two floats, to permit
	 * fractions into the coordinate space.
	 * @param width width of hexagon in grid
	 * @param a first coordinate
	 * @param b second coordinate
	 * @return [x,y] point for this location.
	 */
	private static Point toPoint(int width, float a, float b) {
		float height = width * HEIGHT_RATIO;
		return new Point(Math.round(width*(a-b/2.0f)),Math.round(height*b));
	}
	
	private static final float THIRD = 1.0f/3.0f;
	private static final float TWOTHIRD = 2.0f/3.0f;
	
	/**
	 * Create a polygon (for rendering in AWT) for the hexagon around this
	 * hex coordinate.  The hexagons so created tile the plane.
	 * @param width width of hexagon in pixels
	 * @return polygon for hexagon
	 */
	public Polygon toPolygon(int width) {
		Point[] ps = {
				toPoint(width,a-THIRD,b-TWOTHIRD),
				toPoint(width,a+THIRD,b-THIRD),
				toPoint(width,a+TWOTHIRD,b+THIRD),
				toPoint(width,a+THIRD,b+TWOTHIRD),
				toPoint(width,a-THIRD,b+THIRD),
				toPoint(width,a-TWOTHIRD,b-THIRD)
		};
		Polygon result = new Polygon();
		for (Point p : ps) {
			result.addPoint(p.x,p.y);
		}
		return result;
	}
	
	/**
	 * Return the number of steps to get from one hex to another.
	 * We can use the smallest distance traveling along just two of the coordinates.
	 * Thus we can add all the differences and remove the largest (not used).
	 * Alternately, we can return the <em>largest</em> of the differences directly,
	 * which (do the algebra!) is the same value.
	 * @param other
	 * @return number of steps from one hex to another
	 */
	public int distance(HexCoordinate other) {
		int da = Math.abs(a - other.a);
		int db = Math.abs(b - other.b);
		int dc = Math.abs(c - other.c);
		int maxd = Math.max(da, Math.max(db,dc));
		return maxd; // Or: return da + db + dc - maxd;
	}
	
	// TODO: define static method fromString.  Make sure to document it!
}
