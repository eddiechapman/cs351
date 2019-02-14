// This is an assignment for students to complete after reading Chapter 4 of
// "Data Structures and Other Objects Using Java" by Michael Main.

package edu.uwm.cs351;

import junit.framework.TestCase;

/******************************************************************************
 * This class is a homework assignment;
 * A HexTileSeq is a collection of HexTiles.
 * The sequence can have a special "current element," which is specified and 
 * accessed through four methods that are not available in the sequence class 
 * (start, getCurrent, advance and isCurrent).
 * This implementation uses a singly-linked list implementation.
 ******************************************************************************/
public class HexTileSeq implements Cloneable
{
	// Implementation of the HexTileSeq class:
	//   1. The number of elements in the sequences is in the instance variable 
	//      manyItems.  The elements may be HexTile objects or nulls.
	//   2. For any sequence, the elements of the
	//      sequence are stored in a linked list starting at head.
	//   3. If there is a current element, then it is the element in the node
	//      pointed to by the cursor.  If there is no current element, then
	//      the cursor is null.
	//   4. The instance variable tail points to the last element in the linked list.
	//   5. The instance variable precursor points to the node before the
	//      one pointed to by the cursor.  If the cursor is the first node, the precursor
	//      is null.  If the cursor is null, the precursor points to the last node.

    private static class Node 
    {
        private HexTile data;
        private Node next;
        
        private Node(HexTile initialTile, Node initialLink) {
            data = initialTile;
            next = initialLink;
        }
    }
    
    private int manyNodes;
    private Node head;
    private Node tail;
    private Node cursor;
    private Node precursor;

	private static boolean doReport = true; // changed only by invariant tester
	
	private boolean report(String error) {
		if (doReport) System.out.println("Invariant error: " + error);
		else System.out.println("Caught problem: " + error);
		return false;
	}

