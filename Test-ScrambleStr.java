class Solution {
	public boolean isScramble (String s1, String s2) {
		if (s1.length() != s2.length)
			return false;
		if (s1.length() == 1) {
			return s1.equals(s2);
		}
		int[] arr = new int[26]{0};
		for (int i = 0; i < s1.length(); i++) {
			arr[s1.charAt(i) - 'a']++;
			arr[s2.charAt(i) - 'a']--;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0)
				return false;
		}
		for (int i = 1; i < s1.length(); i++) {
			if (isScramble(s1.substring(0, i), s2.substring(0, i)) && 
				isScramble(s1.substring(i), s2.substring(i)))
				return true;
			if (isScramble(s1.substring(0, i), s2.substring(s1.length() - i)) && 
				isScramble(s1.substring(0, s1.length() - i), s2.substring(i)))
				return true;
		}
		return false;
	}
}










































































