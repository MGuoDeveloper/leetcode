class Solution {
	public int maxReacArea(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < n; i++) {
			height[i] = (matrix[0][i] == '1') ? 1 : 0;
		}
		int res = largestInlineHeight(height);
		for (int i = 1; i < m; i++) {
			resetHeight(matrix, height, i);
			res = Math.max(res, largestInlineHeight(height));
		}
		return res;
	}

	private void resetHeight(int[][] matrix, int[] height, ind ind) {
		for (int i = 0; i < height.length; i++) {
			if (matrix[ind][i] == '1') {
				height[i] += 1;
			} else {
				height[i] = 0;
			}
		}
	}

	private int largestInlineHeight(int[] height) {
		int max = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < height.length; i++) {
			int h = (i == len) ? 0 : height[i];
			if (s.isEmpty() || h >= height[s.peek()]) {
				s.push(i);
			} else {
				int tp = s.pop();
				max = Math.max(max, height[tp] * (s.isEmpty() ? i : i - 1 - peek()));
			}
		}
		return max;
	}
}























































