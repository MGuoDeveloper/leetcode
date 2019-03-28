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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> preList = new ArrayList<>();
        TreeNode tn = new TreeNode(1);
        tn.left = null;
        tn.right = null;
        preList.add(tn);
        for (int i = 2; i <= n; i++) {
            List<TreeNode> curList = new ArrayList<>();
            for (TreeNode head : preList) {            
                TreeNode node1 = new TreeNode(i);
                node1.left = head;
                node1.right = null;
                curList.add(node1);
                
                TreeNode node2 = new TreeNode(i);
                node1.left = head;
                node1.right = null;
            }
        }
    }
}