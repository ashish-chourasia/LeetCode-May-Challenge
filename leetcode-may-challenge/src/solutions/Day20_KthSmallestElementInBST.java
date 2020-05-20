package solutions;

import java.util.Stack;

public class Day20_KthSmallestElementInBST {
	public int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> st = new Stack<>();

		while (root != null) {
			st.push(root);
			root = root.left;
		}

		while (k != 0) {
			TreeNode n = st.pop();
			k--;
			if (k == 0)
				return n.val;
			TreeNode right = n.right;
			while (right != null) {
				st.push(right);
				right = right.left;
			}
		}

		return -1; // never hit if k is valid
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
