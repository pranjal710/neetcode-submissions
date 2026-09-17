class Solution {
    public int climbStairs(int n) {
        int[] steps = new int[n+1];
        if(n == 0) {
            return 0;
        } 
        if(n >= 1) {
            steps[1] = 1;
        } 
        if(n >= 2) {
            steps[2] = 2;
            for(int i = 3; i < steps.length; i++) {
                steps[i] = steps[i-1] + steps[i-2];
            }
        }
        return steps[n];
    }
}
