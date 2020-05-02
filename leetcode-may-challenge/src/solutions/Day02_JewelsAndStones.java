package solutions;

import java.util.HashSet;
import java.util.Set;

public class Day02_JewelsAndStones {

	public static int numJewelsInStones(String J, String S) {
		// If there are no jewels, return 0
		if (J == null || J.length() == 0) {
			return 0;
		}
		
		int jewels = 0;
		Set<Character> jewelSet = new HashSet<>();

		// Initialize jewelSet
		for (char ch : J.toCharArray()) {
			jewelSet.add(ch);
		}

		// Iterate the stones and check if they are a jewel
		for (char ch : S.toCharArray()) {
			if (jewelSet.contains(ch)) {
				jewels++;
			}
		}

		return jewels;
	}

	public static void main(String[] args) {
		String J = "aA", S = "aAAbbbb";
		System.out.println(numJewelsInStones(J, S));
	}
}
