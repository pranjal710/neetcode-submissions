class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        int index = 0;
        int[] ingree = new int[numCourses];
        Map<Integer, List<Integer>> adjGraph = new HashMap<>();
        for(int[] p : prerequisites) {
            List<Integer> nodes = adjGraph.getOrDefault(p[1], new ArrayList<>());
            nodes.add(p[0]);
            adjGraph.put(p[1], nodes);
            ingree[p[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < ingree.length; i++) {
            if(ingree[i] == 0) {
                q.add(i);
            }
        }

        while(q.size() > 0) {
            int removed = q.remove();
            order[index++] = removed;
            List<Integer> nodes = adjGraph.getOrDefault(removed, new ArrayList<>());
            for(int n : nodes) {
                ingree[n]--;
                if(ingree[n] == 0) {
                    q.add(n);
                }
            }
        }
        if(index == order.length) {
            return order;
        } else {
            return new int[]{};
        }
    }
}
