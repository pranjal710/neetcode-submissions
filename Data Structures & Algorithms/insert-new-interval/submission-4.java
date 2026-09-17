class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for(int[] interval : intervals) {
            if(newInterval!= null && before(newInterval, interval)) {
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            } else if(newInterval!= null && (overlap(newInterval, interval) || overlap(interval, newInterval))) {
                newInterval = merge(newInterval, interval);
            } else {
                res.add(interval);
            }
        }
        if(newInterval != null) {
            res.add(newInterval);
        }
        return res.toArray(new int[res.size()][2]);
    }

    private boolean before(int[] a, int[] b) {
        return (a[1] < b[0]);
    }

    private boolean overlap(int[] a, int[] b) {
        return (b[0] <= a[0] && b[1] >= a[0]) || (b[0] <= a[1] && b[1] >= a[1]);
    }

    private int[] merge(int[] a, int[] b) {
        return new int[]{Math.min(a[0], b[0]), Math.max(a[1], b[1])};
    }
}
