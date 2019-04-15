package edu.uwm.cs351;

import java.util.Comparator;

/**
 * Compute the cost of a hex path
 * by looking at the terrains it crosses.
 * The sum of the costs of the terrains is computed,
 * with a path that goes into and out of a terrain costing double.
 * This coster can be used to compare legal hex paths.
 */
public class HexPathCoster implements Comparator<HexPath> {

	private final HexBoard board;
	private final int[] costs;
	
	/**
	 * Construct a coster in which all terrains have the same cost (1)
	 * except {@link Terrain#INACCESSIBLE} which costs the maximum legal amount.
	 */
	public HexPathCoster(HexBoard b) {
		board = b;
		costs = new int[Terrain.values().length];
		// TODO: initialize the costs.
	}
	
	/**
	 * Return the cost used for this terrain.
	 * @param t terrain (must not be null)
	 * @return cost for entering or exiting a hex tile of this terrain.
	 */
	public int getCost(Terrain t) {
		return costs[t.ordinal()];
	}
	
	/**
	 * Change the cost associated with the given terrain
	 * @param t terrain to change cost for (must not be null)
	 * @param c cost
	 */
	public void setCost(Terrain t, int c) {
		costs[t.ordinal()] = c;
	}
	
	/**
	 * Get the cost of a path: the cost for a hex path
	 * counts the cost of the terrain for crossing HALF the hex tile.
	 * So if the path crosses the hex tile, the cost of the terrain
	 * is doubled.  If the cost would overflow, {@link Integer.MAX_VALUE}
	 * is returned instead.  If the path would go across a coordinate
	 * without a hex tile, -1 is returned (the path is illegal).
	 * @param p
	 * @return
	 */
	public int getCost(HexPath p) {
		int sum = 0;
		// TODO: Implement this method.
		// Remember to account internal terrains twice.
		// Make sure to avoid overflow, return Integer.MAX_VALUE if more than this
		return sum;
	}

	@Override
	public int compare(HexPath arg0, HexPath arg1) {
		// TODO: implement this, a one-liner using getCost(HexPath)
		// Useful fact: the difference of two non-negative integers never overflows
		// MAXINT - 0 = MAXINT
		// 0 - MAXINT = -MAXINT = MININT+1
	}
}
