import java.util.EmptyStackException;

import junit.framework.TestCase;
import edu.uwm.cs351.Calculator;
import edu.uwm.cs351.Operation;


public class TestCalculator extends TestCase {

	private Calculator calc;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		calc = new Calculator();
	}
	
	public void testInit() {
		assertEquals(0,calc.getCurrent());
		assertEquals(0,calc.compute());
	}
	
	public void testValue() {
		calc.value(7);
		assertEquals(7,calc.getCurrent());
		assertEquals(7,calc.compute());
	}
	
	public void testAdd() {
		calc.value(1);
		calc.binop(Operation.PLUS);
		calc.value(2);
		
		assertEquals(2,calc.getCurrent());
		
		assertEquals(3,calc.compute());
		assertEquals(3,calc.getCurrent());
	}
	
	public void testSub() {
		calc.binop(Operation.MINUS);
		calc.value(2);
		
		assertEquals(2,calc.getCurrent());
		
		assertEquals(-2,calc.compute());
		assertEquals(-2,calc.getCurrent());		
	}
	
	public void testPrecAddMul() {
		calc.value(5);
		calc.binop(Operation.PLUS);
		calc.value(6);
		calc.binop(Operation.TIMES);
		calc.value(7);
		
		assertEquals(7,calc.getCurrent());
		assertEquals(47,calc.compute());
	}

	public void testPrecMulAdd() {
		calc.value(5);
		calc.binop(Operation.TIMES);
		calc.value(6);
		calc.binop(Operation.PLUS);
		
		assertEquals(30,calc.getCurrent());
		calc.value(7);
		
		assertEquals(7,calc.getCurrent());
		assertEquals(37,calc.compute());
	}

	public void testAssocDiv() {
		calc.value(144);
		calc.binop(Operation.DIVIDE);
		calc.value(8);
		calc.binop(Operation.DIVIDE);
		
		assertEquals(18,calc.getCurrent());
		calc.value(3);
		assertEquals(3,calc.getCurrent());
		assertEquals(6,calc.compute());
	}
	
	public void testParenAddMul() {
		calc.open();
		calc.value(5);
		calc.binop(Operation.PLUS);
		calc.value(6);
		calc.close();
		
		assertEquals(11,calc.getCurrent());
		
		calc.binop(Operation.TIMES);
		calc.value(7);
		
		assertEquals(7,calc.getCurrent());
		assertEquals(77,calc.compute());
		
	}
	
	public void testParenMulAdd() {
		calc.value(5);
		calc.binop(Operation.TIMES);
		calc.open();
		calc.value(6);
		calc.binop(Operation.PLUS);
		
		assertEquals(6,calc.getCurrent());
		
		calc.value(7);
		calc.close();
		
		assertEquals(13,calc.getCurrent());
		assertEquals(65,calc.compute());
	}
	
	public void testLarge() {
		calc.value(1L<<32);
		calc.binop(Operation.TIMES);
		calc.value(1L<<16);
		
		assertEquals(1L<<48,calc.compute());
		assertEquals(1L<<48,calc.getCurrent());
	}
	
	public void testReCompute() {
		calc.value(13);
		calc.binop(Operation.PLUS);
		calc.value(77);
		
		assertEquals(90,calc.compute());
		
		calc.value(25);
		assertEquals(25,calc.compute());
	}
	
	public void testParens() {
		calc.value(1);
		calc.binop(Operation.MINUS);
		calc.open();
		calc.value(2);
		calc.binop(Operation.MINUS);
		calc.open();
		calc.value(3);
		calc.binop(Operation.MINUS);
		calc.value(4);
		calc.binop(Operation.TIMES);
		calc.value(5);
		calc.close();
		
		assertEquals(-17,calc.getCurrent());
		
		calc.close();
		
		assertEquals(19,calc.getCurrent());
		
		calc.binop(Operation.PLUS);
		
		assertEquals(-18,calc.getCurrent());
		
		calc.value(20);
		
		assertEquals(2,calc.compute());
	}
	
	public void testDefaultClose() {
		calc.value(1);
		calc.binop(Operation.MINUS);
		calc.open();
		calc.value(2);
		calc.binop(Operation.MINUS);
		calc.open();
		calc.value(3);
		calc.binop(Operation.MINUS);
		calc.value(4);
		calc.binop(Operation.TIMES);
		calc.value(5);
		
		// compute should close any parens as needed.
		assertEquals(-18,calc.compute());
	}
	
	public void testClear1() {
		calc.value(-144);
		calc.clear();
		calc.binop(Operation.MINUS);
		calc.value(44);
		
		assertEquals(-44,calc.compute());
	}
	
	public void testClear2() {
		calc.value(-144);
		calc.clear();
		calc.value(55);
		calc.binop(Operation.MINUS);
		calc.value(44);
		
		assertEquals(11,calc.compute());
	}
	public void testClear3() {
		calc.value(-144);
		calc.binop(Operation.PLUS);
		calc.clear();
		calc.binop(Operation.MINUS);
		calc.value(44);
		
		assertEquals(-44,calc.compute());
	}
	
	public void testClear4() {
		calc.value(-144);
		calc.binop(Operation.PLUS);
		calc.clear();
		calc.value(101);
		calc.binop(Operation.MINUS);
		calc.value(44);
		
		assertEquals(57,calc.compute());
	}

	public void testSqrt() {
		calc.value(4100);
		calc.sqrt();
		
		assertEquals(64,calc.getCurrent());
		
		calc.sqrt();
		
		assertEquals(8,calc.compute());
		
		calc.sqrt();
		calc.binop(Operation.TIMES);
		calc.value(3);
		
		assertEquals(6,calc.compute());
	}
	
	public void testSqrtEmpty() {
		calc.sqrt();
		assertEquals(0,calc.compute());
	}
	
	public void testSqrtNegative() {
		calc.value(-1);
		calc.sqrt();
		
		assertEquals((1L<<32)-1,calc.compute());
	}
	
	
	/// Error Tests
	
	public void testErrorClose() {
		try {
			calc.close();
			assertFalse("close() should have raised error",true);
		} catch (RuntimeException e) {
			assertTrue("exception of wrong type: " + e.getClass().getName(), e instanceof IllegalStateException);
		}		
	}
	
	public void testErrorValueValue() {
		calc.value(8);
		try {
			calc.value(2);
			assertFalse("second value should have raised error",true);
		} catch (RuntimeException e) {
			assertTrue("exception of wrong type: " + e.getClass().getName(), e instanceof IllegalStateException);
		}
	}
	
	public void testErrorValueOpen() {
		calc.value(8);
		try {
			calc.open();
			assertFalse("open() should have raised error",true);
		} catch (RuntimeException e) {
			assertTrue("exception of wrong type: " + e.getClass().getName(), e instanceof IllegalStateException);
		}		
	}
	
	public void testErrorValueClose() {
		calc.value(8);
		try {
			calc.close();
			assertFalse("close() should have raised error",true);
		} catch (RuntimeException e) {
			assertTrue("exception of wrong type: " + e.getClass().getName(), e instanceof EmptyStackException);
		}
	}
	
	public void testErrorLParenNotBinop() {
		try {
			calc.binop(Operation.LPAREN);
			assertFalse("binop('(') should have raised error",true);
		} catch (RuntimeException e) {
			assertTrue("exception of wrong type: " + e.getClass().getName(), e instanceof IllegalArgumentException);
		}
	}
	
	public void testErrorRParenNotBinop() {
		try {
			calc.binop(Operation.RPAREN);
			assertFalse("binop(')') should have raised error",true);
		} catch (RuntimeException e) {
			assertTrue("exception of wrong type: " + e.getClass().getName(), e instanceof IllegalArgumentException);
		}
	}

	public void testErrorOpOp() {
		calc.binop(Operation.PLUS);
		try {
			calc.binop(Operation.TIMES);
			assertFalse("binop('*') should have raised error",true);
		} catch (RuntimeException e) {
			assertTrue("exception of wrong type: " + e.getClass().getName(), e instanceof IllegalStateException);
		}
	}
	
	public void testErrorOpClose() {
		calc.binop(Operation.PLUS);
		try {
			calc.close();
			assertFalse("close() should have raised error",true);
		} catch (RuntimeException e) {
			assertTrue("exception of wrong type: " + e.getClass().getName(), e instanceof IllegalStateException);
		}
	}
	
	public void testErrorOpSqrt() {
		calc.binop(Operation.PLUS);
		try {
			calc.sqrt();
			assertFalse("sqrt() should have raised error",true);
		} catch (RuntimeException e) {
			assertTrue("exception of wrong type: " + e.getClass().getName(), e instanceof IllegalStateException);
		}
	}

	public void testErrorOpCompute() {
		calc.binop(Operation.PLUS);
		try {
			calc.compute();
			assertFalse("compute() should have raised error",true);
		} catch (RuntimeException e) {
			assertTrue("exception of wrong type: " + e.getClass().getName(), e instanceof IllegalStateException);
		}
	}

	public void testErrorOpenOp() {
		calc.open();
		try {
			calc.binop(Operation.DIVIDE);
			assertFalse("binop('/') should have raised error",true);
		} catch (RuntimeException e) {
			assertTrue("exception of wrong type: " + e.getClass().getName(), e instanceof IllegalStateException);
		}
	}
	
	public void testErrorOpenClose() {
		calc.open();
		try {
			calc.close();
			assertFalse("close() should have raised error",true);
		} catch (RuntimeException e) {
			assertTrue("exception of wrong type: " + e.getClass().getName(), e instanceof IllegalStateException);
		}
	}

	public void testErrorOpenSqrt() {
		calc.open();
		try {
			calc.sqrt();
			assertFalse("sqrt() should have raised error",true);
		} catch (RuntimeException e) {
			assertTrue("exception of wrong type: " + e.getClass().getName(), e instanceof IllegalStateException);
		}
	}

	public void testErrorOpenCompute() {
		calc.open();
		try {
			calc.compute();
			assertFalse("compute() should have raised error",true);
		} catch (RuntimeException e) {
			assertTrue("exception of wrong type: " + e.getClass().getName(), e instanceof IllegalStateException);
		}
	}

	public void testErroClose() {
		calc.binop(Operation.MINUS);
		calc.value(42);
		try {
			calc.close();
			assertFalse("close() should have raised error",true);
		} catch (RuntimeException e) {
			assertTrue("exception of wrong type: " + e.getClass().getName(), e instanceof EmptyStackException);
		}		
	}
	
	public void testErrorComplexRecovery() {
		try {
			calc.close();
			assertFalse("close() should have raised error",true);
		} catch (RuntimeException e) {
			assertTrue("exception of wrong type: " + e.getClass().getName(), e instanceof IllegalStateException);
		}
		
		calc.value(1);
		calc.binop(Operation.MINUS);
		
		try {
			calc.close();
			assertFalse("close() should have raised error",true);
		} catch (RuntimeException e) {
			assertTrue("exception of wrong type: " + e.getClass().getName(), e instanceof IllegalStateException);
		}
		
		calc.open();
		
		try {
			calc.binop(Operation.MINUS);
			assertFalse("binop('-') should have raised error",true);
		} catch (RuntimeException e) {
			assertTrue("exception of wrong type: " + e.getClass().getName(), e instanceof IllegalStateException);
		}
		
		calc.value(2);
		
		try {
			calc.open();
			assertFalse("open() should have raised error",true);
		} catch (RuntimeException e) {
			assertTrue("exception of wrong type: " + e.getClass().getName(), e instanceof IllegalStateException);
		}		
		try {
			calc.value(13);
			assertFalse("value(13) should have raised error",true);
		} catch (RuntimeException e) {
			assertTrue("exception of wrong type: " + e.getClass().getName(), e instanceof IllegalStateException);
		}

		calc.binop(Operation.MINUS);
		
		try {
			calc.binop(Operation.DIVIDE);
			assertFalse("binop('/') should have raised error",true);
		} catch (RuntimeException e) {
			assertTrue("exception of wrong type: " + e.getClass().getName(), e instanceof IllegalStateException);
		}
		try {
			calc.sqrt();
			assertFalse("sqrt() should have raised error",true);
		} catch (RuntimeException e) {
			assertTrue("exception of wrong type: " + e.getClass().getName(), e instanceof IllegalStateException);
		}
		
		calc.open();
		calc.value(3);
		calc.binop(Operation.MINUS);
		calc.value(4);
		calc.binop(Operation.TIMES);
		calc.value(5);
		calc.close();
		
		assertEquals(-17,calc.getCurrent());
		
		calc.close();
		
		assertEquals(19,calc.getCurrent());
		
		calc.binop(Operation.PLUS);
		
		assertEquals(-18,calc.getCurrent());
		
		try {
			calc.close();
			assertFalse("close() should have raised error",true);
		} catch (RuntimeException e) {
			assertTrue("exception of wrong type: " + e.getClass().getName(), e instanceof IllegalStateException);
		}

		calc.value(20);
		
		try {
			calc.close();
			assertFalse("close() should have raised error",true);
		} catch (RuntimeException e) {
			assertTrue("exception of wrong type: " + e.getClass().getName(), e instanceof EmptyStackException);
		}

		assertEquals(2,calc.compute());		
	}
}
