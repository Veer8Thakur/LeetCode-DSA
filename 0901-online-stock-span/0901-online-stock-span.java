class StockSpanner {
    List<Integer> seq; 
    public StockSpanner() {
        seq = new ArrayList<>();
    }
    
    public int next(int price) {
        // if(list.size() == 0) return null;
        int cnt = 1;
        for(int i = seq.size()-1; i>=0; i--){
            if(seq.get(i) <= price) cnt++;
            else break;
        }
        seq.add(price);
        return cnt;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */