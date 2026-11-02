class Solution {
    public int minMoves2(int[] nums) {
        // Arrays.sort(nums);
        // int n = nums.length;
        // int mid = (nums[0] + nums[n-1]) / 2;

        // int ops = 0;
        // for(int num: nums){
        //     ops += Math.abs(mid - num);
        // }

        // return ops;

        Arrays.sort(nums);
        int n = nums.length;
        int mid = n/2;

        int ops = 0;
        for(int i = 0; i<n; i++){
            ops += Math.abs(nums[i] - nums[mid]);
        }
        return ops;
    }
}