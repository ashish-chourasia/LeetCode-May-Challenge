package solutions;

public class Day09_ValidPerfectSquare {

	// A square number is 1+3+5+7+...
	public static boolean isPerfectSquare(int num) {
		int i = 1;

		while (num > 0) {
			num = num - i;
			i = i + 2;
		}
		// If at the end, num equals 0 therefore it is a perfect square
		return (num == 0);
	}

	public static void main(String[] args) {
		int num = 16;
		int num2 = 14;
		System.out.println(isPerfectSquare(num));
		System.out.println(isPerfectSquare(num2));
	}

}
