import java.util.EmptyStackException;
import java.util.function.Supplier;

import edu.uwm.cs.junit.LockedTestCase;
import edu.uwm.cs351.Calculator;
import edu.uwm.cs351.Operation;


public class TestCalculator extends LockedTestCase {

	private Calculator calc;

	/**
	 * Convert the result into a string, or into the name of the exception thrown
	 * @param supp supplier of something, may return null
	 * @return string of result, or simple name of exception thrown
	 */
	protected <T> String toString(Supplier<T> supp) {
		try {
			return ""+supp.get();
		} catch (RuntimeException ex) {
			return ex.getClass().getSimpleName();
		}
	}
	
	protected String howStopped(Runnable r) {
		try {
			r.run();
			return "OK";
		} catch (RuntimeException ex) {
			return ex.getClass().getSimpleName();
		}
	}
	

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		calc = new Calculator();
	}
	
	
	/// locked tests
	
	public void test() {
		// we test 1 + 2 * 3 - 4 =
		calc.value(1);
		assertEquals(1,calc.getCurrent());
		calc.binop(Operation.PLUS);
		// what will the calculator window show after pressing '+'
		assertEquals(Ti(2130836036),calc.getCurrent());
		calc.value(2);
		// what will the calculator window show after pressing '2'
		assertEquals(Ti(2132532626),calc.getCurrent());
		calc.binop(Operation.TIMES);
		// what will the calculator window show after pressing '*'
		assertEquals(Ti(1743461167),calc.getCurrent());
		calc.value(3);
		// what will the calculator window show after pressing '3'
		assertEquals(3,calc.getCurrent());
		calc.binop(Operation.MINUS);
		// what will the calculator window show after pressing '-'
		// Not obvious: remember that minus is lower precedence than * and + (if after)
		assertEquals(Ti(203422342),calc.getCurrent());
		calc.value(4);
		// what happens when we press '=' ?
		assertEquals(Ti(856279275),calc.compute());
		testcont(true);
	}
	
	private void testcont(boolean ignored) {
		// we got an answer of 3.  This is called the "default value".
		calc.binop(Operation.TIMES);
		calc.value(7);
		// what will the calculator show (don't be tricked!)
		assertEquals(Ti(1674274506),calc.getCurrent());
		calc.sqrt(); // what is the integer (rounded down) square root of Ti(1674274506) ?
		assertEquals(Ti(1675006888),calc.getCurrent());
		// do you remember what we were doing?
		assertEquals(Ti(2077042487),calc.compute());
		testerror(false);
	}
	
	private void testerror(boolean ignored) {
		// default value is 6
		// howStopped is "OK" is no exception thrown,
		//            or the name of exception if one is thrown
		// what if we type "99";
		assertEquals("OK",howStopped(() -> calc.value(99)));
		// and then enter another number?
		assertEquals(Ts(760326031),howStopped(() -> calc.value(55)));
		// then press +
		assertEquals(Ts(48507371),howStopped(() -> calc.binop(Operation.PLUS)));
		// then enter another number: 55
		assertEquals("OK",howStopped(() -> calc.value(55)));
		// then a closing parenthesis
		assertEquals(Ts(1325211284),howStopped(() -> calc.close()));
		// but the closing paren did force computation:
		assertEquals(Ti(2128232356),calc.getCurrent());
		// now press '/'
		calc.binop(Operation.DIVIDE);
		// now press 'clear' (red 'C')
		assertEquals(Ts(1998774167),howStopped(() -> calc.clear()));
		assertEquals(0,calc.getCurrent());
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
	
	public void testAddDefault() {
		calc.binop(Operation.PLUS);
		calc.value(17);
		
		assertEquals(17,calc.getCurrent());
		
		assertEquals(17,calc.compute());
		assertEquals(17,calc.getCurrent());
	}
	
	public void testSub() {
		calc.value(6L);
		calc.binop(Operation.MINUS);
		calc.value(2);
		
		assertEquals(2,calc.getCurrent());
		
		assertEquals(4,calc.compute());
		assertEquals(4,calc.getCurrent());		
	}

	public void testSubDefault() {
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
	
	public void testReCompute1() {
		calc.value(13);
		calc.binop(Operation.PLUS);
		calc.value(77);
		
		assertEquals(90,calc.compute());
		
		calc.value(25);
		assertEquals(25,calc.compute());
	}
	
	public void testReCompute2() {
		calc.value(3);
		calc.binop(Operation.TIMES);
		calc.value(4);
		
		assertEquals(12,calc.compute());
		
		calc.binop(Operation.TIMES);
		calc.value(5);
		assertEquals(60,calc.compute());
	}
	
	public void testReCompute3() {
		calc.value(10);
		calc.binop(Operation.DIVIDE);
		calc.value(3);
		
		assertEquals(3,calc.compute());
		assertEquals(3L,calc.compute());
		
		calc.binop(Operation.TIMES);
		calc.value(3);
		assertEquals(9,calc.compute());		
	}
	
	public void testReCompute4() {
		calc.value(6);
		calc.binop(Operation.TIMES);
		calc.value(7);
		
		assertEquals(42,calc.compute());
		
		calc.value(100);
		calc.binop(Operation.MINUS);
		calc.value(52);
		
		assertEquals(48,calc.compute());
		
		calc.binop(Operation.DIVIDE);
		calc.value(6);
		
		assertEquals(8,calc.compute());
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
	
	public void testSqrtLarge() {
		// test to make sure sqrt() uses IntMath.isqrt, not Math.sqrt
		long l1 = 0x87654321L;
		long l2 = l1*l1;
		calc.value(l2);
		calc.sqrt();
		assertEquals(l1,calc.compute());
		calc.value(l2+1);
		calc.sqrt();
		assertEquals(l1,calc.compute());
		calc.value(l2-1);
		calc.sqrt();
		assertEquals(l1-1,calc.compute());
	}
	
	public void testSqrtNegativeOne() {
		calc.value(-1);
		calc.sqrt();
		
		assertEquals((1L<<32)-1,calc.compute());
	}
	
	public void testSqrtNegative() {
		long l1 = (1L<<32)-1;
		long l2 = -(1L<<33)+1;
		calc.value(l2);
		calc.sqrt();
		assertEquals(l1,calc.compute());
		calc.value(l2+1);
		calc.sqrt();
		assertEquals(l1,calc.compute());
		calc.value(l2-1);
		calc.sqrt();
		assertEquals(l1-1,calc.compute());
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
	
	public void testRecovery1() {
		calc.value(2);
		calc.binop(Operation.PLUS);
		calc.value(3);
		calc.binop(Operation.TIMES);
		calc.value(4);
		
		try {
			calc.close();
			assertFalse("close() should have raised error",true);
		} catch (RuntimeException e) {
			assertTrue("exception of wrong type: " + e.getClass().getName(), e instanceof EmptyStackException);
		}
		
		assertEquals(14,calc.getCurrent());
		
		try {
			calc.value(13);
			assertFalse("value(13) should have raised error",true);
		} catch (RuntimeException e) {
			assertTrue("exception of wrong type: " + e.getClass().getName(), e instanceof IllegalStateException);
		}
		
		assertEquals(14,calc.getCurrent());

		calc.binop(Operation.MINUS);
		calc.value(4);
		
		assertEquals(10,calc.compute());
	}
	
	public void testRecovery2() {
		calc.value(2);
		calc.binop(Operation.PLUS);
		calc.value(3);
		calc.binop(Operation.TIMES);

		try {
			calc.sqrt();
			assertFalse("sqrt() should have raised error",true);
		} catch (RuntimeException e) {
			assertTrue("exception of wrong type: " + e.getClass().getName(), e instanceof IllegalStateException);
		}

		calc.value(4);
		assertEquals(4,calc.getCurrent());
		
		calc.binop(Operation.MINUS);
		assertEquals(14, calc.getCurrent());
		
		calc.value(4);
		
		try {
			calc.open();
			assertFalse("open() should have raised error",true);
		} catch (RuntimeException e) {
			assertTrue("exception of wrong type: " + e.getClass().getName(), e instanceof IllegalStateException);
		}		
		
		calc.sqrt();
		assertEquals(2, calc.getCurrent());
		
		assertEquals(12, calc.compute());
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
