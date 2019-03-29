class Solution {
	public int numDistinct(String s, String t) {
		int ls = s.length();
		int lt = t.length();
		if (s < t) return 0;
		int[][] dp = new int[ls][lt];
		dp[0][0] = s.charAt(0) == t.charAt(0);
		for (int i = 1; i < ls; i++) {
			int flag = s.charAt(i) == t.charAt(0) ? 1 : 0;
			dp[i][0] = dp[i - 1][0] + flag;
		}
		for (int i = 1; i < lt; i++) {
			dp[0][i] = 0;
		}
		for (int i = 1; i < ls; i++) {
			for (int j = 1; j < lt; j++) {
				int flag = s.charAt(i) == t.charAt(j) ? 1 : 0;
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] * flag;
			}
		}
		return dp[ls - 1][lt - 1];
	}
}








































































