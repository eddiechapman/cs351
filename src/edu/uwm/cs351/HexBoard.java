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
		return 0; // TODO
	}

	// TODO: What else?
	
	/**
	 * Read a hex board from a reader
	 * @param br read t read from, must not be null
	 * @throws FormatException if there is a format error in the final
	 * @throws IOException if an error reading
	 */
	public void read(BufferedReader br) throws FormatException, IOException {
		String line;
		while ((line = br.readLine()) != null) {
			add(HexTile.fromString(line));
		}
	}
	
	/**
	 * Write a hex board out.
	 * @param p print writer to use.
	 */
	public void write(PrintWriter p) {
		for (HexTile h : this) {
			p.println(h.toString());
		}
		p.flush();
	}
	
	private class MyIterator implements Iterator<HexTile> {
		private Iterator<Map.Entry<HexCoordinate,Terrain>> base = contents.entrySet().iterator();
		
		@Override
		public boolean hasNext() {
			return false; // TODO: very easy, delegate to the "base" iterator
		}

		@Override
		public HexTile next() {
			return null; // TODO: use base iterator and generate hex tile on demand
		}

		// TODO: what else?
	}
}
