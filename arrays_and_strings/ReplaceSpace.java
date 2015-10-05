/**
 * 
 * Write a method to replace all spaces in a string with '%20' (if there
 * are two spaces, repalce them with '%20%20' ). You may
 * assume that the string has sufficient space at the end of the string
 * to hold the additional characters, and that you are given the "true"
 * length of the string. (Note: if implementing in java, please use a
 * character array so that you can perform this operation in place.)
 * 
 * EXAMPLE
 * input: "Mr John Smith           " (assuming there is plenty of space at the end)
 * output: "Mr%20John%20Smith"
 * 
 */
 
public class ReplaceSpace {
	
	// since there is plenty of space at the end of the array, we start
	// from the end and put non-empty character there
	public static void replace(char[] s) {
		int len = s.length;
		int nonSpacePos = len-1;
		
		// start from the end and go left until reach the first non-space char
		int lastNonSpace = len-1;
		while (s[lastNonSpace]==' ') {
			lastNonSpace--;
		} ;	
		
		for (int i=lastNonSpace; i>=0; i--) {
			// if it it space, place it with %20
			if (s[i]==' ') {
				s[nonSpacePos--] = '0';
				s[nonSpacePos--] = '2';
				s[nonSpacePos--] = '%';
			}	
			
			if (s[i]!=' ') {
				s[nonSpacePos--]=s[i];
			}	
			
		}	
		
		// fill all the remaining position with '\0'
		for (int i=0; i<=nonSpacePos; ++i) {
			s[i] = '\0';
		}	
	}
	
	
	
	public static void main(String[] args) {
		String str = "Mr John Smith                        ";
		char[] s = str.toCharArray();
		System.out.println(s);
		replace(s);
		System.out.println(s);
	}		
}	
