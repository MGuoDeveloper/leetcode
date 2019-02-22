/*
Given a string containing only digits, 
restore it by returning all possible valid IP address combinations.

For example: Given "25525511135",
return ["255.255.11.135", "255.255.111.35"].
(Order does not matter)
*/
class Solution {
  public List<String> restoreIpAddresses(String s) {
    List<String> result = new ArrayList<String>();
    int len = s.length();
    if (len < 4 || len > 12) return result;
    helper(s, "", result, 0);
    return result;
  }

  private void helper (String s, String cur, List<String> result, int count) {
  	if (count == 3) {
  		if (isValid(s)) {
  			cur += s;
  			result.add(cur);
  			return;
  		}
  	}
  	for (int i = 1; i < 4 && i < s.length(); i++) {
			String str = s.substring(0, i);
			if (isValid(str)) {
				helper(s.substring(i), cur + str + '.', result, count + 1);
			}
		}
  }

  private boolean isValid (String s) {
  	if (s.charAt(0) == '0') {
  		return s.equals("0");
  	}
  	int n = Integer.parseInt(s);
  	return n <= 255 && n > 0;
  }
}