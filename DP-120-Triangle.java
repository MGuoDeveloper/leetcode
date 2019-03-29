class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[] dp = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			List<Integer> row = triangle.get(i);
			for (int j = 0; j <= i; j++) {
				int x = row.get(j);
				dp[j] = (i == n - 1)
					? x : x + Math.min(dp[j], dp[j + 1]);
			}
		}
		return dp[0];
	}
}














































