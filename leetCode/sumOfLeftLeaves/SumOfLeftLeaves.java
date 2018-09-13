package leetCode.sumOfLeftLeaves;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

class Solution {
	public int sumOfLeftLeaves(TreeNode root) {
		int sum = 0;
		if (root == null)
			return 0;
		while (root.left != null | root.right != null) {
			if (root.left != null) {
				if (root.left.left == null && root.left.right == null)
					sum += root.left.val;
				else
					sum += sumOfLeftLeaves(root.left);
			}
			if (root.right != null)
				sum += sumOfLeftLeaves(root.right);
			return sum;
		}
		return 0;
	}
}