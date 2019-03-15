package edu.uwm.cs351;

import java.util.EmptyStackException;

import edu.uwm.cs351.util.Stack;
import edu.uwm.cs351.Operation;


/**
 * @author Eddie Chapman (chapman4@uwm.edu)
 *
 */
public class Calculator {
    private Stack<Long> operators = new Stack<Long>();
    private Stack<Long> operations = new Stack<Long>();
    private long defaultValue;
    private boolean receiving;
    private int state;
    
    /**
     * 
     * 
     * @precondition
     * @postcondition
     */
    public Calculator() {}
    
    /**
     * Clear the calculator and default value.
     */
    public void clear() {}
    
    /**
     * Enter a number.
     * 
     * @precondition
     * @postcondition
     * @param number    a double to be entered in the calculator
     */
    public void value(long number) {}
    
    /**
     * Enter a binary operator.
     * 
     * If we were in the empty state, then the default value is used to first move the state 1.
     * 
     * @precondition
     * @postcondition   
     */
    public void binop(Operation o) {}
    
    /**
     * Replace the current value with the square root of the unsigned integer. 
     * 
     * This uses the "unsigned integer square root" function in the IntMath class.
     * As with binop, the default value is used if we were in the empty state.
     * 
     * @precondition
     * @postcondition
     */
    public void sqrt() {}
    
    /**
     * Start a parenthetical expression.
     * 
     * @precondition
     * @postcondition
     */
    public void open() {}
    
    /**
     * End a parenthetical expression
     * 
     * @precondition    The operators stack includes an unclosed open
     * @postcondition
     * @throws           EmptyStackException if the operators stack is missing an unclosed open.      
     */
    public void close() throws EmptyStackException {}
    
    /**
     * Perform all pending computations.
     * 
     * In the process, all incomplete parenthetical expressions are ended. If we were 
     * in an empty state before, the result is just the default value. Afterwards, the 
     * default value is the result which is returned.
     * 
     * @precondition
     * @postcondition
     * @return         the default value
     */
    public long compute() {}
    
    /**
     * Return the current value.
     * 
     * In the "empty" state, the current value is the default value;
     * in the "ready" state, the current value is the most recently entered number;
     * in the "waiting" state, the current value is also the most recently entered number.
     * 
     * @precondition
     * @postcondition
     * @return         the current value
     */
    public long getCurrent() {}
    
    
    
    
}
