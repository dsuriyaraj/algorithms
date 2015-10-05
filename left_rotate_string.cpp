#include <stdio.h>
// left rotate by one position
void left_rotate_by_one(char s[]) {
    char first = s[0];
    int i;
    for (i=1; s[i]!='\0';++i) {
        s[i-1]=s[i];
    }
    s[i-1]=first;
    s[i] = '\0';
}


void left_rotate(char s[], int n) {
    for (int i=0; i<n; ++i) {
        left_rotate_by_one(s);
    }
}

// find out the length of the string
int len(char s[]) {
    int len=0;
   while (s[len]!='\0') {
       len++;
   }
   return len;
}

// reverse a string
void reverse(char s[], int from, int to) {
    int i,j;    
    for (i=from, j=to; i<j; ++i, --j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}

// left rotate a string by split it and reverse
// abc|ef --> cba|fe --> efabc
void left_rotate2(char s[], int n) {
    int length = len(s);
    int ne = n % length; // effective positions to rotate
    reverse(s, 0, ne-1);
    reverse(s, ne, length-1);
    reverse(s, 0, length-1);
}


int main() {
    char s[] = "abcdef";
    left_rotate(s, 3);
    printf("%s\n", s);
    
    char s2[] = "who are you?";
    reverse(s2, 0, len(s2)-1);
    printf("%s\n", s2);
    left_rotate2(s, 3);
    printf("%s\n", s);
    return 0;
}