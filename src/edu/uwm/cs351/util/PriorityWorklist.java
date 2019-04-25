package edu.uwm.cs351.util;

import java.util.PriorityQueue;

/**
 * A Worklist whose most elements are returned in ascending order of 
 * their value.
 * 
 * @author Eddie Chapman
 * @param <E>   The type of element to be stored in the Worklist.
 */
public class PriorityWorklist<E> implements Worklist<E> {
    private PriorityQueue<E> worklist;
    
    /**
     * Initialize a new PriorityWorklist.
     * 
     * @postcondition   The Worklist is empty.
     */
    public PriorityWorklist() {
        worklist = new PriorityQueue<E>();
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
