class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        long MOD = 1_000_000_007L;

        int[] sum = new int[n + 1];
        int[] cnt = new int[n + 1];

        // Build prefix sum and count of non-zero digits
        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';

            sum[i + 1] = sum[i] + digit;
            cnt[i + 1] = cnt[i];

            if (digit != 0) {
                cnt[i + 1]++;
            }
        }

        int m = cnt[n];

        long[] pref = new long[m + 1];
        long[] pow10 = new long[m + 1];

        pow10[0] = 1;

        for (int i = 1; i <= m; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        // Build numeric prefix of non-zero digits
        int k = 0;

        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';

            if (digit != 0) {
                pref[k + 1] = (pref[k] * 10 + digit) % MOD;
                k++;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            long total = sum[r + 1] - sum[l];

            int left = cnt[l];
            int right = cnt[r + 1];

            int len = right - left;

            long x = (
                pref[right]
                - (pref[left] * pow10[len]) % MOD
                + MOD
            ) % MOD;

            ans[i] = (int) ((x * total) % MOD);
        }
        return ans;
    }
}