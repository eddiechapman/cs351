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
		return contents.get(c); 
	}

	@Override // required by Java
	public Iterator<HexTile> iterator() {
		return new MyIterator();
	}

	@Override // required by Java
	public int size() {
		return contents.size();
	}
	
	
	@Override // default implementation raises UnsupportedOperationException
    public boolean add(HexTile e) {
	    if (e == null) {
	        throw new NullPointerException("Can't add a null tile to the HexBoard.");
	    }
	    Terrain result = contents.put(e.getLocation(), e.getTerrain());
	    if (result == null || result != e.getTerrain()) {
	        return true;
	    }
	    return false;
    }

    @Override
    public void clear() {
        contents.clear();
    }

    @Override
    public boolean contains(Object o) {
        // TODO Auto-generated method stub
        return super.contains(o);
    }

    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        return super.remove(o);
    }

	// TODO: What else?
	// Document with "//" the reason for every override
	// and add a "//" comment for other Collection methods when you don't need to.
	// (Except for the list in the homework.)
	
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
		
		@Override // required by Java
		public boolean hasNext() {
			return false; // TODO: very easy, delegate to the "base" iterator
		}

		@Override // required by Java
		public HexTile next() {
			return null; // TODO: use base iterator and generate hex tile on demand
		}

		// TODO: what else?
	}
}
