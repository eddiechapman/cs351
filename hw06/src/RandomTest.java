import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.uwm.cs351.HexCoordinate;
import edu.uwm.cs351.HexTile;
import edu.uwm.cs351.Sequence;
import edu.uwm.cs351.Terrain;
import edu.uwm.cs351.test.ArraySequence;
import edu.uwm.cs351.test.ISequence;
import edu.uwm.cs351.test.ISequenceCommand;
import edu.uwm.cs351.test.NewCommand;
import edu.uwm.cs351.test.SequenceAdaptor;
import edu.uwm.cs351.test.SequenceCommand;
import edu.uwm.cs351.test.SequenceCommandFactory;
import edu.uwm.cs351.test.util.Option;


public class RandomTest extends SequenceCommandFactory<HexTile> {

	private final int MAX_TESTS = 3_000_000;
	
	private final boolean testExceptions;
	
	private List<ISequence<HexTile>> mirror = new ArrayList<>();
	private List<ISequence<HexTile>> subject = new ArrayList<>();
	
	private List<String> tests = new ArrayList<>();
	
	public static final int NUM_HEXTILES = 10;
	private List<HexTile> tiles = new ArrayList<>();
	
	
	public RandomTest(boolean testExc) {
		testExceptions = testExc;
		tiles.add(null);
		for (int i=1; i < NUM_HEXTILES; ++i) {
			tiles.add(new HexTile(Terrain.LAND,new HexCoordinate(i,i)));
		}
	}
	
	@Override
	protected HexTile nextElement(Random r) {
		return tiles.get(r.nextInt(tiles.size()));
	}

	public void run() {
		mirror.clear();
		subject.clear();
		tests.clear();
		mirror.add(new ArraySequence<HexTile>());
		subject.add(new SequenceAdaptor(new Sequence<HexTile>()));
		tests.add(new NewCommand<HexTile>(0).toString());
		int count = 0;
		while (count < MAX_TESTS) {
			if ((++count % 10000) == 0) {
				int size = 0;
				for (ISequence<HexTile> s : mirror) {
					size += s.size();
				}
				System.out.println("// " + count + " tests passed (size = " + size + ")");
			}
			ISequenceCommand<HexTile,?> comm = nextCommand(mirror.size());
			Option<?> expected = comm.run(mirror);
			Option<?> actual;
			try {
				 actual = comm.run(subject);
			} catch (Exception|AssertionError e) {
				tests.add(comm + "// crashes with " + e.getLocalizedMessage());
				return;
			}
			if (!Option.equals(expected,actual)) {
				if (expected == null) {
					tests.add("assertException(() -> { "+comm.toString() + "});");
				} else if (actual == null) {
					tests.add(comm + " // throws an exception unexpectedly");
				} else {
					tests.add("Object test = "+comm);
					tests.add("assertEquals(" + SequenceCommand.toString(expected.getValue()) + ",test);");
				}
				return;
			}
			if (expected == null) {
				tests.add("// " + comm);
			} else {
				tests.add(comm.toString());
			}
			/*if (count < 1000) {
				System.out.println(comm);
			}*/
		}
		if (count == MAX_TESTS) {
			System.out.println("Congratulations: no bugs found!");
			tests.clear();
		}
	}

	public void print() {
		if (tests.isEmpty()) return;
		System.out.println("import edu.uwm.cs351.Terrain;");	
		System.out.println("import edu.uwm.cs351.HexCoordinate;");	
		System.out.println("import edu.uwm.cs351.HexTile;");	
		System.out.println("import edu.uwm.cs351.Sequence;");	
		System.out.println("import junit.framework.TestCase;\n\n");
		System.out.println("public class TestGen extends TestCase {\n");
		System.out.println("  protected void assertException(Runnable r) {");
		System.out.println("     try {");
		System.out.println("       r.run();");
		System.out.println("       assertFalse(\"should have thrown an exception.\",true);");
		System.out.println("     } catch (RuntimeException e) {");
		System.out.println("       assertTrue(\"correctly threw an exception.\",true);");
		System.out.println("     }");
		System.out.println("  }\n");
		for (int i=1; i < NUM_HEXTILES; ++i) {
			System.out.println("  HexTile h" + i + " = new HexTile(Terrain.LAND,new HexCoordinate("+
		i + "," + i + "));");
		}
		System.out.println("  public void test() {");
		System.out.print("    Sequence<HexTile> s0");
		int n = mirror.size();
		for (int i=1; i < n; ++i) {
			System.out.print(", s" + i);
		}
		System.out.println(";\n");
		for (String test : tests) {
			if (testExceptions && test.startsWith("//")) {
				test = "assertException(() -> {" + test.substring(2) + "});";
			}
			System.out.println("    " + test);
		}
		System.out.println("  }");
		System.out.println("}");
	}
	
	public static void main(String[] args) {
		boolean testExc = true;
		int exitStatus = 1;
		for (String arg : args) {
			switch (arg) {
			case "--noTestExceptions":
				testExc = false;
				break;
			case "--testExceptions":
				testExc = true;
				break;
			case "-h":
			case "-H":
			case "--help":
				System.out.println("Generate random tests for the CS 351 homework #2 HexTileSeq class.");
				exitStatus = 0;
				// fall through
			default:
				System.out.println("Usage:");
				System.out.println("  java RandomTest [-h/--help] [--noTestExceptions]");
				System.exit(exitStatus);
				break;
			}
		}
		RandomTest test = new RandomTest(testExc);
		test.run();
		test.print();
	}
}
