/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();

    stack.push(root);

    while (!stack.empty()) {
    	root = stack.pop();

    	if (root != null) {
    		stack.push(root.right);
    		stack.push(root.left);

    		result.add(root.val);
    	}
    }
    return result;
  }
}