class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, new HashSet<>(), new ArrayList<>(), result);
        return result;
    }

    public void dfs(int[] nums, Set<Integer> used, List<Integer> intermediateResult, List<List<Integer>> result) {
        if(intermediateResult.size() == nums.length) {
            result.add(new ArrayList<>(intermediateResult));
        } else {
            for(int i = 0 ; i < nums.length; i++) {
                if(!used.contains(i)) {
                    used.add(i);
                    intermediateResult.add(nums[i]);
                    dfs(nums, used, intermediateResult, result);
                    used.remove(i);
                    intermediateResult.remove(intermediateResult.size() -1);
                }
            }
        }
    }
}
