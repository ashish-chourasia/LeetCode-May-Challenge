package solutions;

import java.util.Arrays;

public class Day18_PermutationInString {

	public static boolean checkInclusion(String s, String p) {
		int sLength = s.length(), pLength = p.length();
		int[] sFrequency = new int[26], pFrequency = new int[26];

		// Make frequency array of p
		for (char ch : p.toCharArray()) {
			pFrequency[ch - 'a']++;
		}

		int j = 0; // i, j is the current window

		for (int i = 0; i < sLength; i++) {
			while (j < sLength && j - i + 1 <= pLength) {
				sFrequency[s.charAt(j) - 'a']++;
				j++;
			}

			// If both the frequency array are equal, it means it is contained.
			if (Arrays.equals(sFrequency, pFrequency)) {
				return true;
			}

			// Remove the current char from frequency table (hash table)
			sFrequency[s.charAt(i) - 'a']--;
		}

		return false;
	}

	public static void main(String[] args) {
		// s1 = "ab" s2 = "eidbaooo"
		// Returns true
		// one of the first string's permutations is the substring of the second string.
		String s1 = "ab", s2 = "eidbaooo";
		System.out.println(checkInclusion(s2, s1));
	}

}
