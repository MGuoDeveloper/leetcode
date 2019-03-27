class Solution {
	public int maxSubArray(int[] nums) {
		int size = nums.length;
		int[] sums = new int[size + 1];
		sums[0] = 0;
		int res = nums[0] < 0 ? 0 : nums[0];
		for (int i = 0; i < size; i++) {
			sums[i + 1] = Math.max(sums[i] + nums[i], nums[i]);
			if (sums[i + 1] > res) {
				res = sums[i + 1];
			}
		}
		return res;
	}
}

class Solution {
	public int maxSubArray(int[] nums) {
		int size = nums.length;
		int sum = 0;
		int max = 0;
		for (int i = 0; i < size; i++) {
			sum += nums[i];
			if (sum < 0) {
				sum = 0;
			}
			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}
}




















































































