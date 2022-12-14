package edu.uwm.cs351;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

import java.util.Set;
import java.util.Stack;

import edu.uwm.cs.util.AbstractEntry;
import edu.uwm.cs.util.Primes;
import junit.framework.TestCase;

/**
 * An implementation of the HexBoard ADT using a hash table 
 * implementation. A hex board is a collection of hex tiles except that 
 * there can never be two tiles at the same location.
 * 
 * @author Eddie Chapman (chapman4@uwm.edu)
 * 
 * I completed this assignment by referencing the lecture notes and 
 * Oracle documentation. 
 * 
 * I discussed the assignment with Mason Baran regarding the use of 
 * Math.floorMod instead of the remainder operator (as revealed in
 * test95 and test96.
 *  
 */
public class HexBoard extends AbstractSet<HexTile> {
	
    private static class Node
	extends AbstractEntry<HexCoordinate,Terrain> {

        Node(boolean ignored) {} // don't change this constructor (but you can add a different one)

		HexTile tile;
		Node next;
		
		public Node(HexTile tile, Node next) {
		    this.tile = tile;
		    this.next = next;
		}

		@Override
		public HexCoordinate getKey() {
			return tile.getLocation();
		}
		
		@Override
		public Terrain getValue() {
			return tile.getTerrain();
		}
		
		@Override
		public Terrain setValue(Terrain v) {
			if (v == null) throw new IllegalArgumentException("can't have a null terrain!");
			Terrain result = getValue();
			tile = new HexTile(v, getKey());
			return result;
		}
	}
	
	// data structure
	private Node[] array;
	private int size;
	private int version;
	
	private static boolean doReport = true; 
	private static boolean report(String s) {
		if (doReport) System.err.println("Invariant error: " + s);
		else System.out.println("Detected invariant error: " + s);
		return false;
	}
	
	private int hash(HexCoordinate h, int length) {
        return Math.floorMod(h.hashCode(), length);
    }
	
	private int hash(HexCoordinate h) {
	    return hash(h, array.length);
	}

	private void ensureCapacity(int minimumCapacity) {
	    if (minimumCapacity < (array.length * 0.75)) return;
	    int newCapacity = Primes.nextPrime(array.length * 2);
	    Node[] newArray = new Node[newCapacity];
	    for (int i = 0; i < array.length; ++i) {
            Node n = array[i];
            while (n != null) {
                int newIndex = hash(n.getKey(), newCapacity);
                Node next = n.next;
                n.next = newArray[newIndex];
                newArray[newIndex] = n;
                n = next;
            }
        }
	    array = newArray;
	}
	
	/**
	 * HexBoard invariant:
	 * <ol>
	 * <li>The array is not null;</li>
	 * <li>The number of entries is correctly summed in the ???size??? field;</li>
	 * <li>The length of the array is a prime number;</li>
	 * <li>The array is neither too full nor too empty;</li>
	 * <li>Every entry is in the correct chain;</li>
	 * <li>The chains contain no duplicates (which also prevents loops)</li>
	 * </ol>
	 * @return
	 */
	private boolean wellFormed() {
		if (array == null) return report("array field must not be null.");
		if (!Primes.isPrime(array.length)) return report("array length must be prime.");
		int count = 0;
		for (int i = 0; i < array.length; ++i) {
		    Stack<HexCoordinate> bucket = new Stack<HexCoordinate>();
            Node n = array[i];
		    while (n != null) {
		        if (n.tile == null) return report("Bad node found in array.");
		        if (hash(n.getKey()) != i) return report("Bucket and hash do not match.");
		        if (bucket.contains(n.getKey())) return report("Duplicate found in bucket.");
		        bucket.push(n.getKey());
		        n = n.next;
		        ++count;
		    }
		}
		if (count != size) return report("Size incorrectly represents the number of entries.");
        if ((size == 0) && (array.length != 7)) return report("The array is too empty.");
        if (size >= (array.length * 0.75)) return report("The array is too full.");
        return true;
	}
	
	private HexBoard(boolean ignored) {} // do not change this constructor!
	
