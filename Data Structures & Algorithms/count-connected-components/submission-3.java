class Solution {
    private int find(int c, int[] parent) {
        if(parent[c] == c) {
            return c;
        } else {
            int p = find(parent[c], parent);
            parent[c] = p;
            return p;
        }
    }

    private void union(int c1, int c2, int[] parent) {
        int pc1 = find(c1, parent);//4-1
        int pc2 = find(c2, parent);//3-3
        parent[Math.min(pc1, pc2)] = find(Math.max(pc1, pc2), parent);
        // int tempParent = find(Math.min(c1, c2), parent);
        // if(parent[Math.max(c1, c2)] != Math.max(c1, c2) && parent[Math.max(c1, c2)] != tempParent) {
        //     union(tempParent, Math.min(c1, c2), parent);
        // }
        parent[Math.max(c1, c2)] = find(Math.min(c1, c2), parent);
    }

    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for(int i = 0 ; i < n; i++) parent[i] = i;
        for(int[] e : edges) {
            union(e[0], e[1], parent);
        }
        Set<Integer> distinctParent = new HashSet<>();
        for(int i = 0 ; i < n; i++) distinctParent.add(find(i, parent));
        System.out.println(distinctParent);
        return distinctParent.size();
    }
}
