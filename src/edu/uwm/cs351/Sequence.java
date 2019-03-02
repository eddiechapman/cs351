// This is an assignment for students to complete after reading Chapter 4 of
// "Data Structures and Other Objects Using Java" by Michael Main.

package edu.uwm.cs351;

import java.util.Comparator;

import edu.uwm.cs351.HexTileSeq.Node;
import junit.framework.TestCase;

/******************************************************************************
 * This class is a homework assignment;
 * We generalize the Sequence class from previous homework assignments.
 * The sequence can have a special "current element," which is specified and 
 * accessed through four methods that are not available in the sequence class 
 * (start, getCurrent, advance and isCurrent).
 * This implementation uses a singly-linked list with a dummy node implementation.
 ******************************************************************************/
public class Sequence<E> implements Cloneable
{
	// Implementation of the Sequence class:
	//   0. The dummy node is never null
	//   1. The number of elements in the sequences is in the instance variable 
	//      manyItems.  The elements may be any kind of objects or nulls.
	//   2. For any sequence, the elements of the
	//      sequence are stored in a linked list starting at the node after dummy.
	//   3. The "cursor" is a "model field" (not a real field).
	//      It is always the node (if any) after the precursor node.
	//   4. If there is a current element, then it is the element in the node
	//      pointed to by the "cursor".  If there is no current element, then
	//      the "cursor" is null.
	//   5. The instance variable precursor points to some node in the list
	//      or the dummy node.
	// Your code should not have any unchecked cast or raw type warnings
	// and may not suppress warnings except in one place where we placed it in clone().

	private static class Node<T> {
		// TODO: finish this class.  Keep "T" as the generic parameter
		// (It's sloppy and confusing to use the same name as for Sequence)
	}
	
	// TODO: Declare the *three* fields (see the homework handout)
	private Node<E> dummy;
	private Node<E> precursor;
	private int manyItems;

	private static boolean doReport = true; // changed only by invariant tester
	
	private boolean report(String error) {
		if (doReport) System.out.println("Invariant error: " + error);
		else System.out.println("Caught problem: " + error);
		return false;
	}

	private boolean wellFormed() {
		// Check the invariant.
		// 0. The dummy isn't null
		// 1. the linked list starting at dummy has no cycles.
		//    Use the "Tortoise and Hare" Algorithm attributed to Floyd.
		//    (See Homework #4)
		// 2. manyItems is the length of the list (excluding dummy!).
		// 3. precursor is points to a node (it is not null) and 
		//    that node is in the list which is started by dummy.
		// TODO

		// If no problems discovered, return true
		return true;
	}

	// This is only for testing the invariant.  Do not change!
	private Sequence(boolean testInvariant) { }
	
	/**
     * Initialize an empty sequence.
     * @param - none
     * @postcondition
     *   This sequence is empty.
     **/   
    public HexTileSeq( )
    {
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
        if (cursor == null) {
            precursor = null;
            cursor = head;
        }
        cursor = new Node(element,cursor);
        if (tail == null) tail = cursor;
        if (precursor == null) {
            head = cursor;
        } else {
            precursor.next = cursor;
        }
        ++manyNodes;
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
        if (cursor == null) {
            tail = cursor = new Node(element,null);
            if (precursor == null) {
                head = cursor;
            } else {
                precursor.next = cursor;
            }
        } else {
            cursor.next = new Node(element,cursor.next);
            precursor = cursor;
            cursor = cursor.next;
            if (precursor == tail) tail = cursor;
        }
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
        precursor = null;
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
        if (!isCurrent()) throw new IllegalStateException("no current");
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
        if (!isCurrent()) throw new IllegalStateException("no current");
        precursor = cursor;
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
        if (!isCurrent()) throw new IllegalStateException("no current to remove");
        --manyNodes;
        if (precursor == null) {
            head = cursor.next;
        } else {
            precursor.next = cursor.next;
        }
        if (tail == cursor) tail = precursor;
        cursor = cursor.next;
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
        if (addend.manyNodes == 0) return;
        HexTileSeq copy = addend.clone();
        if (tail == null) {
            head = copy.head;
        } else {
            tail.next = copy.head;
        }
        tail = copy.tail;
        if (cursor == null) {
            precursor = copy.tail;
        }
        manyNodes += addend.manyNodes;
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
        
        Node dummy = new Node(null,null);
        Node newTail = dummy;
        for (Node p = head; p != null; p = p.next) {
            Node c = new Node(p.data,null);
            newTail = newTail.next = c;
            if (p == precursor) answer.precursor = c;
            if (p == cursor) answer.cursor = c;
            if (p == tail) answer.tail = c;
        }
        answer.head = dummy.next;
        
        assert wellFormed() : "invariant failed at end of clone";
        assert answer.wellFormed() : "invariant failed for clone";
        
        return answer;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        boolean first = true;
        for (Node p = head; p != null; p=p.next) {
            if (first) first = false;
            else sb.append(", ");
            if (p == cursor) sb.append("*");
            sb.append(p.data);
        }
        sb.append("}");
        return sb.toString();
    }
    
