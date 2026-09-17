class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length == 0) {
            return false;
        } else {
            int sum = nums[0];
            int max = sum;
            for(int i = 1 ; i < nums.length; i++) {
                sum += nums[i];
                max = Math.max(max, nums[i]);
            }
            if(sum%2 != 0 || max > sum/2) {
                return false;
            } else {
                int target = sum/2;
                Set<Integer> listOfSum = new HashSet<>();
                listOfSum.add(0);
                for(int n : nums) {
                    Set<Integer> tempSet = new HashSet<>();
                    for(int x : listOfSum) {
                        int currSum = x + n;
                        System.out.println(x + " " + n + " " + currSum + " " + target);
                        if(currSum == target) {
                            return true;
                        } else {
                            tempSet.add(currSum);
                        }
                    }
                    listOfSum.addAll(tempSet);
                }
                return false;
            }
        }
    }
}
