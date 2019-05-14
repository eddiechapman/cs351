package edu.uwm.cs351.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import edu.uwm.cs.util.XMLTokenType;
import edu.uwm.cs.util.XMLTokenizer;

/**
 * Useful operations with a tokenizer.
 */
public class XMLTokenizerUtil {
	private final XMLTokenizer tokenizer;
	
	/** Indicate the tokenizer to use.
	 * 
	 * @param t    tokenizer, must not be null,
	 */
	public XMLTokenizerUtil(XMLTokenizer t) {
		tokenizer = t;
	}
	
	/**
	 * Read tokens until we get an OPEN token for the given name.
	 * 
	 * This method is dangerous to call unless you are sure that an 
	 * OPEN tag of the particular form will show up, and that 
	 * everything until then can be completely ignored.
	 * 
	 * In any case, we stop when all the tokens are read or if an ERROR 
	 * happens.
	 * 
	 * @param elemName     element name to look for, if 'null', then
	 *                     stop at the <em>first</em> OPEN token.
	 */
	public void skipUntilOpen(String elemName) {
		while (tokenizer.hasNext()) {
		    switch (tokenizer.next()) {
                case ERROR:
                    return;
                case OPEN:
                    if (elemName == null) return;
                    if (tokenizer.getCurrentName().equals(elemName)) return;
                    break;
                default:
                    break;
		    }
		}
	}
	
	/**
	 * Skip tokens so that we skip an entire element.
	 * 
	 * This method should be called immediately after an OPEN is read. 
	 * We permit unbalanced XML, in that if we have an ETAG, we will
	 * close all intervening elements. If no OPEN was seen for this 
	 * ETAG, then we stop immediately and save the token. Stop 
	 * immediately if an error is found or if the tokens end.
	 * 
	 * @return all the text found, concatenated into a single string, 
	 *         never null
	 */
	public String skipElement() {
		StringBuilder sb = new StringBuilder();
		Stack<String> open = new Stack<String>();
		tokenizer.saveToken();
		while (tokenizer.hasNext()) {
		    tokenizer.next();
		    String name = tokenizer.getCurrentName();
            switch (tokenizer.current()) {
                case ECLOSE:
                    open.pop();
                    break;
                case ERROR:
                    return sb.toString();
                case ETAG:
                    if (open.search(name) == -1) tokenizer.saveToken();
                    while(!open.isEmpty()) {
                        if (open.pop().equals(name)) break;
                    }
                    break;
                case OPEN:
                    open.push(name);
                    break;
                case TEXT:
                    sb.append(tokenizer.getCurrentText());
                    break;
                default:
                    break;
            }
            if (open.isEmpty()) break;
        }
		return sb.toString();
	}
	
	/** 
	 * Assuming the tokenizer just read <tt>&lt;tr&gt;</tt>, read the 
	 * rest of the table row and return each table data 
	 * (<tt>&lt;td&gt;</tt>) as a simple string: ignoring all tags and 
	 * attributes nested inside.
	 * 
	 * Stop when an ERROR happens, the token stream ends or when 
	 * <tt>&lt;/tr&gt;</tt> is encountered.
	 * 
	 * @return strings for each table data entries.
	 */
	public List<String> readTR() {
	    List<String> result = new ArrayList<>(); 
        while (tokenizer.hasNext()) {
            switch (tokenizer.next()) {
                case ECLOSE:
                    break;
                case ERROR:
                    return result;
                case ETAG:
                    if (tokenizer.getCurrentName().equals("tr")) 
                        return result;
                case OPEN:
                    if (tokenizer.getCurrentName().equals("td")) 
                        result.add(skipElement());
                    break;
                default:
                    break;
            }
        }
        return result;
	}

}
