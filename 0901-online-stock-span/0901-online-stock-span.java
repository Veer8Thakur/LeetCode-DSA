class StockSpanner {
    Deque<int[]> dq;
    public StockSpanner() {
        dq = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int span = 1;
        while(!dq.isEmpty() && dq.peekLast()[0] <= price){
            span += dq.removeLast()[1];
        }
        dq.addLast(new int[]{price, span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */