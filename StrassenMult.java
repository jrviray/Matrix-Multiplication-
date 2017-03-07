// package project1;
// package project/path/goes/here;

import java.util.Scanner;

public class StrassenMult {

	public void strassenMult(int n) {
		Matrix first = new Matrix();
		Matrix second = new Matrix();

//		Scanner s = new Scanner(System.in);
//		System.out.println("Enter the dimension of the matrices. This will result in nxn matrices.");
//		System.out.print("Dimension: ");
//		int n = s.nextInt();
		first.makeMatrix(n);
		second.makeMatrix(n);
		Matrix result = new Matrix();
		result = this.strassen(first, second);
		//result.printMatrix(result.getMatrix());
	}
	
	public Matrix strassen(Matrix first, Matrix second){
		//counter
		int n = first.getDimesion();
		Matrix result = new Matrix(n);
		
		if(n==1){
			result.getMatrix()[0][0] = first.getMatrix()[0][0]*second.getMatrix()[0][0];
		}
		else{
			// perform strassens algorithm
			first.makeSmallerMatrices();
			second.makeSmallerMatrices();
			Matrix p1 = this.strassen(first.add(first.a, first.d), second.add(second.a, second.d));
			Matrix p2 = this.strassen(first.add(first.c, first.d), second.a);
			Matrix p3 = this.strassen(first.a, second.sub(second.b, second.d));
			Matrix p4 = this.strassen(first.d, second.sub(second.c, second.a));
			Matrix p5 = this.strassen(first.add(first.a, first.b), second.d);
			Matrix p6 = this.strassen(first.sub(first.c, first.a), second.add(second.a, second.b));
			Matrix p7 = this.strassen(first.sub(first.b, first.d), second.add(second.c, second.d));
			
			result.a = result.add(result.sub(result.add(p1, p4), p5), p7);
			result.b = result.add(p3, p5);
			result.c = result.add(p2, p4);
			result.d = result.add(result.sub(result.add(p1, p3), p2), p6);
			
			result = result.makeBiggerMatrix(result.a, result.b, result.c, result.d);
		}
		return result;
	}
	

}
