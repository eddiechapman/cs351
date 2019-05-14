package edu.uwm.cs351;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.uwm.cs.util.Pair;

/**
 * Check a list of sections for problems.  
 * 
 * Currently we only perform one check: finding conflicting lecture 
 * sections.
 */
public class CheckSchedule {
	private final List<Section> sections;
	
	/**
	 * Initialize the list of sections under review.
	 * 
	 * @param ss       sections to check, must not be null
	 */
	public CheckSchedule(List<Section> ss) {
		sections = new ArrayList<>(ss);
	}
	
	/**
	 * Return a list of all pairs of lecture sections that have 
	 * conflicting periods.
	 * 
	 * Each pair is listed only once (with the earlier lecture section 
	 * listed first).
	 * 
	 * @return new list of conflicting pairs.
	 */
	public List<Pair<Section,Section>> checkOverlap() {
		return null; // TODO
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		List<Section> sections = ImportUWMSchedule.doImport(args);
		if (sections == null) {
			System.out.println("Usage: CheckSchedule <term> <curriculm>");
			System.out.println("    term is SPRING_2019, for example.");
			System.out.println("    curriculum is CompSci, for example.");
			System.out.println("Usage: CheckSchedule <filename>");
			System.out.println("    filename is lib/fal2019.html, for example");			
		} else {
			CheckSchedule self = new CheckSchedule(sections);
			for (Pair<Section,Section> p : self.checkOverlap()) {
				Section s1 = p.fst();
				Section s2 = p.snd();
				System.out.println(s1.getCourse()+"; " + s1 + " conflicts with " + s2.getCourse()+"; "+s2);
			}
		}
	}
}
