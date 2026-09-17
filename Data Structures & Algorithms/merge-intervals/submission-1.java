class Solution {
    private boolean overlap(int[] a, int[] b) {
        return (a[0] <= b[0] && a[1] >= b[0]) || (b[0] <= a[0] && b[1] >= a[0]);
    }

    private int[] merge(int[] a, int[] b) {
        return new int[]{Math.min(a[0], b[0]), Math.max(a[1], b[1])};
    }

    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[0] - b[0] );
        for(int[] x : intervals) q.add(x);
        Deque<int[]> result = new LinkedList<>();
        while(q.size() > 0) {
            int[] curr = q.remove();
            while(result.size() > 0 && overlap(result.peekLast(), curr)) {
                int[] merged = merge(result.peekLast(), curr);
                result.removeLast();
                curr = merged;
            }
            result.addLast(curr);
        }
        int[][] resp = new int[result.size()][2];
        int index = 0;
        while(result.size() > 0) {
            int[] curr = result.removeFirst();
            resp[index][0] = curr[0];
            resp[index][1] = curr[1];
            index++;
        }
        return resp;
    }
}
