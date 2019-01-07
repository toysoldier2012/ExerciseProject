#Problem description
Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.<br>
<br>
Example 1:<br>
Input: <br>
    5<br>
   / \<br>
  3   6<br>
 / \   \<br>
2   4   7<br>
<br>
Target = 9<br>
<br>
Output: True<br>
Example 2:<br>
Input: <br>
    5<br>
   / \<br>
  3   6<br>
 / \   \<br>
2   4   7<br>
<br>
Target = 28<br>
<br>
Output: False<br>
<br>
#Tips:
*Time complexity: O(nh)
*Space complexity: O(h)
h means height of the tree, which is logn in best case, and n in worst case