/*
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//recursive
class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
  	List<Integer> result = new ArrayList<Integer>();
  	if (root == null) {
  		return result;
  	}
  	if (root.left == null && root.right == null) {
  		result.add(root.val);
  		return result;
  	}
  	List<Integer> left = inorderTraversal(root.left);
  	List<Integer> right = inorderTraversal(root.right);
  	result.addAll(left);
  	result.add(root.val);
  	result.addAll(right);
  	return result;
  }
}

//iterative
class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
  	List<Integer> result = new ArrayList<Integer>();
  	Stack<TreeNode> stack = new Stack<TreeNode>();
    
  	while (root != null || !stack.empty()) {
  		while (root != null) {
  			stack.push(root);
  			root = root.left;
  		}
  		
  		root = stack.pop();

  		result.add(root.val);
  		root = root.right;
  	}
  	return result;
  }
}





























