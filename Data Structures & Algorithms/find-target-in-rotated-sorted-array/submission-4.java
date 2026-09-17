class Solution {
    private int getIndex(int curr, int step, int[] nums) {
        int index = curr+ step;
        while(index < 0) {
            index = nums.length + index;
        }
        
        if(index > nums.length) {
            return index%nums.length;
        } return index;
    }

    public int search(int[] nums, int target) {
        int left = 0 , right = nums.length-1, mid = 0, counter = 0;
        while(left <= right && counter++ < 20) {
            if(left +1 == right) {
                if(target == nums[left]) {
                    return left;
                }
                if(target == nums[right]) {
                    return right;
                }
                return -1;
            }
            System.out.println(left + ", " + mid + ", " + right);
            if(nums[left] == target) {
                return left;
            } else if(nums[right] == target) {
                return right;
            } else {
                mid = left + (right-left)/2;
                System.out.println(mid);
                if(nums[mid] == target) {
                    return mid;
                } else {
                    if(target > nums[left] && target < nums[mid]) {
                        right = mid-1;
                    } else if(target > nums[mid] && target < nums[right]) {
                        left = mid+1;
                    } else if (target < nums[mid] && nums[left] > nums[mid]) {
                        right = mid-1;
                    } else if (target > nums[mid] && nums[mid] > nums[right]) {
                        left = mid+1;
                    } else if(target < nums[left] && nums[left] > nums[right]) {
                        left = mid+1;
                    } else if(target > nums[right] && nums[left] > nums[right]) {
                        right = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
}
