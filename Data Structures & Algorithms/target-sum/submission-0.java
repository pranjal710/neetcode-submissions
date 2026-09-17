class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, 0, target);
    }

    private int dfs(int[] nums, int index, int target) {
        if(index == nums.length && target != 0) {
            return 0;
        } else if(index == nums.length && target == 0) {
            return 1;
        } else {
            return dfs(nums, index+1, target + nums[index])
            + dfs(nums, index+1, target - nums[index]);
        }
    }
}
