class SmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    int counter;
    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        counter = 1;
    }
    
    public int popSmallest() {
        if(!pq.isEmpty() && pq.peek() < counter) return pq.poll();
        return counter++;
        
    }
    
    public void addBack(int num) {
        if(!pq.contains(num) && counter > num) pq.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */