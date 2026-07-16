class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0]; // cost
                return a[1] - b[1];                  // left before right on tie
            });

        int left = 0;
        int right = n - 1;

        // Add left candidates
        while (left <= right && left < candidates) {
            pq.offer(new int[]{costs[left], 0}); // 0 = left
            left++;
        }

        // Add right candidates
        while (left <= right && (n - 1 - right) < candidates) {
            pq.offer(new int[]{costs[right], 1}); // 1 = right
            right--;
        }

        long ans = 0;

        while (k-- > 0) {
            int[] cur = pq.poll();
            ans += cur[0];

            if (left <= right) {
                if (cur[1] == 0) { // hired from left
                    pq.offer(new int[]{costs[left], 0});
                    left++;
                } else {           // hired from right
                    pq.offer(new int[]{costs[right], 1});
                    right--;
                }
            }
        }

        return ans;
    }
}