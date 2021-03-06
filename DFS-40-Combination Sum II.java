/*
Given a collection of candidate numbers (C) and a target number (T),
find all unique combinations in C where the candidate numbers sums to T.
Each number in C may only be used once in the combination.
Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,  A solution set is: 
[
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
]
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
				result.add(new ArrayList<Integer>(contains));
			}
			return;
		}
		if (target < 0) {
			return;
		}
		if (target > 0) {
			for (int i = start; i < candidates.length; i++) {
				contains.add(candidates[i]);
				helper(i + 1, target - candidates[i], candidates, result, contains);
				contains.remove(contains.size() - 1);
			}
		}
	}
}
