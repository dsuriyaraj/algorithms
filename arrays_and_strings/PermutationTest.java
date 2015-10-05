/**
* Given two strings, write a method to decide if one is a permutation
* of the other
*/

public class PermutationTest {
	
	public static boolean isPermutation(String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		
		//assuming it is ascii characters
		// there are 256 characters in total
		int [] char_occurence = new int[256];
		// will initialize all elements to zero?
		
		char [] s1_array = s1.toCharArray();
		
		for (char c: s1_array) {
			// you can use a char as if it is an integer
			char_occurence[c]++;
		}
		
		for (int i=0; i<s2.length(); i++) {
			char c = s2.charAt(i);
			if ( char_occurence[c]==0 ) {
				return false;
			}
			char_occurence[c]--;
		}		
		return true;
	}	
	
	
	public static void main(String[] args) {
		test_all_distinct();
		test_negative(); 
		test_all_same();
		test_more_than_one_occurence();
		test_single_same();
		test_single_different();
		
	}
	
	public static void test_helper(String s1, String s2) {
		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s2);
		
		if (isPermutation(s1, s2)) {
			System.out.println("s1 is a permutation of s2\n");
		} else {
			System.out.println("s1 is NOT a permutation of s2\n");
		}
	}
	
		
	public static void test_all_distinct() {
		String s1 = "abcdefgh";
		String s2 = "bcfghade";
		test_helper(s1, s2);
	}
	
	
	public static void test_negative() {
		String s1 = "abcdefgh";
		String s2 = "bcfmyade";
		test_helper(s1, s2);
	}
	
	
	
	public static void test_more_than_one_occurence() {
		String s1 = "abcfefgtt";
		String s2 = "tbcftafge";
		test_helper(s1, s2);
	}
	
	
	public static void test_all_same() {
		String s1 = "aaaaaaaa";
		String s2 = "aaaaaaaa";
		test_helper(s1, s2);
	}

	public static void test_single_same() {
		String s1 = "a";
		String s2 = "a";
		test_helper(s1, s2);
	}
	
	
	public static void test_single_different() {
		String s1 = "a";
		String s2 = "b";
		test_helper(s1, s2);
	}

}		

