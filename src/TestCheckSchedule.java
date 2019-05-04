import java.util.Arrays;
import java.util.List;

import edu.uwm.cs.junit.LockedTestCase;
import edu.uwm.cs.util.Pair;
import edu.uwm.cs351.CheckSchedule;
import edu.uwm.cs351.Course;
import edu.uwm.cs351.Period;
import edu.uwm.cs351.Section;


public class TestCheckSchedule extends LockedTestCase {

	private Course
		cs150 = new Course("COMPSCI",150),
		cs250 = new Course("COMPSCI",250),
		cs251 = new Course("COMPSCI",251),
		cs315 = new Course("COMPSCI",315),
		cs317 = new Course("COMPSCI",317),
		cs337 = new Course("COMPSCI",337),
		cs351 = new Course("COMPSCI",351),
		ger101 = new Course("GERMAN",101);
	
	private Period
		tr9 = Period.fromString("TR 9:00 AM-9:50 AM"),
		mw9 = Period.fromString("MW 9:00 AM-9:50 AM"),
		mtwrf9 = Period.fromString("MTWRF 9:00 AM-9:50 AM"),
		tr930 = Period.fromString("TR 9:30 AM-10:45 AM"),
		mw930 = Period.fromString("MW 9:30 AM-10:45 AM"),
		tr11 = Period.fromString("TR 11:00 AM-12:15 PM"),
		mw11 = Period.fromString("MW 11:00 AM-12:15 PM"),
		m8 = Period.fromString("M 8:00 AM-8:50 AM"),
		m9 = Period.fromString("M 9:00 AM-9:50 AM"),
		m10 = Period.fromString("M 10:00 AM-10:50 AM"),
		t10 = Period.fromString("T 10:00 AM-10:50 AM"),
		t11 = Period.fromString("T 11:00 AM-11:50 AM"),
		w9 = Period.fromString("W 9:00 AM-9:50 AM"),
		w10 = Period.fromString("W 10:00 AM-10:50 AM"),
		r10 = Period.fromString("R 10:00 AM-10:50 AM"),
		f9 = Period.fromString("F 9:00 AM-9:50 AM");
	
	private List<Section> ss(Section... ss) {
		return Arrays.asList(ss);
	}
	
	
	/// locked tests
	
	public void test0() {
		Section s1 = Section.fromString(cs150,"LEC 001");
		Section s2 = Section.fromString(cs251,"LEC 401");
		Section s3 = Section.fromString(ger101,"LEC 101");
		CheckSchedule check = new CheckSchedule(ss(s1,s2,s3));
		// do online/asynchronous courses conflict?
		assertEquals(Ti(2037782835),check.checkOverlap().size());
		s1.addPeriod(mw11);
		s2.addPeriod(mw930);
		s3.addPeriod(mtwrf9);
		List<Pair<Section,Section>> pairs = check.checkOverlap();
		// how many pairs of conflicts ?
		assertEquals(Ti(1128066613),pairs.size());
		// which course is listed FIRST ?
		assertEquals(Ts(334842565),pairs.get(0).fst().getCourse().toString());
		test0Cont(false);
	}
	
	private void test0Cont(boolean ignored) {
		Section s1 = Section.fromString(cs251,"LEC 401");
		Section s2 = Section.fromString(cs251,"LAB 803");
		Section s3 = Section.fromString(ger101,"LEC 101");
		s1.addPeriod(mw11);
		s2.addPeriod(w9);
		s2.addPeriod(w10);
		s3.addPeriod(mtwrf9);
		CheckSchedule check = new CheckSchedule(ss(s1,s2,s3));
		// do labs conflict with lectures?
		assertEquals(Ti(1713711936),check.checkOverlap().size());
		// what if only one of the periods overlap ?
		s1.addPeriod(f9);
		assertEquals(Ti(822945826),check.checkOverlap().size());
	}

	
	/// Normal tests
	
	public void testA() {
		CheckSchedule cs = new CheckSchedule(ss());
		assertEquals(0,cs.checkOverlap().size());
	}
	
	public void testB() {
		Section s1 = Section.fromString(cs351,"LEC 401");
		CheckSchedule cs = new CheckSchedule(ss(s1));
		assertEquals(0,cs.checkOverlap().size());
	}
	
