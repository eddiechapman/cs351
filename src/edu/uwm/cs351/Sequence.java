// This is an assignment for students to complete after reading Chapter 4 of
// "Data Structures and Other Objects Using Java" by Michael Main.

package edu.uwm.cs351;

import java.util.Comparator;

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
	
	// TODO copy code from the Homework #4 HexTileSeq.java (provided)
	// and convert to use the adjusted and simpler data structure.

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

