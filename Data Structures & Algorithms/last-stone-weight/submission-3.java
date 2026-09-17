class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> q = new PriorityQueue<>((a,b) -> b-a);
        for(int s : stones) q.add(s);
        while(q.size() > 1) {
            int x = q.remove();
            int y = q.remove();
            if(x != y) {
                q.add(Math.max(x, y)-Math.min(x, y));
            }
        }
        return q.size() == 0 ? 0 : q.remove();
    }
}
