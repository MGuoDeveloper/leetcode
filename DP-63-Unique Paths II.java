/*
Follow up for "Unique Paths":
Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.
For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.
[
 [0,0,0],
 [0,1,0],
 [0,0,0]
]
The total number of unique paths is 2.
*/

class Solution {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid == null) return 0;
    int rows = obstacleGrid.length;
    if (rows == 0) return 0;
    int cols = obstacleGrid[0].length;
    if (cols == 0 || obstacleGrid[0][0] == 1) return 0;

    int[][] dp = new int[rows][cols];
    int num = 1;
    for (int i = 0; i < rows; i++) {
    	if (obstacleGrid[i][0] == 1) {
    		num = 0;
    	}
    	dp[i][0] = num;
    }
    num = 1;
    for (int j = 0; j < cols; j++) {
    	if (obstacleGrid[0][j] == 1) {
    		num = 0;
    	}
    	dp[0][j] = num;
    }
    for (int i = 1; i < rows; i++) {
    	for (int j = 1; j < cols; j++) {
    		if (obstacleGrid[i][j] == 1) {
    			dp[i][j] = 0;
    		} else {
    			dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
    		}
    	}
    }
    return dp[rows - 1][cols - 1];
  }
}
