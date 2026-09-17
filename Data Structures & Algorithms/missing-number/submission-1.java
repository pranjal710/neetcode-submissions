class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int n: nums) sum += n;
        int expected = (nums.length)*(nums.length+1)/2;
        return (sum == expected) ? 0 : expected - sum;
    }
}
