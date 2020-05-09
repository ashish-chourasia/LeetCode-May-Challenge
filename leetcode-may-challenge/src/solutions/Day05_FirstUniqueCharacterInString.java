package solutions;

public class Day05_FirstUniqueCharacterInString {

	public static int firstUniqChar(String str) {
		int index = -1;
		int[] freq = new int[26];

		// Make the frequency array from the characters in string
		for (int i = 0; i < str.length(); i++) {
			freq[str.charAt(i) - 'a']++;
		}

		// Iterate the string again and check if the current char has frequency=1
		for (int i = 0; i < str.length(); i++) {
			if (freq[(str.charAt(i)) - 'a'] == 1) {
				return i;
			}
		}

		return index;
	}

	public static void main(String[] args) {
		String str = "loveleetcode";
		System.out.println(firstUniqChar(str));
	}

}
