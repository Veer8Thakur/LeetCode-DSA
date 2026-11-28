class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        // 1. Calculate frequency of each factor
        int[] freq = new int[n + 1];
        for (int[] item : items) {
            freq[item[0]]++;
        }
        // 2. Calculate gain for each factor
        int[] gain = new int[n + 1];
        for (int x = 1; x <= n; x++) {
            int count = 0;
            for (int j = x; j <= n; j += x) {
                count += freq[j];
            }
            gain[x] = count - 1;
        }
        // 3. Find minimum price
        int minPrice = Integer.MAX_VALUE;
        for (int[] item : items) {
            minPrice = Math.min(minPrice, item[1]);
        }

        // 4. Sort items by price
        Arrays.sort(items, (a, b) ->
            Integer.compare(a[1], b[1])
        );

        long ans = 0;
        long remainingBudget = budget;
        // 5. Purchase boosted copies
        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];
            // No benefit over regular purchases
            if (price > 2L * minPrice) {
                break;
            }
            // Number of boosted copies we can afford
            long buy = Math.min(
                (long) gain[factor],
                remainingBudget / price
            );
            remainingBudget -= buy * price;
            // Each boosted purchase gives 2 items
            ans += buy * 2;
        }
        // 6. Purchase regular copies using remaining budget
        ans += remainingBudget / minPrice;

        return (int) ans;
    }
}