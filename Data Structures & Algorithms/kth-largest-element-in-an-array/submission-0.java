class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> max = new PriorityQueue<>((a, b) -> b - a);
        Queue<Integer> min = new PriorityQueue<>((a, b) -> a - b);
        for(int x : nums) {
            min.add(x);
            if(min.size() == k ) {
                max.add(min.remove());
            }
        }
        return max.remove();
    }
}
