/*
 * Assume you have a method isSubstring which checks if one word is a
 * substring of another. Given two strings, s1 and s2, write code to 
 * check if s2 is a rotation of s1 using only one call to isSubstring
 * (e.g., "waterbottle" is a rotation of "erbottlewat").
 */
 
public class IsRotation {
	
	// find the first occurence of a char c from string s starting
	// from position pos. Return -1 if not found
	public static int findCharOnward(char c, String s, int pos) {
		while ( pos < s.length() && (s.charAt(pos) != c) ) {
			++pos;
		}
		
		if (pos==s.length()) {
			return -1;
		} else {	
			return pos;	
		}
											   
	}
	
											   
	// check if s1 is a substring of s2
	public static boolean isSubstring(String s1, String s2) {
		if (s1.length() > s2.length() ) return false;
		
		int s2_cur = 0;
		int s1_len = s1.length();
		int s2_len = s2.length();
		
		while ( s2_cur < s2_len ) {
			// find the place where the first characters in s1 and s2 are the same
			int matchPos = findCharOnward(s1.charAt(0), s2, s2_cur);
			if (matchPos == -1) return false;
			
			// compare s1 with s2[s2_cur:]
			s2_cur = matchPos + 1; // s1[0] = s2[matchPos]
			for (int i=1; i < s1_len; ++i ) {
				if ( s2_cur >= s2_len || s1.charAt(i) != s2.charAt(s2_cur) ) {
					break;
				}	
				s2_cur++;
			}
			//System.out.printf("matchPos = %d\n", matchPos );
			//System.out.printf("s2_cur = %d\n", s2_cur );
			// if s2_cur has incremented s1_len times during the above process
			// then s1 = s2[matchPos:s2_cur], otherwise continue	
			if (s2_cur - matchPos == s1_len ) return true;
		}
		return false;
	}
	
	public static void testIsSubstring(String s1, String s2) {
		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s2);
		if (isSubstring(s1, s2)) {
			System.out.println("s1 is a substring of s2\n");
		} else {
			System.out.println("s1 is NOT a substring of s2\n");
		}	
	}	
	
	
	public static void testIsRotation(String s1, String s2) {
		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s2);
		if (isRotation(s1, s2)) {
			System.out.println("s1 is a rotation of s2\n");
		} else {
			System.out.println("s1 is NOT a rotation of s2\n");
		}	
	}	
	
	/* the original string can be regarded as XY
	 * then the rotated string is YX and it is a substring of XYXY
	 */ 
	public static boolean isRotation(String s1, String s2) {
		if (s1.length() != s2.length() ) return false;
		String s2s2 = s2 + s2;
		if (isSubstring(s1, s2s2)) {
			return true;
		} else {
			return false;
		}		
	}	
		
	public static void main(String[] args) {
		// substring at the center
		String s1 = "abcder";
		String s2 = "yoqhtyabcderbnlyh;qwy";
		testIsSubstring(s1, s2);
		
		// substring at the beginning
		s1 = "wrtwy";
		s2 = "wrtwyamfnnblyr";
		testIsSubstring(s1, s2);
		
		// substring at the end
		s1 = "wrtwy";
		s2 = "amfnnblywrtwy";
		testIsSubstring(s1, s2);
		
		// two strings are the same
		s1="abcd";
		s2="abcd";
		testIsSubstring(s1, s2);
		
		// substring with some repeating pattern
		s1 = "wrtwy";
		s2 = "amfnnblywrwrtwymty";
		testIsSubstring(s1, s2);
		
		// test normal case
		s1 = "abcdefgh";
		s2 = "defghabc";
		testIsRotation(s1, s2);
		
		// the same string
		s1 = "abc";
		s2 = "abc";
		testIsRotation(s1, s2);
		
		// single character
		s1 = "a";
		s2 = "a";
		testIsRotation(s1, s2);
		
		// not a rotation
		s1 = "abcdefgh";
		s2 = "defgiabc";
		testIsRotation(s1, s2);
	}	
}	  
