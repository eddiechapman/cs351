package edu.uwm.cs351.util;

import java.lang.reflect.Array;
import java.util.EmptyStackException;

/**
 * A generic stack class with push/pop methods.
 * When an instance is created, one may optionally pass in a
 * class descriptor. This makes the implementation more robust.
 * 
 * @param T     element type of stack
 */
public class Stack<T> implements Cloneable {

	private final Class<T> clazz; // initialize to null if necessary
	private T[] contents;
    private int head;
    
    // Copied from lecture #5
    private boolean report(String s) {
        System.err.println("invariant error: " + s);
        return false;
    }
    
    // Copied from lecture #5
    private boolean wellFormed() {
//        if (contents == null) return report("contents is null");
//        if (used < 0) return report("Used is negative! " + used);
//        if (used > contents.length) return report("more in collection that its capacity? " + used + " > " + contents.length);
        return true;
    }
	
	// a helper method which you will find useful.
	@SuppressWarnings("unchecked")
	private T[] makeArray(int size) {
		if (clazz == null)
			return (T[])new Object[size]; // lying...
		else
			return (T[])Array.newInstance(clazz, size);
	}
	
	private static final int DEFAULT_CAPACITY = 1;
	
	/**
     * Stack constructor of a generic type.
     * 
     * @postcondition   the stack is empty and initialized to accept generic elements.
     */
    public Stack() {
        this.clazz = null;
        this.contents = makeArray(DEFAULT_CAPACITY);
        this.head = 0;
        assert wellFormed() : "Invariant failed at end of Stack constructor (generic)";
    }
    
     /**
     * Stack constructor of a specified type.
     * 
     * @postcondition   the stack is empty and initialized to accept elements of the type clazz
     * @param clazz     the class of elements stored in the stack
     */
    public Stack(Class<T> clazz) {
        this.clazz = clazz;
        this.contents = makeArray(DEFAULT_CAPACITY);
        this.head = 0;
        assert wellFormed() : "Invariant failed at end of Stack constructor (class specified)";
    }
    
    /**
     * Adds a specified element to the top of this stack.
     * 
     * @param t     the element to be added to the top of the stack 
     */
    public void push(T t) {
        assert wellFormed() : "Invariant failed at start of push";
        ensureCapacity(contents.length + 1);
        ++head;
        contents[head] = t;
        assert wellFormed() : "Invariant failed at end of push";
    } 
    
    /**
     * Retrieves and removes the top of this stack, which must not be empty. If the stack is empty,this methods throws an instance ofEmptyStackException.
     * 
     * @return the top element of the stack, which is removed from the stack in the process
     * @throws EmptyStackException  if the stack is empty before calling pop
     */
    public T pop() {
        assert wellFormed() : "Invariant failed at start of pop";
        assert wellFormed() : "Invariant failed at end of pop";
    }
    
    /**
     * Retrieves, but does not remove, the top of this stack, which must not be empty.
     *
     * @return the top element of the stack, which is not removed from the stack
     * @throws EmptyStackException  if the stack is empty before calling peek
     */
    public T peek() {
        assert wellFormed() : "Invariant failed at start of peek";
    }
    
    /**
     * Return true if this stack is empty.
     * 
     * @return <code>true</code> if the stack is empty, <code>false</code> otherwise. 
     */
    public boolean isEmpty() {
        assert wellFormed() : "Invariant failed at start of isEmpty";
        return contents.length == 0;
    }
    
    private void ensureCapacity(int min) {
        if (min <= contents.length) { return; }
        int newCap = contents.length * 2;
        if (newCap < min) { newCap = min; }
        T[] newArray = makeArray(newCap);
        for (int i=0; i < contents.length; ++i) {
            newArray[i] = contents[i];
        }
        contents = newArray;
    }
    
    
    @Override
    public Stack<T> clone() {
        assert wellFormed() : "Invariant failed at start of clone";
        assert wellFormed() : "Invariant failed at end of clone";
    }
    
    /**
     * Discard everything from the stack.
     */
    public void clear() {
        assert wellFormed() : "Invariant failed at start of clear";
        assert wellFormed() : "Invariant failed at end of clear";
    }

	// TODO: rest of class
	// You need two constructors: one taking a class value (used by makeArray)
	// and one without such a value.  In the former case, makeArray
	// won't need to lie in its array creation.
	// Make sure to assert the invariant at end of each constructor
	// and at start (and end, if they mutate anything) of public methods.
}
