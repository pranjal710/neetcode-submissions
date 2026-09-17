class Solution {
    public int minCostClimbingStairs1(int[] cost) {
        for(int i = cost.length - 3; i >=0 ; i--) {
            cost[i] += Math.min(cost[i+1], cost[i+2]);
        }
        return Math.min(cost[0], cost[1]);
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] cumCost = new int[cost.length];
        // cumCost[0] = 0;
        // cumCost[1] = Math.min(cost[0], cost[1]);
        for(int i = 2; i < cost.length; i++) {
            if(i == 2) {
                cumCost[i] = Math.min(cost[i-1], cost[i-2]);
            } else {
                cumCost[i] = Math.min(cumCost[i-1] + cost[i-1], cumCost[i-2] + cost[i-2]);
            }
            
        }
        return Math.min(cumCost[cost.length-1] + cost[cost.length-1], 
        cumCost[cost.length-2] + cost[cost.length-2]);
        
    }
}
