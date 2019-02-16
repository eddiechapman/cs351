package edu.uwm.cs351;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * An abstraction of a hexagonal game board.
 */
public class HexBoard extends AbstractCollection<HexTile> {
	// the only field is an ADT, no redundancy, no need for an invariant
	private Map<HexCoordinate,Terrain> contents = new HashMap<>();

	/** Return the terrain at the given coordinate or null
	 * if nothing at this coordinate.
	 * @param c hex coordinate to look for (null OK but pointless)
	 * @return terrain at that coordinate, or null if nothing
	 */
	public Terrain terrainAt(HexCoordinate c) {
		return null; // TODO (very easy)
	}

	@Override
	public Iterator<HexTile> iterator() {
		return new MyIterator();
	}

	@Override
	public int size() {
