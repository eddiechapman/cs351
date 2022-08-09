package edu.uwm.cs351.util;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A Worklist whose most oldest addition is the first to be accessed.
 * 
 * @author Eddie Chapman (chapman4@uwm.edu)
 * 
 * I completed this assignment by referencing the lecture notes, 
 * textbook, Oracle documentation, and text adventure example. 
 * 
 * I discussed the assignment with Mason Baran regarding how to 
 * interpret the text adventure in the context of search. 
 * 
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
