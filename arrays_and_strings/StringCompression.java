/*
 * implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become
 * a2b1c5a3. If the "compressed" string would not become smaller than the
 * original string, you method should return the original string. You 
 * can assume the string has only upper and lower case letters (A-z)
 * 
 */ 
 
import java.util.*;
import java.lang.StringBuffer;

public class StringCompression {
	
		
	public static String compress(String s) {
		StringBuffer sbuffer = new StringBuffer();
		
		char prevChar = s.charAt(0);
		sbuffer.append(prevChar); // you can append char to a stringbuffer
		int occurence = 1;
		
		for (int i=1; i<s.length(); ++i) {
			char curChar = s.charAt(i);
			if (curChar==prevChar) {
				occurence++;
			} else { // encounter a different char				
				sbuffer.append(occurence); // append an int to a stringbuffer
				// set up for the new different char
				prevChar = curChar;
				sbuffer.append(prevChar);
				occurence = 1;
			}		
		}
		sbuffer.append(occurence);
		
		String compressedString = sbuffer.toString();
		if ( compressedString.length() < s.length() ) {
			return compressedString;
		} else {	
			return s;
		}	
	}
	
	public static void testHelper(String s) {
		System.out.println("original: " + s);
		System.out.println("compressed: " + compress(s) + "\n");
	}	
	
	public static void main(String[] args) {
		// normal case
		testHelper("aabcccccaaa");
		
		// normal case
		testHelper("abcccccaaa");
		
		// all are different
		testHelper("abcdefghijklmnopq");

		// single
		testHelper("a");
		
		// all the same
		testHelper("bbbbbb");

	}	
}	
