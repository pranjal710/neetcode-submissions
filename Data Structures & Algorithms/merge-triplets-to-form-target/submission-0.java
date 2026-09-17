class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean present = false;
        int[] result = null;
        for(int i = 0 ; i < triplets.length && !present; i++) {
            present = isSame(triplets[i], target);
            if(!present && result == null) {
                result = triplets[i];
            } else {
                if(!present && shouldConsider(triplets[i], target)) {
                    result[0] = Math.max(result[0], triplets[i][0]);
                    result[1] = Math.max(result[1], triplets[i][1]);
                    result[2] = Math.max(result[2], triplets[i][2]);
                    present = isSame(result, target);
                }
            }
        }
        return present;
    }

    public boolean shouldConsider(int[] source, int[] target) {
        return source[0] <= target[0]
        && source[1] <= target[1]
        && source[2] <= target[2];
    }

    public boolean isSame(int[] source, int[] target) {
        return source[0] == target[0]
        && source[1] == target[1]
        && source[2] == target[2];
    }
}
