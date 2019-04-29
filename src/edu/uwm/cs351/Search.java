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
		visited.clear();
		while (worklist.hasNext()) {
		    worklist.next();
		}
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
		worklist.add(new HexPath(from));
		while (worklist.hasNext()) {
		    HexPath p = worklist.next();
		    visited.add(p.last());
		    if (p.last().equals(to)) return p;
		    for (HexDirection d : HexDirection.values()) {
                HexCoordinate h = d.applyTo(p.last());
                Terrain t = b.terrainAt(h);
                if ((t != null) && (t != Terrain.INACCESSIBLE) && (!(visited.contains(h)))) 
                    worklist.add(new HexPath(p, h));
            }
		}
		return null;
	}

	/**
	 * For every node that was visited in the most recent search, draw 
	 * an X centered on the tile half the size of tiles.
	 */
	public void markVisited(Graphics g) {
		for (HexCoordinate h : visited) {
		    int xbar = HexTile.WIDTH / 4;
		    int diffPos = xbar / 2;
		    int diffNeg = -(xbar / 2);
		    
		    Point p = h.toPoint(xbar);
		    Point sw = p.getLocation();
		    Point nw = p.getLocation();
		    Point ne = p.getLocation();
		    Point se = p.getLocation();
		     
		    nw.translate(diffNeg, diffPos);
		    ne.translate(diffPos, diffPos);
		    se.translate(diffPos, diffNeg);
		    sw.translate(diffNeg, diffNeg);
		    
		    g.drawLine(p.x, p.y, nw.x, nw.y);
		    g.drawLine(p.x, p.y, ne.x, ne.y);
		    g.drawLine(p.x, p.y, se.x, se.y);
		    g.drawLine(p.x, p.y, sw.x, sw.y);
		}
	}
}
