class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
		int len = s.length();
		if (wordDict.contains(s)) {
			return true;
		}
		boolean[] dp = new boolean[len + 1];
		dp[0] = true;
		for (int i = 1; i <= len; i++) {
			for (int j = i - 1; j >= 0; j++) {
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[len];
	}
}

































































