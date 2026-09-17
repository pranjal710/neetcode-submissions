class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Queue<int[]> q = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        int[] visited = new int[n];
        Map<Integer, Integer> minTimeMap = new HashMap<>();
        int minTime = 0;
        Map<Integer, List<int[]>> paths = new HashMap<>();
        for(int[] p : times) {
            List<int[]> temp = paths.getOrDefault(p[0], new ArrayList<>());
            temp.add(p);
            paths.put(p[0], temp);
            if(p[0] == k) {
                q.add(p);
            }
        }
        minTimeMap.put(k, 0);
        visited[k-1] = 1;

        while(q.size() > 0) {
            int[] newDestination = q.remove();
            if(!minTimeMap.containsKey(newDestination[1])) {
                visited[newDestination[1]-1] = 1;
                System.out.println(minTimeMap.get(newDestination[0]) + " " + newDestination[0] + " " + newDestination[1] + " " + newDestination[2]);
                minTimeMap.put(newDestination[1], newDestination[2]);
                minTime = Math.max(minTime, minTimeMap.get(newDestination[1]));
                for(int[] p : paths.getOrDefault(newDestination[1], new ArrayList<>())) {
                    // System.out.println("add: " + p[0] + " " + p[1] + " " + p[2]);
                    p[2] = minTimeMap.get(p[0]) + p[2];
                    System.out.println("add: " + minTimeMap.get(p[0]) + " " + p[0] + " " + p[1] + " " + p[2]);
                    q.add(p);
                }
            }
        }

        for(int x : visited) {
            if(x == 0) return -1;
        }
        return minTime;

    }
}
