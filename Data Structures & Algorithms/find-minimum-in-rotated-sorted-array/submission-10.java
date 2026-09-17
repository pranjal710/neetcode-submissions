class Solution {
    private int getMid(int start, int end) {
        return start + (end-start)/2;
    }

    private boolean invalid(int[] nums, int mid) {
        int l = mid-1, r = mid + 1;
        if(l < 0) {
            l = nums.length-1;
        }
        if(r >= nums.length) {
            r = 0;
        }
        return nums[mid] > nums[l] || nums[mid] > nums[r];
    }

    public int findMin(int[] nums) {
        
        int start = 0, end = nums.length-1, mid = getMid(start, end);
        // if(nums[start] < nums[end]) {
        //     return nums[start];
        // }
        while(invalid(nums, mid) && nums[start] > nums[end]) {
            System.out.println(mid + " " + nums[mid] + " " + nums[start] + " " + nums[end]);
            if(nums[start] > nums[mid] && nums[end] > nums[mid]) {
                start = nums[start] > nums[end]? start : mid + 1;
                end = nums[start] > nums[end]? mid - 1 : end;
            } else {
                start = nums[start] > nums[end]? mid + 1 : start;
                end = nums[start] > nums[end]? end : mid -1 ;
            }
            start = start < 0 ? nums.length-1 : start;
            end = end > nums.length -1 ? 0 : end;
            end = end < 0 ? nums.length-1 : end;
            start = start > nums.length -1 ? 0 : start;
            mid = getMid(start, end);
            System.out.println(mid + "#" + nums[mid] + " " + nums[start] + " " + nums[end]);
        } 
        return Math.min(nums[mid], nums[start]);
    }
}
