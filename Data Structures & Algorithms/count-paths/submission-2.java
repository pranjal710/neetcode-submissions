class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0 ; i < m; i++) {
            for(int j = 0 ; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return dfs(0, 0, m, n, dp);
    }

    private int dfs(int i, int j, int m, int n, int[][] dp) {
        if(i == m || j == n) {
            return 0;
        } else if(i == m-1 && j == n-1) {
            return 1;
        }  else {
            dp[i][j] = dfs(i+1, j, m, n, dp) + dfs(i, j+1, m, n, dp);
            return dp[i][j];
        }
    }
}
