package solutions;

public class Day15_MaxSumCircularSubArray {
/*
 * https://leetcode.com/problems/maximum-sum-circular-subarray/discuss/178422/One-Pass
		max(the max subarray sum, the total sum - the min subarray sum)
 */
	public static int maxSubarraySumCircular(int[] arr) {
		int maxSoFar = Integer.MIN_VALUE, maxEndingHere = 0;
		int minSoFar = Integer.MAX_VALUE, minEndingHere = 0;
		int total = 0, ans = 0;
		for (int i = 0; i < arr.length; i++) {
			maxEndingHere = Math.max(maxEndingHere + arr[i], arr[i]);
			maxSoFar = Math.max(maxEndingHere, maxSoFar);

			minEndingHere = Math.min(minEndingHere + arr[i], arr[i]);
			minSoFar = Math.min(minEndingHere, minSoFar);
			total = total + arr[i];
		}
		if (maxSoFar > 0) {
			ans = Math.max(maxSoFar, total - minSoFar);
		} else {
			ans = maxSoFar;
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = { 5, -3, 5 };
		System.out.println(maxSubarraySumCircular(arr));
	}
	/*
	 * Input: [3,-2,2,-3] Output: 3 Explanation: Subarray [3] and [3,-2,2] both have
	 * maximum sum 3
	 */
}
