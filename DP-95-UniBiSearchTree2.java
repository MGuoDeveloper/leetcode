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
        if (n == 0) return new ArrayList<TreeNode>();
        return generateSubTree(1, n);
    }

    private List<TreeNode> generateSubTree (int num, int len) {
        List<TreeNode> list = new ArrayList<>();
        if (num < len) {
            list.add(null);
        }
        for (int i = num; i <= len; i++) {
            List<TreeNode> leftList = generateSubTree(tree, num, i - 1);
            List<TreeNode> rightList = generateSubTree(tree, i + 1, len);
            for (TreeNode left: leftList) {
                for (TreeNode right: rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}

























