package Logic;

/**
 * 
 * @author Jonathan 
 * 
 * 		   Class that takes matrices and applies the appropriate math:
 * 
 *         Adding vectors, Dot products, cross products, Matrix-vector
 *         multiplication, Vector magnitude calculation, Normalize a vector,
 *         Normals
 * 
 */

public class MatrixCalc {

	//					 Methods to display/create Matrix data
	// -------------------------------------------------------------------------------------------

	public static void display(int[][] matrix) {
		int size = matrix.length;
		int dim  = matrix[0].length;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < dim; j++) {
				System.out.printf("[%d] ", matrix[i][j]);
			}
			System.out.println();
		}

		System.out.println("");
	}

	public static int[][] createMatrix(int size, int dimensions) {
		int[][] A = new int[size][dimensions];
		return fill(A);
	}

	public static int[][] fill(int[][] matrix) {
		int size = matrix.length;
		int dim  = matrix[0].length;
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < dim; j++) {
				matrix[i][j] = 0;
			}
		}

		return matrix;
	}

	// 								Matrix Operations
	// -------------------------------------------------------------------------------------------

	/**
	 * Takes a matrix and multiplies it by a constant
	 * 
	 * @param A
	 * @param b
	 */
	public static int[][] multiply(int[][] A, int b) {
		int size         = A.length;
		int dim          = A[0].length;

		int[][] solution = new int[size][dim];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < dim; j++) {
				solution[i][j] = A[i][j] * b;
			}
		}

		return solution;
	}

	
	public static int[][] multiply(int[][] A, int[][] B) {
		int size   = A.length;
		int dim    = A[0].length;
		int dimB   = B[0].length - 1;
		int repeat = 0;
		int[][] solution;

		if (dim != B.length) {
			System.out.println("A: " + dim + "B: " + B.length);
			System.out.println("Matrices not equal!");
			return null;
		}

		//check to see if we're dealing with a vector a or matrix
		//dim 0 means vector
		if (dimB != 0) {
			repeat = size;
		}

		// if it is a vector multiply in this way
		if (repeat == 0) {
			
			solution = new int[size][dimB + 1];

			for (int i = 0; i < size; i++) {
				for (int k = repeat; k >= 0; k--) {
					for (int j = 0; j < dimB; j++) {
						solution[i][dimB] += A[i][j] * B[j][dimB];
					}
				}
			}
			
		//if it is a matrix multiply in this way 
		} else {
		
			solution = new int[size][dim];
			
			for (int i = 0; i < size; i++) {
				for (int k = 0; k < dimB; k++) {
					for (int j = 0; j < dim; j++) {
						solution[i][k] += A[i][j] * B[j][k];
					}
				}
			}
			
		}

		return solution;

	}

	// --------------------------------------------------------------------------------------

	public static int [][] add(int[][] A, int[][] B) {
		int size   = A.length;
		int dim    = A[0].length;
		int dimB   = B[0].length - 1;
		int[][] solution = new int [size][dim];

		if (size != B.length || dim != dimB + 1) {
			System.out.println("Matrices not equal!");
			return null;
		}

		for(int i = 0; i < size; i++){
			for(int j = 0; j < dim; j++){
				solution[i][j] = A[i][j] + B[i][j];
			}
		}

		return solution;
		
	}
	

	public static int [][] subtract(int[][] A, int[][] B) {
		int size   = A.length;
		int dim    = A[0].length;
		int dimB   = B[0].length - 1;
		int[][] solution = new int [size][dim];

		if (size != B.length || dim != dimB + 1) {
			System.out.println("Matrices not equal!");
			return null;
		}

		for(int i = 0; i < size; i++){
			for(int j = 0; j < dim; j++){
				solution[i][j] = A[i][j] - B[i][j];
			}
		}

		return solution;
		
	}

	// --------------------------------------------------------------------------------------

	public static int dot(int[][] A, int[][] B) {
		
		int size       = A.length;
		int dim        = A[0].length;
		int sizeB      = B.length;
		int solution   = 0;
		int repeat     = 0;

		boolean vector = false;
		
				
		if(size != sizeB){
			System.out.println("Matrices not equal!");
			return -1;
		}
		
		//test to see if dot of vectors
		if((B[0].length-1 == 0) && (dim-1 == 0)){
			vector = true;
			repeat = size;
		}
		
		if(vector == true){
			for(int i = 0; i < size; i++){
				for(int j = 0; j < dim; j++){
					solution += A[i][j] * B[i][j];
					}
				}
			
		}else{
			
			for(int i = 0; i < size; i++){
				for (int k = repeat; k >= 0; k--) {
				for(int j = 0; j < dim; j++){
					solution += A[i][j] * B[i][k];
					}
				}
				}		
			
			}
		
		return solution;

	}
}
