class Solution {
    public int rob(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        int max = 0;
        for(int i = 0 ; i < nums.length; i++) {
            result[i] = nums[i];
            result[i] = Math.max(result[i] + ((i-2) >= 0 ? result[i-2] : 0), ((i-1) >= 0 ? result[i-1] : 0));
        }
        return result[nums.length-1];
    }
}
