class Solution {
    private Map<Integer, List<int[]>> getRoutes(int[][] times) {
        return Arrays.stream(times).collect(Collectors.groupingBy(t -> t[0]));
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        Map<Integer, List<int[]>> routes = getRoutes(times);
        q.add(new int[]{k, 0});
        int time = 0;
        while(q.size() > 0) {
            int[] curr = q.remove();
            visited.add(curr[0]);
            if(visited.size() == n) {
                return curr[1];
            } else {
                List<int[]> destinations = routes.getOrDefault(curr[0], new ArrayList<>());
                for(int[] d : destinations) {
                    if(!visited.contains(d[1])) {
                        q.add(new int[]{d[1], d[2] + curr[1]});
                    }
                }
            }
        }
        return -1;
    }
}