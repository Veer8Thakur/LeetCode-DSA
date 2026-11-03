class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int max = 0;
        for(int num: nums) max = Math.max(max, num);

        int ops = 0;
        for(int num: nums){
            ops += Math.abs(max - num);
        }
        return ops;
    }
}