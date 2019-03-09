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
    private int used;
    
    // Copied from lecture #5
    private boolean report(String s) {
        System.err.println("invariant error: " + s);
        return false;
    }
    
    // Copied from lecture #5
    private boolean wellFormed() {
        if (contents == null) return report("contents is null");
        if (used < 0) return report("Used is negative! " + used);
        if (used > contents.length) return report("more in collection that its capacity? " + used + " > " + contents.length);
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
        this.used = 0;
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
        this.used = 0;
        assert wellFormed() : "Invariant failed at end of Stack constructor (class specified)";
    }

	// TODO: rest of class
	// You need two constructors: one taking a class value (used by makeArray)
	// and one without such a value.  In the former case, makeArray
	// won't need to lie in its array creation.
	// Make sure to assert the invariant at end of each constructor
	// and at start (and end, if they mutate anything) of public methods.
}
