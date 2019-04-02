class Solution {
	public List<String> wordBreak(String s, List<String> wordDict) {
		return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
	}

	public List<String> DFS(String s, List<String> wordDict,
		HashMap<String, LinkedList<String>> map) {
		// make sure left String result list not cal duplicate
		// use map do memoization
		if (map.containsKey(s)) {
			return map.get(s);
		}
		LinkedList<String> res = new LinkedList<>();
		if (s.length() == 0) {
			res.add("");
			return res;
		}
		// word show once in Dict
		for (String word : wordDict) {
			if (s.startsWith(word)) {
				String rest = s.substring(word.length());
				List<String> restList = DFS(rest, wordDict, map);
				for (String sub : restList) {
					res.add(word + (sub == "" ? sub : (" " + sub)));
				}
			}
		}
		map.put(s, res);
		return res;
	}
}



































