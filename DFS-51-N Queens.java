/*
The n-queens puzzle is the problem of placing n queens on
an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement,
where 'Q' and '.' both indicate a queen and an empty space respectively.

For example, There exist two distinct solutions to the 4-queens puzzle:

[
[".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],

["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
]
*/

class Solution {
  public List<List<String>> solveNQueens (int n) {
  	List<List<String>> result = new ArrayList<List<String>>();
    String[] lines = generateLines(n);
    helper(n, 0, lines, result, new int[n]);
    return result;
  }

  private void helper (int n, int row, String[] lines, List<List<String>> result, int[] record) {
  	if (row == n) {
  		ArrayList<String> queens = new ArrayList<String>();
  		for (int i = 0; i < n; i++) {
  			int col = record[i];
  			queens.add(lines[col]);
  		}
  		result.add(queens);
  		return;
  	}
  	for (int j = 0; j < n; j++) {
  		record[row] = j;
  		if (isValid(row, record)) {
  			helper(n, row + 1, lines, result, record);
  		}
  	}
  }

  private boolean isValid (int row, int[] record) {
  	int lastCol = record[row];
  	for (int x = 0; x < row; x++) {
  		int col = record[x];
  		if (lastCol == col || Math.abs(lastCol - col) == Math.abs(x - row))
  		  return false;
  	}
  	return true;
  }

  private String[] generateLines (int n) {
  	String[] lines = new String[n];
  	char[] cr = new char[n];
  	for (int i = 0; i < n; i++) {
  		cr[i] = '.';
  	}
  	String base = String.valueOf(cr);
  	for (int i = 0; i < n; i++) {
      StringBuilder sb = new StringBuilder(base);
	  	sb.setCharAt(i, 'Q');
	  	lines[i] = sb.toString();
  	}
  	return lines;
  }
}