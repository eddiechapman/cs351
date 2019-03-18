package edu.uwm.cs351;

import java.util.EmptyStackException;

import edu.uwm.cs351.util.Stack;
import edu.uwm.cs351.util.IntMath;
import edu.uwm.cs351.Operation;


/**
 * @author Eddie Chapman (chapman4@uwm.edu)
 *
 */
public class Calculator {
    private Stack<Operation> operators;     // Stores operators for applying to the operands upon calculation
    private Stack<Long> numbers;            // Stores long integers for calculating
    private Long defaultValue;              // The result of the most recent compute operation
    private int state;                      // Indicates which operations are legal
    
    /**
     * Initialize an empty calculator.
     * 
     * @postcondition   The calculator has an empty state with no stored operators, 
     *                  operands, or recently calculated values.         
     */
    public Calculator() {
        operators = new Stack<Operation>();
        numbers = new Stack<Long>();
        defaultValue = 0L;
        numbers.push(defaultValue);
        state = 0;  // 'empty'
    }
    
    /**
     * Clear the calculator and default value.
     * 
     * @postcondition   the calculator has an empty state with no stored operators, 
     *                  operands, or recently calculated values.
     */
    public void clear() {
        operators.clear();
        numbers.clear();
        defaultValue = 0L;
        numbers.push(defaultValue);
        state = 0;  // 'empty'
    }
    
    private void cleanUp() {
        defaultValue = getCurrent();
        operators.clear();
        numbers.clear();
        numbers.push(defaultValue);
        state = 0;
    }
    
    /**
     * Enter a number.
     * 
     * @precondition    the Calculator is in an empty or waiting state.
     * 
     * @postcondition   the number is added to the top of the operands Stack. 
     *                  The Calculator is a ready state. 
     *                  
     * @param val       a Long to be entered in the Calculator.
     * 
     * @throws          IllegalStateException if the Calculator is in a ready state.
     */
    public void value(long val) throws IllegalStateException {
        if (state == 0)
            numbers.pop();
        
        if (state == 1) {
            throw new IllegalStateException("Cannot add a value to a calculator in a ready state"); 
        }
            
        numbers.push(val);
        state = 1;
    }
    
    /**
     * Enter a binary operator.
     * 
     * @precondition    the Calculator is in an empty or ready state.
     * 
     * @postcondition   an Operation has been added to the operators Stack and the 
     *                  Calculator is in a waiting state.
     *                  
     * @param op        an Operation that will be performed on the long integers in the 
     *                  operators Stack.
     *                  
     * @throws          IllegalStateException if the Calculator is in an waiting state 
     *                  before calling this method.
     */
    public void binop(Operation op) throws IllegalStateException{
        if ((op == Operation.RPAREN) || (op == Operation.LPAREN)) 
            throw new IllegalArgumentException("Parenthesis are not binary operators. Please use open() and close() instead.");
        
        if (state == 2) {
            throw new IllegalStateException("A binary operation cannot be entered to a calculator in a waiting state");
        }
        
        while (!operators.isEmpty() && (op.precedence() <= operators.peek().precedence())) {
            activateTop();
        }
        
        operators.push(op);
        state = 2;  // 'waiting'
    }
    
    /**
     * Replace the current value with the square root of the unsigned integer. 
     * 
     * @precondition        the Calculator is in an empty or ready state
     * 
     * @postcondition       the current value has been replaced by the square root 
     *                      of the unsigned integer
     *                      
     * @throws              IllegalStateException if the Calculator is in a waiting 
     *                      state when this method is called.
     */
    public void sqrt() throws IllegalStateException {
        if (state == 2) {
            throw new IllegalStateException("A binary operation cannot be entered to a calculator in a waiting state");
        }
        Long sqrt = IntMath.isqrt(numbers.pop());
        
        numbers.push(sqrt);  
        
        state = 1;
    }
    
    /**
     * Start a parenthetical expression.
     * 
     * @precondition    The Calculator is in an empty or waiting state.
     * 
     * @postcondition   A left parenthesis has been added to the operators stack,
     *                  and the Calculator is in a waiting state.
     * 
     * @throws          IllegalStateException if the Calculator is in a ready state
     *                  when this method is called. 
     */
    public void open() throws IllegalStateException {
        if (state == 0)
            numbers.pop();
        
        if (state == 1) {
            throw new IllegalStateException("Cannot add a parenthesis when the Calculator is in a ready state.");
        }
        
        operators.push(Operation.LPAREN);
        state = 2;
    }
    
    /**
     * End a parenthetical expression
     * 
     * @precondition    the Calculator is in a ready state and the operators stack includes 
     *                  an unclosed parenthetical expression.
     * 
     * @postcondition   the most recent unclosed parenthetical expression has been closed. 
     *                  The Calculator is in a ready state.
     * 
     * @throws          EmptyStackException if the operators stack is missing an unclo sed open.
     * 
     * @throws          IllegalStateException if the Calculator is in an empty or waiting state
     *                  when this this method is called.
     */
    public void close() throws IllegalStateException, EmptyStackException {
        if (state != 1) {
            throw new IllegalStateException("The Calculator must be in a ready state to attempt a close operation.");  
        }
        
        while (operators.peek() != Operation.LPAREN) {
            activateTop();
            if (operators.isEmpty()) {
                throw new EmptyStackException();
            }
        }
        operators.pop();       
    }
    
    /**
     * Perform all pending computations.
     * 
     * In the process, all incomplete parenthetical expressions are ended. If we were 
     * in an empty state before, the result is just the default value. Afterwards, the 
     * default value is the result which is returned.
     * 
     * @precondition
     * 
     * @postcondition
     */
    public long compute() { 
        if (state == 2) {
            throw new IllegalStateException("Cannot compute values in a waiting state");  
        }
 
        while (!operators.isEmpty()) {
            if (operators.peek() != Operation.LPAREN)
                activateTop();
            else
                operators.pop();
        }
        
        defaultValue = numbers.peek();
        state = 0;

        return defaultValue;
    }
    
    private void activateTop() {
        Operation op = operators.pop();
        long val1 = numbers.pop();
        long val2 = numbers.pop();
        long result = op.operate(val2, val1);
        numbers.push(result);
    }
    
    /**
     * Return the current value.
     * 
     * @return          the long integer most recently added to the operands Stack, 
     *                  or the default value if the Calculator is in an empty state.          
     */
    public long getCurrent() {
        if (numbers.isEmpty())
            return defaultValue;
        else
            return numbers.peek();
    }
        
    
    
    
    
}
