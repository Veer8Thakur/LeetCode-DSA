class ProductOfNumbers {
    List<Integer> list;
    public ProductOfNumbers() {
        list = new ArrayList<>();
    }
    
    public void add(int num) {
        list.addFirst(num);
    }
    
    public int getProduct(int k) {
        int product = list.get(0);
        for(int i = 1; i<k; i++){
            product *= list.get(i);
        }
        return product;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
*/