class Solution {
    public int uniquePaths(int m, int n) {
        int[][] visited = new int[m][n];
        int i = 0, j = 0;
        int val = recur(i, j, m, n, visited);
        for(int i1 = 0; i1 < m; i1++) {
            for(int j1 = 0 ; j1 < n; j1++) {
                System.out.print(visited[i1][j1] + " ");
            }
            System.out.println(" ");
        }
        return val;
    }

    private boolean isValid(int i, int j, int m, int n) {
        return (i >= 0 && i < m && j >= 0 && j < n);
    }

    public int recur(int i, int j, int m, int n, int[][] visited) {
        if(!isValid(i, j, m, n)) {
            return 0;
        } else if(i == m-1 && j == n-1) {
            return 1;
        } else if(visited[i][j] == 0) {
            int totalPaths = recur(i, j+1, m, n, visited) + recur(i+1, j, m, n, visited);
            visited[i][j] = totalPaths;
        }
        return visited[i][j];
    }
}
