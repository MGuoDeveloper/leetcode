class Solution {
	public List<String> wordBreak(String s, List<String> wordDict) {
		List<String> res = new ArrayList<>();
		addWord(s, 0, new StringBuilder(), wordDict, res);
		return res;
	}

	public void addWord(String s, int start, StringBuilder sb, List<String> wordDict, List<String> res) {
		if (start == s.length() && sb.length() > 0) {
			sb.deleteCharAt(sb.length() - 1);
			res.add(sb.toString());
		}
		for (int i = start + 1; i <= s.length(); i++) {
			String sub = s.substring(start, i);
			if (wordDict.contains(sub)) {
				int sbLen = sb.length();
				sb.append(sub);
				sb.append(" ");
				addWord(s, i, sb, wordDict, res);
				sb.delete(sbLen, sbLen + i - start + 1);
			}
		}
	}
}