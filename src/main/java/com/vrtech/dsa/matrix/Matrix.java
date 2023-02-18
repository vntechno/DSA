package com.vrtech.dsa.matrix;

public class Matrix {

	public static void print(int[] matrix[], int row, int column) {

		for (int i = 0; i < row; i++) {

			for (int k = 0; k < column; k++) {

				System.out.print(matrix[i][k] + " ");
			}
			System.out.println();
		}

	}

	public static void spiral(int[] matrix[], int[] matrix2[], int row, int column) {

		int j = 2;
		for (int i = 0; i < row; i++) {
			for (int k = 0; k < column; k++) {
				matrix2[i][k] = matrix[k][j];
			}
			j--;
		}

	}

	public static void main(String[] args) {

		int[] matrix[] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[] matrix2[] = new int[3][3];

		print(matrix, 3, 3);
		spiral(matrix, matrix2, 3, 3);
		System.out.println("====================================");
		print(matrix2, 3, 3);
	}

}