	public void testC() {
		Section s1 = Section.fromString(cs351,"LEC 401");
		s1.addPeriod(tr9);
		CheckSchedule cs = new CheckSchedule(ss(s1));
		assertEquals(0,cs.checkOverlap().size());
	}
	
	public void testD() {
		Section s1 = Section.fromString(cs351,"LEC 401");
		s1.addPeriod(tr9);
		s1.addPeriod(tr930); // conflicts with self?
		CheckSchedule cs = new CheckSchedule(ss(s1));
		assertEquals(0,cs.checkOverlap().size());
	}
	
	public void testE() {
		Section s1 = Section.fromString(cs150,"LEC 001");
		Section s2 = Section.fromString(ger101,"LEC 001");
		s1.addPeriod(mw11);
		s2.addPeriod(mtwrf9);
		CheckSchedule cs = new CheckSchedule(ss(s1,s2));
		assertEquals(0,cs.checkOverlap().size());
	}
	
	public void testF() {
		Section s1 = Section.fromString(cs250,"LEC 401");
		Section s2 = Section.fromString(cs351,"LEC 401");
		s1.addPeriod(mw9);
		s2.addPeriod(tr9);
		CheckSchedule cs = new CheckSchedule(ss(s1,s2));
		assertEquals(0,cs.checkOverlap().size());		
	}
	
	public void testG() {
		Section s1 = Section.fromString(cs317,"LEC 401");
		Section s2 = Section.fromString(cs315,"LEC 401");
		s1.addPeriod(tr9);
		s2.addPeriod(tr930);
		CheckSchedule cs = new CheckSchedule(ss(s1,s2));
		assertEquals(1,cs.checkOverlap().size());	
	}
	
	public void testH() {
		Section s1 = Section.fromString(cs317,"LEC 401");
		Section s2 = Section.fromString(cs315,"LEC 401");
		s1.addPeriod(tr9);
		s2.addPeriod(tr930);
		CheckSchedule cs = new CheckSchedule(ss(s1,s2));
		List<Pair<Section,Section>> pairs = cs.checkOverlap();
		assertSame(s1,pairs.get(0).fst());
		assertSame(s2,pairs.get(0).snd());
	}
	
	public void testI() {
		Section s1 = Section.fromString(cs317,"LEC 401");
		Section s2 = Section.fromString(cs315,"LEC 401");
		s1.addPeriod(t10);
		s1.addPeriod(t11);
		s2.addPeriod(t10);
		s2.addPeriod(t11);
		CheckSchedule cs = new CheckSchedule(ss(s1,s2));
		List<Pair<Section,Section>> pairs = cs.checkOverlap();
		assertEquals(1,pairs.size());
		assertSame(s1,pairs.get(0).fst());
		assertSame(s2,pairs.get(0).snd());
	}
	
	public void testJ() {
		Section s1 = Section.fromString(cs317,"LEC 401");
		Section s2 = Section.fromString(cs315,"LEC 401");
		Section s3 = Section.fromString(cs337,"LEC 401");
		s1.addPeriod(mw9);
		s2.addPeriod(mw11);
		s3.addPeriod(tr11);
		CheckSchedule cs = new CheckSchedule(ss(s1,s2,s3));
		List<Pair<Section,Section>> pairs = cs.checkOverlap();
		assertEquals(0,pairs.size());
	}
	
	public void testK() {
		Section s1 = Section.fromString(cs317,"LEC 401");
		Section s2 = Section.fromString(cs315,"LEC 401");
		Section s3 = Section.fromString(cs337,"LEC 401");
		s1.addPeriod(mw9);
		s2.addPeriod(mtwrf9);
		s3.addPeriod(tr11);
		CheckSchedule cs = new CheckSchedule(ss(s1,s2,s3));
		List<Pair<Section,Section>> pairs = cs.checkOverlap();
		assertEquals(1,pairs.size());	
		assertEquals(new Pair<>(s1,s2),pairs.get(0));
	}
	
