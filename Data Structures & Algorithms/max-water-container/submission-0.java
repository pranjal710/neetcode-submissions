class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int maxWater = 0;
        while(left < right) {
            int volume = 0;
            if(heights[left] < heights[right]) {
                volume = heights[left] * (right - left);
                left++;
            } else {
                volume = heights[right] * (right - left);
                right--;
            }
            maxWater = volume > maxWater ? volume : maxWater;
        }
        return maxWater;
    }
}
