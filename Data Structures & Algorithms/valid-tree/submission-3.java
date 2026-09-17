class Solution {
    private Set<int[]> getNeighbours(int[] removed,Map<Integer, Set<Integer>> graph, Set<Integer> allVertices) {
        return graph.getOrDefault(removed[0], new HashSet<>()).stream().filter(x -> x != removed[1])
        .filter(x -> allVertices.contains(x)).collect(Collectors.toSet()).stream()
        .map(x -> new int[]{x, removed[0]}).collect(Collectors.toSet())
        ;
    }

    private Map<Integer, Set<Integer>> construct(int[][] edges) {
        Map<Integer, Set<Integer>> resp = new HashMap<>();
        for(int[] e : edges) {
            if(!resp.containsKey(e[0])) {
                resp.put(e[0], new HashSet<>());
            }
            if(!resp.containsKey(e[1])) {
                resp.put(e[1], new HashSet<>());
            }
            resp.get(e[0]).add(e[1]);
            resp.get(e[1]).add(e[0]);
        }
        return resp;
    }

    private boolean selfNode(int[][] edges) {
        for(int[] e : edges) {
            if(e[0] == e[1]) return true;
        }
        return false;
    }

    public boolean validTree(int n, int[][] edges) {
        if(selfNode(edges)) return false;
        Map<Integer, Set<Integer>> graph = construct(edges);
        Set<Integer> allVertices = new HashSet<>();
        for(int i = 0 ; i < n ; i++) allVertices.add(i);
        while(allVertices.size() > 0) {
            int curr = allVertices.iterator().next();
            Set<Integer> visited = new HashSet<>();
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{curr, curr});
            while(q.size() > 0) {
                int[] removed = q.remove();
                System.out.println(curr + " " + removed[0] + " " + visited);
                if(!visited.add(removed[0])) {
                    return false;
                } else {
                    q.addAll(getNeighbours(removed, graph, allVertices));
                }
            }
            allVertices.removeAll(visited);
            if(allVertices.size() > 0) return false;
        }
        return true;
    }
}
