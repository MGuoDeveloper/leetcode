/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s = "aab", Return 1 since the palindrome partitioning ["aa","b"] 
 * could be produced using 1 cut.
 0、设置初始值，例如存取每个长度字符串"最大的"分割数值为初始值，1个字符串0次，len字符串len - 1次:
  a. dp[]: dp数组 用于存储动态最优值，
  b. 矩阵数组matrix[][]: 存false/true或其他数值，来做memoization，存储可能会重复用到的“状态”；
 1、大循环：根据之前长度最优值来动态获取下一个长度最优值；小循环：存取当前长度最优分割数值；
 2、动态循环过程：
  a. 考虑添加一个元素prev：那么为了更新prev的最优，或为当前curr最优+1，或循环去查找:
  b. 如果prev元素到之前某个元素bef为palindrome 并且bef‘s next最优+1 < curr最优+1，
  c. 遍历bef in (curr to last) 取较小者 更新得到“最终”这个元素prev的最优分割数值；
 3、循环第二步，再添加元素new，并获取添加元素new为初始元素时的最优分割数值；
 4、最终得到完整字符串的最优值。
 */
class Solution {
	public int minCut(String s) {
  	int len = s.length();
  	boolean[][] palin = new boolean[len][len];
  	int[] dp = new int[len + 1];
  	for (int i = 0; i <= len; i++) {
  		dp[i] = len - i - 1;
  	}
  	for (int i = 0; i < len; i++) {
  		for (int j = 0; j < len; j++) {
  			palin[i][j] = false;
  		}
  	}
  	for (int i = len - 1; i >= 0; i--) {
  		for (int j = i; j < len; j++) {
  			if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || palin[i + 1][j - 1])) {
  				palin[i][j] = true;
  				int tmp = dp[j + 1] + 1;
  				dp[i] = tmp < dp[i] ? tmp : dp[i];
  			}
  		}
  	}
  	return dp[0];
  }
}