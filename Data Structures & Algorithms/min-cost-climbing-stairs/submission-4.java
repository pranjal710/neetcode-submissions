class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] stairs = new int[cost.length];
        if(cost.length < 2) {
            return 0;
        }
        int i = 2;
        for(i = 2; i < stairs.length; i++) {
            stairs[i] = Math.min(stairs[i-1]+cost[i-1], stairs[i-2]+cost[i-2]);
        }
        return Math.min(stairs[i-1]+cost[i-1], stairs[i-2]+cost[i-2]);
    }
}
