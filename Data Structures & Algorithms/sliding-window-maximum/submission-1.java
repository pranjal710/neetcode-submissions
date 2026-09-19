class Solution {
    private void insertKElements(PriorityQueue<Integer> pq, int k, int[] nums) {
        for(int i = 0 ; i < k && i < nums.length ; i++) {
            pq.add(i);
        }
    }

    private void remoeveElems(PriorityQueue<Integer> pq, int st) {
        while(pq.peek() < st) pq.remove();
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> nums[b] - nums[a]);
        insertKElements(pq, k, nums);
        int[] rs = new int[nums.length-k+1];
        int resIndex = 0;
        while(resIndex < rs.length) {
            int start = resIndex;
            int end = Math.min(nums.length-1, start + k - 1);
            remoeveElems(pq, start);
            rs[resIndex++] = nums[pq.peek()];
            if(end < nums.length-1)
                pq.add(end+1);
        }
        return rs;
    }
}
