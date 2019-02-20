/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s = "aab", Return 1 since the palindrome partitioning ["aa","b"] 
 * could be produced using 1 cut.
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