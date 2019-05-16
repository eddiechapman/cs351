package edu.uwm.cs351;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import edu.uwm.cs.util.XMLTokenType;
import edu.uwm.cs.util.XMLTokenizer;
import edu.uwm.cs351.util.XMLTokenizerUtil;

/**
 * Import information off a UWM Schedule page for a department.
 */
public class ImportUWMSchedule {
	private static final String SCHEDULE_URL_FORMAT = "http://www4.uwm.edu/schedule/index.cfm?a1=subject_details&subject=%s&strm=%d";

	private static URL makeURL(Term term, String code) throws IOException {
		int result = JOptionPane.showConfirmDialog(null, "This will open a network connection to the UWM web pages.\nProceed?", "Network Query", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.CANCEL_OPTION) throw new IOException("Not opening network connection");
		try {
			return new URL(String.format(SCHEDULE_URL_FORMAT,code.toUpperCase(),term.getId()));
		} catch (MalformedURLException e) {
			throw new AssertionError("Internal error in UWM Scheule importer: " + e.getLocalizedMessage());
		}
	}
	
	private static final Charset UTF8 = Charset.forName("UTF-8");
	
	private final XMLTokenizer tokenizer;
	private final XMLTokenizerUtil util;
	
	/**
	 * Read UWM schedule information for a particular curricular code 
	 * and term.
	 * 
	 * @param term     UWM term, must not be null
	 * @param code     curricular code, e.g. "COMPSCI", must not be null
	 * @throws         IOException problem opening the web page
	 */
	public ImportUWMSchedule(Term term, String code) throws IOException {
		this(makeURL(term,code));
	}
	
	/**
	 * Read UWM schedule information from the given URL.
	 * 
	 * @param url      source of data, must not be null
	 * @throws         IOException if the URL cannot be opened and a few 
	 *                 bytes read.
	 */
	public ImportUWMSchedule(URL url) throws IOException {
		this(new InputStreamReader(url.openStream(),UTF8));
	}
	
	/**
	 * Use the given stream to read UWM schedule information.
	 * 
	 * @param r        a reader, not necessarily buffered
	 */
	public ImportUWMSchedule(Reader r) {
		tokenizer = new XMLTokenizer(new BufferedReader(r));
		tokenizer.addCDATA("script");
		tokenizer.addCDATA("style");
		util = new XMLTokenizerUtil(tokenizer);
	}

	private List<Section> readSections = new ArrayList<>();
	private String error = null;
	

