class Solution {
	public boolean isInterleave(String s1, String s2, String s3) {
		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();
		if (len1 + len2 != len3)
			return false;
		int[] arr = new int[len3];
		Arrays.fill(arr, 1);
		int i = 0; int p = 0; int q = 0;
		for (int i = 0; i < len3; i++) {
			if (arr[i] != 0 && s3.charAt(i) == s1.charAt(p)) {
				p++;
				arr[i] = 0
			}
		}
		for (int i = 0; i < len3; i++) {
			if (arr[i] != 0 && s3.charAt(i) == s2.charAt(q)) {
				q++;
				arr[i] = 0
			}
		}
		return p == len1 && q == len2;
	}
}














































































