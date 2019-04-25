package edu.uwm.cs351;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import edu.uwm.cs351.util.Worklist;

/**
 * Class to find paths across HexTile boards.
 */
public class Search {
	private final Worklist<HexPath> worklist;
	private final Set<HexCoordinate> visited = new HashSet<HexCoordinate>();
	
	/**
	 * Create a searcher that uses the given Worklist.
	 * 
	 * @param w        Worklist to use to find HexPath.
	 */
	public Search(Worklist<HexPath> w) {
		worklist = w;
	}
	
	private void clear() {
		// TODO: empty worklist and visited set
	}
	
	/**
	 * Find a path through a hex board.
	 * 
	 * @param from     HexCoordinate to start from (must not be null).
	 * @param to       HexCoordinate to reach (must not be null).
	 * @param b        HexBoard to traverse.
	 * @return a       search state including a possible HexPath, or 
	 *                 null if no path is found.
	 */
	public HexPath find(HexCoordinate from, HexCoordinate to, HexBoard b) {
		clear();
		Terrain initial = b.terrainAt(from);
		if (initial == null || initial == Terrain.INACCESSIBLE) return null; // can't go anywhere
		// TODO: Use worklist to find path to "to"
		return null;
	}
	
	/**
	 * For every node that was visited in the most recent search, draw 
	 * an X centered on the tile half the size of tiles.
	 */
	public void markVisited(Graphics g) {
		// TODO: Similar to what was done in Homework #5
	}
}
