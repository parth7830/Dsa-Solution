class MedianFinder {
    PriorityQueue<Integer> pq;
    PriorityQueue<Integer> pq1;
    public MedianFinder() {
        pq = new PriorityQueue<>(Collections.reverseOrder());
        pq1 = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        pq.offer(num);
        pq1.offer(pq.poll());
        if(pq1.size() > pq.size()){
            pq.offer(pq1.poll());
        }
    }
    
    public double findMedian() {
        if(pq.size() > pq1.size()){
            return pq.peek();
        }else{
            return (pq.peek() + pq1.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */