package edu.uwm.cs351.util;

import java.lang.reflect.Array;
import java.util.EmptyStackException;

/**
 * A generic stack class with push/pop methods.
 * When an instance is created, one may optionally pass in a
 * class descriptor. This makes the implementation more robust.
 * 
 * @param T         element type of stack
 * 
 * @author Eddie Chapman (chapman4@uwm.edu)
 *
 * I completed this assignment by referencing the assigned readings, lecture notes,
 * and the Oracle documentation. 
 */
public class Stack<T> implements Cloneable 
{
	private final Class<T> clazz; // initialize to null if necessary
	private T[] contents;
    private int head;
    private int manyItems;
    
    // Copied from lecture #5
    private boolean report(String s) {
        System.err.println("invariant error: " + s);
        return false;
    }

    private boolean wellFormed() {
        if (contents == null) 
            return report("contents is null");  
        
        if (head < -1) 
            return report(String.format("Head cannot be less than -1 (%d)", head));      
        
        if (head >= contents.length)
            return report(String.format("head (%d) cannot point beyond array boundaries (%d)", 
                                        head, contents.length));         
        else           
            return true;
    }
	
	// a helper method which you will find useful.
	@SuppressWarnings("unchecked")
	private T[] makeArray(int size) {
		if (clazz == null) {
			return (T[])new Object[size];  // lying...
		} else {
			return (T[])Array.newInstance(clazz, size);
		}
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
        this.head = -1;
        
        assert wellFormed() : "Invariant failed at end of Stack constructor (generic)";
    }
    
     /**
     * Stack constructor of a specified type.
     *                  
     * @param clazz     the class of elements stored in the stack
     * 
     * @postcondition   the stack is empty and initialized to accept elements of the 
     *                  type clazz
     */
    public Stack(Class<T> clazz) {
        this.clazz = clazz;
        this.contents = makeArray(DEFAULT_CAPACITY);
        this.head = -1;
        
        assert wellFormed() : "Invariant failed at end of Stack constructor (class specified)";
    }
    
    /**
     * Adds a specified element to the top of this stack.
     * 
     * @param t         the element to be added to the top of the stack 
     * 
     * @postcondition   the stack has another element and may have been resized if needed
     */
    public void push(T t) {
        assert wellFormed() : "Invariant failed at start of push";
        
        ensureCapacity(head + 2);
        contents[++head] = t;
        
        assert wellFormed() : "Invariant failed at end of push";
    } 
    
    /**
     * Retrieves and removes the top of this stack, which must not be empty. If the 
     * stack is empty,this methods throws an instance ofEmptyStackException.
     * 
     * @precondition    the stack is not empty
     * 
     * @postcondition   the top element of the stack has been removed
     * 
     * @return          the top element of the stack, which is removed from the stack 
     *                  in the process
     *                  
     * @throws          EmptyStackException  if the stack is empty before calling pop
     */
    public T pop() {
        assert wellFormed() : "Invariant failed at start of pop";
        
        if (isEmpty()) 
            throw new EmptyStackException();
        
        T element = contents[head];
        contents[head] = null;
        --head;
        
        assert wellFormed() : "Invariant failed at end of pop";
        
        return element;
    }
    
    /**
     * Retrieves, but does not remove, the top of this stack, which must not be empty.
     *
     * @precondition    the stack is not empty
     * 
     * @throws          EmptyStackException if the stack is empty before calling peek
     * 
     * @return          the top element of the stack, which is not removed from the 
     *                  stack
     */
    public T peek() {
        assert wellFormed() : "Invariant failed at start of peek";
        
        if (isEmpty()) 
            throw new EmptyStackException();
        
        return contents[head];
    }
    
    /**
     * Return true if this stack is empty.
     * 
     * @return          true if the stack is empty, false otherwise. 
     */
    public boolean isEmpty() {
        assert wellFormed() : "Invariant failed at start of isEmpty";
        
        return head == -1;
    }
    
    private void ensureCapacity(int min) {
        if (min <= contents.length) 
            return; 
        
        int newCap = contents.length * 2;
        if (newCap < min) 
            newCap = min;
        
        T[] newArray = makeArray(newCap); 
        for (int i=0; i < contents.length; ++i) {
            newArray[i] = contents[i];
        }
        
        contents = newArray;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public Stack<T> clone() {
        assert wellFormed() : "Invariant failed at start of clone";
        
        Stack<T> answer;
        
        try {
            answer = (Stack<T>) super.clone();
        } catch (CloneNotSupportedException e) {
            // This exception should not occur. But if it does, it would probably
            // indicate a programming error that made super.clone unavailable.
            // The most common error would be forgetting the "Implements Cloneable"
            // clause at the start of this class.
            throw new RuntimeException("This class does not implement Cloneable");
        }
        
        answer.contents = contents.clone();
        
        assert answer.wellFormed() : "Invariant failed at end of answer's clone";  
        assert wellFormed() : "Invariant failed at end of clone";
        
        return answer;
    }
    
    /**
     * Discard everything from the stack.
     * 
     * @postcondition       the stack is returned to an initial state
     */
    public void clear() {
        assert wellFormed() : "Invariant failed at start of clear";
        
        if (isEmpty()) 
            return;
        
        contents = makeArray(DEFAULT_CAPACITY);
        head = -1;
        
        assert wellFormed() : "Invariant failed at end of clear";
    }

}
