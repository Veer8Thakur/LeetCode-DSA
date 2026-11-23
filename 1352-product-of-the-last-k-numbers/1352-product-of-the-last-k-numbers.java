class ProductOfNumbers {
    List<Integer> list;
    List<Integer> prefixSum;
    public ProductOfNumbers() {
        list = new ArrayList<>();
        prefixSum = new ArrayList<>();
    }
    
    public void add(int num) {
        list.add(num);
        if(prefixSum.size() == 0) prefixSum.add(num);
        else prefixSum.add(prefixSum.get(prefixSum.size()-1) * num);
        
        if(num == 0) {
            prefixSum.clear();
        }
    }
    
    public int getProduct(int k) {
        int size = prefixSum.size();
        if (k > size) return 0;
        else if(k == size) return prefixSum.get(size-1);
        else return prefixSum.get(size-1)/prefixSum.get(size-1-k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
*/