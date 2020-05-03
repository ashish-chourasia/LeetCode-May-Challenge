package solutions;

public class Day03_RansomNote {

	public static boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length())
			return false;

		int[] freq = new int[26];

		// For chars in magazine, increment the count
		for (char ch : magazine.toCharArray()) {
			freq[(ch) - 'a']++;
		}

		// For chars in ransomNote, decrement the count
		for (char ch : ransomNote.toCharArray()) {
			freq[(ch) - 'a']--;
		}

		// If at any point freq[i] becomes negative, it means magazine doesn't have enough chars to make ransomNote
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] < 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(canConstruct("a", "b"));
		System.out.println(canConstruct("aa", "ab"));
		System.out.println(canConstruct("aa", "aab"));
	}

}
