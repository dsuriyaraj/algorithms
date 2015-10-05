/* 1.3 Design an algorithm and write code to remove the duplicate characters in 
       a string without using any additional buffer. Note: one or two additional
       variables are fine. An extra copy of the array is not.
       
    Follow up: Write the test case for this method
*/

/* what does additional buffer means? 

*/

public class RemoveDuplicates {
    public static void main(String[] args) {
        test_all_the_same ();
        test_normal();
        test_all_different();
        test_single_char();
        test_null();
    }
    
    /*
    * The main idea is: we compare every character with all the characters before it,
    * if it is not a duplicate of any preceding character, we go to the next character after it,
    * otherwise we use an integer to mark its position and later put at this position the next 
    * non-repeating character to get rid of this repeating character
    */
    public static void removeDuplicate(char[] s) {
		if (s==null) return;
        int len = s.length;
        int distinctBefore = 1; // the characters with index from 0 to distinctBefore-1 are all distinct
        int i,j;
        // s[i] is the element to be compared with all the elements before distinctBefore
        for (i=1; i<len; ++i) {
            
            // s[j] is the element before s[i]
            // tail represent a position where the first repeating character appears
            for (j=0; j<distinctBefore; ++j) {
                if (s[i]==s[j]) break; // duplicates found and the distinctBefore remains the same
            }
            
            /*no duplicate is found, so use the character at position i to replace 
            * the possible repeating character at position tail
            */
            if (j==distinctBefore) { 
                s[distinctBefore] = s[i];
                distinctBefore+=1; 
            }
        }
        // let all remaining positions to be filled with 0
        for (int r=distinctBefore; r<len; ++r) {
			s[r]=0;
		}	

    }
    
    public static void test_all_the_same () {
        char[] s = {'a','a','a','a','a'};
        System.out.println(s);
        removeDuplicate(s);
        System.out.println(s);
        System.out.println("\n");
    }
    
    public static void test_normal() {
        char[] s = {'a','b','c','a','2','b','f', 'c', 'e', 'm', 'f'};
        System.out.println(s);
        removeDuplicate(s);
        System.out.println(s);
        System.out.println("\n");
    }
    
    public static void test_all_different () {
        char[] s = {'a','b','c','d','m'};
        System.out.println(s);
        removeDuplicate(s);
        System.out.println(s);
        System.out.println("\n");
    }
    
    public static void test_single_char () {
        char[] s = {'a'};
        System.out.println(s);
        removeDuplicate(s);
        System.out.println(s);
        System.out.println("\n");
    }
    
    public static void test_null () {
        char[] s = null;
        //System.out.println(s);
        removeDuplicate(s);
        //System.out.println(s);
        //System.out.println("\n");
    }
    
}

