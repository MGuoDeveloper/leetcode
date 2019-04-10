class Solution {
	// O(n*n)
    public int lengthOfLIS(int[] nums) {
    	int len = nums.length;
    	if (len <= 1) return len;
        int[] dp = new int[len];
        int max = 0;
        for (int i = 0; i < len; i++) {
        	for (int j = i + 1; j < len; j++) {
        		if (nums[j] > nums[i]) {
					dp[j] = Math.max(dp[j], dp[i] + 1);
					max = Math.max(dp[j], max);
        		}
        	}
        }
        return max + 1;
    }

    // O(n * lg(n))
    public int lengthOfLIS(int[] nums) {
    	int len = nums.length;
    	int size = 0;
    	int[] tails = new int[len];
    	for (int num: nums) {
    		int i = 0, j = size;
    		while (i != j) {
    			int m = (i + j) / 2;
    			if (tails[m] < num) {
    				i = m + 1;
    			} else {
    				j = m;
    			}
    		}
    		tails[i] = num;
    		if (i == size) size++;
    	}
    	return size;
    }
}