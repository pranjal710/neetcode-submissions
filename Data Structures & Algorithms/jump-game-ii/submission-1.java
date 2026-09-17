class Solution {
    public int jump(int[] nums) {
        int l = 0, r = 0;
        int res = 0;
        while (r < nums.length - 1) {
            int maxJump = 0;
            for (int i = l; i <= r; i++) {
                maxJump = Math.max(maxJump, i + nums[i]);
            }
            l = r + 1;
            r = maxJump;
            res++;
        }
        return res;
    }
    public int jump1(int[] nums) {
        int[] minSteps = new int[nums.length];
        for(int i = 0 ; i < nums.length; i++) {
            if(i == 0 || minSteps[i] != 0) {
                updateSteps(minSteps, nums, i+1);
            }
        }
        return minSteps[nums.length - 1];
    }

    public void updateSteps(int[] minSteps, int[] nums, int index) {
        for(int i = index; i < index + nums[index - 1] && i < nums.length; i++) {
            minSteps[i] = minSteps[i] == 0 ? minSteps[index-1] + 1 :
            Math.min(minSteps[i], minSteps[index-1] + 1);
        }
    }
}
