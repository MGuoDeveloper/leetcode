class Solution {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> ans = new ArrayList<>();
		int len = p.length();
		int total = s.length();

		if (total < len)
			return ans;

		int[] table = new int[26];
		int[] list = new int[26];
		Arrays.fill(table, 0);
		Arrays.fill(list, 0);

		for (int i = 0; i < len; i++) {
			table[p.charAt(i) - 'a']++;
			list[s.charAt(i) - 'a']++;
		}

		if (compare(table, list)) {
			ans.add(0);
		}

		for (int j = len; j < total; j++) {
			list[s.charAt(j) - 'a']++;
			list[s.charAt(j - len) - 'a']--;
			if (compare(table, list)) {
				ans.add(j - len + 1);
			}
		}

		return ans;
	}

	public boolean compare(int[] t1, int[] t2) {
		int len = t1.length;
		for (int i = 0; i < len; i++) {
			if (t1[i] != t2[i]) {
				return false;
			}
		}
		return true;
	}
}