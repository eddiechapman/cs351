package edu.uwm.cs351;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * A hexagonal game tail with a particular coordinate and terrain.
 */
public class HexTile {

	public static final int WIDTH = 50; // subject to change
	
	private final Terrain _terrain;
	private final HexCoordinate _location;
	
	/**
	 * Create a hexagonal tile for the given terrain and location in hex coordinates.
	 * @param t terrain, must not be null
	 * @param loc location, must not be null
	 * @exception IllegalArgumentException if either argument is null
	 */
	public HexTile(Terrain t, HexCoordinate loc) {
		if (t == null || loc == null) throw new IllegalArgumentException("neither terrain nor location may be null");
		_terrain = t;
		_location = loc;
	}
	
	@Override
	public String toString() {
		return _terrain.toString() + _location.toString();
	}
	
	/**
	 * Return terrain of this tile.
	 * @return terrain of this tile
	 */
	public Terrain getTerrain() { return _terrain; }
	
	/**
	 * Return location of this tile.
	 * @return location of this tile
	 */
	public HexCoordinate getLocation() { return _location; }
	
	/**
	 * Render the tile in a graphics context.
	 * We fill the hexagon with the terrain suggested color and then
	 * outline the tile in black.
	 * @param g context to use.
	 */
	public void draw(Graphics g) {
		Polygon hexagon = _location.toPolygon(WIDTH);
		g.setColor(_terrain.getColor());
		g.fillPolygon(hexagon);
		g.setColor(Color.BLACK);
		g.drawPolygon(hexagon);
	}
}
