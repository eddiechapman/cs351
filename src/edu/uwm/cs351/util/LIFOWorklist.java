package edu.uwm.cs351.util;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * A Worklist whose most recent addition is the first to be accessed.
 * 
 * @author Eddie Chapman
 * @param <E>       The type of element to be stored in the Worklist.
 */
public class LIFOWorklist<E> implements Worklist<E> {
    private Stack<E> worklist; 
    
    /**
     * Initialize a new LIFOWorklist.
     * 
     * @postcondition   The Worklist is empty.
     */
    public LIFOWorklist() {
        worklist = new Stack<E>();
    }

    @Override
    public boolean hasNext() {
        return !worklist.empty();
    }

    @Override
    public E next() {
        if (!hasNext()) throw new NoSuchElementException("Exhausted");
        return worklist.pop();
    }

    @Override
    public void add(E element) {
        worklist.push(element);    
    }

}
