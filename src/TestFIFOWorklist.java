import edu.uwm.cs351.util.FIFOWorklist;
import edu.uwm.cs351.util.Worklist;


public class TestFIFOWorklist extends AbstractTestWorklist<String> {

	private Worklist<Integer> worklist;
	
	private Integer i(int i) { return new Integer(i); }
	
	@Override
	protected void initWorklist() {
		w = new FIFOWorklist<String>();
		v1 = "hello";
		v2 = "goodbye";
		v3 = null;
		v4 = "";
		v5 = "0";
		worklist = new FIFOWorklist<Integer>(); // for local tests
	}

	public void test() {
		Worklist<Integer> w = new FIFOWorklist<Integer>();
		w.add(1);
		w.add(2);
		assertEquals(Ts(543470984),toString(() -> w.next()));
		w.add(3);
		assertEquals(Ts(1682282319),toString(() -> w.next()));
		assertEquals(Ts(168703477),toString(() -> w.next()));
		assertEquals(Ts(700462792),toString(() -> w.next()));
	}

	public void testFIFO() {
		worklist.add(10);
		worklist.add(0);
		worklist.add(42);
		worklist.add(-100);
		worklist.add(19);
		
		assertEquals(i(10),worklist.next());
		assertEquals(i(0),worklist.next());
		
		worklist.add(80);
		
		assertEquals(i(42),worklist.next());
		assertEquals(i(-100),worklist.next());
		
		worklist.add(99);
		
		assertEquals(i(19),worklist.next());
		assertEquals(i(80),worklist.next());
		
		worklist.add(2);
		
		assertEquals(i(99),worklist.next());
		assertEquals(i(2),worklist.next());
	}
}
