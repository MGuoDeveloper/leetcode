class Solution {
	// bad time and space complexity
    public int maxProfit(int k, int[] prices) {
    	int len = prices.length;
        if (k == 0 || len <= 1) return 0;
        if (k > len / 2) {
            k = len / 2;
        }
        int[] release = new int[k];
    	int[] hold = new int[k];
    	Arrays.fill(hold, Integer.MIN_VALUE);
        for (int i : prices) {
        	for (int j = k - 1; j >= 0; j--) {
        		release[j] = Math.max(release[j], hold[j] + i);
            	hold[j] = Math.max(hold[j], (j > 0 ? release[j - 1] : 0) - i);
        	}
        }
        return release[k - 1];
    }
}

class BetterSolution {
    public int maxProfit(int k, int[] prices) {
    	int len = prices.length;
        if (k == 0 || len <= 1) return 0;
        if (k > len / 2) {
            return quickSolve(prices);
        }
        int[] release = new int[k];
    	int[] hold = new int[k];
    	Arrays.fill(hold, Integer.MIN_VALUE);
        for (int i : prices) {
        	for (int j = k - 1; j >= 0; j--) {
        		release[j] = Math.max(release[j], hold[j] + i);
            	hold[j] = Math.max(hold[j], (j > 0 ? release[j - 1] : 0) - i);
        	}
        }
        return release[k - 1];
    }

    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}
















































