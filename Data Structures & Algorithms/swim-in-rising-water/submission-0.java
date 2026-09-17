class Solution {
    private void addAndUpdate(int[] left, int[][] visited, List<int[]> result) {
        if(visited[left[0]][left[1]] != 1) {
            result.add(left);
            visited[left[0]][left[1]] = 1;
        }
    }

    private List<int[]> getChildren(int[] curr, int[][] visited) {
        int[] left = new int[]{curr[0]-1, curr[1]};
        int[] right = new int[]{curr[0]+1, curr[1]};
        int[] top = new int[]{curr[0], curr[1]-1};
        int[] bottom = new int[]{curr[0], curr[1]+1};
        List<int[]> result = new ArrayList<>();
        if(left[0] >= 0) {
            //System.out.print("1");
            addAndUpdate(left, visited, result);
        }
        if(right[0] < visited[0].length) {
            //System.out.print("2");
            addAndUpdate(right, visited, result);
        }
        if(top[1] >= 0) {
            //System.out.print("3");
            addAndUpdate(top, visited, result);
        }
        if(bottom[1] < visited.length) {
            //System.out.print("4");
            addAndUpdate(bottom, visited, result);
        }
        return result;
    }

    public int swimInWater(int[][] grid) {
        if(grid.length == 0) return 0;

        int maxTime = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]] );
        int[] curr = new int[]{0,0};
        visited[0][0] = 1;
        q.add(curr);
        while(q.size() > 0 && (curr[0] != grid.length - 1 || curr[1] != grid[0].length-1 )) {
            curr = q.remove();
            maxTime = Math.max(maxTime, grid[curr[0]][curr[1]]);
            List<int[]> children = getChildren(curr, visited);
            for(int[] c : children) q.add(c);
        }
        System.out.println(maxTime + " " + curr[0] + " " + curr[1]);
        maxTime = Math.max(maxTime, grid[curr[0]][curr[1]]);
        return maxTime;
    }
}
