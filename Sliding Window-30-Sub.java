/*
You are given a string, s, and a list of words, words, 
that are all of the same length. Find all starting indices of substring(s) 
in s that is a concatenation of each word in words exactly once 
and without any intervening characters.

Example 1:

Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
Example 2:

Input:
  s = "wordgoodgoodgoodbestword",
  words = ["word","good","best","word"]
Output: []
*/

class Solution {
  public List<Integer> findSubstring(String s, String[] words) {
  	HashMap<String, Integer> table = new HashMap<>();
    List<Integer> ans = new ArrayList<>();

    int size = words.length;
    if (size == 0) return ans;

    int wordLen = words[0].length();
    int windowLen = wordLen * size;

    for (String word: words) {
    	int v = table.getOrDefault(word, 0);
			table.put(word, v + 1);
    }

    for (int i = 0; i < wordLen; i++) {
    	HashMap<String, Integer> ref = new HashMap<>();
    	ref.putAll(table);
    	int counter = table.size();
    	int begin = i;
    	int end = i;

    	while (end + wordLen - 1 < s.length()) {
    		String lastWord = s.substring(end, end + wordLen);
    		if (ref.containsKey(lastWord)) {
    			int v = ref.get(lastWord);
    			ref.put(lastWord, v - 1);
    			if (v == 1) {
    				counter--;
    			}
    		}

    		if (end + wordLen - begin == windowLen) {
    			if (counter == 0) {
    				ans.add(begin);
    			}
    			String firstWord = s.substring(begin, begin + wordLen);
    			if (ref.containsKey(firstWord)) {
    				int v = ref.get(firstWord);
    				ref.put(firstWord, v + 1);
    				if (v == 0) {
    					counter++;
    				}
    			}
    			begin += wordLen;
    		}

    		end += wordLen;
    	}
    }

    return ans;
  }
}





















































