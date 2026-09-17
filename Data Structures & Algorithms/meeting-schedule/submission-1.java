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
    private int[] getInstant(int time, boolean start) {
        return new int[]{time, start ? 1 : -1};
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        List<int[]> instant = new ArrayList<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            if(a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        for(Interval i : intervals) {
            q.add(getInstant(i.start, true));
            q.add(getInstant(i.end, false));
        }
        int sum = 0;
        while(q.size() > 0) {
            int[] i = q.remove();
            System.out.println(i[0] + " " + i[1]);
            sum += i[1];
            if(sum != 0 && sum != 1 && sum != -1) {
                return false;
            }
        }
        return true;

    }
}
