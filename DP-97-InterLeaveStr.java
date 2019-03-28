class Solution {
	public boolean isInterleave(String s1, String s2, String s3) {
		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();
		if (len1 + len2 != len3)
			return false;
		int[] arr = new int[len3];
		Arrays.fill(arr, 1);
		int p = 0; int q = 0;
		int i = 0;
		while (i < len3 && p < len1) {
			if (arr[i] == 1 && s3.charAt(i) == s1.charAt(p)) {
				p++;
				arr[i] = 0;
			}
			i++;
		}

		i = 0;
		while (i < len3 && q < len2) {
			if (arr[i] == 1 && s3.charAt(i) == s2.charAt(q)) {
				q++;
				arr[i] = 0;
			}
			i++;
		}
		
		return p == len1 && q == len2;
	}
}














































































