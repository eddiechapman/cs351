package edu.uwm.cs351;

import java.util.AbstractCollection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import junit.framework.TestCase;

/**
 * An implementation of the HexBoard ADT using a binary search tree 
 * implementation. A hex board is a collection of hex tiles except 
 * that there can never be two tiles at the same location. 
 */
public class HexBoard extends AbstractCollection<HexTile> 
{
    private static boolean doReport = true;
    
    private Node root;
    private int size;
    private int version;

    private static class Node {
        HexCoordinate loc;
        Terrain terrain;
        Node left, right;
        Node(HexCoordinate l, Terrain t) { loc = l; terrain = t; }
    }
    
    /**
     * Create an empty hex board.
     */
    public HexBoard() {
        root = null;
        size = 0;
        version = 0;
        assert wellFormed() : "in constructor";
    }
    
	private static boolean report(String s) {
        if (doReport) System.err.println("Invariant error: " + s);
        return false;
    }
	
	/**
	 * Compare two hex coordinates so that it does one full row before the next one 
	 * in order.  That means that the b()coordinate (the row) must be checked first, 
	 * and then a()if the rows are the same.  
	 * 
	 * This method can be implemented with a single “if” statement.
	 * 
	 * @param h1
	 * @param h2
	 * @return         -1 if h1 comes before h2, 0 if they are equal, and 1 if h1 
	 *                 comes after h2. 
	 */
	private static int compare(HexCoordinate h1, HexCoordinate h2) {
	    int c = Integer.compare(h1.b(), h2.b());
	    if (c == 0) c = Integer.compare(h1.a(), h2.a());
	    return c;
    }
	
	/**
	 * Return true if the nodes in this BST are properly ordered with respect to the 
	 * {@link #compare(HexCoordinate, HexCoordinate)} method.  If a problem is found, 
	 * it should be reported (once).
	 * 
	 * @param r        subtree to check (may be null)
	 * @param lo       lower bound (if any)
	 * @param hi       upper bound (if any)
	 * @return         whether there are any problems in the tree.
	 * 
	 */
	private static boolean isInProperOrder(Node r, HexCoordinate lo, HexCoordinate hi) {   
	    if (r != null) {
	        try {
	            assert r.loc != null;
	            assert r.terrain != null;
	            if (lo != null) assert compare(r.loc, lo) > 0;
	            if (hi != null) assert compare(r.loc, hi) < 0;
	        }
	        catch(AssertionError e) {
	            return false;
	        }
	        return isInProperOrder(r.left, lo, r.loc) && isInProperOrder(r.right, r.loc, hi);
	    }
	    return true;
	}
	
	/**
	 * Return the count of the nodes in this subtree.
	 * 
	 * @param p        subtree to count nodes for (may be null)
	 * @return         number of nodes in the subtree.
	 */
	private static int countNodes(Node p) {
	    if (p == null) return 0;
		return countNodes(p.left) + countNodes(p.right) + 1;
	}
	
	private boolean wellFormed() {
        if (!isInProperOrder(root, null, null)) 
            return report("Tree is out of proper order.");
  
        if (size != countNodes(root)) 
            return report(String.format("Size disparity. Field: %d\tMethod: %d", 
                                        size, countNodes(root)));
        
        return true;
    }
	
