package edu.uwm.cs351;

import java.awt.Point;
import java.awt.Polygon;

/**
 * Coordinates on a hexagon-filled game board.
 * <dl>
 * <dt>a
 * <dd>left to right (0 = left edge, moving left half a hex each line down)
 * <dt>b
 * <dd>top to bottom (0 = top edge)
 * <dt>c
 * <dd>left to right (0 = top edge, moving right half a hex each line down)
 * </dl>
 * The {@link #c()} coordinate is always the difference of the first two.
 */
public class HexCoordinate
  {
    private static final float HEIGHT_RATIO = (float) Math.sqrt(3) / 2;
    private static final float RADIUS_RATIO = (float) Math.sqrt(3) / 3;
    private static final float RADIAN_RATIO = (float) Math.PI / 180;
    private final int a;
    private final int b;
    private final int c;

    /**
     * Create a hexagonal coordinate by specifying the first two coordinates and
     * computing the third.
     * 
     * @param a first coordinate
     * @param b second coordinate
     */
    public HexCoordinate(int a, int b) {
      this.a = a;
      this.b = b;
      this.c = a - b;
    }

    /**
     * Create a hexagonal coordinate by specifying all three coordinates, which must
     * be consistent.
     * 
     * @param a
     * @param b
     * @param c
     * @exception IllegalArgumentException if the coordinates are not consistent.
     */
    public HexCoordinate(int a, int b, int c) throws IllegalArgumentException {
      if (!(c == a - b)) {
        throw new IllegalArgumentException(
                "the third coordinate must equal the first minus the second.");
      }
      this.a = a;
      this.b = b;
      this.c = c;
    }

    /// three simple accessors

    /**
     * Return the first coordinate (how far from left plus more every line).
     * 
     * @return the first coordinate
     */
    public int a() {
      return a;
    }

    /**
     * Return the second coordinate (how far from top).
     * 
     * @return the second coordinate
     */
    public int b() {
      return b;
    }

    /**
     * Return the third coordinate (how far from left minus more very line).
     * 
     * @return the third coordinate
     */
    public int c() {
      return c;
    }

    @Override
    public boolean equals(Object x) {
      if (!(x instanceof HexCoordinate)) {
        return false;
      }
      HexCoordinate hc = (HexCoordinate) x;
      return (hc.a == a) && (hc.b == b);
    }

    @Override
    public int hashCode() {
      int result = 17;
      result = 31 * result + a;
      result = 31 * result + b;
      return result;
    }

    @Override
    public String toString() {
      return String.format("<%d,%d,%d>", a, b, c);
    }

    /**
     * Return the closest hex coordinate to this point. If two are equally close,
     * either may be returned.
     * 
     * @param p
     * @param width width of grid (must NOT be negative or zero)
     * @return closest hex coordinate
     */
    public static HexCoordinate fromPoint(Point p, int width) {
      float db = p.y / (width * HEIGHT_RATIO);
      float da = (float) p.x / width + db / 2.0f;
      float dc = da - db;

      int ac = (int) Math.floor((da + dc));
      int ab = (int) Math.floor((da + db));
      int bc = (int) Math.floor((db - dc));

      int a = (int) Math.ceil((ab + ac) / 3.0);
      int b = (int) Math.ceil((ab + bc) / 3.0);
      return new HexCoordinate(a, b);
    }

    /// Other accessors

    // TODO: define HEIGHT_RATIO, the amount down each row is from the last. (Not
    // the height of a hexagon!)

    // TODO: Add more public methods here.
    // Each should have a documentation comment.
    // You may also wish to add private methods and static final fields (named
    // constants).
    // In particular you should avoids performing very similar computations over and
    // over.
    // (We use a private static method to generalize {@link #toPoint()}
    // that can be used when making the polygon.)

    /**
     * Return the (x,y) center of the hexagon at this coordinate using the given
     * width.
     * 
     * @param width the size of the polygon when plotted on a square grid
     * @returns the (x,y) coordinates of the center of this hexagon as plotted on a
     *          square grid, given a specified hexagon width
     */
    public Point toPoint(int width) {
      Point p = new Point();
      p.translate(xDisplacement(width), yDisplacement(width));
      return p;
    }
    
    
    /**
     * Compute the displacement along the x-axis of a hex coordinate compared to 0,0,0.
     * 
     * @param a         the "a" hex coordinate (of <a,b,c>)
     * @param b         the "b" hex coordinate (of <a,b,c>)
     * @param width     the width of a hexagon
     * @return          the distance of a hex coordinate
     */ 
    private int xDisplacement(int width) {
      return (int) Math.round((a - b * 0.5) * width);
    }
    
    /**
     * Compute the displacement along the y-axis of a hex coordinate compared to 0,0,0.
     * 
     * @param b         the "b" hex coordinate (of <a,b,c>)
     * @param width     the width of a hexagon
     * @return          the distance of a hex coordinate
     */ 
    private int yDisplacement(int width) {
      return (int) Math.round(b * width * HEIGHT_RATIO);
    }

    /**
     * Return an AWT Polygon using hex coordinates and the given width.
     * 
     * @param width        the size of the Polygon when plotted on a square grid
     * @param returns      an AWT Polygon with point coordinates that reflect the
     *                     width
     */
    public Polygon toPolygon(int width) {
      float radian;
      int[] angles = new int[] {270, 330, 30, 90, 150, 210};
      int[] xPoints = new int[6];
      int[] yPoints = new int[6];
      for (int i=0; i<=5; i++) {
        radian = angles[i] * RADIAN_RATIO;
        xPoints[i] = (int) Math.round(width * RADIUS_RATIO * Math.cos(radian));
        yPoints[i] = (int) Math.round(width * RADIUS_RATIO * Math.sin(radian));
      }
      Polygon hexagon = new Polygon(xPoints, yPoints, 6);
      hexagon.translate(xDisplacement(width), yDisplacement(width));
      return hexagon;
    }

    
    /**
     * The minimum number of moves needed to reach another hex coordinate.
     * 
     * @param hc        a HexCoordinate to measure the distance to
     * @param returns   the number of moves needed to reach the hc coordinate
     */
    public int distance(HexCoordinate hc) {
      // Coordinate differences in absolute value
      int aDiff = Math.abs(a - hc.a);
      int bDiff = Math.abs(b - hc.b);
      int cDiff = Math.abs(c - hc.c);
      
      // The distance is the sum of the two smallest differences
      if ((aDiff > bDiff) && (aDiff > cDiff)) {
        return bDiff + cDiff;
      } else {
        return aDiff + Math.min(bDiff, cDiff);
      }
    }
  }














