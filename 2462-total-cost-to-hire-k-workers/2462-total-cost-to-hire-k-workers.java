class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;

        PriorityQueue<Integer> leftPQ = new PriorityQueue<>();
        PriorityQueue<Integer> rightPQ = new PriorityQueue<>();

        int left = 0;
        int right = n - 1;

        // Fill left heap
        while (left <= right && left < candidates) {
            leftPQ.offer(costs[left++]);
        }

        // Fill right heap
        while (left <= right && n - 1 - right < candidates) {
            rightPQ.offer(costs[right--]);
        }

        long ans = 0;

        while (k-- > 0) {

            if (rightPQ.isEmpty() ||
               (!leftPQ.isEmpty() && leftPQ.peek() <= rightPQ.peek())) {

                ans += leftPQ.poll();

                if (left <= right) {
                    leftPQ.offer(costs[left++]);
                }

            } else {
                ans += rightPQ.poll();
                if (left <= right) {
                    rightPQ.offer(costs[right--]);
                }
            }
        }

        return ans;
    }
}