package edu.uwm.cs351;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * A hexagonal game tail with a particular coordinate and terrain.
 */
public class HexTile {

	public static final int WIDTH = 50; // subject to change
	
	private final Terrain terrain;
	private final HexCoordinate location;
	
	/**
	 * Create a hexagonal tile for the given terrain and location in hex coordinates.
	 * @param t terrain, must not be null
	 * @param loc location, must not be null
	 * @exception IllegalArgumentException if either argument is null
	 */
	public HexTile(Terrain t, HexCoordinate loc) {
		if (t == null || loc == null) throw new IllegalArgumentException("neither terrain nor location may be null");
		terrain = t;
		location = loc;
	}
	
	@Override
	public String toString() {
		return terrain.toString() + location.toString();
	}
	
	/**
	 * Return terrain of this tile.
	 * @return terrain of this tile
	 */
	public Terrain getTerrain() { return terrain; }
	
	/**
	 * Return location of this tile.
	 * @return location of this tile
	 */
	public HexCoordinate getLocation() { return location; }
	
	/**
	 * Render the tile in a graphics context.
	 * We fill the hexagon with the terrain suggested color and then
	 * outline the tile in black.
	 * @param g context to use, must not be null
	 */
	public void draw(Graphics g) {
		draw(g, WIDTH);
	}

	/**
	 * Render the tile in a graphics context.
	 * We fill the hexagon with the terrain suggested color and then
	 * outline the tile in black.
	 * @param g context to use, must not be null
	 * @param width width of hexagon
	 */
	public void draw(Graphics g, int width) {
		Polygon hexagon = location.toPolygon(width);
		g.setColor(terrain.getColor());
		g.fillPolygon(hexagon);
		g.setColor(Color.BLACK);
		g.drawPolygon(hexagon);
	}
	
	// TODO: define static method fromString.  Make sure to document it!

}
