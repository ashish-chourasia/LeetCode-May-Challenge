package solutions;

import java.util.Stack;

public class Day19_OnlineStockSpan {

	public static void main(String[] args) {
		StockSpanner S = new StockSpanner();
		System.out.println(S.next(100)); //is called and returns 1,
		S.next(80); //is called and returns 1,
		S.next(60); //is called and returns 1,
		S.next(70); //is called and returns 2,
		S.next(60); //is called and returns 1,
		S.next(75); //is called and returns 4,
		S.next(85); //is called and returns 6.
	}

}

class StockSpanner {
	Stack<int[]> stack = new Stack();

	public int next(int price) {
		System.out.println("Current price: "+price);
		int res = 1;
		while (!stack.isEmpty() && stack.peek()[0] <= price) {
			System.out.println("Before popping, result: "+res);
			res += stack.pop()[1];
			System.out.println("After popping, result: "+res);
		}
		stack.push(new int[] { price, res });
		
		System.out.println("After pushing :"+price+"\tres: "+res+"\tStack: "+stack.peek()[0]+"\t"+stack.peek()[1]+"\n\n");
		return res;
	}
}