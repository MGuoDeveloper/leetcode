class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
		int len = s.length();
		if (wordDict.contains(s)) {
			return true;
		}
		for (int i = len - 1; i > 0; i--) {
			String sub = s.substring(0, i);
			if (wordDict.contains(sub) && 
				wordBreak(s.substring(i), wordDict)) {
				return true;
			}
		}
		return false;
	}
}

































































