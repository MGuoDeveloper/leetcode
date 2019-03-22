/*
Given a string containing just the characters '(' and ')', 
find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"
*/

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Character> charStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        int[][] list = new int[s.length()][2];
        int cursor = -1;

        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (c == '(' || charStack.empty() || charStack.peek() == ')') {
        		charStack.push(c);
        		indexStack.push(i);
        	} else {
        		charStack.pop();
        		int start = indexStack.pop();
        		// 如果并联，则合并
        		if (cursor >= 0 && list[cursor][1] + 1 == start) {
	        		list[cursor][1] = i;
        		} else if (cursor >= 0 && list[cursor][0] > start && list[cursor][1] < i) {
	        		// 如果包含，则取代
	        		list[cursor][0] = left;
	        		list[cursor][1] = i;
	        		// 取代后，有可能需要再往前并联合并一次
	        		if (cursor >= 1 && list[cursor - 1][1] + 1 == start) {
	        			list[cursor - 1][1] = i;
	        			cursor--;
	        		}
        		} else {
        			cursor++;
	        		list[cursor][0] = start;
	        		list[cursor][1] = i;
        		}
        	}
        }
        int max = 0;
        for (int j = 0; j <= cursor; j++) {
        	int len =list[j][1] - list[j][0] + 1;
        	if (len > max) max = len;
        }
        return max;
    }
}

class Solution {
    public int longestValidParentheses(String s) {
    	if (s == null || s.length() == 0)
    		return 0;

    	int size = s.length();
    	int max = 0;

    	// can only check unbalanced type with more ')'
    	int len = 0;
    	int sum = 0;
    	for (int i = 0; i < size; i++) {
    		if (s.charAt(i) == '(') sum++;
    		else sum--;
    		if (sum < 0) {
    			sum = 0;
    			len = 0;
    		} else {
    			len++;
    			if (sum == 0)
    				max = Math.max(max, len);
    		}
    	}

    	// if travere from left side only, sum may not arrive 0 even len > 0
    	// like example: ((((), this case right side check will work.

    	// can only check unbalanced type with more '('
    	len = 0;
    	sum = 0;
    	for (int i = size - 1; i >= 0; i--) {
    		if (s.charAt(i) == ')') sum++;
    		else sum--;
    		if (sum < 0) {
    			sum = 0;
    			len = 0;
    		} else {
    			len++;
    			if (sum == 0)
    				max = Math.max(max, len);
    		}
    	}

    	return max;
    }
}















































