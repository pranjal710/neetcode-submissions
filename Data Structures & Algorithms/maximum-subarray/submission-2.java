class Solution {

    private boolean allNegativeOrZero(int[] nums) {
        for(int i = 0 ; i < nums.length; i++ ) {
            if(nums[i] > 0) {
                return false;
            }
        }
        return true;
    }

    private int maxElement(int[] nums) {
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    private int getFirstPositiveIndex(int[] nums) {
        for(int i = 0 ; i < nums.length; i++) {
            if(nums[i] >= 0) {
                return i;
            }
        }
        return -1;
    }

    public int maxSubArray(int[] nums) {
        if(nums.length == 0) {
            return 0;
        } else if(allNegativeOrZero(nums)) {
            return maxElement(nums);
        } else {
            int ind = getFirstPositiveIndex(nums);
            int max = nums[ind];
            int sumUntilNow = max;
            for(int i = ind+1 ; i < nums.length; i++) {
                int temp = sumUntilNow + nums[i];
                if(nums[i] >= 0 || ( temp > 0 && temp >= nums[i])) {
                    sumUntilNow = temp;
                } else {
                    sumUntilNow = Math.max(0, nums[i]);
                }
                max = Math.max(max, sumUntilNow);
                // System.out.println(sumUntilNow + " " + i + " " + max);
            }
            return max;
        }
    }
}
