import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import edu.uwm.cs.junit.LockedTestCase;
import edu.uwm.cs.util.XMLTokenType;
import edu.uwm.cs.util.XMLTokenizer;
import edu.uwm.cs351.util.XMLTokenizerUtil;

public class TestXMLUtil extends LockedTestCase {
	
	private XMLTokenizer tokenizer;
	private XMLTokenizerUtil util;
	
	private void init(String s) {
		tokenizer = new XMLTokenizer(new StringReader(s));
		util = new XMLTokenizerUtil(tokenizer);
	}
	
	private List<String> l(String... args) {
		return Arrays.asList(args);
	}
	
	
	/// Locked tests:
	
	// XML Syntax Questions
	public void test00(){
		// How would you go about opening/closing
		// an "apple" element with a single tag?
			Ts(1325493464);
		
		// Say we wanted to add an attribute of ripe with the
		// value 'true', what would we need to add into the tag?
		// NB: Use single quote instead of double-quote for the value,
		//		and only answer with the attribute, not the entire tag.
			Ts(1816582217);
			
		// Great! Now, say you wanted to create an apple with
		// no attributes and the text content 'worm' (with no spaces or quotes).
		// What would that look like?
			Ts(721024958);
	}
	
	public void test01(){
		// Good! Now for some true/false questions...
		
		// T/F: Text is legal content of an XML element.
			Tb(236098543);
				
		// T/F: The element <orange/> might have contents.
			Tb(2112063273);
				
		// T/F: <cake> <cake> cream filling </cake> </cake>     ...is valid XML.
			Tb(1083105664);
						
		// T/F: <bread> peanut butter & jelly </bread>     ...is valid XML.
			Tb(440449791);
			
		// T/F: An XML document may have multiple root elements.
			Tb(90068664);
	}
	
	//XMLTokenizer Questions
	public void test02(){
		// What is the type of the first token you should expect
		// to receive when calling next() on your XMLTokenizer?
		// NB: Use all-caps for your answers.
			Ts(1684521520);
		
		// If the token had an attribute, what type of token
		// should you expect to see next?
			Ts(1948628040);
		
		// What token would appear if the element had no content,
		// and were closed immediately after the attributes?
			Ts(1477217464);
	}
	
	public void test03(){
		// Nice work! A few more questions to go...
		// NB: Include parentheses for any answers that are method calls.
		
		// What tokenizer method would you use to retrieve the attribute's
		// name if the most recently returned token was of type ATTR?
			Ts(210108484);
			
		// And what method would you call to retrieve the attribute's value?
			Ts(1138250466);
			
		// What method should you call to return the most recently returned token?
			Ts(408539470);
			
		// If there is an error detected by XMLTokenizer, what token do you get?
			Ts(618258717);
			
		// If you get an ERROR token, how do you get the error message?
			Ts(1902534462);
			
		// And finally, what email address should you use for any
		// questions that arise over the course of completing this assignment?
			Ts(849318788);
	}
	
	
	/// Tests of skipUntilOpen
	
	public void test10() {
		init("");
		util.skipUntilOpen(null); // shouldn't crash
	}
	
	public void test11() {
		init(" ");
		util.skipUntilOpen("A");
	}
	
	public void test12() {
		init("<A>");
		util.skipUntilOpen(null);
		assertEquals(XMLTokenType.CLOSE,tokenizer.next());
	}
	
	public void test13() {
		init("<B foo='1'>");
		util.skipUntilOpen("B");
		assertEquals(XMLTokenType.ATTR,tokenizer.next());
	}
	
	public void test14() {
		init("<C bar='42'/>");
		util.skipUntilOpen("B");
		assertFalse(tokenizer.hasNext());
	}
	
	public void test15() {
		init("<D>Hi! <E/></D>");
		util.skipUntilOpen("E");
		assertEquals(XMLTokenType.ECLOSE,tokenizer.next());
	}
	
	public void test16() {
		init("<F test='true'><G>&nbsp;</G>");
		util.skipUntilOpen("H");
		assertFalse(tokenizer.hasNext());
	}
	
	public void test17() {
		init("<F test='true'><G>&nbsp;</G attr='disallowed'>");
		util.skipUntilOpen("H");
		assertEquals(XMLTokenType.ERROR,tokenizer.current());
	}
	
