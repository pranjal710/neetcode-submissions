class MedianFinder {

    private final PriorityQueue<Integer> min;
    private final PriorityQueue<Integer> max;

    public MedianFinder() {
        this.min = new PriorityQueue<>((a,b) -> a-b);
        this.max = new PriorityQueue<>((a,b) -> b-a);
    }
    
    public void addNum(int num) {
        if(this.min.size() == 0 || num > this.min.peek()) {
            this.min.add(num);
            this.max.add(this.min.remove());
        } else {
            this.max.add(num);
        }
        if(this.max.size() > this.min.size()) {
            this.min.add(this.max.remove());
        }
    }
    
    public double findMedian() {
        //0 size() ??
        if(this.min.size() == this.max.size()) {
            return (((double)this.max.peek() + (double)this.min.peek())/2d);
        } else {
            return this.min.peek();
        }
    }
}