	private boolean wellFormed() {
		// Check the invariant.
		// 1. the linked list starting at head has no cycles.
		// This uses the "Tortoise and Hare" Algorithm attributed to Floyd.
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) return report("cycle in list!");
		}
		
		// 2. manyItems is the length of the list.
        int count = 0;
        for (Node p = head; p != null; p = p.next) {
            ++count;
        }
		if (count != manyNodes) return report("manyNodes inaccurately represents the length of the list!");
		
		// 3. tail is the last node in the list started by head.
		if ((tail != null) && (head == null))
		    return report("tail is not the last node in the list!");
		if ((tail != null) && (tail.next != null))
		    return report("tail is not the last node in the list!");
		if ((tail == null) && (manyNodes != 0))
		    return report("tail is not the last node in the list!");
		if ((tail != null) && (head != null))
		    for (Node p = head; p != tail; p = p.next) {
		        if (p == null) return report("tail could not be reached from the head");
		    }
		    
		
		// 4. precursor is null or points to a node in the list which is started by head.
		if (precursor != null) {
    		for (Node p = head; p != precursor; p = p.next) {
    		    if (p == null) return report("precursor points to a node that cannot be reached from the head!");
    		}
		}
		
		// 5. if precursor is null, then cursor points to the first node if any
		//    otherwise it points the node after the one precursor points to (if any).
		if ((precursor == null) && (cursor != head)) return report("precursor is null but cursor does not point to the head!");
		if ((precursor != null) && (cursor != precursor.next)) return report("precursor points to a node that does not point directly to cursor!");

		// If no problems discovered, return true
		return true;
	}

	// This is only for testing the invariant.  Do not change!
	private HexTileSeq(boolean testInvariant) { }
	
	/**
	 * Initialize an empty sequence.
	 * @param - none
	 * @postcondition
	 *   This sequence is empty.
	 **/   
	public HexTileSeq( )
	{
		manyNodes = 0;
		assert wellFormed() : "Invariant false at end of constructor";
	}

	/**
	 * Determine the number of elements in this sequence.
	 * @param - none
	 * @return
	 *   the number of elements in this sequence
	 **/ 
	public int size( )
	{
		assert wellFormed() : "invariant failed at start of size";
		return manyNodes;
		// size() should not modify anything, so we omit testing the invariant here
	}

	/**
	 * Add a new element to this sequence, before the current element. 
	 * @param element
	 *   the new element that is being added, it is allowed to be null
	 * @postcondition
	 *   A new copy of the element has been added to this sequence. If there was
	 *   a current element, then the new element is placed before the current
	 *   element. If there was no current element, then the new element is placed
	 *   at the start of the sequence. In all cases, the new element becomes the
	 *   new current element of this sequence. 
	 **/
	public void addBefore(HexTile element)
	{
		assert wellFormed() : "invariant failed at start of addBefore";
		cursor = new Node(element, precursor.next);
		assert wellFormed() : "invariant failed at end of addBefore";
	}

	/**
	 * Add a new element to this sequence, after the current element. 
	 * @param element
	 *   the new element that is being added, may be null
	 * @postcondition
	 *   A new copy of the element has been added to this sequence. If there was
	 *   a current element, then the new element is placed after the current
	 *   element. If there was no current element, then the new element is placed
	 *   at the end of the sequence. In all cases, the new element becomes the
	 *   new current element of this sequence. 
	 **/
	public void addAfter(HexTile element)
	{
		assert wellFormed() : "invariant failed at start of addAfter";
		cursor = new Node(element, cursor.next);
		precursor = precursor.next;
		precursor.next = cursor;
		if (cursor.next == null) tail = cursor;
		++manyNodes;
		assert wellFormed() : "invariant failed at end of addAfter";
	}

	/// Cursor methods
	
	/**
	 * The first element (if any) of this sequence is now current.
	 * @param - none
	 * @postcondition
	 *   The front element of this sequence (if any) is now the current element (but 
	 *   if this sequence has no elements at all, then there is no current 
	 *   element).
	 **/ 
	public void start( )
	{
		assert wellFormed() : "invariant failed at start of start";
		cursor = head;
		assert wellFormed() : "invariant failed at end of start";
	}

	/**
	 * Accessor method to determine whether this sequence has a specified 
	 * current element (a HexTile or null) that can be retrieved with the 
	 * getCurrent method. This depends on the status of the cursor.
	 * @param - none
	 * @return
	 *   true (there is a current element) or false (there is no current element at the moment)
	 **/
	public boolean isCurrent( )
	{
		assert wellFormed() : "invariant failed at start of isCurrent";
		return cursor != null;
	}

	/**
	 * Accessor method to get the current element of this sequence. 
	 * @param - none
	 * @precondition
	 *   isCurrent() returns true.
	 * @return
	 *   the current element of this sequence, possibly null
	 * @exception IllegalStateException
	 *   Indicates that there is no current element, so 
	 *   getCurrent may not be called.
	 **/
	public HexTile getCurrent( )
	{
		assert wellFormed() : "invariant failed at start of getCurrent";
		if (!isCurrent()) throw new IllegalStateException("There is no current element to access.");
		return cursor.data;
	}

	/**
	 * Move forward, so that the next element is now the current element in
	 * this sequence.
	 * @param - none
	 * @precondition
	 *   isCurrent() returns true. 
	 * @postcondition
	 *   If the current element was already the end element of this sequence 
	 *   (with nothing after it), then there is no longer any current element. 
	 *   Otherwise, the new current element is the element immediately after the 
	 *   original current element.
	 * @exception IllegalStateException
	 *   If there was no current element, so 
	 *   advance may not be called (the precondition was false).
	 **/
	public void advance( )
	{
		assert wellFormed() : "invariant failed at start of advance";
		if (!isCurrent()) throw new IllegalStateException("There is no current element to advance beyond.");
		cursor = cursor.next;
		assert wellFormed() : "invariant failed at end of advance";
	}

	/**
	 * Remove the current element from this sequence.
	 * @param - none
	 * @precondition
	 *   isCurrent() returns true.
	 * @postcondition
	 *   The current element has been removed from this sequence, and the 
	 *   following element (if there is one) is now the new current element. 
	 *   If there was no following element, then there is now no current 
	 *   element.
	 * @exception IllegalStateException
	 *   Indicates that there is no current element, so 
	 *   removeCurrent may not be called. 
	 **/
	public void removeCurrent( )
	{
		assert wellFormed() : "invariant failed at start of removeCurrent";
		// TODO: Implement this code.
		assert wellFormed() : "invariant failed at end of removeCurrent";
	}

	/**
	 * Place the contents of another sequence at the end of this sequence.
	 * @param addend
	 *   a sequence whose contents will be placed at the end of this sequence
	 * @precondition
	 *   The parameter, addend, is not null. 
	 * @postcondition
	 *   The elements from addend have been placed at the end of 
	 *   this sequence. The current element of this sequence if any,
	 *   remains unchanged.   The addend is unchanged.
	 * @exception NullPointerException
	 *   Indicates that addend is null. 
	 **/
	public void addAll(HexTileSeq addend)
	{
		assert wellFormed() : "invariant failed at start of addAll";
		// TODO: Implement this code.
		assert wellFormed() : "invariant failed at end of addAll";
	}   


	/**
	 * Generate a copy of this sequence.
	 * @param - none
	 * @return
	 *   The return value is a copy of this sequence. Subsequent changes to the
	 *   copy will not affect the original, nor vice versa.
	 * @exception OutOfMemoryError
	 *   Indicates insufficient memory for creating the clone.
	 **/ 
	public HexTileSeq clone( )
	{  // Clone a HexTileSeq object.
		assert wellFormed() : "invariant failed at start of clone";
		HexTileSeq answer;

		try
		{
			answer = (HexTileSeq) super.clone( );
		}
		catch (CloneNotSupportedException e)
		{  // This exception should not occur. But if it does, it would probably
			// indicate a programming error that made super.clone unavailable.
			// The most common error would be forgetting the "Implements Cloneable"
			// clause at the start of this class.
			throw new RuntimeException
			("This class does not implement Cloneable");
		}
		
		// TODO: clone the whole list and give it four new pointers
		
		assert wellFormed() : "invariant failed at end of clone";
		assert answer.wellFormed() : "invariant failed for clone";
		
		return answer;
	}

	
	public static class TestInvariant extends TestCase {
		private HexTileSeq self;
		
		private Node n() {
			return new HexTileSeq.Node(null,null);
		}
		
		@Override
		public void setUp() {
			self = new HexTileSeq(false);
			doReport = false;
		}
			
		public void testA() {
			doReport = true;
			assertTrue(self.wellFormed());
		}
		
		public void testB() {
			self.manyNodes = 1;
			assertFalse(self.wellFormed());
			self.manyNodes = -1;
			assertFalse(self.wellFormed());
		}
		
		public void testC() {
			self.precursor = n();
			assertFalse(self.wellFormed());
			self.precursor = null;
			self.cursor = n();
			assertFalse(self.wellFormed());
		}
		
		public void testD() {
			self.tail = n();
			assertFalse(self.wellFormed());
			self.precursor = self.tail;
			assertFalse(self.wellFormed());
		}
		
		public void testE() {
			self.head = n();
			self.manyNodes = 1;
			self.precursor = self.head;
			assertFalse(self.wellFormed());
			self.precursor = null;
			self.cursor = self.head;
			assertFalse(self.wellFormed());
		}
		
		public void testF() {
			self.head = n();
			self.tail = n();
			self.manyNodes = 1;
			self.precursor = self.tail;
			assertFalse(self.wellFormed());
			self.precursor = null;
			self.cursor = self.head;
			assertFalse(self.wellFormed());
		}
		
		public void testG() {
			self.head = n();
			self.tail = self.head;
			self.manyNodes = 1;
			assertFalse(self.wellFormed());
		}
		
		public void testH() {
			self.head = n();
			self.tail = self.head;
			self.manyNodes = 1;
			doReport = true;
			self.cursor = self.head;
			assertTrue(self.wellFormed());
			self.precursor = self.head;
			self.cursor = null;
			assertTrue(self.wellFormed());
		}
		
		public void testI() {
			self.head = n();
			self.tail = self.head;
			self.head.next = self.head;
			self.manyNodes = 1;
			assertFalse(self.wellFormed());
			self.tail = n();
			assertFalse(self.wellFormed());
			self.tail.next = self.tail;
			assertFalse(self.wellFormed());
			self.tail = null;
			assertFalse(self.wellFormed());
		}
		
		public void testJ() {
			self.head = n();
			self.tail = n();
			self.head.next = self.tail;
			self.manyNodes = 2;

			doReport = true;
			self.cursor = self.head;
			assertTrue(self.wellFormed());
			self.precursor = self.cursor;
			self.cursor = self.tail;
			assertTrue(self.wellFormed());
			self.precursor = self.cursor;
			self.cursor = null;
			assertTrue(self.wellFormed());
		}
		
		public void testK() {
			self.head = n();
			self.tail = n();
			self.head.next = self.tail;
			self.cursor = self.head;
			assertFalse(self.wellFormed());
			self.manyNodes = 1;
			assertFalse(self.wellFormed());
			self.manyNodes = 3;
			assertFalse(self.wellFormed());
		}
		
		public void testL() {
			self.head = n();
			self.head.next = n();
			self.cursor = self.head;
			self.manyNodes = 2;
			assertFalse(self.wellFormed());
			self.tail = self.head;
			assertFalse(self.wellFormed());
			self.tail = n();
			assertFalse(self.wellFormed());
		}
		
		public void testM() {
			self.head = n();
			self.tail = n();
			self.head.next = self.tail;
			self.manyNodes = 2;
			self.cursor = self.head;
			self.tail.next = self.head;
			assertFalse(self.wellFormed());
			self.tail.next = self.tail;
			assertFalse(self.wellFormed());
		}
		
		public void testN() {
			self.head = n();
			self.tail = n();
			self.head.next = self.tail;
			self.manyNodes = 2;
			assertFalse(self.wellFormed());
			self.precursor = self.head;
			assertFalse(self.wellFormed());
			self.cursor = self.head;
			assertFalse(self.wellFormed());
			self.precursor = self.tail;
			assertFalse(self.wellFormed());
			self.cursor = self.tail;
			assertFalse(self.wellFormed());
			self.precursor = null;
			assertFalse(self.wellFormed());
		}
		
		public void testO() {
			self.head = n();
			self.tail = n();
			self.head.next = self.tail;
			self.manyNodes = 2;
			self.precursor = n();
			assertFalse(self.wellFormed());
			self.cursor = self.tail;
			self.precursor.next = self.cursor;
			assertFalse(self.wellFormed());
			self.cursor = self.head;
			self.precursor.next = self.cursor;
			assertFalse(self.wellFormed());
		}
		
		public void testP() {
			self.head = n();
			self.head.next = n();
			self.head.next.next = self.tail = n();
			self.manyNodes = 3;
			self.cursor = self.head;
			
			doReport = true;
			assertTrue(self.wellFormed());
			self.precursor = self.cursor;
			self.cursor = self.cursor.next;
			assertTrue(self.wellFormed());
			self.precursor = self.cursor;
			self.cursor = self.cursor.next;
			assertTrue(self.wellFormed());			
		}
		
		public void testQ() {
			self.head = n();
			self.head.next = n();
			self.head.next.next = self.tail = n();
			self.manyNodes = 3;
			self.cursor = self.head;
			self.tail.next = self.head;
			assertFalse(self.wellFormed());
			self.tail.next = self.head.next;
			assertFalse(self.wellFormed());
			self.tail.next = self.tail;
			assertFalse(self.wellFormed());
		}
		
		public void testR() {
			self.head = n();
			self.head.next = n();
			self.head.next.next = self.tail = n();
			self.manyNodes = 3;
			self.cursor = self.head;
			
			self.head.next.next = self.head.next;
			assertFalse(self.wellFormed());
			self.head.next.next = self.head;
			assertFalse(self.wellFormed());
		}
		
		public void testS() {
			self.head = n();
			self.head.next = n();
			self.head.next.next = self.tail = n();
			self.cursor = self.head;
			assertFalse(self.wellFormed());
			self.manyNodes = 1;
			assertFalse(self.wellFormed());
			self.manyNodes = 2;
			assertFalse(self.wellFormed());
			self.manyNodes = 4;
			assertFalse(self.wellFormed());
			self.manyNodes = -3;
			assertFalse(self.wellFormed());
		}
		
		public void testT() {
			self.head = n();
			self.head.next = n();
			self.head.next.next = n();
			self.cursor = self.head;
			self.manyNodes = 3;
			assertFalse(self.wellFormed());
			self.tail = self.head;
			assertFalse(self.wellFormed());
			self.tail = self.head.next;
			assertFalse(self.wellFormed());
			self.tail = n();
			assertFalse(self.wellFormed());
		}
		
		public void testU() {
			self.head = n();
			self.head.next = n();
			self.head.next.next = n();
			self.manyNodes = 3;
			self.tail = self.head.next.next;

			assertFalse(self.wellFormed());
			self.precursor = self.head.next;
			assertFalse(self.wellFormed());
			self.precursor = self.head;
			assertFalse(self.wellFormed());
			self.cursor = self.head;
			assertFalse(self.wellFormed());
			self.precursor = self.tail;
			assertFalse(self.wellFormed());
			self.precursor = self.head.next;
			assertFalse(self.wellFormed());
			self.cursor = self.head.next;
			assertFalse(self.wellFormed());
			self.precursor = null;
			assertFalse(self.wellFormed());
			self.precursor = self.tail;
			assertFalse(self.wellFormed());
			self.cursor = self.tail;
			assertFalse(self.wellFormed());
			self.precursor = null;
			assertFalse(self.wellFormed());
			self.precursor = self.head;
			assertFalse(self.wellFormed());
		}
		
		public void testV() {
			self.head = n();
			self.head.next = n();
			self.head.next.next = n();
			self.manyNodes = 3;
			self.tail = self.head.next.next;

			self.precursor = n();
			assertFalse(self.wellFormed());
			self.cursor = self.head;
			self.precursor.next = self.cursor;
			assertFalse(self.wellFormed());
			self.cursor = self.head.next;
			self.precursor.next = self.cursor;
			assertFalse(self.wellFormed());
			self.cursor = self.head.next.next;
			self.precursor.next = self.cursor;
			assertFalse(self.wellFormed());
		}
		
		public void testW() {
			self.head = n();
			self.head.next = n();
			self.head.next.next = n();
			self.head.next.next.next = self.tail = n();
			self.manyNodes = 4;
			self.cursor = self.head;
			
			doReport = true;
			assertTrue(self.wellFormed());
			self.precursor = self.cursor;
			self.cursor = self.cursor.next;
			assertTrue(self.wellFormed());
			self.precursor = self.cursor;
			self.cursor = self.cursor.next;
			assertTrue(self.wellFormed());			
			self.precursor = self.cursor;
			self.cursor = self.cursor.next;
			assertTrue(self.wellFormed());			
		}
		
		public void testX() {
			self.head = n();
			self.head.next = n();
			self.head.next.next = n();
			self.head.next.next.next = self.tail = n();
			self.manyNodes = 4;
			self.cursor = self.head;

			self.tail.next = self.head;
			assertFalse(self.wellFormed());
			self.tail.next = self.head.next;
			assertFalse(self.wellFormed());
			self.tail.next = self.head.next.next;
			assertFalse(self.wellFormed());
			self.tail.next = self.head.next.next.next;
			assertFalse(self.wellFormed());
		}
		
		public void testY() {
			Node n;
			self.head = n();
			self.head.next = n();
			self.head.next.next = n = n();
			self.head.next.next.next = self.tail = n();
			self.manyNodes = 4;
			self.cursor = self.head;

			n.next = self.head;
			assertFalse(self.wellFormed());
			n.next = self.head.next;
			assertFalse(self.wellFormed());
			n.next = self.head.next.next;
			assertFalse(self.wellFormed());
		}
	}
}

