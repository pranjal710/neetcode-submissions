class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> response = new ArrayList<>();
        int[] extra = newInterval;
        for(int[] curr : intervals) {
            if(extra == null) {
                response.add(curr);
            } else if(isBefore(extra, curr)) {
                response.add(extra);
                response.add(curr);
                extra = null;
            } else if(!overlap(extra, curr)) {
                response.add(curr);
            } else {
                extra = derive(extra, curr);
            }
        }
        if(extra != null) {
            response.add(extra);
        }
        return response.toArray(new int[response.size()][2]);
    }

    private int[] derive(int[] first, int[] second) {
        return new int[]{Math.min(first[0], second[0]), Math.max(first[1], second[1])};
    }

    private boolean overlap(int[] first, int[] second) {
        return (first[0] >= second[0] && first[0] <= second[1])
        || (second[0] >= first[0] && second[0] <= first[1]);
    }

    private boolean isBefore(int[] first, int[] second) {
        return first[1] < second[0];
    }
}
