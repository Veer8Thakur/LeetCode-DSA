class Solution {
    public int maxTurbulenceSize(int[] nums) {
        int n = nums.length;
        if(n == 1) return n;
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