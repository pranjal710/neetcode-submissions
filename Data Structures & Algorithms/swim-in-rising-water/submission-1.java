class Solution {
    public int swimInWater(int[][] grid) {
        int[] curr = new int[]{0,0, grid[0][0]};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        pq.add(curr);
        grid[0][0] = -1;
        int max = 0;
        while(pq.size() > 0 && (curr[0] != grid.length-1 || curr[1] != grid[0].length-1)) {
            curr = pq.remove();
            max = Math.max(curr[2], max);
            List<int[]> neighbours = getNeighbours(curr, grid);
            pq.addAll(neighbours);
        }
        return max;
    }

    private List<int[]> getNeighbours(int[] curr, int[][] grid) {
        List<int[]> resp = new ArrayList<>();
        if(check(grid, curr[0]-1, curr[1])) add(curr[0]-1, curr[1], grid, resp);
        if(check(grid, curr[0]+1, curr[1])) add(curr[0]+1, curr[1], grid, resp);
        if(check(grid, curr[0], curr[1]-1)) add(curr[0], curr[1]-1, grid, resp);
        if(check(grid, curr[0], curr[1]+1)) add(curr[0], curr[1]+1, grid, resp);
        return resp;
    }

    private boolean check(int[][] grid, int i, int j) {
        return i >=0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] != -1;
    }

    private void add(int i, int j, int[][] grid, List<int[]> resp) {
        resp.add(new int[]{i, j, grid[i][j]});
        grid[i][j] = -1;
    }
}
