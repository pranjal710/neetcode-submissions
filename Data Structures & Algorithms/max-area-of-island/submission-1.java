class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0 ; i < grid.length; i++) {
            for(int j = 0 ; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(max, getArea(grid, i, j));
                }
            }
        }
        return max;
    }

    private int getArea(int[][] grid, int i, int j) {
        if(i == grid.length || j == grid[0].length || i < 0 || j < 0) {
            return 0;
        } else if (grid[i][j] == 0) {
            return 0;
        } else {
            grid[i][j] = 0;
            return 1 + getArea(grid, i+1, j)
            + getArea(grid, i-1, j)
            + getArea(grid, i, j+1)
            + getArea(grid, i, j-1);
        }
    }
}
