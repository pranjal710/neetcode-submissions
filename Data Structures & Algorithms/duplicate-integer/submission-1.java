class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> dupes = new HashSet<>();
        for(int x : nums) {
            if(!dupes.add(x)) {
                return true;
            }
        }
        return false;
    }
}
