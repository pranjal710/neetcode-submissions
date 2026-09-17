class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>(), res);
        return new ArrayList<>(res);
    }

    private void dfs(int[] candidates, int target, int index, List<Integer> current, Set<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList<>(current));
        } else if(index == candidates.length || target < 0) {
            return;
        } else {
            current.add(candidates[index]);
            dfs(candidates, target - candidates[index], index + 1, current, res);
            current.remove(current.size()-1);
            dfs(candidates, target, index + 1, current, res);
        }
    }
}
