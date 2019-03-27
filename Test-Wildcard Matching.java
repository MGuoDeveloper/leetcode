class Solution {
	public boolean isMatch(String str, String pattern) {
		int s = 0; int p = 0; int starInd = -1; int match = 0;
		while (s < str.length()) {
			if (p < pattern.length() && (pattern.charAt(p) == '?' || pattern.charAt(p) == str.charAt(s))) {
				p++;
				s++;
			} else if (p < pattern.length() && pattern.charAt(p) == '*') {
				starInd = p;
				match = s;
				p++;
			} else if (starInd != -1) {
				p = starInd + 1;
				match++;
				s = match;
			} else {
				return false;
			}
		}

		while (p < pattern.length() && pattern.charAt(p) == '*') {
			p++;
		}
		return p == pattern.length();
	}
}
































































