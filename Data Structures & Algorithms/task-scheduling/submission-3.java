class Solution {
    

    

        private Map<Integer, Integer> getFrequency(char[] tasks) {
            Map<Integer, Integer> map = new HashMap<>();
            for(char ch: tasks) {
                int curr = ch-'A';
                map.put(curr, map.getOrDefault(curr, 0)+1);
            }
            return map;
        }

        private void addToQueue(Map<Integer, Integer> freq, Queue<int[]> pendingQueue) {
            for(int k : freq.keySet()) {
                pendingQueue.add(new int[]{k, freq.get(k)});
            }
        }

        private void updatePendingWithStandBy(Queue<int[]> pendingQueue, Queue<int[]> standby, int curr) {
            while(standby.size() > 0 && standby.peek()[2] <= curr) {
                pendingQueue.add(standby.remove());
            }
        }

        private void transferToStandby(int[] curr, Queue<int[]> standby, int currTime, int n) {
            if(curr[1] > 1)
            standby.add(new int[]{curr[0], curr[1]-1, currTime+n+1});
        }


    public int leastInterval(char[] tasks, int n) {
        Map<Integer, Integer> freq = getFrequency(tasks);
        int currtime = 0;
        // 0 - char 1 - freq
        Queue<int[]> pendingQueue = new PriorityQueue<>((a,b) -> b[1] - a[1]) ;//decreasing
        addToQueue(freq, pendingQueue);
        //0 - char, 1 - freq, 2 - nextTime
        Queue<int[]> standby = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        while(pendingQueue.size() > 0 || standby.size() > 0) {
            currtime++;
            updatePendingWithStandBy(pendingQueue, standby, currtime);
            if(pendingQueue.size() > 0) {
                transferToStandby(pendingQueue.remove(), standby, currtime, n);
            } else {
                currtime = standby.peek()[2]-1;
            }
        }
        return currtime;
    }
}
