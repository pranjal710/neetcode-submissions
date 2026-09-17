class Solution {
    private int find(int child, int[] parent) {
        if(parent[child] == child) {
            return child;
        } else {
            parent[child] = find(parent[child], parent);
            return parent[child];
        }
    }

    private void union(int c1, int c2, int[] parent) {
        int c1Parent = find(c1, parent);
        int c2Parent = find(c2, parent);
        parent[Math.max(c1Parent, c2Parent)] = find(Math.min(c1Parent, c2Parent), parent);
        parent[Math.max(c1, c2)] = find(Math.min(c1, c2), parent);
    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length+1];
        for(int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }
        for(int[] e : edges) {
            if(find(e[0], parent) == find(e[1], parent)) {
                return e;
            } else {
                union(e[0], e[1], parent);
            }
            for(int i = 0 ; i < parent.length; i++) System.out.print(parent[i] + " ");
            System.out.println();
        }
        return null;
    }
}