	public void test18() {
		init("</A> <B attr='test'/>");
		util.skipUntilOpen(null);
		assertEquals("B",tokenizer.getCurrentName());
	}
	
	
	/// tests of skipElement
	
	public void test20() {
		init("<A>");
		tokenizer.next();
		assertEquals("",util.skipElement());
	}
	
	public void test21() {
		init("<B foo='bar'>Hello</B>Bye");
		tokenizer.next();
		assertEquals("Hello",util.skipElement());
	}
	
	public void test22() {
		init("<B foo='bar'>Hello</B>Bye");
		tokenizer.next();
		util.skipElement();
		assertEquals(XMLTokenType.TEXT,tokenizer.next());
		assertEquals("Bye",tokenizer.getCurrentText());
	}
	
	public void test23() {
		init("<C attr='ignored' lost='true' width='100%'/>Stuff");
		tokenizer.next();
		assertEquals("",util.skipElement());
		assertEquals(XMLTokenType.TEXT,tokenizer.next());
	}
	
	public void test24() {
		init("<D>1<E>2</E>3<F/>4</D>5");
		tokenizer.next();
		assertEquals("1234",util.skipElement());
	}
	
	public void test25() {
		// don't require everything to be balanced
		// if you find a closing tag of something you're waiting for:
		init("<G class='foo'>1&nbsp;2<br>3 4</G>5");
		tokenizer.next();
		assertEquals("1 23 4",util.skipElement());
	}
	
	public void test26() {
		// on the other hand, if you don't recognize the ETAG
		// assume that your element is done, and 'un'comsume the ETAG
		init("<li>1 2<b>test</b></ul>3 4");
		tokenizer.next();
		assertEquals("1 2test",util.skipElement());
		assertEquals(XMLTokenType.ETAG,tokenizer.next());
	}
	
	public void test27() {
		init("<H>1<H attr='none'/>2<H>3</H>4<I>5<J>6</I>7</H>8");
		tokenizer.next();
		assertEquals("1234567",util.skipElement());
	}
	
	public void test28() {
		init("<K>1<L>2</L></K attr='not allowed'>3 4");
		tokenizer.next();
		assertEquals("12",util.skipElement());
		assertEquals(XMLTokenType.ERROR,tokenizer.current());
	}
	
	
	/// tests of readTR
	
	public void test30() {
		init("<tr/>");
		tokenizer.next();
		assertEquals(l(),util.readTR());
	}
	
	public void test31() {
		init("<tr style='normal' colspan='100%'> <!-- nothing --> </tr>");
		tokenizer.next();
		assertEquals(l(),util.readTR());
	}
	
	public void test32() {
		init("<tr> <td>A</td></tr>2");
		tokenizer.next();
		assertEquals(l("A"),util.readTR());
	}
	
	public void test33() {
		init("<tr> <td>A</td> <td/> <td>C</td> </tr>2");
		tokenizer.next();
		assertEquals(l("A","","C"),util.readTR());		
	}
	
	public void test34() {
		init("<tr> <td style='normal'>A<b>B</b></td> <td style='normal'/> <td><span style='red'>&lt;</span>&gt;</td> </tr>2");
		tokenizer.next();
		assertEquals(l("AB","","<>"),util.readTR());	
	}
	
	public void test35() {
		init("<tr> <td>A</td> <br/> <td>B</td> </tr>2");
		tokenizer.next();
		assertEquals(l("A","B"),util.readTR());	
	}
	
	public void test36() {
		init("<tr> <td><table><tr><td>a</td><td>b</td></tr></table></td> <td>c</td></tr>");
		tokenizer.next();
		assertEquals(l("ab","c"),util.readTR());	
	}
	
	public void test37() {
		init("<tr style='normal'> <td>A");
		tokenizer.next();
		assertEquals(l("A"),util.readTR());
		assertFalse(tokenizer.hasNext());
	}
	
	public void test38() {
		init("<tr style='normal'> <td>A < B");
		tokenizer.next();
		assertEquals(l("A "),util.readTR());
		assertEquals(XMLTokenType.ERROR,tokenizer.current());
	}
	
	public void test39() {
		init("<tr style='normal'> <td span='0'/> <td span='1'>A</td> ");
		tokenizer.next();
		assertEquals(l("","A"),util.readTR());
		assertFalse(tokenizer.hasNext());
	}
}
