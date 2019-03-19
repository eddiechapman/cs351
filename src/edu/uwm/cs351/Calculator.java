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
     * @postcondition   The calculator is in an empty state with no pending
     *                  computations and no saved values. The default value
     *                  is stored on the numbers stack to avoid special cases,
     *                  but it is not considered to be a stored operand until
     *                  it is needed in another method.         
     */
    public Calculator() {
        operators = new Stack<Operation>();
        numbers = new Stack<Long>();
        defaultValue = 0L;
        numbers.push(defaultValue);
        state = 0;  // empty
    }
    
    /**
     * Clear the calculator and default value.
     * 
     * @postcondition   The calculator is in an empty state with no pending
     *                  computations and no saved values. The default value
     *                  is stored on the numbers stack to avoid special cases,
     *                  but it is not considered to be a stored operand until
     *                  it is needed in another method.
     */
    public void clear() {
        operators.clear();
        numbers.clear();
        defaultValue = 0L;
        numbers.push(defaultValue);
        state = 0;  // empty
    }
    
    /**
     * Enter a number.
     * 
     * If the calculator is in an empty state, the default value is removed from
     * the number stack before the new number is added.
     * 
     * @precondition    the Calculator is in an empty or waiting state.
     * 
     * @postcondition   the number is added to the top of the operands Stack. 
     *                  The Calculator is a ready state. 
     *                  
     * @param val       a long integer to be entered in the Calculator.
     * 
     * @throws          IllegalStateException if the Calculator is in a ready state.
     */
    public void value(long val) throws IllegalStateException {
        if (state == 0)
            numbers.pop();
        
        if (state == 1)
            throw new IllegalStateException("Cannot add a value to a calculator in a ready state"); 
            
        numbers.push(val);
        state = 1;
    }
    
    /**
     * Enter a binary operator.
     * 
     * This method also resolves any pending operations of lower precedence before 
     * adding the new operator. 
     * 
     * @precondition    the Calculator is in an empty or ready state.
     * 
     * @postcondition   an Operation has been added to the operators Stack. Pending 
     *                  operations of lower precedence have been activated, 
     *                  potentially creating a new current value. The Calculator is 
     *                  in a waiting state.
     *                  
     * @param op        an Operation that will be performed on the long integers in 
     *                  the operators Stack.
     *                  
     * @throws          IllegalStateException if the Calculator is in an waiting 
     *                  state before calling this method.
     * 
     * @throws          IllegalArgumentException if the caller passes invalid 
     *                  Operations to this method such as parenthesis. 
     * 
     * @throws          ArithmeticException if the pending operations activated by 
     *                  this method lead to dividing by zero.
     */
    public void binop(Operation op) throws IllegalStateException, IllegalArgumentException, ArithmeticException {
        if ((op == Operation.RPAREN) || (op == Operation.LPAREN)) 
            throw new IllegalArgumentException("Parenthesis are not binary operators. Please use open() and close() instead.");
        
        if (state == 2)
            throw new IllegalStateException("A binary operation cannot be entered to a calculator in a waiting state");
        
        while (!operators.isEmpty() && (op.precedence() <= operators.peek().precedence())) {
            activateTop();
        }
        
        operators.push(op);
        state = 2;  // waiting
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
        if (state == 2)
            throw new IllegalStateException("A binary operation cannot be entered to a calculator in a waiting state");
        
        Long sqrt = IntMath.isqrt(numbers.pop());
        
        numbers.push(sqrt);  
        
        state = 1;
    }
    
    /**
     * Start a parenthetical expression.
     * 
     * In the case of an empty calculator, the default value is booted from the
     * numbers stack before the parentheses is added.
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
        if (state == 1)
            throw new IllegalStateException("Cannot add a parenthesis when the Calculator is in a ready state.");

        if (state == 0)
            numbers.pop();
        
        operators.push(Operation.LPAREN);
        state = 2;  // ready
    }
    
    /**
     * End the most recent parenthetical expression. All pending operations found within 
     * the expression are activated. 
     * 
     * If the calculator does not include an unclosed parenthetical expression, all
     * operators will be activated before throwing an error.
     * 
     * @precondition    the Calculator is in a ready state and the operators stack includes 
     *                  an unclosed parenthetical expression.
     * 
     * @postcondition   all operations within the most recent parenthetical expression are 
     *                  activated and their parenthesis removed. The Calculator is in a ready 
     *                  state.
     * 
     * @throws          EmptyStackException if the operators stack is missing an unclosed open.
     * 
     * @throws          IllegalStateException if the Calculator is in an empty or waiting state
     *                  when this this method is called.
     *              
     * @throws          ArithmeticException if the pending operations of the completed 
     *                  parenthetical expression result in division by zero.
     */
    public void close() throws IllegalStateException, EmptyStackException, ArithmeticException {
        if (state != 1)
            throw new IllegalStateException("The Calculator must be in a ready state to attempt a close operation.");  
        
        while (operators.peek() != Operation.LPAREN) {
            activateTop();
        }
        operators.pop();       
    }
    
    /**
     * Perform all pending computations.
     * 
     * In the process, all incomplete parenthetical expressions are ended. A new default
     * value is set, and the calculator is otherwise returned to a default state.
     * 
     * @precondition    the calculator is in an empty or ready state
     * 
     * @postcondition   all pending operations have been activated. The result is stored
     *                  as a new default value. The calculator is otherwise reset to a 
     *                  default state.
     *                 
     * @throws          IllegalStateException if the calculator is in a waiting state.
     * 
     * @throws          ArithmeticException if the pending computations result in
     *                  division by zero.
     *                  
     * @returns         the number resulting from the activation of all pending operations.
     */
    public long compute() { 
        if (state == 2)
            throw new IllegalStateException("Cannot compute values in a waiting state");  
 
        while (!operators.isEmpty()) {
            if (operators.peek() == Operation.LPAREN)
                operators.pop();
            else
                activateTop();
        }
        
        defaultValue = numbers.peek();
        state = 0;

        return numbers.peek();
    }
    
    /**
     * A helper method to activate the most recent operation on the stacks.
     * 
     * If an operation would result in division by zero, the calculator is
     * restored to a default state and an error is thrown.
     */
    private void activateTop() {
        try {
            Operation op = operators.pop();
            long val1 = numbers.pop();
            long val2 = numbers.pop();
            long result = op.operate(val2, val1);
            numbers.push(result);
        } catch (ArithmeticException ae) {
            clear();
            throw new ArithmeticException();
        }
    }
    
    /**
     * Return the current value.
     * 
     * @return          the long integer most recently added to the operands Stack.
     *                  In an empty calculator, this is the default value. 
     *                  Occasionally the default value will be booted from the stack
     *                  as part of a different method. If this method is called 
     *                  at that point, the defaultValue attribute is returned instead.          
     */
    public long getCurrent() {
        if (numbers.isEmpty())
            return defaultValue;
        else
            return numbers.peek();
    }
        
}
