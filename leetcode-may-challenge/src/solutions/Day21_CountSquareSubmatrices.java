package solutions;

public class Day21_CountSquareSubmatrices {

	public static int countSquares(int[][] A) {
		int res = 0;
		for (int i = 0; i < A.length; ++i) {
			for (int j = 0; j < A[0].length; ++j) {
				if (A[i][j] > 0 && i > 0 && j > 0) {
					A[i][j] = Math.min(A[i - 1][j - 1], Math.min(A[i - 1][j], A[i][j - 1])) + 1;
				}
				res += A[i][j];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[][] A = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } };
		System.out.println(countSquares(A));
	}

}
