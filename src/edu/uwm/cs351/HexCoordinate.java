package edu.uwm.cs351;

import java.awt.Point;
import java.awt.Polygon;

/**
 * Coordinates on a hexagon-filled game board.
 * 
 * Hexagons can be plotted at various widths to an x-y grid such as a screen. 
 * Distances between hexagons, hexagon pixel boundaries, and hexagon pixel centers
 * can be calculated.
 * 
 * @author Eddie Chapman
 * 
 * I consulted the guide to hexagon grids on Red Blob Games. I found it useful in
 * understanding the basics of hex grid systems: https://www.redblobgames.com/grids/hexagons/
 * 
 * My toPolygon is inspired by methods found in that guide for computing hexagon corner point 
 * coordinates using sine and cosine. I adapted their method to our hex coordinate system with
 * the help of my younger brother Louis Chapman who is a second year civil engineering student.
 * He helped refresh my memory of trigonometry and double checked my work. He has no experience 
 * with computer programming but I hope he takes it up soon.
 * 
 * I also reviewed the assignment instructions with my classmate Mason Baran at the beginning 
 * of the week. We compared our general understanding of the method requirements but did not 
 * discuss program or logic. 
 */
public class HexCoordinate
  {
    private static final float HEIGHT_RATIO = (float) Math.sqrt(3) / 2;
    private static final double RADIUS_RATIO = Math.sqrt(3) / 3;
    private static final double RADIAN_RATIO = Math.PI / 180;
    
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

    /**
     * Return the first hex coordinate (how far from left plus more every line).
     * 
     * @return a    the first hex coordinate
     */
    public int a() {
      return a;
    }

    /**
     * Return the second hex coordinate (how far from top).
     * 
     * @return b    the second hex coordinate
     */
    public int b() {
      return b;
    }

    /**
     * Return the third hex coordinate (how far from left minus more very line).
     * 
     * @return c    the third hex coordinate
     */
    public int c() {
      return c;
    }

    // I followed the "Effective Java" example linked to in the class Q&A page.
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
     * @param width     width of grid (must NOT be negative or zero)
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


    /**
     * Return an AWT Point object located at the center of this hex.
     * 
     * @param width     the size of the polygon when plotted on a square grid
     * @returns point   an AWT Point object whose coordinates equal the center of the hex
     */
    public Point toPoint(int width) {
      int dx = (int) Math.round(xDisplacement(width));
      int dy = (int) Math.round(yDisplacement(width));
      return new Point(dx, dy);
    }
    
    /**
     * Compute the pixel displacement along the x-axis for the center of a hex coordinate.
     * 
     * @param width     the width of a hexagon
     * @return          a hexagon center's distance from 0 along the x-axis  
     */ 
    private double xDisplacement(int width) {
      return (a - b * 0.5) * width;
    }
    
    /**
     * Compute the pixel displacement along the y-axis for the center of a hex coordinate.
     * 
     * @param width     the width of a hexagon
     * @return          a hexagon center's distance from 0 along the y-axis  
     */ 
    private double yDisplacement(int width) {
      return b * width * HEIGHT_RATIO;
    }

    /**
     * Create an AWT Polygon of six sides using the hex coordinates and a width.
     * 
     * @param width        the size of the Polygon when plotted on a square grid
     * @param returns      an AWT Polygon with point coordinates that reflect the
     *                     width
     */
    public Polygon toPolygon(int width) {
      int[] angles = new int[] {270, 330, 30, 90, 150, 210};  // The angles of a hexagon's outer points along a circle.
      int[] xPoints = new int[6];
      int[] yPoints = new int[6];
      double radian;
      for (int i=0; i<=5; i++) {
        radian = angles[i] * RADIAN_RATIO;  //Math.cos/sin use radians, not degrees.
        xPoints[i] = (int) Math.round(width * RADIUS_RATIO * Math.cos(radian) + xDisplacement(width));
        yPoints[i] = (int) Math.round(width * RADIUS_RATIO * Math.sin(radian) + yDisplacement(width));
      }
      return new Polygon(xPoints, yPoints, 6);
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