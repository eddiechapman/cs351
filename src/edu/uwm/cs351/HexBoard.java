package edu.uwm.cs351;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

//I completed this assignment using the PDF from the the "examples" page of 
//the CS351 website, my notes from the lectures, and the portion of the 
//textbook chapter 4 dealing with alternative forms of linked lists.

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

    @Override  // default implementation is inefficient
    public boolean contains(Object o) {
        if (!(o instanceof HexTile)) return false;
        HexTile tile = (HexTile) o;
        if (terrainAt(tile.getLocation()) == null) return false;
        HexTile stored = new HexTile(terrainAt(tile.getLocation()), tile.getLocation());
        return stored.equals(tile);
    }

    @Override // default implementation is inefficient
    public boolean remove(Object o) {
        if (!(o instanceof HexTile)) return false;
        HexTile tile = (HexTile) o;
        Terrain terrain = terrainAt(tile.getLocation());
        if ((terrain == null) || (terrain != tile.getTerrain())) return false;
        contents.remove(tile.getLocation());
        return true;
    }

	// TODO: What else?
    //  clear       -   default implementation is sufficient
    //  toString    -   not required by program
    //  addAll      -   not required by program
    //  containsAll -   not required by program
    //  isEmpty     -   not required by program
    //  removeAll   -   not required by program
    //  retainAll   -   not required by program
    //  toArray     -   not required by program
	
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
		private boolean canRemove = false;
		
        @Override // required by Java
		public boolean hasNext() {
			return base.hasNext();
		}

		@Override // required by Java
		public HexTile next() {
		    Map.Entry<HexCoordinate,Terrain> current = base.next();
		    canRemove = true;
			return new HexTile(current.getValue(), current.getKey());
		}
		
		@Override // default implementation raises UnsupportedOperationException
        public void remove() {  
		    if (!canRemove) throw new IllegalStateException("Must call next() before calling remove()");
		    base.remove();
            canRemove = false;
        }

		// TODO: what else?
        //  forEachRemaining   -   not required by program
	}
}
