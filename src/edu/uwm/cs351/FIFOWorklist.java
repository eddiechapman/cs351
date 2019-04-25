package edu.uwm.cs351;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

import edu.uwm.cs351.util.Worklist;

/**
 * A Worklist whose most oldest addition is the first to be accessed.
 * 
 * @author Eddie Chapman
 * @param <E>   The type of element to be stored in the Worklist.
 */
public class FIFOWorklist<E> implements Worklist<E> {
    private Queue<E> worklist;
    
    /**
     * Initialize a new LIFOWorklist.
     * 
     * @postcondition   The Worklist is empty.
     */
    public FIFOWorklist() {
        worklist = new LinkedList<E>();
    }

    @Override
    public boolean hasNext() {
        return !worklist.isEmpty();
    }

    @Override
    public E next() {
        return worklist.remove();
    }

    @Override
    public void add(E element) {
        worklist.add(element);
    }
    
}
