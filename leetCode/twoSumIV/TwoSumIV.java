package leetCode.twoSumIV;

import leetCode.TreeNode;

class Solution {
	// Use set collection
	// public boolean findTarget(TreeNode root, int k) {
	// HashSet<Integer> collection = new HashSet();
	// return ft(root, k, collection);
	// }
	//
	// public boolean ft(TreeNode root, int k, Set collection) {
	// if (root == null)
	// return false;
	// if (collection.contains(k - root.val))
	// return true;
	//
	// collection.add(root.val);
	// return ft(root.left, k, collection) || ft(root.right, k, collection);
	// }
	
	// Just use BST
	public boolean findTarget(TreeNode root, int k) {
		return helper(root, root, k);
	}

	public boolean helper(TreeNode root, TreeNode cur, int k) {
		if (root == null)
			return false;
		//Try to find the second element in TREE root, if the NODE root doesn't match, change the NODE to root's childnodes
		return search(root, cur, k - root.val) 
				|| helper(root.left, cur, k) || helper(root.right, cur, k);
	}
	
	//Search the second element such that the sum of two elements is the key
	//First fixed element is the root, the cur is used for checking the others elements in the tree
	public boolean search(TreeNode root, TreeNode cur, int k) {
		if (cur == null)
			return false;
		if (root != cur && k == cur.val)
			return true;
		return (k > cur.val) ? search(root, cur.right, k) : search(root, cur.left, k);
	}

}