package solutions;

public class Day12_SingleElementInSortedArray {

	// O(n) solution
	public static int singleNonDuplicateBits(int[] nums) {
		int ans = 0;
		for(int i=0; i<nums.length; i++) {
			ans = ans ^ nums[i];
		}
		return ans;
	}

	// https://ai.googleblog.com/2006/06/extra-extra-read-all-about-it-nearly.html	
	public static int singleNonDuplicate(int[] nums) {
	    int lo = 0, hi = nums.length - 1;
	    while (lo < hi) {
	        int mid = (lo + hi) >>> 1;
	        if (nums[mid] == nums[mid ^ 1])
	            lo = mid + 1;
	        else
	            hi = mid;
	    }
	    return nums[lo];
	}

	public static void main(String[] args) {
		int[] nums = {1,1,2,3,3,4,4,8,8};
		System.out.println(singleNonDuplicate(nums));
	}

}
