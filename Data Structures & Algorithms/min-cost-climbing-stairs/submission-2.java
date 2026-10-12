class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] stairs = new int[cost.length+1];
        if(cost.length < 2) {
            return 0;
        } else {
            stairs[0] = 0;
            stairs[1] = 0;
        }
        for(int i = 2; i < stairs.length; i++) {
            stairs[i] = Math.min(stairs[i-1]+cost[i-1], stairs[i-2]+cost[i-2]);
        }
        return stairs[stairs.length-1];
    }
}
