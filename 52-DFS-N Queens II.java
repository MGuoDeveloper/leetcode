/*
Follow up for N-Queens problem.
Now, instead outputting board configurations,
return the total number of distinct solutions.
这个不需要回溯，只是通过累加，如果不能合理到达底部，则返回0，
到达底部
*/

class Solution {
  public int totalNQueens (int n) {
    if (n <= 1) return n;
    return helper(n, 0, new int[n]);
  }

  private int helper (int n, int row, int[] record) {
  	if (row == n) {
  		return 1;
  	}
    int res = 0;
  	for (int j = 0; j < n; j++) {
  		record[row] = j;
  		if (isValid(row, record)) {
  			res += helper(n, row + 1, record);
  		}
  	}
    //每行可行方案数量，逐层叠加
    return res;
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
}