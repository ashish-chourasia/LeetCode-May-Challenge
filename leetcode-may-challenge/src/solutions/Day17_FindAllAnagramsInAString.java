package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day17_FindAllAnagramsInAString {

	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> startIndices = new ArrayList<>();
		int sLength = s.length(), pLength = p.length();
		int[] sFrequency = new int[26], pFrequency = new int[26];

		// Make frequency array for string p
		for (char ch : p.toCharArray()) {
			pFrequency[ch - 'a']++;
		}

		int j = 0; // i, j is the current window

		for (int i = 0; i < sLength; i++) {
			while (j < sLength && j - i + 1 <= pLength) {
				sFrequency[s.charAt(j) - 'a']++;
				j++;
			}
			
			// If the 2 frequency arrays are equal, add it to answer
			if (Arrays.equals(sFrequency, pFrequency)) {
				startIndices.add(i);
			}
			
			sFrequency[s.charAt(i) - 'a']--;
		}

		return startIndices;
	}

	public static void main(String[] args) {
		String s = "cbaebabacd", p = "abc";
		System.out.println(findAnagrams(s, p));
	}

}
