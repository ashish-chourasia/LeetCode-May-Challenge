package solutions;

public class Day01_FirstBadVersion extends VersionControl {
	public int firstBadVersion(int n) {
		int start = 1, end = n;
		while (start < end) {
			int mid = start + (end - start) / 2; // avoid overflow if (start+end)>2147483647
			if (!isBadVersion(mid)) {
				start = mid + 1; // If its not a bad version, try to find it in the end side
			}

			else {
				end = mid; // If it is a bad version, try to find it in the start side
			}
		}
		return start;
	}
}

/* Dummy class */
class VersionControl {
	public boolean isBadVersion(int n) {
		return true;
	}
}