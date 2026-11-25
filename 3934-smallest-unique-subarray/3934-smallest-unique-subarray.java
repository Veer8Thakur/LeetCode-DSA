class Solution {

    static final long BASE = 100001L;
    static final long MOD1 = 1_000_000_007L;
    static final long MOD2 = 1_000_000_009L;

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

        int n = nums.length;

        long power1 = 1;
        long power2 = 1;

        // Calculate BASE^(len-1)
        for (int i = 1; i < len; i++) {
            power1 = (power1 * BASE) % MOD1;
            power2 = (power2 * BASE) % MOD2;
        }

        // Calculate hash of first window
        long hash1 = 0;
        long hash2 = 0;

        for (int i = 0; i < len; i++) {

            hash1 = (hash1 * BASE + nums[i]) % MOD1;
            hash2 = (hash2 * BASE + nums[i]) % MOD2;
        }

        Map<String, Integer> freq = new HashMap<>();

        freq.put(hash1 + "#" + hash2, 1);

        // Sliding window
        for (int i = len; i < n; i++) {

            // Remove outgoing element
            hash1 = (hash1 - (nums[i - len] * power1) % MOD1 + MOD1) % MOD1;
            hash2 = (hash2 - (nums[i - len] * power2) % MOD2 + MOD2) % MOD2;

            // Add incoming element
            hash1 = (hash1 * BASE + nums[i]) % MOD1;
            hash2 = (hash2 * BASE + nums[i]) % MOD2;

            String key = hash1 + "#" + hash2;

            freq.put(key, freq.getOrDefault(key, 0) + 1);
        }

        // Check if any window is unique
        for (int count : freq.values()) {
            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}
