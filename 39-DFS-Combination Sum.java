/*
Given a set of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.
The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7,  A solution set is: 
[
 [7],
 [2, 2, 3]
]
C may have duplicate nummbers. And sorted C will avoid duplicate insertion.

*/

class Solution {
	public List<List<Integer>> combinationSum (int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (candidates == null || candidates.length == 0) {
			return result;
		}
		Arrays.sort(candidates);
		helper(0, target, candidates, result, new ArrayList<Integer>());
		return result;
	}

	private void helper (int start, int target, int[] candidates, List<List<Integer>> result, List<Integer> contains) {
		if (target == 0) {
			if (!result.contains(contains))	{
				result.add(new Arraylist<Integer>(contains));
			}
			return;
		}
		if (target < 0) {
			return;
		}
		if (target > 0) {
			for (int i = start; i < candidates.length; i++) {
				if (i > 0 && candidates[i] == candidates[i - 1]) {
					continue;
				}
				contains.add(candidates[i]);
				helper(i, target - candidates[i], candidates, result, contains);
				contains.remove(contains.size() - 1);
			}
		}
	}
}
