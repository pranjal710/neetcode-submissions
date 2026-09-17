class Solution {
    private void addToDeque(Deque<Integer> q, int[] nums, int index) {
        while(q.size() > 0 && nums[q.peekLast()] < nums[index]) {
            System.out.println("Remove in loop: " + q.removeLast());
        }
        System.out.println("Add: " + index);
        q.add(index);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        while(index < nums.length) {
            addToDeque(q, nums, index);
            if(index >= k-1) {
                result[index - k + 1] = nums[q.peek()];
                if(q.peekFirst() == (index - k + 1)) {
                    System.out.println("Remove: " + q.removeFirst());
                }
            }
            index++;
        }
        return result;
    }
}