	public void testL() {
		Section s1 = Section.fromString(cs317,"LEC 401");
		Section s2 = Section.fromString(cs315,"LEC 401");
		Section s3 = Section.fromString(cs337,"LEC 401");
		s1.addPeriod(mw9);
		s2.addPeriod(tr9);
		s3.addPeriod(m8);
		s3.addPeriod(m9);
		s3.addPeriod(m10);
		CheckSchedule cs = new CheckSchedule(ss(s1,s2,s3));
		List<Pair<Section,Section>> pairs = cs.checkOverlap();
		assertEquals(1,pairs.size());	
		assertEquals(new Pair<>(s1,s3),pairs.get(0));
	}
	
	public void testM() {
		Section s1 = Section.fromString(cs317,"LEC 401");
		Section s2 = Section.fromString(cs315,"LEC 401");
		Section s3 = Section.fromString(cs337,"LEC 401");
		s1.addPeriod(mw9);
		s2.addPeriod(tr930);
		s3.addPeriod(t10);
		s3.addPeriod(r10);
		CheckSchedule cs = new CheckSchedule(ss(s1,s2,s3));
		List<Pair<Section,Section>> pairs = cs.checkOverlap();
		assertEquals(1,pairs.size());	
		assertEquals(new Pair<>(s2,s3),pairs.get(0));
	}
	
	public void testN() {
		Section s1 = Section.fromString(cs317,"LEC 401");
		Section s2 = Section.fromString(cs315,"LEC 401");
		Section s3 = Section.fromString(cs337,"LEC 401");
		s1.addPeriod(mtwrf9);
		s2.addPeriod(tr930);
		s3.addPeriod(mw9);
		CheckSchedule cs = new CheckSchedule(ss(s1,s2,s3));
		List<Pair<Section,Section>> pairs = cs.checkOverlap();
		assertEquals(2,pairs.size());	
		assertEquals(new Pair<>(s1,s2),pairs.get(0));
		assertEquals(new Pair<>(s1,s3),pairs.get(1));
	}
	
	public void testP() {
		Section s1 = Section.fromString(cs317,"LEC 401");
		Section s2 = Section.fromString(cs315,"LEC 401");
		Section s3 = Section.fromString(cs337,"LEC 401");
		s1.addPeriod(tr9);
		s2.addPeriod(tr930);
		s3.addPeriod(t10);
		s3.addPeriod(r10);
		CheckSchedule cs = new CheckSchedule(ss(s1,s2,s3));
		List<Pair<Section,Section>> pairs = cs.checkOverlap();
		assertEquals(2,pairs.size());	
		assertEquals(new Pair<>(s1,s2),pairs.get(0));
		assertEquals(new Pair<>(s2,s3),pairs.get(1));
	}
	
	public void testQ() {
		Section s1 = Section.fromString(cs317,"LEC 401");
		Section s2 = Section.fromString(cs315,"LEC 401");
		Section s3 = Section.fromString(cs337,"LEC 401");
		s1.addPeriod(mw9);
		s2.addPeriod(tr930);
		s3.addPeriod(mtwrf9);
		CheckSchedule cs = new CheckSchedule(ss(s1,s2,s3));
		List<Pair<Section,Section>> pairs = cs.checkOverlap();
		assertEquals(2,pairs.size());	
		assertEquals(new Pair<>(s1,s3),pairs.get(0));
		assertEquals(new Pair<>(s2,s3),pairs.get(1));
	}
	
	public void testR() {
		Section s1 = Section.fromString(cs317,"LEC 401");
		Section s2 = Section.fromString(cs315,"LEC 401");
		Section s3 = Section.fromString(cs337,"LEC 401");
		s1.addPeriod(mw9);
		s2.addPeriod(tr930);
		s2.addPeriod(m9);
		s3.addPeriod(mtwrf9);
		CheckSchedule cs = new CheckSchedule(ss(s1,s2,s3));
		List<Pair<Section,Section>> pairs = cs.checkOverlap();
		assertEquals(3,pairs.size());	
		assertEquals(new Pair<>(s1,s2),pairs.get(0));
		assertEquals(new Pair<>(s1,s3),pairs.get(1));
		assertEquals(new Pair<>(s2,s3),pairs.get(2));
	}
}
