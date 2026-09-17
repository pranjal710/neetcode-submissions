class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][2];
        return recurse(prices, 0, 1, false, dp);
    }

    private int holdsToIn(boolean hold) {
        return hold ? 1 : 0;
    }

    private int recurse(int[] prices, int curr, int daysLastSold, boolean holds, int[][][] dp) {
        int x = 0;
        int secondIndex = holds ? 1 : 0;
        int thirdIndex =  daysLastSold > 0 ? 1 : 0;
        if(curr == prices.length) {
            return 0;
        } else if(dp[curr][secondIndex][thirdIndex] > 0) {
            return dp[curr][secondIndex][thirdIndex];
        } else if(holds) {
            dp[curr][secondIndex][thirdIndex] = 
                Math.max(prices[curr]+recurse(prices, curr+1, 0, false, dp), 
                recurse(prices, curr+1, 0, true, dp));
        } else if(!holds && daysLastSold == 0) {
            dp[curr][secondIndex][thirdIndex] = recurse(prices, curr+1, ++daysLastSold, false, dp);
        } else {
            dp[curr][secondIndex][thirdIndex] = 
                Math.max(recurse(prices, curr+1, 0, true, dp)-prices[curr], 
                recurse(prices, curr+1, ++daysLastSold, false, dp));
        }

        return dp[curr][secondIndex][thirdIndex];
    }
}
