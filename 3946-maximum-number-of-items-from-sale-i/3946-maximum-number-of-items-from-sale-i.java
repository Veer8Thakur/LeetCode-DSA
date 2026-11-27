class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int[] gain = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                if (items[j][0] % items[i][0] == 0) {
                    gain[i]++;
                }
            }
        }

        int NEG = -(int)1e9;

        int[] dp = new int[budget + 1];
        Arrays.fill(dp, NEG);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int price = items[i][1];

            int[] ndp = Arrays.copyOf(dp, budget + 1);

            for (int b = 0; b + price <= budget; b++) {
                if (dp[b] == NEG) continue;

                ndp[b + price] = Math.max(
                    ndp[b + price],
                    dp[b] + gain[i] + 1
                );
            }

            for (int b = price; b <= budget; b++) {
                if (ndp[b - price] == NEG) continue;

                ndp[b] = Math.max(
                    ndp[b],
                    ndp[b - price] + 1
                );
           }
            dp = ndp;
        }
        int ans = 0;
        for (int b = 0; b <= budget; b++) {
            ans = Math.max(ans, dp[b]);
        }

        return ans;
    }
}