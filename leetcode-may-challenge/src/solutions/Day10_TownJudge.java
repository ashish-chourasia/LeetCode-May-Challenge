package solutions;

public class Day10_TownJudge {

	/*lee215
	 * Intuition:
		Consider trust as a graph, all pairs are directed edge.
		The point with in-degree - out-degree = N - 1 become the judge.
		
		Explanation:
		Count the degree, and check at the end.
		
		Time Complexity:
		Time O(T + N), space O(N)
		
		Out-Degree of x1 refers to the number of arcs incident from x1. That is, the number of arcs directed away from the vertex x1. 
		The In-Degree of x1 refers to the number of arcs incident to x1. That is, the number of arcs directed towards the vertex x1.
	 */
	 public static int findJudge(int N, int[][] trust) {
	        int[] count = new int[N+1];
	        for (int[] t: trust) {
	            count[t[0]]--; // Out degree
	            count[t[1]]++; // In degree
	        }
	        
//			for (int i = 0; i < count.length; i++) {
//				System.out.println("Element: " + i + " = " + count[i]);
//			}
			
	        for (int i = 1; i <= N; i++) {
	            if (count[i] == N - 1) return i;
	        }
	        return -1;
	    }

	public static void main(String[] args) {
		// N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
		/*
		 * The town judge trusts nobody. Everybody (except for the town judge) trusts
		 * the town judge. There is exactly one person that satisfies properties 1 and
		 * 2.
		 */
		int[][] trust = { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } };
		int[][] trust2 = {{1,3},{2,3}};
		int n2 = 3;
		int n = 4;
		System.out.println(findJudge(n, trust));
		System.out.println(findJudge(n2, trust2));
	}

}
