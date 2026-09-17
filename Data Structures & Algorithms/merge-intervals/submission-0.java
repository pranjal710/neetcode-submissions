class Solution {
    public boolean isToMergeBefore(int[] toMerge, int[] interval) {
        return toMerge[1] < interval[0];
    }

    public int[] merge(int[] toMerge, int[] interval) {
        return new int[]{
            Math.min(toMerge[0], interval[0]),
            Math.max(toMerge[1], interval[1])
        };
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        int[] toMerge = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            if(isToMergeBefore(toMerge, intervals[i])) {
                merged.add(toMerge);
                toMerge = intervals[i];
            } else {
                toMerge = merge(toMerge, intervals[i]);
            }
        }
        merged.add(toMerge);
        return merged.toArray(new int[0][2]);
    }
}
