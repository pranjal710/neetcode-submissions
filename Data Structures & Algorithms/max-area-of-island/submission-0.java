class Solution {
    public int area(int i, int j, int[][] grid) {
        if(i < 0 || i == grid.length || j < 0 || j == grid[i].length) {
            return 0;
        } else{
            if(grid[i][j] == 1) {
                grid[i][j] = 0;
                return 1 + area(i-1, j, grid) + area(i+1, j, grid) + area(i, j-1, grid) + area(i, j+1, grid);
            } else {
                return 0;
            }
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i = 0 ; i < grid.length; i++) {
            for(int j = 0 ; j < grid[i].length; j++) {
                maxArea = Math.max(maxArea, area(i, j, grid));
            }
        }
        return maxArea;
    }
}
