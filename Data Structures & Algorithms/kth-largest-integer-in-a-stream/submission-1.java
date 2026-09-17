class KthLargest {

    Queue<Integer> q;
    int size;

    public KthLargest(int k, int[] nums) {
        q = new PriorityQueue<>();
        size = k;
        for(int n : nums) q.add(n);
        while(q.size() > size) {
            q.remove();
        }
    }
    
    public int add(int val) {
        q.add(val);
        while(q.size() > size ) {
            q.remove();
        }
        return q.peek();
    }
}
