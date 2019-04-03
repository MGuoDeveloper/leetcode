class Solution {
	public int maxProduct(int[] nums) {
		int front = 1;
		int back = 1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length(); i++) {
			front *= nums[i];
			back *= nums[nums.length() - i - 1];
			max = Math.max(max, Math.max(front, back));
			front = front == 0 ? 1 : front;
			back = back == 0 ? 1 : back;
		}
		return max;
	}
}























































