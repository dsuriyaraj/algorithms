/* The most straightforward method is to iterate over every character in string B and 
*  see whether it is contained in string A
*/


/* the best way is to use a character (usually 4 bytes --- 32 bits) to represent the 
   signature of a string. We only need 26 bits out of the 32 bits. If the digit on
   the rightmost bit is 1, it means the string contains A, and 0 otherwise

*/

#include <stdio.h>

int compare(char * A, char * B) {
    int signature = 0;
    while (*A !='\0') {
        signature |= (1 << (*A - 'A'));
        ++A;
    }
    
    while (*B !='\0') {
        if ( signature & (1<< (*B - 'A')) == 0 )
            return 0;
        
        ++B;
    }
    
    return 1;
}

int main() {
    char a1[] = "ABCDEFGHLMNOPQRS";
    char b1[] = "DCGSRQPO";
    
    char a2[] = "ABCDEFGHLMNOPQRS";
    char b2[] = "DCGSRQPZ";
    
    if (compare(a1, b1)) {
        printf("%s contains %s\n", a1, b1);
    }
    
    if (compare(a2, b2)) {
        printf("%s doesn't contain %s\n", a2, b2);
    }
    
    return 0;
}