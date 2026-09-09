class Solution {
    public long countCommas(long n) {
        long ans = 0;
        for (long t = 1000; t <= n; t *= 1000) {
            ans += n - t + 1;
        }
        return ans;
    }
}