	/**
	 * Read the HTML and return the list of sections found. 
	 * 
	 * If there is an error, we may stop prematurely.
	 * 
	 * @see {@link #getError()}.
	 * @return         list of sections found.
	 */
	public List<Section> read() {
		util.skipUntilOpen("html");
		tokenizer.next();
		while (tokenizer.hasNext()) {
		    
		    // find the next course
	        while (tokenizer.hasNext()) {
	            util.skipUntilOpen("span");
	            if ((tokenizer.next() == XMLTokenType.ATTR) &&
	                (tokenizer.getCurrentName().equals("class")) &&
	                (tokenizer.getCurrentText().equals("subhead")) &&
	                (tokenizer.next() == XMLTokenType.CLOSE) &&
	                (tokenizer.next() == XMLTokenType.TEXT)) break;             
	        }
	        
	        // process the course info
	        while (true) {
	            String text = tokenizer.getCurrentText().trim();
	            
	            if (!text.contains("-") || !text.contains(":")) 
	                throw new RuntimeException("help!! " + tokenizer); 
	            
	            int sep1 = text.indexOf("-");
	            int sep2 = text.indexOf(":");
	            
	            String curriculumCode = text.substring(0, sep1);
	            String courseTitle = text.substring(sep2 + 1);
	            String courseNumberStr = text.substring(sep1 + 1, sep2);	            
	            if (courseNumberStr.endsWith("G")) break;  // Don't need U/G courses
	            Integer courseNumber = Integer.parseInt(courseNumberStr);
	            
	            Course c = new Course(curriculumCode, courseNumber);
	            c.setTitle(courseTitle);
	            System.out.println(c.toString());
	            break;
	        }
	        
    	}
		return readSections;
    }
		
		
//		    util.skipUntilOpen("span");
//		    tokenizer.next();
//		    if (tokenizer.getCurrentText().equals("subhead")) {
//		        tokenizer.next();
//		        tokenizer.next(); 
//		        
//		        // Found a course
//		        if (tokenizer.getCurrentText().startsWith("COMPSCI")) {  
//		            String text = tokenizer.getCurrentText().trim();
//		            String curriculumCode = text.substring(0, text.indexOf("-")).trim();
//		            String courseNumberString = text.substring(text.indexOf("-") + 1, text.indexOf(":")).trim();
//		            
//		            // G denotes grad/undergrad course - not needed for assignment and breaks parseInt()
//		            if (courseNumberString.endsWith("G")) 
//		                break;  
//		            
//		            Integer courseNumber = Integer.parseInt(courseNumberString);
//		            String courseTitle = text.substring(text.indexOf(":") + 1).trim();
//		            Course c = new Course(curriculumCode, courseNumber);
//		            c.setTitle(courseTitle);
//		            
//		            System.out.println(c.toString());
//		            util.skipUntilOpen("tr");
//		            tokenizer.next();
//		            System.out.println(tokenizer.getCurrentName());
//                    System.out.println(tokenizer.getCurrentText());
//		            util.skipUntilOpen("tr");
//		            tokenizer.next();
//		            System.out.println(tokenizer.getCurrentName());
//                    System.out.println(tokenizer.getCurrentText());
//		            util.skipUntilOpen("tr");
//                    tokenizer.next();
//                    util.skipUntilOpen("tr");
//                    System.out.println(tokenizer.getCurrentName());
//                    System.out.println(tokenizer.getCurrentText());
//                    tokenizer.next();
//                    util.skipUntilOpen("tr");
//                    System.out.println(tokenizer.getCurrentName());
//                    System.out.println(tokenizer.getCurrentText());
//                    tokenizer.next();
//                    
//		            List<String> courseInfo = new ArrayList<String>();
//		            courseInfo = util.readTR();
//		            for (String info : courseInfo) {
//		                System.out.println(info);
//		            }
//		            System.out.println();
//		            Integer sectionNo = Integer.parseInt(courseInfo.get(3));
//		            String time = courseInfo.get(5);
//		            String days = courseInfo.get(6);
//		              <td>GER</td>
//                    <td>&nbsp;</td>
//                    <td>Units</td>
//                    <td>Section</td>
//                    <td>Class#</td>
//                    <td>Hours</td>
//                    <td>Days</td>
//                    <td>Dates</td>
//                    <td>Instructor</td>
//                    <td>Room</td>
//                    <td>Syllabus</td>
		            

	
	/**
	 * Return an error message if reading stopped prematurely. 
	 * 
	 * If there was no error, return null.
	 * 
	 * @return         error message, or null if no error.
	 */
	public String getError() {
		return error;
	}
	

	public static void main(String[] args) throws MalformedURLException, IOException {
		List<Section> sections = doImport(args);
		if (sections == null) {
			System.out.println("Usage: ImportUWMSchedule <term> <curriculm>");
			System.out.println("    term is SPRING_2019, for example.");
			System.out.println("    curriculum is CompSci, for example.");
			System.out.println("Usage: ImportUWMSchedule <filename>");
			System.out.println("    filename is lib/fal2019.html, for example");			
		} else {
			for (Section s : sections) {
				System.out.println(s.getCourse() + "; " + s);
				for (Period p : s) {
					System.out.println("  " + p);
				}
			}
		}
	}

	/**
	 * Import sections according to the specification in args:
	 * 
	 * @param args     main arguments: either TERM CODE or filename of 
	 *                 HTML.
	 * @return         list of sections, or null if bad arguments
	 * @throws         FileNotFoundException if file is read
	 * @throws         IOException problem reading
	 */
	public static List<Section> doImport(String[] args) throws FileNotFoundException, IOException {
		ImportUWMSchedule self;
		switch (args.length) {
		default:
		case 0:
			return null;
		case 1:
			self = new ImportUWMSchedule(new FileReader(args[0]));
			break;
		case 2:
			self = new ImportUWMSchedule(Term.valueOf(args[0]),args[1]);
			break;
		}
		List<Section> sections = self.read();
		return sections;
	}
}
