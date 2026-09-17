class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = 1, maxNegative = 1, result = 0;
        boolean first = false;
        for(int i = 0 ; i < nums.length; i++) {
            maxProduct *= nums[i];
            if(i == 0) {
                result = Math.max(maxProduct, nums[i]);
            } else {
                result = Math.max(result, Math.max(maxProduct, nums[i]));
            }
            if(maxProduct == 0) maxProduct = 1;
        }
        return result;
    }
}
