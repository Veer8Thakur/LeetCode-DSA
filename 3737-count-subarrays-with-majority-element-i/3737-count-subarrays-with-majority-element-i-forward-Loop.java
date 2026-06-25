class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int ans = 0;
        int n = nums.length;

        for(int i = 0; i<n; i++){
            int occur = 0;
            for(int j = i; j<n; j++){
                if(nums[j] == target) occur++;
                if(2 * occur > j - i + 1) ans++;
            }
        }

        return ans;
    }
}