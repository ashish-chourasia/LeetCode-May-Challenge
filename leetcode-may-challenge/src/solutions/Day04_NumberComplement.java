package solutions;

public class Day04_NumberComplement {
	/*
	 * for example: 100110, its complement is 011001, the sum is 111111. So we only
	 * need get the min number large or equal to num, then do substraction
	 */
	public static int findComplement(int num) {
		int i = 0;
		int j = 0;

		while (i < num) {
			i += Math.pow(2, j);
			j++;
		}

		return i - num;
	}

	public int findComplement_2(int num) {
		int cp = num;
		int sum = 0;
		while (num > 0) {
			sum = (sum << 1) + 1;
			num >>= 1;
		}
		return sum - cp;

	}

	public int findComplement_3(int num) {
		return ~num & ((Integer.highestOneBit(num) << 1) - 1);
	}

	public static void main(String[] args) {
		System.out.println(findComplement(5));
	}

}