	/**
	 * Create an empty hex board.
	 */
	public HexBoard() {
		array = new Node[7];
		size = 0;
		version = 0;
		assert wellFormed() : "in constructor";
	}
	
	/** 
	 * Return the terrain at the given coordinate or null if nothing at 
	 * this coordinate.
	 * 
	 * @param l    hex coordinate to look for (null OK but pointless)
	 * @return     terrain at that coordinate, or null if nothing
	 */
	public Terrain terrainAt(HexCoordinate l) {
		assert wellFormed() : "in terrainAt";
		Node n = array[hash(l)];
		while (n != null) {
		    if (n.getKey().equals(l)) return n.getValue();
		    n = n.next;
		}
		return null;
	}

	@Override // required by Java
	public Iterator<HexTile> iterator() {
		assert wellFormed() : "in iterator";
		return new MyIterator();
	}

	@Override // required by Java
	public int size() {
		assert wellFormed() : "in size";	
		return size;
	}

    @Override // required for efficiency
    public boolean contains(Object o) {
	    assert wellFormed() : "in contains()";
        if (o instanceof HexTile) {
            HexTile h = (HexTile)o;
            return terrainAt(h.getLocation()) == h.getTerrain();
        }
        return false;
    }

    @Override  // required for functionality
    public boolean add(HexTile e) {
        assert wellFormed() : "at start of add";
        if (e == null) throw new NullPointerException("HexTile must not be null");
        if (contains(e)) return false;
        if (terrainAt(e.getLocation()) == null) {
            ensureCapacity(size + 1);
            array[hash(e.getLocation())] = new Node(e, array[hash(e.getLocation())]);
            ++size;
        } else {
            Node n = array[hash(e.getLocation())];
            while (n != null) {
                if (n.getKey().equals(e.getLocation())) n.setValue(e.getTerrain());
                n = n.next;
            }
        }
        ++version;
        assert wellFormed() : "at end of add";
        return true;
    }
    

    @Override // required for functionality
    public boolean remove(Object o) {
        assert wellFormed() : "in remove()";
        if (!(o instanceof HexTile)) return false;
        HexTile t = (HexTile)o;
        int i = hash(t.getLocation());
        Node lag = null;
        for (Node n = array[i]; n != null; ) {
            if (n.tile.equals(t)) {
                if (lag != null) lag.next = n.next;
                else array[i] = n.next;
                --size;
                ++version;
                if (size == 0) array = new Node[7];
                assert wellFormed() : "at end of remove";
                return true;
            }
            lag = n;
            n = n.next;
        }
        return false;
    }

    @Override  // required for functionality
    public void clear() {
        assert wellFormed() : "at start of clear";
        if (isEmpty()) return;
        array = new Node[7];
        size = 0;
        ++version;
        assert wellFormed() : "at end of clear";
    }

    /**
	 * Return a view of this hex board as a map from hex coordinates to 
	 * terrain. It is as efficient as the hex board itself.
	 * 
	 * @return     view of HexBoard as map ADT. 
	 */
	public Map<HexCoordinate,Terrain> asMap() {
		return new MyMap();
	}
	
	private class MyMap extends AbstractMap<HexCoordinate,Terrain> {
		@Override // required by Java
		public Set<Entry<HexCoordinate, Terrain>> entrySet() {
			return new EntrySet();
		}

		@Override // needed for functionality
		public Terrain put(HexCoordinate key, Terrain value) {
		    if (key == null || value == null) throw new IllegalArgumentException();
			Terrain t = terrainAt(key);
			add(new HexTile(value,key));
			return t;
		}

		@Override // needed for efficiency
		public Terrain get(Object key) {
			if (!(key instanceof HexCoordinate)) return null;
			return terrainAt((HexCoordinate)key);
		}

		@Override // needed for efficiency
		public boolean containsKey(Object key) {
			if (!(key instanceof HexCoordinate)) return false;
			return terrainAt((HexCoordinate)key) != null;
		}

