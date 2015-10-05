#include <stdio.h>
// modify an array A such that A[i] = A[A[i]] without using additional memory
// for example {2,3,1,0} --> {1,0,3,2}
// note the values contained in the array are integer 0 ... n-1
void move_vlaues(int a[], int len) {
    for (int i=0; i<len; ++i) {
        a[i]+=(a[a[i]]%len)*len; //encode the information a[a[i]] into the array
    }
    
    for (int i=0; i<len; ++i) {
        a[i]/=len;
    }
}


int main() {
    int a[] = {2, 3, 1, 0};
    int len = sizeof(a)/sizeof(a[0]);
    printf("the array size is %d \n", len);  
    
    move_vlaues(a,len);
    int i=0;
    for(int i=0; i<len; ++i) {
        printf("%d ", a[i]);
    }
    printf("\n");
    return 0;
}
