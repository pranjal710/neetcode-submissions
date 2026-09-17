class Solution {
    private List<int[]> getNeighbours(Set<Integer> visited, int[] curr, Map<Integer, List<int[]>> srcToDstGraph) {
        return srcToDstGraph.getOrDefault(curr[0], new ArrayList<>()).stream().map(x -> new int[]{x[1], curr[1]+1, curr[2]+x[2]})
        .collect(Collectors.toList());
    }

    private Map<Integer, List<int[]>> getGraph(int[][] flights) {
        return Arrays.stream(flights).collect(Collectors.groupingBy(x -> x[0]));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> srcToDstGraph = getGraph(flights);
        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[2]-b[2]);
        q.add(new int[]{src, 0, 0});
        Set<Integer> visited = new HashSet<>();
        while(q.size() > 0) {
            int[] curr = q.remove();
            //0 - index , 1 = stops, 2 - price
            if(curr[1] <= k+1) {
                if(curr[0] == dst) {
                    return curr[2];
                }
                //if(visited.add(curr[0])) {
                    List<int[]> neighbours = getNeighbours(visited, curr, srcToDstGraph);
                    q.addAll(neighbours);
                //}
            }
        }
        return -1;
    }
}
