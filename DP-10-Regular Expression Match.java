/*
Given an input string (s) and a pattern (p), implement regular expression 
matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, 
and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 
'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. 
Therefore it matches "aab".
Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false
*/
class Solution {
	public boolean isMatch(String s, String p) {
		if (p.length() == 0) 
			return s.length() == 0;
		if (p.length() == 1 || p.charAt(1) != '*') {
			if (s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
				return isMatch(s.substring(1), p.substring(1));
			}
			return false;
		} else {
			// p.length >= 2 and p[1] == '*'
			// i start from -1 is because need to consider the situation: isMatch(s, p.substring(2))
			// no matter what is first char of p, p(0 - 1) can be ignore.
			int i = -1;
			// .* can match any string, so need to traverse all possibility
			// 1. i < 0, check isMatch(s, p.substring(2)), s is original complete string.
			// 2. p.charAt(0) == '.', check isMatch(s.substring(i), p.substring(2)): 1 <= i < len;
			// 3. p(0) = s(i), i is anychar between 0 and i: p(0) = s(0), p(0) = s(1), p(0) = s(2)...
			//  then check, isMatch(s.substring(i + 1), p.substring(2))
			//  So if the beginning of s has some chars all same with first char of p(0) && p(1) == '.'
			//  then s can cut off any number >= 1 of them, then compare left of s with p.substring(2).
			while (i < s.length() && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))) {
				if (isMatch(s.substring(i + 1), p.substring(2)))
					return true;
				i++;
			}
			return false;
		}
	}
}

// recursive
class Solution {
	public boolean isMatch(String s, String p) {
		if (p.length() == 0) return s.length() == 0;
		boolean firstMatch = s.length() > 0 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0));
		if (p.length() == 1 || p.charAt(1) != '*')
			return firstMatch && isMatch(s.substring(1), p.substring(1));
		else
			return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
	}
}

















