		@Override // needed for efficiency
		public Terrain remove(Object key) {
			if (!(key instanceof HexCoordinate)) return null;
			HexCoordinate h = (HexCoordinate)key;
			Terrain t = terrainAt(h);
			if (t != null) HexBoard.this.remove(new HexTile(t,h));
			return t;
		}		
	}
	
	private class EntrySet extends AbstractSet<Entry<HexCoordinate,Terrain>> {

		@Override // required by Java
		public Iterator<Entry<HexCoordinate, Terrain>> iterator() {
			return new EntrySetIterator();
		}

		@Override // required by Java
		public int size() {
			return HexBoard.this.size();
		}

		@Override // required for efficiency
		public boolean contains(Object o) {
			if (!(o instanceof Entry<?,?>)) return false;
			Entry<?,?> entry = (Entry<?,?>)o;
			if (!(entry.getKey() instanceof HexCoordinate)) return false;
			HexCoordinate h = (HexCoordinate)entry.getKey();
			if (!(entry.getValue() instanceof Terrain)) return false;
			Terrain t = (Terrain)entry.getValue();
			return terrainAt(h) == t;
		}

		@Override // required for efficiency
		public boolean remove(Object o) {
			if (!(o instanceof Entry<?,?>)) return false;
			Entry<?,?> entry = (Entry<?,?>)o;
			if (!(entry.getKey() instanceof HexCoordinate)) return false;
			HexCoordinate h = (HexCoordinate)entry.getKey();
			if (!(entry.getValue() instanceof Terrain)) return false;
			Terrain t = (Terrain)entry.getValue();
			return HexBoard.this.remove(new HexTile(t,h));
		}		
	}
		
	private class MyIterator implements Iterator<HexTile> {
		private Iterator<Entry<HexCoordinate, Terrain>> it;
		
		MyIterator() {
			it = new EntrySetIterator();
		}
		
		@Override // Required by Java
		public boolean hasNext() {
			return it.hasNext();
		}
		
		@Override // Required by Java
		public HexTile next() {
			Entry<HexCoordinate,Terrain> n = it.next();
			return new HexTile(n.getValue(), n.getKey());
		}
		
		@Override //Required for functionality 
		public void remove() {
			it.remove();
		}
	}
	
	private class EntrySetIterator implements Iterator<Entry<HexCoordinate,Terrain>> {
		private int index;
		private Node current;
		private boolean canRemove;
		private int myVersion;
	    
		private boolean wellFormed() {
			if (!HexBoard.this.wellFormed()) return false;
			// OPTIONAL: define an invariant on the iterator
			// (Only check if the iterator is not stale!)
			return true;
		}
		
		private void checkVersion() {
            if (version != myVersion) throw new ConcurrentModificationException("stale");
        }

		private EntrySetIterator() {
			index = -1;
			current = null;
			canRemove = false;
			myVersion = version;
			assert wellFormed();
		}
		
		@Override // required by Java
		public boolean hasNext() {
		    checkVersion(); 
		    if ((current != null) && (current.next != null)) return true;
	        for (int i = index + 1; i < array.length; ++i) {
	            if (array[i] != null) return true;
	        }
			return false;
		}

		@Override // required by Java
		public Entry<HexCoordinate,Terrain> next() {
		    checkVersion();
		    if (!hasNext()) throw new NoSuchElementException("Exhausted");
			if (current != null) current = current.next;
			while (current == null) {
			    ++index;
			    current = array[index];
			}
			canRemove = true;
			return current;
		}

		@Override // required for functionality
		public void remove() {
		    checkVersion();
			if (!canRemove) throw new IllegalStateException("Remove can only be called a single time following next()");
			HexBoard.this.remove(current.tile);
			++myVersion;
			canRemove = false;
		}
	}
	
	public static class TestInternals extends TestCase {
		private HexBoard self;
		
		private void assertWellFormed(boolean val) {
			doReport = val;
			assertEquals(val,self.wellFormed());
		}
		
		private HexCoordinate h(int a, int b) {
			return new HexCoordinate(a,b);
		}
		
