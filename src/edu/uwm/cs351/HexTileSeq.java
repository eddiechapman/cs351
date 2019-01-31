// This is an assignment for students to complete after reading Chapter
// 3 of
// "Data Structures and Other Objects Using Java" by Michael Main.

package edu.uwm.cs351;

import junit.framework.TestCase;

/******************************************************************************
 * This class is a homework assignment; A HexTileSeq is a collection of
 * HexTiles. The sequence can have a special "current element," which is
 * specified and accessed through four methods that are not available in
 * the sequence class (start, getCurrent, advance and isCurrent).
 *
 * @note (1) The capacity of a sequence can change after it's created,
 * but the maximum capacity is limited by the amount of free memory on
 * the machine. The constructor, addAfter, addBefore, clone, and
 * concatenation will result in an OutOfMemoryError when free memory is
 * exhausted.
 * <p>
 * (2) A sequence's capacity cannot exceed the maximum integer
 * 2,147,483,647 (Integer.MAX_VALUE). Any attempt to create a larger
 * capacity results in a failure due to an arithmetic overflow.
 * 
 * NB: Neither of these conditions require any work for the implementors
 * (students).
 ******************************************************************************/
public class HexTileSeq implements Cloneable
  {
    // Implementation of the HexTileSeq class:
    // 1. The number of elements in the sequences is in the instance
    //    variable manyItems. The elements may be HexTile objects or nulls.
    // 2. For any sequence, the elements of the sequence are stored in data[0] 
    //    through data[manyItems-1], and we don't care what's in the rest of data.
    // 3. If there is a current element, then it lies in data[currentIndex]; 
    //    if there is no current element, then currentIndex equals manyItems.

    private HexTile[] data;
    private int manyItems;
    private int currentIndex;

    private static int INITIAL_CAPACITY = 1;

    private static boolean doReport = true; // changed only by invariant tester

    private boolean report(String error) {
      if (doReport) {
        System.out.println("Invariant error: " + error);
      }
      else {
        System.out.println("Caught problem: " + error);
      }
      return false;
    }

    private boolean wellFormed() {
      if (data == null) {
        return report("data is null");
      }
      if (manyItems > data.length) {
        return report("the item count claimed by manyItems exceeds the capacity of the array");
      }
      if (0 > currentIndex || currentIndex > manyItems) {
        return report("currentIndex refers to an illegal or unused portion of the array");
      }
      return true;
    }

    // This is only for testing the invariant. Do not change!
    private HexTileSeq(boolean testInvariant) {}

    /**
     * Initialize an empty sequence with an initial capacity of
     * INITIAL_CAPACITY. The addAfter and addBefore methods work efficiently
     * (without needing more memory) until this capacity is reached.
     * 
     * @postcondition 
     *   This sequence is empty and has an initial capacity of INITIAL_CAPACITY
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for initial array.
     **/
    public HexTileSeq() {
      data = new HexTile[INITIAL_CAPACITY];
      manyItems = 0;
      currentIndex = 0;
      assert wellFormed() : "Invariant false at end of constructor";
    }

    /**
     * Initialize an empty sequence with a specified initial capacity. Note
     * that the addAfter and addBefore methods work efficiently (without
     * needing more memory) until this capacity is reached.
     * 
     * @param initialCapacity
     *   the initial capacity of this sequence
     * @precondition 
     *   initialCapacity is non-negative.
     * @postcondition 
     *   This sequence is empty and has the given initial capacity.
     * @exception IllegalArgumentException
     *   Indicates that initialCapacity is negative.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for an array with this many elements.
     *   new HexTile[initialCapacity].
     **/
    public HexTileSeq(int initialCapacity) {
      if (0 > initialCapacity) {
        throw new IllegalArgumentException("initialCapacity cannot be negative");
      }
      data = new HexTile[initialCapacity];
      manyItems = 0;
      currentIndex = 0;
      assert wellFormed() : "Invariant false at end of constructor";
    }

    /**
     * Determine the number of elements in this sequence.
     * 
     * @return 
     *   the number of elements in this sequence
     **/
    public int size() {
      assert wellFormed() : "invariant failed at start of size";
      return data.length;
    }

    /**
     * The first element (if any) of this sequence is now current.
     * 
     * @postcondition 
     *   The front element of this sequence (if any) is now the current 
     *   element (but if this sequence has no elements at all, then there 
     *   is no current element).
     **/
    public void start() {
      assert wellFormed() : "invariant failed at start of start";
      currentIndex = 0;
      assert wellFormed() : "invariant failed at end of start";
    }

    /**
     * Accessor method to determine whether this sequence has a specified
     * current element (a HexTile or null) that can be retrieved with the
     * getCurrent method. This depends on the status of the cursor.
     * 
     * @return 
     *   true (there is a current element) or false (there is no current 
     *   element at the moment)
     **/
    public boolean isCurrent() {
      assert wellFormed() : "invariant failed at start of isCurrent";
      return currentIndex < manyItems;
    }

    /**
     * Accessor method to get the current element of this sequence.
     * 
     * @precondition 
     *   isCurrent() returns true.
     * @return 
     *   the current element of this sequence, possibly null
     * @exception IllegalStateException
     *   Indicates that there is no current element, so getCurrent may not
     *   be called.
     **/
    public HexTile getCurrent() {
      assert wellFormed() : "invariant failed at start of getCurrent";
      if (!isCurrent()) {
        throw new IllegalStateException("there is no current element");
      }
      return data[currentIndex];
    }

    /**
     * Move forward, so that the next element is now the current element in
     * this sequence.
     * 
     * @precondition 
     *   isCurrent() returns true.
     * @postcondition 
     *   If the current element was already the end element of this sequence 
     *   (with nothing after it), then there is no longer any current element. 
     *   Otherwise, the new current element is the element immediately after 
     *   the original current element.
     * @exception IllegalStateException
     *   If there was no current element, so advance may not be called (the
     *   precondition was false).
     **/
    public void advance() {
      assert wellFormed() : "invariant failed at start of advance";
      if (!isCurrent()) {
        throw new IllegalStateException("there is no element to advance to");
      }
      currentIndex++;
      assert wellFormed() : "invariant failed at end of advance";
    }

    /**
     * Remove the current element from this sequence.
     * 
     * @precondition 
     *   isCurrent() returns true.
     * @postcondition 
     *   The current element has been removed from this sequence, and the 
     *   following element (if there is one) is now the new current element. 
     *   If there was no following element, then there is now no current 
     *   element.
     * @exception IllegalStateException
     *   Indicates that there is no current element, so removeCurrent may
     *   not be called.
     **/
    public void removeCurrent() {
      assert wellFormed() : "invariant failed at start of removeCurrent";
      if (!isCurrent()) {
        throw new IllegalStateException("there is no current element to remove");
      }
      for (int i = currentIndex+1; i < manyItems; i++) {
        data[i-1] = data[i];
      }
      manyItems--;
      assert wellFormed() : "invariant failed at end of removeCurrent";
    }

    /**
     * Add a new element to this sequence, before the current element. If
     * the new element would take this sequence beyond its current capacity,
     * then the capacity is increased before adding the new element.
     * 
     * @param element
     *   the new element that is being added, it is allowed to be null
     * @postcondition 
     *   A new copy of the element has been added to this sequence. If there 
     *   was a current element, then the new element is placed before the 
     *   current element. If there was no current element, then the new 
     *   element is placed at the start of the sequence. In all cases, the 
     *   new element becomes the new current element of this sequence.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for increasing the sequence's
     *   capacity.
     * @note 
     *   An attempt to increase the capacity beyond Integer.MAX_VALUE
     *   will cause the sequence to fail with an arithmetic overflow.
     **/
    public void addBefore(HexTile element) {
      assert wellFormed() : "invariant failed at start of addBefore";
      ensureCapacity(manyItems + 1);
      if (!isCurrent()) {
        currentIndex = 0;
      }
      for (int i = manyItems; i > currentIndex; i--) {
        data[i] = data[i-1];
      }
      data[currentIndex] = element;
      manyItems++;
      assert wellFormed() : "invariant failed at end of addBefore";
    }

    /**
     * Add a new element to this sequence, after the current element. If the
     * new element would take this sequence beyond its current capacity,
     * then the capacity is increased before adding the new element.
     * 
     * @param element
     *   the new element that is being added, may be null
     * @postcondition 
     *   A new copy of the element has been added to this sequence. If 
     *   there was a current element, then the new element is placed after 
     *   the current element. If there was no current element, then the new 
     *   element is placed at the end of the sequence. In all cases, the new 
     *   element becomes the new current element of this sequence.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for increasing the sequence's
     *   capacity.
     * @note 
     *   An attempt to increase the capacity beyond Integer.MAX_VALUE
     *   will cause the sequence to fail with an arithmetic overflow.
     **/
    public void addAfter(HexTile element) {
      assert wellFormed() : "invariant failed at start of addAfter";
      ensureCapacity(manyItems + 1);
      if (!isCurrent()) {
        data[currentIndex] = element;
      }
      else {
        for (int i = manyItems; i > currentIndex+1; i--) {
          data[i] = data[i-1];
        }
        currentIndex++;
        data[currentIndex] = element;
      }
      manyItems++;
      assert wellFormed() : "invariant failed at end of addAfter";
    }

    /**
     * Place the contents of another sequence at the end of this sequence.
     * 
     * @param addend
     *   a sequence whose contents will be placed at the end of this
     *   sequence
     * @precondition 
     *   The parameter, addend, is not null.
     * @postcondition 
     *   The elements from addend have been placed at the end of this 
     *   sequence. The current element of this sequence if any, remains 
     *   unchanged. The addend is unchanged.
     * @exception NullPointerException
     *   Indicates that addend is null.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory to increase the size of this
     *   sequence.
     * @note 
     *   An attempt to increase the capacity beyond Integer.MAX_VALUE will 
     *   cause an arithmetic overflow that will cause the sequence to fail.
     **/
    public void addAll(HexTileSeq addend) {
      assert wellFormed() : "invariant failed at start of addAll";
      assert wellFormed() : "invariant failed at end of addAll";
    }

    /**
     * Change the current capacity of this sequence.
     * 
     * @param minimumCapacity
     *   the new capacity for this sequence
     * @postcondition 
     *   This sequence's capacity has been changed to at least minimumCapacity. 
     *   If the capacity was already at or greater than minimumCapacity, then 
     *   the capacity is left unchanged. If the size is changed, it must be at 
     *   least twice as big as before.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for: new array of minimumCapacity
     *   elements.
     **/
    private void ensureCapacity(int minimumCapacity) {
      if (minimumCapacity <= data.length) {
        return;
      }
      int newSize = data.length*2;
      if (newSize < minimumCapacity) {
        newSize = minimumCapacity;
      }
      HexTile[] newArray = new HexTile[newSize];
      for (int i = 0; i < manyItems; i++) {
        newArray[i] = data[i];
      }
      data = newArray;
    }

    /**
     * Generate a copy of this sequence.
     * 
     * @return 
     *   The return value is a copy of this sequence. Subsequent changes to the 
     *   copy will not affect the original, nor vice versa.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for creating the clone.
     **/
    public HexTileSeq clone() { // Clone a HexTileSeq object.
      assert wellFormed() : "invariant failed at start of clone";
      HexTileSeq answer;

      try {
        answer = (HexTileSeq) super.clone();
      } catch (CloneNotSupportedException e) { // This exception should not occur. But if it does,
                                               // it would probably
                                               // indicate a programming error that made super.clone
                                               // unavailable.
                                               // The most common error would be forgetting the
                                               // "Implements Cloneable"
                                               // clause at the start of this class.
        throw new RuntimeException("This class does not implement Cloneable");
      }

      // TODO: clone the data array

      assert wellFormed() : "invariant failed at end of clone";
      assert answer.wellFormed() : "invariant failed for clone";

      return answer;
    }

    public static class TestInvariant extends TestCase
      {
        private HexTileSeq hs;

        @Override
        public void setUp() {
          hs = new HexTileSeq(false);
          doReport = false;
        }

        public void test1() {
          assertFalse(hs.wellFormed());
        }

        public void test2() {
          hs.data = new HexTile[3];
          hs.manyItems = -1;
          assertFalse(hs.wellFormed());
        }

        public void test3() {
          hs.data = new HexTile[3];
          hs.manyItems = 4;
          assertFalse(hs.wellFormed());
        }

        public void test4() {
          hs.data = new HexTile[10];
          hs.manyItems = 4;
          assertTrue(hs.wellFormed());
        }

        public void test5() {
          hs.data = new HexTile[5];
          hs.manyItems = 4;
          hs.currentIndex = -1;
          assertFalse(hs.wellFormed());
        }

        public void test6() {
          hs.data = new HexTile[3];
          hs.manyItems = 3;
          hs.currentIndex = 3;
          assertTrue(hs.wellFormed());
        }

        public void test7() {
          hs.data = new HexTile[5];
          hs.manyItems = 3;
          hs.currentIndex = 4;
          assertFalse(hs.wellFormed());
        }

      }
  }
