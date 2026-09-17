class Solution {
    public void fillIsland(int i, int j, char[][] grid) {
        if(i < 0 || i == grid.length || j < 0 || j == grid[i].length) {
            return;
        }
        if(grid[i][j] == '1') {
            grid[i][j] = '0';
        
            fillIsland(i+1, j, grid);
            fillIsland(i-1, j, grid);
            fillIsland(i, j+1, grid);
            fillIsland(i, j-1, grid);
        }
    }

    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int i = 0 ; i < grid.length; i++) {
            for(int j = 0 ; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    fillIsland(i, j, grid);
                    islands++;
                }
            }
        }
        return islands;
    }
}
