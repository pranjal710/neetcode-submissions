class Solution {
    public List<int[]> getChildren(int[]coord, int[][] grid) {
        List<int[]> res = new ArrayList<>();
        int x = coord[0];
        int y = coord[1];
        if(x-1 >= 0 && grid[x-1][y] == 2147483647)  {
            res.add(new int[]{x-1, y});
        }
        if(x+1 < grid.length && grid[x+1][y] == 2147483647)  {
            res.add(new int[]{x+1, y});
        }
        if(y-1 >= 0 && grid[x][y-1] == 2147483647)  {
            res.add(new int[]{x, y-1});
        }
        if(y+1 < grid[x].length && grid[x][y+1] == 2147483647)  {
            res.add(new int[]{x, y+1});
        }

        return res;
    }

    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < grid.length; i++) {
            for(int j = 0 ; j < grid[i].length; j++) {
                if(grid[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }

        int distance = 0;
        while(q.size() > 0) {
            int size = q.size();
            while(size-- > 0) {
                int[] coord = q.remove();
                grid[coord[0]][coord[1]] = Math.min(grid[coord[0]][coord[1]], distance);
                List<int[]> ch = getChildren(coord, grid);
                for(int[] c: ch) q.add(c);
            }
            distance++;
        }
    }
}
