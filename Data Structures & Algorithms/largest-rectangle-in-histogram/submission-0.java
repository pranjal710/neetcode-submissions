class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> s = new Stack<>();
        int maxArea = 0;
        for(int h : heights ) {
            if(s.size() == 0 || s.peek()[0] <= h) {
                s.push(new int[]{h, 1});
                
            } else {
                int tempMax = 0;
                int removed = 0;
                while(s.size() > 0 && s.peek()[0] > h) {
                    int[] removedBar = s.pop();
                    removed += removedBar[1];
                    tempMax = Math.max(tempMax, removedBar[0]*removed);
                    maxArea = Math.max(maxArea, tempMax);
                }
                s.push(new int[]{h, removed+1});
            }
        }

        int removed = 0;
        int tempMax = 0;
        while(s.size() > 0) {
            int[] removedBar = s.pop();
            removed += removedBar[1];
            tempMax = Math.max(tempMax, removedBar[0]*removed);
            maxArea = Math.max(maxArea, tempMax);
        }
        return maxArea;
    }
}
