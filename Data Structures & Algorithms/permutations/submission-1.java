class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new HashSet<>(), new ArrayList<>(), nums);
        return result;
    }

    private void dfs(List<List<Integer>> result, Set<Integer> visited, List<Integer> current, int[] nums) {
        if(visited.size() == nums.length) {
            result.add(new ArrayList<>(current));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(visited.add(i)) {
                    current.add(nums[i]);
                    dfs(result, visited, current, nums);
                    current.remove(current.size()-1);
                    visited.remove(i);
                }
            }
        }
    }
}
