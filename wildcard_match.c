#include<stdio.h>
#include <stdlib.h>     /* malloc, free, rand */


int str_len(char * a) {
    if (*a==0) {
        return 0;
    }
    
    int len=0;
    while (*a != '\0' ) {
        ++len;
    }
    return len;
}

// copy len characters from the source to the target
void str_copy(char * target, char * source, int len) {
    for( ; len>0; --len, ++target, ++source) {
        *target = *source;
    }
    *target = 0;
}


// concatenate two strings with space in between
char* str_join(char *a, char *b) {
    int lenb = str_len(b);
    int lena = str_len(a);
    int len = lena + lenb + 1; // one extra for the space ' ' 
    
    char *t = (char *) malloc(sizeof(char)*len);
    
    str_copy(t, a, lena);

    t[lena] = ' ';
    // append b to the end of a
    str_copy(&t[lena+1], b, lenb);
    return t;
}


int main() {
    // test str_join
    char a[] = "who are you?";
    char b[] = "hello";
    char *ab = str_join(a, b);
    
    printf("the original strings are: %s\n  %s\n", a, b);
    printf("The string after concatenation is: %s \n", ab);
}