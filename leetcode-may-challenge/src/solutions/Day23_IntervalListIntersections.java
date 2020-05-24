package solutions;

import java.util.ArrayList;
import java.util.List;

public class Day23_IntervalListIntersections {

	public static int[][] intervalIntersection(int[][] A, int[][] B) {
		if (A == null || A.length == 0 || B == null || B.length == 0)
			return new int[][] {};
		List<int[]> res = new ArrayList<>();

		int i = 0, j = 0;
		int startMax, endMin;
		while (i < A.length && j < B.length) {
			startMax = Math.max(A[i][0], B[j][0]);
			endMin = Math.min(A[i][1], B[j][1]);

			if (endMin >= startMax)
				res.add(new int[] { startMax, endMin });

			if (A[i][1] == endMin)
				i++;
			if (B[j][1] == endMin)
				j++;
		}

		return res.toArray(new int[res.size()][2]);
	}

	public static void main(String[] args) {
		int[][] A={{0,2},{5,10},{13,23},{24,25}}, B = {{1,5},{8,12},{15,24},{25,26}};
		System.out.println(intervalIntersection(A, B));
	}

}
