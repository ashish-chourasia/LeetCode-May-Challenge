package solutions;

import java.util.Stack;

public class Day13_RemoveKDigits {
	public static String removeKdigits(String num, int k) {
		int len = num.length();
		// corner case
		if (k == len)
			return "0";

		Stack<Character> stack = new Stack<>();
		int i = 0;
		while (i < num.length()) {
			// whenever meet a digit which is less than the previous digit, discard the
			// previous one
			while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
				stack.pop();
				k--;
			}
			stack.push(num.charAt(i));
			i++;
		}

		// corner case like "1111"
		while (k > 0) {
			stack.pop();
			k--;
		}

		// construct the number from the stack
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
			sb.append(stack.pop());
		sb.reverse();

		// remove all the 0 at the head
		while (sb.length() > 1 && sb.charAt(0) == '0')
			sb.deleteCharAt(0);
		return sb.toString();
	}
	/*
	 * public static String removeKdigits(String num, int k) { if(num.length() <= k)
	 * { return "0"; } String ans = ""; StringBuilder str = new StringBuilder(num);
	 * while(k-->0) { // System.out.println("Inside"); for(int i=0; i<str.length();
	 * i++) { //
	 * System.out.println("char at i: "+str.charAt(i)+"\tchar at i+1: "+str.charAt(i
	 * +1)); if(str.charAt(i) <= str.charAt(i+1)) { //
	 * System.out.println("Removing char: "+str.charAt(i+1)); str.deleteCharAt(i+1);
	 * } else { str.deleteCharAt(i); } break; } // System.out.println("k: "+k+"\n");
	 * } // System.out.println("Value of str: "+str); if(str.toString().equals("0"))
	 * { return "0"; } int i=0; while(i<str.length() && str.charAt(0)=='0') { i++;
	 * str.replace(0, i, ""); } // System.out.println(str); return str.toString(); }
	 * 
	 * 
	 * The first algorithm is straight-forward. Let's think about the simplest case:
	 * how to remove 1 digit from the number so that the new number is the smallest
	 * possible Well, one can simply scan from left to right, and remove the first
	 * "peak" digit; the peak digit is larger than its right neighbor. One can
	 * repeat this procedure k times, and obtain the first algorithm:
	 * 
	 * 
	 * // public static String removeKdigits(String num, int k) { // while (k > 0) {
	 * // int n = num.length(); // int i = 0; // while (i+1<n && num[i]<=num[i+1])
	 * i++; // num.erase(i, 1); // k--; // } // // trim leading zeros // int s = 0;
	 * // while (s<(int)num.size()-1 && num[s]=='0') s++; // num.erase(0, s); // //
	 * return num=="" ? "0" : num; // }
	 * 
	 * public static String removeKdigits_2(String num, int k) { StringBuilder str =
	 * new StringBuilder(num); while (k > 0) { int n = num.length(); int i=0; while
	 * (i+1 < n && str.charAt(i) <= str.charAt(i+1)) { i++; str.delete(i,1); k--; }
	 * } int i = 0; while(i<str.length() && str.charAt(0)=='0') { i++;
	 * str.replace(0, i, ""); } return str.toString()=="" ? "0" : str.toString(); }
	 */

	public static void main(String[] args) {
		String num = "1432219";
		int k = 3;
//		System.out.println(removeKdigits(num, k));
//		System.out.println(removeKdigits("10200", 1));
//		System.out.println(removeKdigits("10", 2));
//		System.out.println(removeKdigits("112", 1));
		System.out.println(removeKdigits("112", 1));

	}

	/*
	 * Remove 'k' peak elements starting from left Input: num = "1432219", k = 3
	 * Output: "1219" k=2 remove 43 12219
	 * 
	 */

}
