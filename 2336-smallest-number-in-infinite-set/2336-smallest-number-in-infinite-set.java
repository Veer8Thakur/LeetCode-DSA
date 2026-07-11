class SmallestInfiniteSet {
    private PriorityQueue<Integer> pq;
    private HashSet<Integer> set;
    private int counter;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        set = new HashSet<>();
        counter = 1;
    }

    public int popSmallest() {
        if (!pq.isEmpty()) {
            int smallest = pq.poll();
            set.remove(smallest);
            return smallest;
        }
        return counter++;
    }

    public void addBack(int num) {
        if (num < counter && set.add(num)) {
            pq.offer(num);
        }
    }
}