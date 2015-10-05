/*
 * 
 * Given an image represented by an NXN matrix, where each pixel i the 
 * image is 4 bytes, write a method to rotate the image by 90 degrees.
 * Can you do this in place?
 */

public class RotateMatrix {
	
	private static class MatrixIndex {
		
		MatrixIndex(int row_, int col_) {
			row = row_;
			col = col_;
		}
			
		public int row;
		public int col;
	}	
	
	public static void printMatrix(int[][] A) {
		for (int row=0; row<A.length; ++row) {
			for (int col=0; col<A[row].length; ++col) {
				//System.out.println(" ");
				System.out.printf("%3d ", A[row][col]);
			}
			System.out.println(" ");
		}
		System.out.println(" ");		
	}	
	
	// rotate the four numbers [a1, a2, a3, a4] -> [a4, a1, a2, a3]
	public static void rotateFour( int[][] A, MatrixIndex index1, 
	                                  MatrixIndex index2, 
	                                  MatrixIndex index3,
	                                  MatrixIndex index4 ) {
	
	    int tmp = A[index4.row][index4.col];	    
	    A[index4.row][index4.col] = A[index3.row][index3.col];
	    A[index3.row][index3.col] = A[index2.row][index2.col];
		A[index2.row][index2.col] = A[index1.row][index1.col];
		A[index1.row][index1.col] = tmp;
	}	
	
	// rotate a square matrix by 90 degree
	public static void rotateMatrix(int[][] A) {
		int N = A.length;
		int startRow = 0;
		int startCol = 0;
		int endBeforeCol = N-1;
		// do the rotation layer by layer
		for (int layer=1; layer<=N/2; ++layer) {
			for (int col=startCol; col<endBeforeCol; ++col) {
				int row = startRow;
				MatrixIndex index1 = new MatrixIndex(row, col);
				MatrixIndex index2 = new MatrixIndex(col, N-1-row);
				MatrixIndex index3 = new MatrixIndex(N-1-row, N-1-col);
				MatrixIndex index4 = new MatrixIndex(N-1-col, row);
				rotateFour(A, index1, index2, index3, index4);
			}
			startRow++;
			startCol++;
			endBeforeCol--;	
		}	
	}	
	
	public static void main(String[] args) {
		int image[][] = { {1, 2, 3, 4},
		                  {5, 6, 7, 8},
		                  {9, 10, 11, 12},
		                  {13, 14, 15, 16}
					  };
		printMatrix(image);	
		rotateMatrix(image);
		printMatrix(image);	
		
		int image2[][] = { {1, 2, 3, 4, 5},
		                  {6, 7, 8, 9, 10},
		                  {11, 12, 13, 14, 15},
		                  {16, 17, 18, 19, 20},
		                  {21, 22, 23, 24, 25}
					  };
		printMatrix(image2);	
		rotateMatrix(image2);
		printMatrix(image2);		  
	}	
	
}	
