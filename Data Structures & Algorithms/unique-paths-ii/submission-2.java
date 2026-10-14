class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        return recurse(0, 0, obstacleGrid, dp);
    }

    private boolean isAllowed(int i, int j, int[][] obstacleGrid) {
        return i >= 0 && i < obstacleGrid.length && j >= 0 && j < obstacleGrid[0].length
        && obstacleGrid[i][j] != 1;
    }

    private int recurse(int x, int y, int[][] obstacleGrid, int[][] dp) {
        if(!isAllowed(x, y, obstacleGrid)) {
            return 0;
        } else if(x == obstacleGrid.length-1 && y == obstacleGrid[0].length-1) {
            return 1;
        } else if(dp[x][y] > 0) {
            return dp[x][y];
        }
         else {
            dp[x][y] = recurse(x+1, y, obstacleGrid, dp) + recurse(x, y+1, obstacleGrid, dp);
            return dp[x][y];
        }
    }
}