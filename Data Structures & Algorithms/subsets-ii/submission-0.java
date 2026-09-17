class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        dfs(nums, 0, new ArrayList<>(), result);
        return new ArrayList<>(result);
    }

    public void dfs(int[] nums, int index, List<Integer> intermediateResult, Set<List<Integer>> result) {
        List<Integer> clone = new ArrayList<>(intermediateResult);
        Collections.sort(clone);
        result.add(clone);
        if(index < nums.length) {
            dfs(nums, index+1, intermediateResult, result);
            intermediateResult.add(nums[index]);
            dfs(nums, index+1, intermediateResult, result);
            intermediateResult.remove(intermediateResult.size()-1);
        } 
    }
}
