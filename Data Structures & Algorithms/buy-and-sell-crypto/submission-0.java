class Solution {
    public int maxProfit(int[] prices) {
        int[] min = new int[prices.length];
        int[] max = new int[prices.length];
        min[0] = prices[0];
        for(int i = 1; i < prices.length; i++) {
            min[i] = Math.min(min[i-1], prices[i]);
        }

        max[prices.length-1] = prices[prices.length-1];
        for(int i = prices.length-2; i >= 0; i--) {
            max[i] = Math.max(min[i+1], prices[i]);
        }

        int mx = 0;
        for(int i = 0; i < prices.length; i++) {
            mx = Math.max(mx, max[i] - min[i]);
        }
        return mx;
    }
}
