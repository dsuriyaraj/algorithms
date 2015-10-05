/*
 * write an algorithm such that if an element in an MXN matrix is 0,
 * its entire row and column are set to zero
 */ 

public class SetZero {
	public static void setZero(int[][] A) {
		int nrow = A.length;
		int ncol = A[0].length;
		boolean[] rowContainZero = new boolean[nrow];
		boolean[] colContainZero = new boolean[ncol];
		
		// find out the rows and columns which contain zero
		for (int i=0; i<nrow; ++i) {
			for (int j=0; j<ncol; ++j) {
				if (A[i][j]==0) {
					rowContainZero[i]=true;
					colContainZero[j]=true;
				}	
			}	
		}
		
		// set the corresponding rows and columns to zero
		for (int rowIndex=0; rowIndex<nrow; ++rowIndex) {
			if (rowContainZero[rowIndex]) {
				nullifyRow(A, rowIndex);
			}
		}
		for (int colIndex=0; colIndex<ncol; ++colIndex) {
			if (colContainZero[colIndex]) {
				nullifyColumn(A, colIndex);
			}
		}
					
	}
	
	public static void nullifyRow(int[][] A, int row) {
		for (int col=0; col<A[row].length; ++col) {
			A[row][col] = 0;
		}	
	}
	
	public static void nullifyColumn(int[][] A, int col) {
		for (int row=0; row<A.length; ++row) {
			A[row][col] = 0;
		}	
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
		
	public static void main(String[] args) {
		int[][] A = { {1, 2, 3, 4, 5},
		              {6, 0, 8, 9, 10},
		              {4, 9, 2, 7, 0},
		              {2, 11, 41, 13, 29}
			};
		printMatrix(A);	
		setZero(A);	
		printMatrix(A);
	}	
	
}	
