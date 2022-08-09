package edu.uwm.cs351;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	/**
	 * Construct a HexTile using a string to specify parameters.
	 * 
	 * @param  input a formatted string containing HexTile parameters
     * @return  a HexTile reflecting the input information
     * @throws  FormatException if the input string could not be parsed. 
     *          This could be due to inability to separate input components,
     *          or because input components could not be converted to useful 
     *          values.        
     * @throws  IllegalArgumentException if the input specified illegal coordinates
     *          for a HexCoordinate. Or, if the input resulted in a null Terrain
     *          argument for the HexTile constructor. 
	 */
	public static HexTile fromString(String input) throws FormatException{
	    String regexPattern = "[A-Z]*<[-\\d]+,[-\\d]+,[-\\d]+>";
	    if (!input.matches(regexPattern)) {
	        throw new FormatException(
                "Input string could not be parsed into useful values. Input should specify the" +
                "name of a valid terrain type in capital letters, followed comma-separated hex" +
                "coordinates surrounded by angle brackets: TERRAIN<X,Y,Z>");                          
	    }
	    Terrain t = Terrain.valueOf(input.substring(0, input.indexOf("<")));
	    HexCoordinate h = HexCoordinate.fromString(input.substring(input.indexOf("<")));
        return new HexTile(t, h);
	}

}
