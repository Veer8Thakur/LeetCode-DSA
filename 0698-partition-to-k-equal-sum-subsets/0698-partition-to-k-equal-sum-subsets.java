class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        int target = sum / k;
        int n = nums.length;
        boolean[] used = new boolean[n];
        return backtrack(nums, used, k, 0, 0, target);
    }
    private boolean backtrack(int[] nums, boolean[] used, int k, int start, int currSum, int target) {
        // all subsets formed
        if (k == 0) return true;

        // one subset completed
        if (currSum == target) {
            return backtrack(nums, used, k - 1, 0, 0, target);
        }
        for (int i = start; i < nums.length; i++) {
            if (used[i]) continue;
            if (currSum + nums[i] > target) continue;
            used[i] = true;
            if (backtrack(nums, used, k, i + 1, currSum + nums[i], target)) {
                return true;
            }
            used[i] = false;
            if (currSum == 0) return false;
        }
        return false;
    }
}

// class Solution {
//     public boolean canPartitionKSubsets(int[] nums, int k) {
//         int n = nums.length;
//         int total = 0;
//         for (int num : nums) total += num;
//         if (total % k != 0) return false;
//         int target = total / k;

//         // Sort descending for pruning (big numbers first)
//         Arrays.sort(nums);
//         for (int i = n - 1; i >= 0; i--) {
//             if (nums[i] > target) return false;
//         }

//         int size = 1 << n; // total masks
//         int[] dp = new int[size];
//         Arrays.fill(dp, -1);
//         dp[0] = 0; // base case: empty set has sum 0

//         for (int mask = 0; mask < size; mask++) {
//             if (dp[mask] == -1) continue; // invalid state
//             for (int i = 0; i < n; i++) {
//                 if ((mask & (1 << i)) == 0) { // if nums[i] not used
//                     int next = mask | (1 << i);
//                     if (dp[mask] + nums[i] <= target) {
//                         dp[next] = (dp[mask] + nums[i]) % target;
//                     }
//                 }
//             }
//         }
//         return dp[size - 1] == 0; // all elements used, last subset closed
//     }
// }