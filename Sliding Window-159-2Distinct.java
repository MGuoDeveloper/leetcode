class Solution {
	public int getLength(String s) {
		int max = 0;
		if (s == null || s.length() == 0)
			return max;

		int len = s.length();
		int begin = 0;
		int end = 0;
		int counter = 0;

		HashMap<Character, Integer> table = new HashMap<>();
		while (end < len) {
			char lastChar = s.charAt(end);
			int v = table.getOrDefault(lastChar, 0);
			table.put(lastChar, v + 1);
			if (v == 0) {
				counter++;
			}
			end++;

			while (counter > 2) {
				char firstChar = s.charAt(begin);
				int cnt = table.get(firstChar);
				table.put(firstChar, cnt - 1);
				if (cnt == 1) {
					counter--;
				}
				begin++;
			}

			if (count == 2 && end - begin > max) {
				max = end - begin;
			}
		}
		return max;
	} 
}



































































