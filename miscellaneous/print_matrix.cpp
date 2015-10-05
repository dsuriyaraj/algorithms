#include <stdio.h>

/* Given a M X N matrix, print it out diagonally
   for example:
    1 2 3
    4 5 6
    
    print:
    1
    2 4
    3 5
    6
*/

class Matrix {
public:
    Matrix(int rows, int cols) {
        this->rows = rows;
        this->cols = cols;
        p = new int*[rows];
        for (int i=0; i<rows; ++i) {
            p[i] = new int[cols];
        }
        
        for (int i=0; i<rows*cols; ++i) {
            int r = i/cols;
            int c = i%cols;
            p[r][c] = i;
        }
    }
    
    int Rows() {
        return rows;
    }
    
    int Cols() {
        return cols;
    }
    
    int operator()(int r, int c) {
        return p[r][c];
    }
    
    ~Matrix() {
        for (int i=0; i<rows; ++i) {
            delete [] p[i];
        }
        delete [] p;
    }
    
    void print() {
        for (int r=0; r<rows; ++r) {
            for (int c=0; c<cols; ++c) {
                printf("%2d ", p[r][c]);
            }
            printf("\n");
        }
    }
    
private:
    int rows;
    int cols;
    int **p;
};    
    

// print starting form position (r, c) and give the next starting point
void print_start_from(Matrix& a, int& r, int& c) {
    // print the diagonal starting from (row, col)
    int ci;
    int ri;  
    int rows = a.Rows();
    int cols = a.Cols();
    for (ri=r,ci=c; ri<rows&&ci>=0; ++ri,--ci) {
        printf("%d ", a(ri,ci) );
    }
    printf("\n");
    
    if (r==0&&c<cols-1) {
        c+=1; 
    } else if(c==cols-1&&r<=rows-1) {
        r++;
    } else {
        r = -1;
        c = -1;
    }
}

void print_diagonal(Matrix& a) {
    int currentRow = 0;
    int currentCol = 0;
    
    while (currentRow>=0&&currentCol>=0) {
        print_start_from(a, currentRow, currentCol);
    }

}


int main() {
    Matrix a(2,3);
    a.print();
    printf("printing diagonal parts:\n");
    print_diagonal(a);
    
    Matrix a2(3,3);
    a2.print();
    printf("printing diagonal parts:\n");
    print_diagonal(a2);
    
    Matrix a3(1,3);
    a3.print();
    printf("printing diagonal parts:\n");
    print_diagonal(a3);
    
    Matrix a4(4,1);
    a4.print();
    printf("printing diagonal parts:\n");
    print_diagonal(a4);

    Matrix a5(4,3);
    a5.print();
    printf("printing diagonal parts:\n");
    print_diagonal(a5);    
}