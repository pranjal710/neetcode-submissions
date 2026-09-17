class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();
        backtrack(result, 0, nums, new ArrayList<>(), 0, target);
        return new ArrayList<>(result);
    }

    private void backtrack(Set<List<Integer>> result, int index, int[] nums, List<Integer> current, int runningSum, int target) {
        if(runningSum == target) {
            result.add(new ArrayList<>(current));
        } else if(index == nums.length || runningSum > target) {
            return;
        } else {
            for(int i = index; i < nums.length; i++) {
                current.add(nums[i]);
                backtrack(result, i, nums, current, runningSum+nums[i], target);
                current.remove(current.size() -1);
                backtrack(result, i+1, nums, current, runningSum, target);
            }
        }
    }
}