		private HexTile ht(Terrain t, HexCoordinate h) {
			return new HexTile(t,h);
		}
		
		private HexCoordinate h1 = h(3,0), h1x = h(10,0);
		private HexCoordinate h2 = h(2,1);
		private HexCoordinate h3 = h(3,1);
		private HexCoordinate h4 = h(2,2);
		private HexCoordinate h5 = h(3,2);
		private HexCoordinate h6 = h(4,2);
		private HexCoordinate h7 = h(7,4), h7x = h(8,4);
		
		private Node n(HexCoordinate h,Terrain t,Node n1) {
			Node result = new Node(false);
			result.tile = ht(t,h);
			result.next = n1;
			return result;
		}
		
		private Node clone(Node n) {
			return n(n.tile.getLocation(),n.tile.getTerrain(),n.next);
		}
		
		private static int unique = 0;
		
		@Override
		protected void setUp() {
			self = new HexBoard(false);
			self.size = 0;
			self.array = new Node[7];
			self.version = ++unique;
			assertWellFormed(true);
		}

		public void test() {
			System.out.println("h1.hashCode() = " + h1.hashCode());
			System.out.println("h2.hashCode() = " + h2.hashCode());
			System.out.println("h3.hashCode() = " + h3.hashCode());
			System.out.println("h4.hashCode() = " + h4.hashCode());
			System.out.println("h5.hashCode() = " + h5.hashCode());
			System.out.println("h6.hashCode() = " + h6.hashCode());
			System.out.println("h7.hashCode() = " + h7.hashCode());
			System.out.println("h1x.hashCode() = " + h1x.hashCode());
			System.out.println("h7x.hashCode() = " + h7x.hashCode());
		}
		public void testA() {
			self.array = null;
			assertWellFormed(false);
		}
		
		public void testB() {
			self.array = new Node[6];
			assertWellFormed(false);
			self.array = new Node[5];
			assertWellFormed(false);
			self.array = new Node[9];
			assertWellFormed(false);
		}
		
		public void testC() {
			self.array = new Node[11];
			assertWellFormed(false);
			self.array = new Node[17];
			assertWellFormed(false);			
		}
		
		public void testD() {
			Node n1 = n(h1,Terrain.CITY,null);
			self.size = 1;
			assertWellFormed(false);
			self.array[3] = n1;
			assertWellFormed(true);
			self.size = 0;
			assertWellFormed(false);
			self.size = 2;
			assertWellFormed(false);
		}
		
		public void testE() {
			Node n1 = n(h1,Terrain.CITY,null);
			self.size = 1;
			self.array[1] = n1;
			assertWellFormed(false);
			self.array[3] = n1;
			self.size = 2;
			assertWellFormed(false);
			self.array[1] = null;
			self.array[6] = n1;
			assertWellFormed(false);
		}
		
		public void testF() {
			Node n2 = n(h2,Terrain.WATER,null);
			self.size = 1;
			self.array[6] = n2;
			assertWellFormed(true);
			self.array = new Node[11];
			assertWellFormed(false);
			self.array[6] = n2;
			assertWellFormed(false);
			self.array[6] = null;
			self.array[5] = n2;
			assertWellFormed(true);
		}
		
		public void testG() {
			Node n1 = n(h1,Terrain.CITY,null);
			Node n2 = n(h2,Terrain.WATER,null);
			self.array[3] = n1;
			self.array[6] = n2;
			assertWellFormed(false);
			self.size = 1;
			assertWellFormed(false);
			self.size = 3;
			assertWellFormed(false);
			self.size = 2;
			assertWellFormed(true);
		}
		
		public void testH() {
			Node n1 = n(h1,Terrain.CITY,null);
			Node n2 = n(h2,Terrain.WATER,null);
			self.array[6] = n1;
			self.array[3] = n2;
			self.size = 2;
			assertWellFormed(false);
		}
		
