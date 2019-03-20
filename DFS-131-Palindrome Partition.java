/*

Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.
For example, given s = "aab", Return
[
 ["aa","b"],
 ["a","a","b"]
]

 * 
 * 深度优先搜索DFS, 思路
 * 1. 如何找到状态，如何扩展状态，如何判重
 * 2. 递归函数设计：
 * a. 首先找到递归结束点，添加递归结果到返回
 * b. 循环中，回溯：判断是否添加递归元素，然后调用递归函数，删除递归元素
 *
 */
class Solution {
  public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<List<String>>();
    if (s == null || s.length() == 0) {
      return result;
    }
    ArrayList<String> partition = new ArrayList<String>();
    addPalindrome(s, 0, result, partition);
    return result;
  }

  private void addPalindrome(String s, int start, List<List<String>> result, List<String> partition) {
    if (start == s.length()) {
      List<String> tmp = new ArrayList<String>(partition);
      result.add(tmp);
      return;
    }
    for (int i = start + 1; i <= s.length(); i++) {
      String str = s.substring(start, i);
      if (isPalindrome(str)) {
        partition.add(str);
        addPalindrome(s, i, result, partition);
        partition.remove(partition.size() - 1);
      }
    }
  }

  private boolean isPalindrome(String str) {
    int i = 0;
    int j = str.length() - 1;
    while (i < j) {
      if (str.charAt(i) != str.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
}