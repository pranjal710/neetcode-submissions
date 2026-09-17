class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] coinNum = new int[amount+1];
        for(int i = 1 ; i < coinNum.length ; i++) {
            int min = 9999999;
            for(int t : coins) {
                if(i == t) {
                    min = 0;
                } else {
                    min = Math.min(min, i-t < 1 ? 9999999 : coinNum[i - t]);
                }
            }
            coinNum[i] = min + 1;
        }
         for(int i = 1 ; i < coinNum.length ; i++) System.out.print(coinNum[i] + " ");
        return coinNum[amount] >= 9999999 ? -1 : coinNum[amount];
    }
}
