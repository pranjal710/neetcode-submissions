class Solution {
    private List<int[]> getChildren(int[] curr, int[][] grid) {
        int row = grid.length, col = grid[0].length, x = curr[0], y = curr[1];
        List<int[]> result = new ArrayList<>();
        if(x-1 >= 0) {
            result.add(new int[]{x-1,y});
        }
        if(x+1 < row) {
            result.add(new int[]{x+1,y});
        }
        if(y-1 >= 0) {
            result.add(new int[]{x,y-1});
        }
        if(y+1 < col) {
            result.add(new int[]{x,y+1});
        }
        return result;
    }


    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i = 0 ; i < grid.length; i++) {
            for(int j = 0 ; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int origFresh = fresh;
        int time = 0;
        while(q.size() > 0) {
            int qSize = q.size();
            time++;
            System.out.println("----" + time + "----");
            while(qSize-- > 0) {
                int[] curr = q.remove();
                System.out.println(curr[0] + " " + curr[1]);
                List<int[]> children = getChildren(curr, grid);
                for(int[] ch : children) {
                    if(grid[ch[0]][ch[1]] == 1) {
                        grid[ch[0]][ch[1]] = 2;
                        fresh--;
                        q.add(ch);
                    }
                }
            }
        }
        return origFresh > 0 ? fresh == 0 ? time - 1 : -1 : 0;
    }
}
