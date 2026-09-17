class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0) return -1;
        Queue<Integer> q = new PriorityQueue<>();
        for(int n : nums) {
            if(q.size() < k) {
                q.add(n);
            } else if(n > q.peek()) {
                q.add(n);
                q.remove();
            }
        }
        return q.peek();
    }
}
