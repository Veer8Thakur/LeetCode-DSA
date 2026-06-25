class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int ans = 0;
        int n = nums.length;


        for(int i = 0; i<n; i++){
            int occurence = 0;
            for(int j = i; j>=0; j--){
                if(nums[j] == target) occurence++;
                if(i - j + 1 < 2 * occurence) ans++;
            }
        }

        return ans;
    }
}