/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        int max = 0;
        int currCount = 0;
        for(Interval i : intervals) {
            q.add(new int[]{i.start, 1});
            q.add(new int[]{i.end, -1});
        }
        while(q.size() > 0) {
            int[] curr = q.remove();
            currCount += curr[1];
            max = Math.max(max, currCount);
        }
        return max;
    }
}
