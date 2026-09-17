class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        dfs(nums, 0, new ArrayList<>(), result);
        return new ArrayList<>(result);
    }

    public void dfs(int[] nums, int index, List<Integer> currList, Set<List<Integer>> result) {
        if(index == nums.length) {
            result.add(new ArrayList<>(currList));
        } else {
            result.add(new ArrayList<>(currList));
            dfs(nums, index+1, currList, result);
            currList.add(nums[index]);
            dfs(nums, index+1, currList, result);
            currList.remove(currList.size() - 1);
        }
    }
}
