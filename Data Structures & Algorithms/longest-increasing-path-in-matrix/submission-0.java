class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0 ; i < dp.length; i++) {
            for(int j = 0 ; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        int max = 0;
        for(int i = 0 ; i < matrix.length; i++) {
            for(int j = 0 ; j < matrix[0].length; j++) {
                if(dp[i][j] == -1) {
                    dfs(matrix, i, j, dp);
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        for(int i = 0 ; i < dp.length; i++) {
            for(int j = 0 ; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println(" ");
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] dp) {
        if(i == matrix.length || j == matrix[0].length) {
            return 0;
        } else if(dp[i][j] > -1) {
            return dp[i][j];
        } else {
            dp[i][j] = -2;
            List<int[]> children = getChildren(matrix, i, j, dp);
            int max = 0;
            for(int[] ch : children) {
                max = Math.max(max, dfs(matrix, ch[0], ch[1], dp));
            }
            dp[i][j] = max+1;
            return dp[i][j];
        }
    }

    private List<int[]> getChildren(int[][] matrix, int i, int j, int[][] dp) {
        List<int[]> res = new ArrayList<>();
        checkAndAdd(res, i+1, j, dp, matrix, matrix[i][j]);
        checkAndAdd(res, i-1, j, dp, matrix, matrix[i][j]);
        checkAndAdd(res, i, j+1, dp, matrix, matrix[i][j]);
        checkAndAdd(res, i, j-1, dp, matrix, matrix[i][j]);
        return res;
    }

    private void checkAndAdd(List<int[]> res, int i, int j, int[][] dp, int[][] matrix, int curr) {
        if(valid(i, j, matrix, dp) && matrix[i][j] > curr) {
            res.add(new int[]{i, j});
        }
    }

    private boolean valid(int i, int j, int[][] matrix, int[][] dp) {
        return i >= 0 && j >= 0 && i < matrix.length && j < matrix[0].length && dp[i][j] != -2;
    }
}