	/** 
	 * Return the terrain at the given coordinate or null if nothing at this 
	 * coordinate.
	 * 
	 * @param c        hex coordinate to look for (null OK but pointless)
	 * @return         terrain at that coordinate, or null if nothing
	 */
	public Terrain terrainAt(HexCoordinate l) {
		assert wellFormed() : "in terrainAt";
		return null; // TODO
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

	// new methods (used by the iterator)
	
	/**
	 * Return the "b" coordinate of the first tile in the hex board, or 
	 * 0 if the board is empty.
	 * 
	 * @return         row of first tile or zero if none
	 */
	private int getFirstRow() {
		assert wellFormed() : "in getFirstRow()";
		int firstRow = 0;
		Node n = root;
		while (n != null) {
		    firstRow = n.loc.b();
		    n = n.left;
		}
		return firstRow;
	}
	
	/**
	 * Return the "b" coordinate of the last tile in the hex board, or 0 
	 * if the board is empty.
	 * 
	 * @return         row of last tile, or zero if none
	 */
	private int getLastRow() {
		assert wellFormed() : "in getLastRow()";
		int lastRow = 0;
		Node n = root;
		while (n != null) {
		    lastRow = n.loc.b();
		    n = n.right;
		}
		return lastRow;
	}
	
	/**
	 * Return the first (leftmost) hex tile in the given row, if any.
	 * 
	 * @param b        row number (second part of hex coordinate)
	 * 
	 * @return         hex tile with lowest a with this b location, 
	 *                 or null if no such hex tile.
	 */
	private HexTile getFirstInRow(int b) {
		assert wellFormed() : "in getFirstInRow()";
		HexTile leftMost = null;
		Node n = root;
		while (n != null) {
		    if (n.loc.b() < b) {
		        n = n.right;
		    } else if (n.loc.b() == b) {
		        if (leftMost == null) {
		            leftMost = new HexTile(n.terrain, n.loc);
		        }
		        if (n.loc.a() < leftMost.getLocation().a()) {
		            leftMost = new HexTile(n.terrain, n.loc);
		        }
		        n = n.left;
		    } else {
		        n = n.left;
		    }
		}
		return leftMost;
	}

	
	/**
	 * Return the first (rightmost) hex tile in the given row, if any.
	 * 
	 * @param b        row number (second [part of hex coordinate)
	 * 
	 * @return         hex tile with highest a with this b location, 
	 *                 or null if no such hex tile.
	 */
	private HexTile getLastInRow(int b) {
		assert wellFormed() : "in getLastInRow()";
        Node n = root;
        HexTile rightMost = null;
        while (n != null) {
            if (n.loc.b() < b) {
                n = n.right;
            } else if (n.loc.b() == b) {
                if (rightMost == null) {
                    rightMost = new HexTile(n.terrain, n.loc);
                }
                if (n.loc.a() > rightMost.getLocation().a()) {
                    rightMost = new HexTile(n.terrain, n.loc);
                }
                n = n.right;
            } else {
                n = n.left;
            }
        }
        return rightMost;
	}

	// TODO: What else?
	
	private class MyIterator implements Iterator<HexTile> {
		// TODO: fields, constructor, any helper method(s) (see homework description)
	    private int myVersion;
	    private int currentRow;
	    private int nextColumn;
	    
	    public MyIterator() {
	        myVersion = version;
	        currentRow = getFirstRow();
	    }
		
		@Override // required by Java
		public boolean hasNext() {
			return false; // TODO
		}

		@Override // required by Java
		public HexTile next() {
			return null; // TODO: find next entry and generate hex tile on demand
		}

		// TODO: anything else?
	}

	// Do not change anything in this test class:
	public static class TestInternals extends TestCase {
		private HexBoard self;
		
		private HexCoordinate h(int a, int b) {
			return new HexCoordinate(a,b);
		}
		
		private HexCoordinate h1 = h(3,0), h1x = h(4,0);
		private HexCoordinate h2 = h(2,1);
		private HexCoordinate h3 = h(3,1), h3x = h(4,1);
		private HexCoordinate h4 = h(2,2);
		private HexCoordinate h5 = h(3,2);
		private HexCoordinate h6 = h(4,2);
		private HexCoordinate h7 = h(7,4);
		
		private Node n(HexCoordinate h,Terrain t,Node n1, Node n2) {
			Node result = new Node(h,t);
			result.left = n1;
			result.right = n2;
			return result;
		}
		
		@Override
		protected void setUp() {
			self = new HexBoard();
			self.size = 0;
			self.root = null;
			self.version = 0;
		}
		
		
		/// Compare tests:
		
		public void testC0() {
			assertEquals(0,compare(h(2,1),h(2,1)));
		}
		
		public void testC1() {
			assertTrue(compare(h(2,1),h(1,2)) < 0);
			assertTrue(compare(h(1,2),h(2,1)) > 0);
		}
		
		public void testC2() {
			assertTrue(compare(h(2,1),h(3,1)) < 0);
			assertTrue(compare(h(3,1),h(2,1)) > 0);
		}
		
		public void testC3() {
			assertTrue(compare(h(5,0),h(0,5)) < 0);
			assertTrue(compare(h(0,5),h(5,0)) > 0);
		}
		
		public void testC4() {
			assertTrue(compare(h(-4,-4),h(-2,-4)) < 0);
			assertTrue(compare(h(-2,-4),h(-4,-4)) > 0);
		}
		
		public void testC5() {
			assertTrue(compare(h(3,2),h(3,4)) < 0);
			assertTrue(compare(h(3,4),h(3,2)) > 0);
		}
		
		// testing count nodes
		
		public void testC6() {
			assertEquals(0,countNodes(null));
		}
		
		public void testC7() {
			assertEquals(1,countNodes(n(h(1,1),Terrain.CITY,null,null)));
		}
		
		public void testC8() {
			Node n1 = n(null,null,null,null);
			Node n2 = n(null,null,null,null);
			Node n3 = n(null,null,n1,n2);
			assertEquals(3,countNodes(n3));
		}
		
		public void testC9() {
			Node n1 = n(null,null,null,null);
			Node n2 = n(null,null,n1,null);
			Node n3 = n(null,null,null,n2);
			Node n4 = n(null,null,null,null);
			Node n5 = n(null,null,null,n4);
			Node n6 = n(null,null,n5,null);
			Node n7 = n(null,null,n3,n6);
			assertEquals(7,countNodes(n7));
		}
		
		
		/// testing isInProperOrder
		
		public void testI0() {
			assertEquals("null tree",true,isInProperOrder(null, null, null));
			assertEquals("null tree",true,isInProperOrder(null, null, h5));
			assertEquals("null tree",true,isInProperOrder(null, h3, null));
			assertEquals("null tree",true,isInProperOrder(null, h3, h5));
		}
		
		public void testI1() {
			Node a1 = new Node(h1,Terrain.CITY);
			Node b2 = new Node(h2,Terrain.CITY);
			assertEquals("one node tree",true,isInProperOrder(a1, null, null));
			assertEquals("one node tree",true,isInProperOrder(a1, null, h2));
			assertEquals("one node tree out of range",false,isInProperOrder(a1, h1, null));
			assertEquals("one node tree out of range",false,isInProperOrder(b2, null, h2));
			assertEquals("one node tree in range",true,isInProperOrder(b2, h1, null));
			assertEquals("one node tree in range",true,isInProperOrder(b2, h1, h3));
		}
		
		public void testI2() {
			Node a1 = new Node(h1,Terrain.CITY);
			Node a2 = new Node(h1,Terrain.CITY);
			Node b2 = new Node(h2,Terrain.CITY);
			a1.left = a2;
			assertEquals("malformed tree",false, isInProperOrder(a1, null, null));
			b2.left = a2;
			assertEquals("OK tree (ba)",true,isInProperOrder(b2, null, null));
		}

		public void testI3() {
			Node a1 = new Node(h1,Terrain.CITY);
			Node a2 = new Node(h1,Terrain.CITY);
			Node a3 = new Node(h1,Terrain.CITY);
			Node b2 = new Node(h2,Terrain.CITY);
			a1.right = a2;
			assertEquals("malformed tree",false, isInProperOrder(a1, null, null));
			a1.right = b2;
			assertEquals("OK tree (ab)",true,isInProperOrder(a1, null, null));
			a1.left=a3;
			assertEquals("malformed tree",false, isInProperOrder(a1, null, null));
			a1.left = a1.right = null;
			assertEquals("good tree",true, isInProperOrder(a1, null, null));
		}
		
		public void testI4() {
			Node a1 = new Node(h1,Terrain.CITY);
			Node b2 = new Node(h2,Terrain.CITY);
			Node c3 = new Node(h3,Terrain.CITY);
			
			b2.left = a1;
			b2.right = c3;
			assertEquals("OK tree (bac)",true,isInProperOrder(b2, null, null));
			assertEquals("OK tree (bac) in range",true,isInProperOrder(b2, null, h3x));
			assertEquals("tree (bac) not in hi range",false,isInProperOrder(b2, null, h3));
			assertEquals("tree (bac) not in lo range",false,isInProperOrder(b2, h1, null));
		}
		
		public void testI5() {
			Node a1 = new Node(h1,Terrain.CITY);
			Node a2 = new Node(h1,Terrain.CITY);
			Node a3 = new Node(h1,Terrain.CITY);
			
			a1.left = a2;
			assertEquals("malformed tree",false, isInProperOrder(a1, null, null));
			a1.left=null;
			a1.right = a2;
			assertEquals("malformed tree",false, isInProperOrder(a1, null, null));
			a1.left=a3;
			assertEquals("malformed tree",false, isInProperOrder(a1, null, null));
			a1.left = a1.right = null;
			assertEquals("good tree",true, isInProperOrder(a1, null, null));
		}


		public void testI6() {
			Node a = new Node(h1,Terrain.CITY);
			Node b = new Node(h2,Terrain.CITY);
			Node c = new Node(h3,Terrain.CITY);
			Node d = new Node(h4,Terrain.CITY);
			Node e = new Node(h5,Terrain.CITY);
			Node f = new Node(h6,Terrain.CITY);
			
			c.left = b;
			b.left = a;
			c.right = e;
			e.left = d;
			
			e.terrain = null;
			assertEquals("null terrain in tree",false, isInProperOrder(c, null, null));
			e.terrain = Terrain.FOREST;
			e.loc = null;
			assertEquals("null terrain in tree",false, isInProperOrder(c, null, null));			
			e.loc = h5;	
			assertEquals("good tree",true, isInProperOrder(c, null, null));
			
			e.left=f;
			f.left=d;
			assertEquals("malformed tree",false, isInProperOrder(c, null, null));
			f.left=null;
			e.right=f;
			e.left=d;
			assertEquals("good tree",true, isInProperOrder(c, null, null));
			
			Node aa = new Node(h1x,Terrain.CITY);
			a.left=aa;
			assertEquals("malformed tree",false, isInProperOrder(c, null, null));
			a.left=null;
			a.right=aa;
			assertEquals("good tree",true, isInProperOrder(c, null, null));
		}
		
		public void testI7() {
			Node a = new Node(h1,Terrain.CITY);
			Node b = new Node(h2,Terrain.CITY);
			Node c = new Node(h3,Terrain.CITY);
			Node d = new Node(h4,Terrain.CITY);
			Node e = new Node(h5,Terrain.CITY);
			Node f = new Node(h6,Terrain.CITY);
			
			a.right = b;
			b.right = c;
			c.right = d;
			d.right = e;
			e.left=f;
			assertEquals("malformed tree",false, isInProperOrder(a, null, null));
			e.left=null;
			a.left=f;
			assertEquals("malformed tree",false, isInProperOrder(a, null, null));
			a.left=b;
			a.right=null;
			assertEquals("malformed tree",false, isInProperOrder(a, null, null));
			b.right=null;
			a.left=null;
			a.right=c;
			c.left=b;
			assertEquals("good tree",true, isInProperOrder(a, null, null));
		}
		
		public void testI9() {
			Node n1 = new Node(h1,Terrain.CITY);
			Node n2 = new Node(h2,Terrain.CITY);
			Node n3 = new Node(h3,Terrain.CITY);
			Node n4 = new Node(h4,Terrain.CITY);
			n2.left = n1;
			n2.right = n3;
			n1.right = n2;
			assertEquals("cyclic tree",false,isInProperOrder(n2, null, null));
			n1.right = null;
			n3.left = n2;
			assertEquals("cyclic tree",false,isInProperOrder(n2, null, null));
			n3.left = null;
			n3.right = n3;
			assertEquals("cyclic tree",false,isInProperOrder(n2, null, null));
			n3.right = n4;
			assertEquals("acyclic tree",true,isInProperOrder(n2, null, null));
			n4.left = n3;
			assertEquals("cyclic tree",false,isInProperOrder(n2, null, null));
		}
		
		
		/// invariant tests
		// Don't do until both C and I tests are succeeding
		
		public void testJ0() {
			self.root = null;
			self.size = 0;
			assertTrue(self.wellFormed());
			self.size = 1;
			assertFalse(self.wellFormed());
		}
		
		public void testJ1() {
			testI1();
			self.root = new Node(h(3,2),Terrain.FOREST);
			self.size = 0;
			assertFalse(self.wellFormed());
			self.size = 1;
			assertTrue(self.wellFormed());
		}
		
		public void testJ2() {
            Node a1 = new Node(h1,Terrain.CITY);
            Node a2 = new Node(h1,Terrain.CITY);
            Node b2 = new Node(h2,Terrain.CITY);
            self.size = 2;
            a1.left = a2;
            self.root = a1;
            assertFalse(self.wellFormed());
            b2.left = a2;
			self.root = b2;
			assertTrue(self.wellFormed());
			self.size = 1;
			assertFalse(self.wellFormed());
		}
		
		public void testJ3() {
			self.size = 2;
            Node a1 = new Node(h1,Terrain.CITY);
            Node a2 = new Node(h1,Terrain.CITY);
            Node a3 = new Node(h1,Terrain.CITY);
            Node b2 = new Node(h2,Terrain.CITY);
            a1.right = a2;
            self.root = a1;
            assertFalse(self.wellFormed());
            a1.right = b2;
            assertTrue(self.wellFormed());
            self.size = 3;
            assertFalse(self.wellFormed());
            a1.left=a3;
            assertFalse(self.wellFormed());
            a1.loc = h1x;
            assertTrue(self.wellFormed());
		}
		
		public void testJ4() {
			self.size = 4;
            Node a1 = new Node(h1,Terrain.CITY);
            Node b2 = new Node(h2,Terrain.CITY);
            Node c3 = new Node(h3,Terrain.CITY);
            
            b2.left = a1;
            b2.right = c3;
            
            self.root = b2;
            assertFalse(self.wellFormed());
            self.size = 3;
            assertTrue(self.wellFormed());
		}
		
		public void testJ5() {
			self.size = 2;
            Node a1 = new Node(h1,Terrain.CITY);
            Node a2 = new Node(h1,Terrain.CITY);
            Node a3 = new Node(h1,Terrain.CITY);
            
            self.root = a1;
            
            a1.left = a2;
            assertFalse(self.wellFormed());
            a1.left=null;
            a1.right = a2;
            assertFalse(self.wellFormed());
            a1.left=a3;
            assertFalse(self.wellFormed());
            a1.left = a1.right = null;
            assertFalse(self.wellFormed());
            self.size = 1;
            assertTrue(self.wellFormed());
		}
		
		public void testJ6() {
            Node a = new Node(h1,Terrain.CITY);
            Node b = new Node(h2,Terrain.CITY);
            Node c = new Node(h3,Terrain.CITY);
            Node d = new Node(h4,Terrain.CITY);
            Node e = new Node(h5,Terrain.CITY);
            Node f = new Node(h6,Terrain.CITY);

            self.root = c;
			self.size = 5;
			
            c.left = b;
            b.left = a;
            c.right = e;
            e.left = d;
            
            e.terrain = null;
            assertFalse(self.wellFormed());
            e.terrain = Terrain.FOREST;
            e.loc = null;
            assertFalse(self.wellFormed());                     
            e.loc = h5;     
            assertTrue(self.wellFormed());
            
            self.size = 6;
            assertFalse(self.wellFormed());
            
            e.left=f;
            f.left=d;
            assertFalse(self.wellFormed());
            f.left=null;
            e.right=f;
            e.left=d;
            assertTrue(self.wellFormed());
            
            Node aa = new Node(h1x,Terrain.CITY);
            a.left=aa;
            assertFalse(self.wellFormed());
            a.left=null;
            a.right=aa;
            assertFalse(self.wellFormed());
            
            self.size = 7;
            assertTrue(self.wellFormed());			
		}
		
		public void testJ7() {
            Node a = new Node(h1,Terrain.CITY);
            Node b = new Node(h2,Terrain.CITY);
            Node c = new Node(h3,Terrain.CITY);
            Node d = new Node(h4,Terrain.CITY);
            Node e = new Node(h5,Terrain.CITY);
            Node f = new Node(h6,Terrain.CITY);
            
            self.root = a;
            self.size = 6;
            
            a.right = b;
            b.right = c;
            c.right = d;
            d.right = e;
            e.left=f;
            assertFalse(self.wellFormed());
            e.left=null;
            a.left=f;
            assertFalse(self.wellFormed());
            a.left=b;
            a.right=null;
            assertFalse(self.wellFormed());
            b.right=null;
            a.left=null;
            a.right=c;
            c.left=b;
            assertFalse(self.wellFormed());
            self.size = 5;
            assertTrue(self.wellFormed());
		}
		
		public void testJ9() {
            Node n1 = new Node(h1,Terrain.CITY);
            Node n2 = new Node(h2,Terrain.CITY);
            Node n3 = new Node(h3,Terrain.CITY);
            Node n4 = new Node(h4,Terrain.CITY);
            
            self.root = n2;
            self.size = 4;
            
            n2.left = n1;
            n2.right = n3;
            n1.right = n2;
            assertFalse(self.wellFormed());
            n1.right = null;
            n3.left = n2;
            assertFalse(self.wellFormed());
            n3.left = null;
            n3.right = n3;
            assertFalse(self.wellFormed());
            n3.right = n4;
            assertTrue(self.wellFormed());
            n4.left = n3;
            assertFalse(self.wellFormed());
		}
		
		
		/// test first/last row
		
		public void testR0() {
			self.root = null;
			self.size = 0;
			assertEquals(0,self.getFirstRow());
			assertEquals(0,self.getLastRow());
		}
		
		public void testR1() {
			self.root = new Node(h3,Terrain.FOREST);
			self.size = 1;
			assertEquals(h3.b(),self.getFirstRow());
			assertEquals(h3.b(),self.getLastRow());
		}
		
		public void testR2() {
			Node n1 = new Node(h4,Terrain.WATER);
			self.root = n(h2,Terrain.LAND,null,n1);
			self.size = 2;
			assertEquals(1,self.getFirstRow());
			assertEquals(2,self.getLastRow());
		}
		
		public void testR3() {
			Node n1 = new Node(h3,Terrain.FOREST);
			Node n2 = n(h5,Terrain.MOUNTAIN,n1,null);
			self.root = n(h1,Terrain.INACCESSIBLE,null,n2);
			self.size = 3;
			assertEquals(0,self.getFirstRow());
			assertEquals(2,self.getLastRow());
		}
		
		public void testR4() {
			Node n1 = new Node(h(1,-1067),Terrain.WATER);
			Node n2 = new Node(h(2,-3829),Terrain.LAND);
			Node n3 = n(h(3,-1031),Terrain.CITY,n1,null);
			Node n4 = n(h(4,-5489),Terrain.DESERT,null,n2);
			self.root = n(h(5,-2222),Terrain.FOREST,n4,n3);
			self.size = 5;
			assertEquals(-5489,self.getFirstRow());
			assertEquals(-1031,self.getLastRow());
		}
		
		public void testR5() {
			Node n1 = new Node(h(1,-92618),Terrain.MOUNTAIN);
			Node n2 = n(h(2,-45213),Terrain.LAND,n1,null);
			Node n5 = new Node(h(5,-9987),Terrain.INACCESSIBLE);
			Node n4 = n(h(4,-10635),Terrain.DESERT,null,n5);
			self.root = n(h(3,-29850),Terrain.WATER,n2,n4);
			self.size = 5;
			assertEquals(-92618,self.getFirstRow());
			assertEquals(-9987,self.getLastRow());
		}
		
		
		/// Testing get first/last in row
		
		public void testS0() {
			assertNull(self.getFirstInRow(0));
			assertNull(self.getLastInRow(0));
			assertNull(self.getFirstInRow(13));
			assertNull(self.getLastInRow(-98));
		}
		
		public void testS1() {
			self.root = new Node(h3,Terrain.CITY);
			self.size = 1;
			assertNull(self.getFirstInRow(0));
			assertEquals(new HexTile(Terrain.CITY,h(3,1)),self.getFirstInRow(1));
			assertNull(self.getFirstInRow(2));
			assertNull(self.getLastInRow(0));
			assertEquals(new HexTile(Terrain.CITY,h(3,1)),self.getLastInRow(1));
			assertNull(self.getLastInRow(2));
		}
		
		public void testS2() {
			Node n2 = new Node(h2,Terrain.LAND);
			self.root = n(h3,Terrain.DESERT,n2,null);
			self.size = 2;
			assertNull(self.getFirstInRow(0));
			assertEquals(new HexTile(Terrain.LAND,h2),self.getFirstInRow(1));
			assertNull(self.getFirstInRow(2));
			assertNull(self.getLastInRow(0));
			assertEquals(new HexTile(Terrain.DESERT,h3),self.getLastInRow(1));
			assertNull(self.getLastInRow(2));
		}
		
		private void testS3Help(HexTile t4,HexTile t6) {
			assertNull(self.getFirstInRow(1));
			assertEquals(t4,self.getFirstInRow(2));
			assertNull(self.getFirstInRow(3));
			assertNull(self.getLastInRow(1));
			assertEquals(t6,self.getLastInRow(2));
			assertNull(self.getLastInRow(3));			
		}
		
		public void testS3() {
			Node n4 = new Node(h4,Terrain.FOREST);
			Node n5 = new Node(h5,Terrain.WATER);
			Node n6 = new Node(h6,Terrain.MOUNTAIN);
			HexTile t4 = new HexTile(Terrain.FOREST,h4);
			HexTile t6 = new HexTile(Terrain.MOUNTAIN,h6);
			self.size = 3;
			
			self.root = n5;
			n5.left = n4;
			n5.right = n6;
			testS3Help(t4,t6);
			n5.left = n5.right = null;
			
			self.root = n4;
			n4.right = n5;
			n5.right = n6;
			testS3Help(t4,t6);
			n4.right = n5.right = null;
			
			n4.right = n6;
			n6.left = n5;
			testS3Help(t4,t6);
			n4.right = n6.left = null;
			
			self.root = n6;
			n6.left = n5;
			n5.left = n4;
			testS3Help(t4,t6);
			n6.left = n5.left = null;
			
			n6.left = n4;
			n4.right = n5;
			testS3Help(t4,t6);
		}
		
		public void testS4() {
			Node n3 = new Node(h1,Terrain.CITY);
			Node n4 = new Node(h4,Terrain.FOREST);
			Node n5 = new Node(h5,Terrain.WATER);
			Node n6 = new Node(h6,Terrain.MOUNTAIN);
			Node n7 = new Node(h7,Terrain.DESERT);
			HexTile t4 = new HexTile(Terrain.FOREST,h4);
			HexTile t6 = new HexTile(Terrain.MOUNTAIN,h6);
			self.size = 5;
			
			self.root = n5;
			n5.left = n3;
			n3.right = n4;
			n5.right = n7;
			n7.left = n6;
			testS3Help(t4,t6);
			n5.left = n3.right = n5.right = n7.left = null;
			
			self.root = n3;
			n3.right = n5;
			n5.left = n4;
			n5.right = n7;
			n7.left = n6;
			testS3Help(t4,t6);
			n5.left = n3.right = n5.right = n7.left = null;
			
			self.root = n7;
			n7.left = n3;
			n3.right = n6;
			n6.left = n4;
			n4.right = n5;
			testS3Help(t4,t6);
			n7.left = n3.right = n6.left = n4.right = null;
		}
	}
}
