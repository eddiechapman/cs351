package edu.uwm.cs351;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Compute the cost of a HexPath by looking at the Terrain it crosses.
 * 
 * The sum of the costs of the Terrain is computed, with a path that 
 * goes into and out of a Terrain costing double. This coster can be 
 * used to compare legal HexPaths.
 * 
 * @author Eddie Chapman (chapman4@uwm.edu)
 * 
 * I completed this assignment by referencing the lecture notes, 
 * textbook, Oracle documentation, and text adventure example. 
 * 
 * I discussed the assignment with Mason Baran regarding how to 
 * interpret the text adventure in the context of search. 
 */
public class HexPathCoster implements Comparator<HexPath> {
    private static final int MAX = Integer.MAX_VALUE;
	private final HexBoard board;
	private final int[] costs;
	
	/**
	 * Construct a coster in which all Terrain have the same cost (1)
	 * except {@link Terrain#INACCESSIBLE} which costs the maximum 
	 * legal amount.
	 * 
	 * @param b        HexBoard containing terrain of varying costs.
	 */
	public HexPathCoster(HexBoard b) {
		board = b;
		costs = new int[Terrain.values().length];
		Arrays.fill(costs, 1);
		setCost(Terrain.INACCESSIBLE, MAX);
	}
	
	/**
	 * Return the cost used for this terrain.
	 * 
	 * @param t        Terrain (must not be null)
	 * @return         cost for entering or exiting a HexTile of this 
	 *                 Terrain.
	 */
	public int getCost(Terrain t) {
		return costs[t.ordinal()];
	}
	
	/**
	 * Change the cost associated with the given terrain
	 * 
	 * @param t        Terrain to change cost for (must not be null).
	 * @param c        integer cost.
	 */
	public void setCost(Terrain t, int c) {
		costs[t.ordinal()] = c;
	}
	
	/**
	 * Get the cost of a path: the cost for a HexPath counts the cost 
	 * of the Terrain for crossing HALF the HexTile.
	 * 
	 * So if the HexPath crosses the HexTile, the cost of the Terrain 
	 * is doubled. If the cost would overflow, {@link Integer.MAX_VALUE} 
	 * is returned instead. If the HexPath would go across a 
	 * HexCoordinate without a HexTile, -1 is returned (the HexPath is 
	 * illegal).
	 * 
	 * @param p        A HexPath across the board whose cost will be 
	 *                 calculated.
	 * @return         The integer value for traveling the path.
	 */
	public int getCost(HexPath p) {
	    if (p.size() == 0) return 0;
		int sum = 0;
	    HexCoordinate[] path = p.toArray();
	    for (HexCoordinate h : path) {
	        if (sum < 0) return MAX;
            Terrain t = board.terrainAt(h);
            if (t == null) return -1;
            int cost = getCost(t);
            if (cost == MAX) return MAX;
            if ((h != path[0]) && (h != path[path.length-1])) cost = cost * 2;
            sum += cost;
        }
		return sum;
	}

	@Override
	public int compare(HexPath arg0, HexPath arg1) {
	    return Integer.compare(getCost(arg0), getCost(arg1)); 
	}
}
