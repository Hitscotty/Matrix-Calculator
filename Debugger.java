package Logic;

public class Debugger extends MatrixCalc {
		
	public static void main(String args []){
		
		//initialize matrix types with values of 0;
		int [][] vector1 = createMatrix(2,1);
		int [][] vector2 = createMatrix(1,2);
		int [][] matrix1 = createMatrix(2,2);
		int [][] matrix2 = createMatrix(2,2);
		
		//set up first vector
		matrix1[0][0] = 1;
		matrix1[1][0] = 3;
		
		//set up second vector
		matrix2[0][0] = 1;
		matrix1[1][0] = 5;

	
		 System.out.println("Matrix 1: ");
		 display(matrix1);
		 System.out.println("Matrix 2: ");
		 display(matrix2);
		 
		 System.out.println("Testing multiplication: ");
		 display(multiply(matrix1, matrix2));


	}
}
