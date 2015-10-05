import java.util.HashMap;

//check if a string contains all unique characters
public class CheckUniqueness {
    
    public static void main(String[] args) {
        
        String s = "abcedf";
        info(s, "bruteForce");
        info(s, "useHashMap");
        info(s, "ascii");
        
        s = "67ag23907";
        info(s, "bruteForce");
        info(s, "useHashMap");
        info(s, "ascii");
        
        s = "67ag2390我们7";
        info(s, "bruteForce");
        info(s, "useHashMap");
        
        s = "abcedfghijklmnab";
        info(s, "bruteForce");
        info(s, "useHashMap");  
        info(s, "lowerCase");
        
        s = "abcedfghijklmn";
        info(s, "bruteForce");
        info(s, "useHashMap");  
        info(s, "lowerCase");
                       
    }
    
    // print out the information about the uniqueness of characters contained in s
    public static void info(String s, String method) {
        boolean unique = false;
        switch (method) {
            case "bruteForce":
                unique = isUniqueSlow(s);
                break;
            case "useHashMap":
                unique = isUniqueHashMap(s);
                break;
            case "ascii":
                unique = isUniqueASCII(s);
                break; 
            case "lowerCase":
                unique = isUniqueLowerCase(s);
                break; 
            default:
                System.out.println("Unknown method!");
        }
        
        if ( unique ) {
            System.out.printf("Characters in \"%s\" are all unique\n", s);
        } else {
            System.out.printf("Characters in \"%s\" are not all unique\n", s);
        }
    }
    

    
    // use hashmap 
    public static boolean isUniqueHashMap(String s) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i=0; i<s.length(); ++i) {
            if (map.get(s.charAt(i) )!=null) return false; 
            map.put(s.charAt(i),1);
        }
        return true;
    }
    
    // without using any data structure
    public static boolean isUniqueSlow(String s) {
        for (int i=0; i<s.length(); ++i ) {
            for (int j=i+1; j<s.length(); ++j ) {
                if (s.charAt(i)==s.charAt(j) ) return false;
            }
        }
        return true;
    }
    
    // assuming all the characters are ASCII, use additional array[256]
    public static boolean isUniqueASCII(String s) {
        boolean[] contained = new boolean[256];
        for (int i=0; i<s.length(); ++i) {
            if (contained[s.charAt(i)-'0']==true) return false; 
            contained[s.charAt(i)-'0']=true;
        }
        return true;
    }
    
    // use bit vector to save memory
    // assuming the characters are from a to z (26 bit)
    public static boolean isUniqueLowerCase(String s) {
        int checker = 0;
        for (int i=0; i<s.length(); ++i) {
            int value = s.charAt(i)-'a';
            if ( (checker&(1<<value)) > 0 ) return false; 
            checker |= (1<<value);
        }
        return true;
    }
    
}