package project1;

import java.util.Scanner;

public class DNCMult {

	public void dncMult(int n) {
		Matrix first = new Matrix();
		Matrix second = new Matrix();

//		Scanner s = new Scanner(System.in);
//		System.out.println("Enter the dimension of the matrices. This will result in nxn matrices.");
//		System.out.print("Dimension: ");
//		int n = s.nextInt();
		first.makeMatrix(n);
		second.makeMatrix(n);
		Matrix result = new Matrix();
		result = this.DNC(first, second, n);
		//result.printMatrix(result.getMatrix());
	}

	public Matrix DNC(Matrix first, Matrix second, int n) {
		Matrix result = new Matrix(n);
		if (n == 1) {
			//System.out.println((first.getMatrix()[0][0]));
			result.getMatrix()[0][0] = first.getMatrix()[0][0] * second.getMatrix()[0][0];
			return result;
		}
		// make smaller matrices
		first.makeSmallerMatrices();
		second.makeSmallerMatrices();
		// perform recursion
		result.a = result.add(this.DNC(first.a, second.a, n / 2), this.DNC(first.b, second.c, n / 2));
		result.b = result.add(this.DNC(first.a, second.b, n / 2), this.DNC(first.b, second.d, n / 2));
		result.c = result.add(this.DNC(first.c, second.a, n / 2), this.DNC(first.d, second.c, n / 2));
		result.d = result.add(this.DNC(first.c, second.b, n / 2), this.DNC(first.d, second.d, n / 2));
		result = result.makeBiggerMatrix(result.a, result.b, result.c, result.d);
		return result;
	}

}
