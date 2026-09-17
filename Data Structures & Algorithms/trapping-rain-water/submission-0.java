class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int maxLeftIndex = 0;
        int maxRightIndex = height.length-1;
        for(int i = 0 ; i < height.length; i++) {
            if(height[i] >= height[maxLeftIndex]) {
                maxLeftIndex = i;
            }
            leftMax[i] = maxLeftIndex;

            if(height[height.length-1 - i] >= height[maxRightIndex]) {
                maxRightIndex = height.length-1 - i;
            }
            rightMax[height.length-1 - i] = maxRightIndex;
        }

        System.out.println(Arrays.toString(leftMax));
        System.out.println(Arrays.toString(rightMax));

        int toalVolume = 0;
        for(int i = 0 ; i < height.length; i++) {
            toalVolume += Math.abs(height[i]-Math.min(height[leftMax[i]], height[rightMax[i]]));
            System.out.println(toalVolume);
        }
        return toalVolume;

    }
}
