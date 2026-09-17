class Solution {
    public boolean canJump(int[] nums) {
        int last = 0, curr = 0;
        while(last != nums.length-1 && curr <= last) {
            last = Math.max(last, nums[curr]+curr );
            curr++;
            last = last >= nums.length ? nums.length-1 : last;
        }
        return last == nums.length -1;
    }
}
