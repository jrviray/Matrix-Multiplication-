package project1;

import java.util.Scanner;

public class ClassicMult {
	
	public void classicMult(int n) {
		Matrix first = new Matrix();
		Matrix second = new Matrix();

//		Scanner s = new Scanner(System.in);
//		System.out.println("Enter the dimension of the matrices. This will result in nxn matrices.");
//		System.out.print("Dimension: ");
//		int n = s.nextInt();
		first.makeMatrix(n);
		second.makeMatrix(n);
		Matrix result = new Matrix(n);
		int sum = 0;

		// matrix math
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					sum = sum + first.getMatrix()[i][k] * second.getMatrix()[k][j];
					// System.out.println(sum);
				}

				result.getMatrix()[i][j] = sum;
				sum = 0;
			}
		}
	}
}
