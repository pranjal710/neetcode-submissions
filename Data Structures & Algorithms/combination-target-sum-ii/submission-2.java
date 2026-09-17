class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] candidates, int target, int curr, List<Integer> currList) {
        if(target == 0 && currList.size() > 0) {
            res.add(new ArrayList<>(currList));
        } else if(target <= 0 || curr == candidates.length) {
            return;
        } else {
            currList.add(candidates[curr]);
            backtrack(res, candidates, target - candidates[curr], curr+1, currList);
            currList.remove(currList.size()-1);
            backtrack(res, candidates, target, getNextDifferent(candidates, curr), currList);
        }
    }

    private int getNextDifferent(int[] candidates, int curr) {
        int ind = curr;
        while(ind < candidates.length && candidates[curr] == candidates[ind])
            ind++;
        return ind;
    }
}
