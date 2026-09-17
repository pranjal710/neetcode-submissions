class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, 0, nums, new ArrayList<>());
        return result;
    }

    private void backtrack(List<List<Integer>> result, int index, int[] nums, List<Integer> current) {
        if(index == nums.length) {
            result.add(new ArrayList<>(current));
        } else {
            current.add(nums[index]);
            backtrack(result, index+1, nums, current);
            current.remove(current.size() -1);
            backtrack(result, index+1, nums, current);
        }
    }
}
