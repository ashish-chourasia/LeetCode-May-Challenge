package solutions;

import java.util.Arrays;

public class Day06_MajorityElement {

	public static int majorityElement(int[] nums) {
		int majorityElement = -1;
		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			if (count == 0) {
				majorityElement = nums[i];
				count++;
			} else if (majorityElement != nums[i]) {
				count--;
			} else {
				count++;
			}
		}

		return majorityElement;
	}

	public static int majorityElementUsingSorting(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	public static void main(String[] args) {
		int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
		int[] nums2 = { 3, 2, 3 };
		int[] nums3 = { 3, 3, 4 };
		System.out.println(majorityElement(nums));
		System.out.println(majorityElement(nums2));
		System.out.println(majorityElement(nums3));
	}

}
