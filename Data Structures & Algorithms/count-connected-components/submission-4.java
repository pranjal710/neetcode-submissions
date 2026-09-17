class Solution {

    private int find(int[] parent, int p) {
        if(parent[p] == p) {
            return p;
        } else {
            int pr = find(parent, parent[p]);
            parent[p] = pr;
            return pr;
        }
    }

    private void union(int p0, int p1, int[] parent) {
        int pr = Math.min(p0, p1);
        parent[p0] = pr;
        parent[p1] = pr;
    }


    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int component = n;
        for(int i = 0 ; i < n ; i++) parent[i] = i;
        for(int[] e : edges) {
            int p0 = find(parent, e[0]);
            int p1 = find(parent, e[1]);
            if(p0 != p1) {
                component--;
                union(p0, p1, parent);
            }
        }
        return component;
    }
}
