class Solution {
    public int maxTurbulenceSize(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        int up = 1, down = 1, max = 1;
        for(int i = 1; i<n; i++){
            if(nums[i] > nums[i-1]){
                up = down + 1;
                down = 1;
            } 
            else if(nums[i] < nums[i-1]){
                down = up + 1;
                up = 1;
            }
            else up = down = 1;
            max = Math.max(max, Math.max(up, down));
        }
        return max;
    }
}

// class Solution {
//     public int maxTurbulenceSize(int[] nums) {
//         int n = nums.length;
//         if (n == 1) return 1;

//         int[] dp = new int[n];
//         dp[0] = 1;
//         int max = 1;

//         for (int i = 1; i < n; i++) {
//             if (nums[i] == nums[i-1]) {
//                 dp[i] = 1;  // equal → turbulence broken
//             } else if (i == 1) {
//                 dp[i] = 2;  // first comparison
//             } else if ((nums[i-2] < nums[i-1] && nums[i-1] > nums[i]) ||
//                        (nums[i-2] > nums[i-1] && nums[i-1] < nums[i])) {
//                 dp[i] = dp[i-1] + 1;  // extend turbulence
//             } else {
//                 dp[i] = 2;  // reset to new pair
//             }
//             max = Math.max(max, dp[i]);
//         }
//         return max;
//     }
// }