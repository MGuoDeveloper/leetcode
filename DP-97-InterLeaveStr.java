class Solution {
	public boolean isInterleave(String s1, String s2, String s3) {
		int p = 0; int q = 0; int c = 0;
		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();
		while (p < len1 && q < len2 && c < len3) {
			char cp = s1.charAt(p);
			char cq = s2.charAt(q);
			char cur = s3.charAt(c);
			if (cp != cur && cq != cur) {
				return false;
			} else if (cp == cur && cq != cur) {
				p++;
			} else if (cq == cur && cp != cur) {
				q++;
			} else {
				String com = s3.substring(c + 1);
				return isInterleave(s1.substring(p + 1), s2.substring(q), com) ||
					isInterleave(s1.substring(p), s2.substring(q + 1), com);
			}
		}
		if (p == len1) return s3.substring(c).equals(s2.substring(q));
		if (q == len2) return s3.substring(c).equals(s1.substring(p));
		return false;
	}
}














































































