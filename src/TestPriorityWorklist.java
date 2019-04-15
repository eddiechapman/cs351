import java.util.Comparator;

import edu.uwm.cs351.HexCoordinate;
import edu.uwm.cs351.util.PriorityWorklist;
import edu.uwm.cs351.util.Worklist;


public class TestPriorityWorklist extends AbstractTestWorklist<String> {

	private Worklist<Integer> worklist;
	
	private Integer i(int i) { return new Integer(i); }
	
	@Override
	protected void initWorklist() {
		w = new PriorityWorklist<String>(String.CASE_INSENSITIVE_ORDER);
		v1 = "Hello";
		v2 = "goodbye";
		v3 = "null";
		v4 = "";
		v5 = "Foo";
		worklist = new PriorityWorklist<Integer>(new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return i1 - i2;
			}
		}); // for local tests
	}


	public void test() {
		// create using ascending order:
		Worklist<Integer> w = new PriorityWorklist<Integer>((a,b) -> a-b);
		w.add(5);
		w.add(3);
		assertEquals(Ts(1948198176),toString(() -> w.next()));
		w.add(7);
		w.add(1);
		assertEquals(Ts(1837984610),toString(() -> w.next()));
		assertEquals(Ts(1644830301),toString(() -> w.next()));
		assertEquals(Ts(1382433383),toString(() -> w.next()));
	}
	
	public void testPriority() {
		worklist.add(10);
		worklist.add(0);
		worklist.add(42);
		worklist.add(-100);
		worklist.add(19);
		
		assertEquals(i(-100),worklist.next());
		assertEquals(i(0),worklist.next());
		
		worklist.add(80);
		
		assertEquals(i(10),worklist.next());
		assertEquals(i(19),worklist.next());
		
		worklist.add(99);
		
		assertEquals(i(42),worklist.next());
		assertEquals(i(80),worklist.next());
		
		worklist.add(2);
		
		assertEquals(i(2),worklist.next());
		assertEquals(i(99),worklist.next());
	}
	
	public void testPriority2() {
		w.add("Hello");
		w.add("bye");
		
		assertEquals("bye",w.next()); // test that comparator is actually used!
		assertEquals("Hello",w.next());
	}
	
	public void testNotComparable() {
		Worklist<HexCoordinate> wl = new PriorityWorklist<HexCoordinate>(new Comparator<HexCoordinate>() {
			public int compare(HexCoordinate h1, HexCoordinate h2) {
				return h1.a() - h2.a();
			}
		});
		wl.add(new HexCoordinate(1,3));
		wl.add(new HexCoordinate(0,0));
		wl.add(new HexCoordinate(2,0));
		
		assertEquals(new HexCoordinate(0,0),wl.next());
		assertEquals(new HexCoordinate(1,3),wl.next());
		assertEquals(new HexCoordinate(2,0),wl.next());
	}
}
