class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        int mid = l + (r-l)/2;
        while(l <= r ) {
            mid = l + (r-l)/2;
            System.out.println(l + " " + r + " " + mid);
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }    
}
/*
[-1,0,2,4,6,8]
[0  1 2 3 4 5]
mid = 
*/