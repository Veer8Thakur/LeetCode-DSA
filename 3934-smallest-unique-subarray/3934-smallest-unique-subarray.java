class Solution {

    public int smallestUniqueSubarray(int[] nums) {

        int low = 1;
        int high = nums.length;
        int ans = nums.length;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (check(nums, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean check(int[] nums, int len) {

        long BASE = 100001;
        long MOD = 1_000_000_007;

        int n = nums.length;

        long power = 1;

        for (int i = 1; i < len; i++) {
            power = (power * BASE) % MOD;
        }

        long hash = 0;

        for (int i = 0; i < len; i++) {
            hash = (hash * BASE + nums[i]) % MOD;
        }

        Map<Long, Integer> freq = new HashMap<>();

        freq.put(hash, 1);

        for (int i = len; i < n; i++) {

            hash = (hash - nums[i - len] * power % MOD + MOD) % MOD;

            hash = (hash * BASE + nums[i]) % MOD;

            freq.put(hash, freq.getOrDefault(hash, 0) + 1);
        }

        for (int count : freq.values()) {
            if (count == 1) return true;
        }

        return false;
    }
}