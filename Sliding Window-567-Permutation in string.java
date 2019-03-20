class Solution {
	public boolean checkInclusion(String s1, String s2) {
		if (s2.length() < s1.length()) return false;
		int begin = 0;
		int end = 0;
		HashMap<Character, Integer> table = new HashMap<>();
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			table.put(c, table.getOrDefault(c, 0) + 1);
		}
		int counter = table.size();

		while(end < s2.length()) {
			char lastChar = s2.charAt(end);
			if (table.containsKey(lastChar)) {
				int v = table.get(lastChar);
				table.put(lastChar, v - 1);
				if (v == 1) {
					counter--;
				}
			}
			end++;

			while (counter == 0) {
				if (end - begin == s1.length())
					return true;
				char firstChar = s2.charAt(begin);
				if (table.containsKey(firstChar)) {
					int c = table.get(firstChar);
					table.put(firstChar, c + 1);
					if (c == 0) {
						counter++;
					}
				}
				begin++;
			}
		}
		return false;
	}
}

/*Better if String only includes lowercase letters*/
class Solution {
	public boolean checkInclusion(String s1, String s2) {
		if (s2.length() < s1.length()) return false;
		int begin = 0;
		int end = s1.length();
		int[] arr = new int[26];
		Arrays.fill(arr, 0);
		for (int i = 0; i < s1.length(); i++) {
			arr[s1.charAt(i) - 'a'] += 1;
		}

		for (int j = 0; j < s1.length(); j++) {
			arr[s2.charAt(j) - 'a'] -= 1;
		}

		if (checkEmpty(arr)) {
			return true;
		}

		while (end < s2.length()) {
			char firstChar = s2.charAt(begin++);
			char lastChar = s2.charAt(end++);
			arr[lastChar - 'a'] -= 1;
			arr[firstChar - 'a'] += 1;
			if (checkEmpty(arr)) {
				return true;
			}
		}
		return false;
	}

	public boolean checkEmpty(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0)
				return false;
		}
		return true;
	}
}










































































