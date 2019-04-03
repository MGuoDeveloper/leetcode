class Solution {
	public int rob(int[] nums) {
		int len = nums.length();
		int max = 0;
		if (len <= 3) {
			for (int i = 0; i < len; i++) {
				max = Math.max(max, nums[i]);
			}
			return max;
		}
		return Math.max(helper(nums, 0, len - 2), helper(nums, 0, len - 1))
	}

	public int helper(int[] nums, int start, int end) {
		int len = end - start + 1;
		int[] dp = new int[len];
		if (len == 0) return 0;
		if (len == 1) return nums[start];
		dp[0] = nums[start];
		dp[1] = nums[start + 1] > nums[start] ? nums[start + 1] : nums[start];
		for (int i = start + 2; i <= end; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i])
		}
		return dp[end];
	}
}