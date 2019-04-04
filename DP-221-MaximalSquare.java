class Solution {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 ||
			matrix[0].length == 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int res = 0;
		int[][] b = new int[2][n + 1];
		for (int i = 1; i <= m; i++) {
			int t = i % 2;
			for (int j = 1; j <= n; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					b[t][j] = Math.min(
						Math.min(b[t][j - 1], b[1 - t][j - 1]),
						b[1 - t][j]) + 1;
					res = Math.max(res, b[t][j]);
				}
			}
		}
		return res * res;
	}
}



















































