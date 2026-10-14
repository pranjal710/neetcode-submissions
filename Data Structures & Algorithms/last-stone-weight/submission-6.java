class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i : stones) {
            pq.add(i);
        }
        while(pq.size() > 1) {
            int a = pq.remove();
            int b = pq.remove();
            int diff =  a-b;
            if(diff > 0) pq.add(diff);
        }
        return pq.size() > 0 ? pq.remove() : 0;
    }
}
