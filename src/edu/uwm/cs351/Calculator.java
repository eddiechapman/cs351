package edu.uwm.cs351;

import java.util.EmptyStackException;

import edu.uwm.cs351.util.Stack;
import edu.uwm.cs351.Operation;


/**
 * @author Eddie Chapman (chapman4@uwm.edu)
 *
 */
public class Calculator {
    private Stack<Operation> operators;      // Stores operators for applying to the operands upon calculation
    private Stack<Long> operands;       // Stores long integers for calculating
    private long defaultValue;          // The result of the most recent compute operation
    private boolean receiving;
    private int state;                  // Indicates which operations are legal
    
    /**
     * Initialize an empty calculator.
     * 
     * @postcondition   The calculator has an empty state with no stored operators, operands, or recently calculated values.         
     */
    public Calculator() {
        operators = new Stack<Operation>();
        operands = new Stack<Long>();
        defaultValue = 0;
        state = 0;
    }
    
    /**
     * Clear the calculator and default value.
     * 
     * @postcondition   The calculator has an empty state with no stored operators, operands, or recently calculated values.
     */
    public void clear() {
        operators.clear();
        operands.clear();
        defaultValue = 0;
        state = 0;
    }
    
    /**
     * Enter a number.
     * 
     * @precondition    the calculator is in an empty or waiting state.
     * @postcondition   the number is added to the top of the operand stack. The calculator is a ready state. 
     * @param number    a double to be entered in the calculator.
     * @throws          IllegalStateException if the calculator is in a ready state.
     */
    public void value(long number) throws IllegalStateException {
        if (state == 1) throw new IllegalStateException("Cannot add a value to a calculator in state 1 ('ready')"); 
        operands.push(number);
        state = 1;  // ready
    }
    
    /**
     * Enter a binary operator.
     * 
     * @precondition    the calculator is in an empty or ready state.
     * @postcondition   an operation has been added to the operators stack and the calculator is in a waiting state.
     * @param o         an Operation that will be performed on the long integers in the operators stack.
     * @throws          IllegalStateException if the calculator is in an waiting state before calling this method.
     */
    public void binop(Operation o) throws IllegalStateException {
        switch (state) {
            case 0:
                value(defaultValue);
            case 1:
                operators.push(o);
                state = 2;
                break;
            case 3:
                throw new IllegalStateException("A binary operation cannot be entered to a calculator in a waiting state");
            default:
                break;
        }
    }
    
    /**
     * Replace the current value with the square root of the unsigned integer. 
     * 
     * This uses the "unsigned integer square root" function in the IntMath class.
     * As with binop, the default value is used if we were in the empty state.
     * 
     * @precondition
     * @postcondition
     */
    public void sqrt() {

    }
    
    /**
     * Start a parenthetical expression.
     * 
     * @precondition
     * @postcondition
     */
    public void open() {

    }
    
    /**
     * End a parenthetical expression
     * 
     * @precondition    The operators stack includes an unclosed open
     * @postcondition
     * @throws          EmptyStackException if the operators stack is missing an unclosed open.      
     */
    public void close() throws EmptyStackException {

    }
    
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
    public long compute() {
        
    }
    
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
    public long getCurrent() {

    }
    
    
    
    
}
