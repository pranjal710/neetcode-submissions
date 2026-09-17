class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        } else {
            int mx = 1;
            int[] count = new int[nums.length];
            Arrays.fill(count, 1);
            for(int i = 0 ; i < nums.length ; i++) {
                for(int j = i+1; j < nums.length; j++) {
                    if(nums[j] > nums[i]) {
                        count[j] = Math.max(count[j], 1 + count[i]);
                        mx = Math.max(count[j], mx);
                    }
                }
            }
            return mx;
        }
    }
}