		public void testI() {
			Node n1 = n(h1,Terrain.CITY,null);
			Node n2 = n(h2,Terrain.WATER,n1);
			self.size = 2;
			self.array[3] = n2;
			assertWellFormed(false);
			self.array = new Node[17];
			self.array[3] = n2;
			assertWellFormed(true);
			self.array = new Node[7];
			self.array[6] = n2;
			assertWellFormed(false);
			self.array[3] = n1;
			assertWellFormed(false);
		}
		
		public void testJ() {
			Node n1 = n(h1,Terrain.CITY,null);
			Node n2 = n(h2,Terrain.WATER,n1);
			self.size = 2;
			self.array = new Node[17];
			self.array[3] = n2;
			n1.next = clone(n2);
			n1.next.next = null;
			assertWellFormed(false);
			self.size = 3;
			assertWellFormed(false);
			n1.next.tile = ht(Terrain.FOREST,h1);
			assertWellFormed(false);
		}
		
		public void testK() {
			Node n1 = n(h1,Terrain.CITY,null);
			Node n2 = n(h2,Terrain.WATER,n1);
			self.size = 2;
			self.array = new Node[17];
			self.array[3] = n2;
			n1.next = clone(n2);
			assertWellFormed(false);
			self.size = 3;
			assertWellFormed(false);
			n1.next.tile = ht(Terrain.FOREST,h1);
			assertWellFormed(false);
		}
		
		public void testL() {
			Node n1 = n(h1,Terrain.CITY,null);
			Node n2 = n(h2,Terrain.WATER,n1);
			self.size = 2;
			self.array = new Node[17];
			self.array[3] = n2;
			n1.next = n2;
			assertWellFormed(false);
			n1.next = clone(n2);
			assertWellFormed(false);
			n1.next.next = n2;
			assertWellFormed(false);
			n1.next.next = n1;
			assertWellFormed(false);
		}
		
		public void testM() {
			Node n1 = n(h1,Terrain.CITY,null);
			Node n2 = n(h2,Terrain.WATER,null);
			Node n3 = n(h3,Terrain.LAND,null);
			Node n4 = n(h4,Terrain.MOUNTAIN,null);
			Node n5 = n(h5,Terrain.DESERT,null);
			Node n6 = n(h6,Terrain.FOREST,null);
			Node n7 = n(h7,Terrain.INACCESSIBLE,null);
			self.array[3] = n1;
			self.array[6] = n2;
			self.array[0] = n3;
			self.size = 3;
			assertWellFormed(true);
			n1.next = n4;
			assertWellFormed(false);
			self.size = 4;
			assertWellFormed(true);
			self.array[4] = n5;
			self.size = 5;
			assertWellFormed(true);
			self.array[5] = n6; 
			self.size = 6;
			assertWellFormed(false);
			self.array[3] = null;
			self.size = 4;
			assertWellFormed(true);
			self.array[2] = n7;
			self.size = 5;
			assertWellFormed(true);
		}
		
		public void testN() {
			Node n1 = n(h1,Terrain.CITY,null);
			Node n2 = n(h2,Terrain.WATER,null);
			Node n3 = n(h3,Terrain.LAND,null);
			Node n4 = n(h4,Terrain.MOUNTAIN,null);
			self.array[3] = n1;
			self.array[6] = n2;
			self.array[0] = n3;
			n1.next = n4;
			self.size = 4;
			assertWellFormed(true);
			n1.tile = null;
			assertWellFormed(false);
			n1.tile = ht(Terrain.FOREST,h1);
			assertWellFormed(true);
			n4.tile = null;
			assertWellFormed(false);
		}
		
		public void testO() {
			Node n1 = n(h1,Terrain.CITY,null);
			Node n1x = n(h1x,Terrain.WATER,n1);
			Node n4 = n(h4,Terrain.MOUNTAIN,n1x);
			Node n7x = n(h7x,Terrain.LAND,n4);
			self.array[3] = n7x;
			self.size = 4;
			assertWellFormed(true);
			n1.next = n1;
			assertWellFormed(false);
			n1.next = n1x;
			assertWellFormed(false);
			n1.next = n4;
			assertWellFormed(false);
			n1.next = n7x;
			assertWellFormed(false);
		}
	}
}