	// TODO:
	// Add the "sort" method with documentation comment (AKA "javadoc").
	
	
	// Please don't change the following tests:
	public static class TestInvariant extends TestCase {
		private Sequence<String> self;
		
		private Node<String> n() {
			return new Sequence.Node<String>(null,null);
		}
		
		@Override
		public void setUp() {
			self = new Sequence<String>(false);
			doReport = false;
		}
			
		public void testA() {
			assertFalse(self.wellFormed());
		}
		
		public void testB() {
			self.dummy = n();
			assertFalse(self.wellFormed());
		}
		
		public void testC() {
			self.precursor = n();
			assertFalse(self.wellFormed());
		}
		
		public void testD() {
			self.dummy = n();
			self.precursor = n();
			assertFalse(self.wellFormed());
		}
		
		public void testE() {
			self.dummy = n();
			self.precursor = self.dummy;
			
			doReport = true;
			assertTrue(self.wellFormed());
		}
		
		public void testF() {
			self.dummy = self.precursor = n();
			self.manyItems = 1;
			assertFalse(self.wellFormed());
			self.manyItems = -1;
			assertFalse(self.wellFormed());
		}
				
		public void testG() {
			self.dummy = n();
			self.dummy.next = n();
			self.manyItems = 1;
			assertFalse(self.wellFormed());
			self.precursor = n();
			assertFalse(self.wellFormed());
		}
		
		public void testH() {
			self.dummy = n();
			self.dummy.next = n();
			self.manyItems = 1;
			
			doReport = true;
			self.precursor = self.dummy;
			assertTrue(self.wellFormed());
			self.precursor = self.dummy.next;
			assertTrue(self.wellFormed());
		}
		
		public void testI() {
			self.dummy = self.precursor = n();
			self.dummy.next = n();
			assertFalse(self.wellFormed());
			self.manyItems = 2;
			assertFalse(self.wellFormed());
		}
		
		public void testJ() {
			self.manyItems = 1;
			self.dummy = self.precursor = n();
			self.dummy.next = self.dummy;
			assertFalse(self.wellFormed());
		}
				
		public void testK() {
			self.dummy = n();
			self.dummy.next = n();
			self.dummy.next.next = n();
			self.manyItems = 2;
			
			self.precursor = null;
			assertFalse(self.wellFormed());
			self.precursor = n();
			assertFalse(self.wellFormed());
			self.precursor.next = self.dummy.next;
			assertFalse(self.wellFormed());

			doReport = true;
			self.precursor = self.dummy;
			assertTrue(self.wellFormed());
			self.precursor = self.dummy.next;
			assertTrue(self.wellFormed());
			self.precursor = self.dummy.next.next;
			assertTrue(self.wellFormed());
		}
		
		public void testL() {
			self.manyItems = 3;
			self.dummy = self.precursor = n();
			self.dummy.next = n();
			
			self.dummy.next.next = self.dummy;
			assertFalse(self.wellFormed());
			
			self.dummy.next.next = self.dummy.next;
			assertFalse(self.wellFormed());
			
			self.dummy.next.next = n();
			self.dummy.next.next.next = self.dummy.next;
			assertFalse(self.wellFormed());
			
			self.dummy.next.next.next = self.dummy.next.next;
			assertFalse(self.wellFormed());
		}
	}
}

