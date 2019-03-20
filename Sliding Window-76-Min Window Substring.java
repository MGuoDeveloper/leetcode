class Solution {
	public String minWindow(String s, String t) {
		HashMap<Character, Integer> table = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			int v = table.getOrDefault(c, 0);
			table.put(c, v + 1);
		}
		int counter = table.size();
		int len = Integer.MAX_VALUE;
		int start = 0, end = 0;
		String ans = "";

		while (end < s.length()) {
			char cur = s.charAt(end);
			if (table.containsKey(cur)) {
				int v = table.get(cur);
				table.put(cur, v - 1);
				if (v == 1) counter--;
			}
			end++;
			
			while (counter == 0) {
				if (end - start < len) {
					len = end - start;
					ans = s.substring(start, end);
				}
				char head = s.charAt(start);
				if (table.containsKey(head)) {
					int v = table.get(head);
					table.put(head, v + 1);
					if (v == 0) counter++;
				}
				start++;
			}
		}

		return ans;
	}
}