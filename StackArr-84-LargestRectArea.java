class Solution {
	public int largestRectangleArea(int[] heights) {
		int len = heights.length;
		int max = 0;
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i <= len; i++) {
			int h = (i == len) ? 0 : heights[i];
			if (s.isEmpty() || h >= s.peek()) {
				s.push(i);
			} else {
				int tp = s.pop();
				max = Math.max(max, heights[tp] *
					(s.isEmpty() ? i : i - 1 - s.peek()));
				i--;
			}
		}
		return max;
	}
}






























































