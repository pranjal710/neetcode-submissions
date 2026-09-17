class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int product = 1;
        int zeroCount = 0;
        for(int i = 0 ; i < nums.length; i++) {
            if(nums[i] != 0) {
                product *= nums[i];
            } else {
                zeroCount++;
            }
        }
        for(int i = 0 ; i < nums.length; i++) {
            if(nums[i] == 0) {
                if(zeroCount > 1) {
                    result[i] = 0;
                } else {
                    result[i] = product;
                }
            } else {
                result[i] = zeroCount > 0 ? 0 : product/nums[i];
            }
            
        }

        return result;
    }
}