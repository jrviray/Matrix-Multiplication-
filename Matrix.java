// package project1;
// package project/path/goes/here;

import java.util.Random;
import java.util.Scanner;

public class Matrix {

	// variables 
	private int matrix[][];
	// n = dimension
	private int n = 0;
	Matrix a, b, c, d;

	// constructor
	Matrix() {
		int matrix[][];
	}

	// // constructor
	Matrix(int dimension) {
		n = dimension;
		matrix = new int[n][n];
	}

	public int getDimesion() {
		return n;
	}

	public void setDimension(int x) {
		n = x;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	// prints out the matrix
	public void printMatrix(int[][] matrix) {
		//System.out.println("The matrix is");
		int n = matrix[0].length;
		// System.out.println("The dimension is " + n);
		int counter = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + "\t");
				counter++;
				if (counter == n) {
					System.out.println();
					counter = 0;
				}
			}
		}
	}

	// creates and fills the matrix
	public void makeMatrix(int n) {

		Random rand = new Random();

		this.setDimension(n);
		matrix = new int[n][n];

		// random fills in the matrix
		//System.out.println("Randomly filled the elements of the matrix");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				this.matrix[i][j] = rand.nextInt(99) + 1;
			}
		}
	}

	// get 4 smaller submatrices from the parent matrix
	public void makeSmallerMatrices() {
		a = new Matrix(this.getDimesion() / 2);
		b = new Matrix(this.getDimesion() / 2);
		c = new Matrix(this.getDimesion() / 2);
		d = new Matrix(this.getDimesion() / 2);
		for (int i = 0; i < a.n; i++) {
			for (int j = 0; j < a.n; j++) {
				a.matrix[i][j] = this.getMatrix()[i][j];
			}
		}
		for (int i = 0; i < a.n; i++) {
			for (int j = 0; j < a.n; j++) {
				b.matrix[i][j] = this.getMatrix()[i][j + a.n];
			}
		}
		for (int i = 0; i < a.n; i++) {
			for (int j = 0; j < a.n; j++) {
				c.matrix[i][j] = this.getMatrix()[i + a.n][j];
			}
		}
		for (int i = 0; i < a.n; i++) {
			for (int j = 0; j < a.n; j++) {
				d.matrix[i][j] = this.getMatrix()[i + a.n][j + a.n];
			}
		}
	}

	// create a bigger matrix from 4 smaller matrices
	public Matrix makeBiggerMatrix(Matrix a, Matrix b, Matrix c, Matrix d) {
		Matrix m = new Matrix(a.getDimesion() * 2);
		for (int i = 0; i < a.n; i++) {
			for (int j = 0; j < a.n; j++) {
				m.matrix[i][j] = a.getMatrix()[i][j];
			}
		}
		for (int i = 0; i < b.n; i++) {
			for (int j = 0; j < b.n; j++) {
				m.matrix[i][j + a.n] = b.getMatrix()[i][j];
			}
		}
		for (int i = 0; i < a.n; i++) {
			for (int j = 0; j < a.n; j++) {
				m.matrix[i + a.n][j] = c.getMatrix()[i][j];
			}
		}
		for (int i = 0; i < a.n; i++) {
			for (int j = 0; j < a.n; j++) {
				m.matrix[i + a.n][j + a.n] = d.getMatrix()[i][j];
			}
		}
		return m;
	}

	// add 2 matrices
	public Matrix add(Matrix first, Matrix second) {
		Matrix result = new Matrix(first.getDimesion());
		for (int i = 0; i < result.getDimesion(); i++) {
			for (int j = 0; j < result.getDimesion(); j++) {
				result.getMatrix()[i][j] = first.getMatrix()[i][j] + second.getMatrix()[i][j];
			}
		}
		return result;
	}

	// subtract 2 matrices
	public Matrix sub(Matrix first, Matrix second) {
		Matrix result = new Matrix(first.getDimesion());
		for (int i = 0; i < first.getDimesion(); i++) {
			for (int j = 0; j < first.getDimesion(); j++) {
				result.getMatrix()[i][j] = first.getMatrix()[i][j] - second.getMatrix()[i][j];
			}
		}
		return result;
	}

}
