class MedianFinder {

    private final PriorityQueue<Integer> minHeap;
    private final PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b-a);
    }
    
    public void addNum(int num) {
        this.maxHeap.add(num);
        this.minHeap.add(this.maxHeap.remove());
        if(this.minHeap.size() -1 > this.maxHeap.size()) {
            this.maxHeap.add(this.minHeap.remove());
        }
    }
    
    public double findMedian() {
        if(this.minHeap.size() == this.maxHeap.size()) {
            return ((double)this.minHeap.peek() + (double)this.maxHeap.peek())/2;
        } else {
            return this.minHeap.peek();
        }
    }
}
