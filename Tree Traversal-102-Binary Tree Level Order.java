class Solution {
  public List<List<Integer>> levelOrderTraversal(TreeNode root) {
  	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> level = new ArrayList<Integer>();

    TreeNode marker = new TreeNode(Integer.MIN_VALUE);
    queue.add(root);
    queue.add(marker);

    while(queue.size() > 0) {
      TreeNode cur = queue.poll();
      if (cur != null) {
        if (cur.val == Integer.MIN_VALUE) {
          result.add(level);
          level = new ArrayList<Integer>();
          if (queue.size() > 0) {
            queue.add(marker);
          }
        } else {
          level.add(cur.val);
          queue.add(cur.left);
          queue.add(cur.right);
        }
      }
    }
    result.remove(result.size() - 1);
    return result;
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> level = new ArrayList<Integer>();

    queue.add(root);

    while(queue.size() > 0) {
      int s = queue.size();

      for (int i = 0; i < s; i++) {
        TreeNode cur = queue.poll();
        if (cur != null) {
          level.add(cur.val);
          queue.add(cur.left);
          queue.add(cur.right);
        }
      }
      
      result.add(level);
      level = new ArrayList<Integer>();
    }
    result.remove(result.size() - 1);
    return result;
  }
}
