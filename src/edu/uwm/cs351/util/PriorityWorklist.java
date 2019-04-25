package edu.uwm.cs351.util;

import java.util.Comparator;
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
     * @param comp      Comparator of type E used to order Worklist.
     * @postcondition   The Worklist is empty.
     */
    public PriorityWorklist(Comparator<E> comp) {
        worklist = new PriorityQueue<E>(comp);
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
