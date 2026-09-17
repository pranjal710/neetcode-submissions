class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    public void dfs(int[] candidates, int index, int target, List<Integer> selected, List<List<Integer>> result) {
        if(target < 0) {
            return;
        } else if(index == candidates.length) {
            return;
        } else if(target == 0) {
            result.add(new ArrayList<>(selected));
        } else {
            dfs(candidates, index+1, target, selected, result);
            selected.add(candidates[index]);
            dfs(candidates, index, target-candidates[index], selected, result);
            selected.remove(selected.size()-1);
        }
    }
}