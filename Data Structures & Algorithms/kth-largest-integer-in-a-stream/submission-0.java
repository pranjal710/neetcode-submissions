class KthLargest {

    private final PriorityQueue<Integer> maxHeap;
    private final PriorityQueue<Integer> minHeap;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.maxHeap = new PriorityQueue<>((a, b) -> b - a);
        this.minHeap = new PriorityQueue<>((a, b) -> a - b);
        for(int x : nums) {
            this.addVal(x);
        }

    }

    private void addVal(int val) {
        this.minHeap.add(val);
        if(this.minHeap.size() == k) {
            int removed = this.minHeap.remove();
            this.maxHeap.add(removed);
        }
    }

    private int getHeadOfMaxHeap() {
        int removed = this.maxHeap.remove();
        this.maxHeap.add(removed);
        return removed;
    }
    
    public int add(int val) {
        this.addVal(val);
        return getHeadOfMaxHeap();
    }
}
