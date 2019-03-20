class Solution {
	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> table = new HashMap<>();
		int max = 0;
		int begin = 0;
		int end = 0;
		while (end < s.length()) {
			char c = s.charAt(end);
			int v = table.getOrDefault(c, 0);
			table.put(c, v + 1);
			if (v == 0) {
				int len = end - begin + 1;
				if (len > max) max = len;
			} else if (v == 1) {
				while (s.charAt(begin) != c) {
					table.put(s.charAt(begin), 0);
					begin++;
				}
				begin++;
				table.put(c, 1);
			}
			end++;
		}
		return max;
	}
}


class Solution {
	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> table = new HashMap<>();
		int max = 0;
		int begin = 0;
		int end = 0;
		while (end < s.length()) {
			char c = s.charAt(end);

			if (table.containsKey(c) && table.get(c) > -1) {
				int ind = table.get(c);
				while (begin < ind) {
					table.put(s.charAt(begin), -1);
					begin++;
				}
				begin = ind + 1;
			} else {
				int len = end - begin + 1;
				if (len > max) max = len;
			}

			table.put(c, end);
			end++;
		}
		return max;
	}
}

class Solution {
	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> table = new HashMap<>();
		int max = 0;
		int begin = 0;
		int end = 0;
		while (end < s.length()) {
			char c = s.charAt(end);

			if (table.containsKey(c) && table.get(c) >= begin) {
				begin = table.get(c) + 1;
			} else {
				int len = end - begin + 1;
				if (len > max) max = len;
			}

			table.put(c, end);
			end++;
		}
		return max;
	}
}




































































