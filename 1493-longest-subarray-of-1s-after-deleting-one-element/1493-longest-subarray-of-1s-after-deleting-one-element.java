class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int max = 0;
        int del = 0;
        int left = 0;
        int ones = 0;
        for(int right = 0; right<n; right++){
            if(nums[right] == 1) ones++;
            if(nums[right] == 0 && del == 0) {
                del++;
            }

            else if(nums[right] == 0 && del >= 1){
                while(nums[left] != 0){
                    left++;
                }
                left++;
                
            }
            max = Math.max(max, right - left + 1 - del);
        }
        if(n == ones) return n-1;
        return max;
    }
}