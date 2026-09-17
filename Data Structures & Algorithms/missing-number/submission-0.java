class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int expectedSum = ((nums.length)*(nums.length+1))/2;
        for(int n : nums) sum += n;
        return expectedSum-sum;
        

    }
}
