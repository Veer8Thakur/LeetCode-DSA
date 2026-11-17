class Solution {
    public int countConsistent(int[] nums) {
        int n = nums.length;
        int res = 0;

        for(int i = 0; i<n; i++){
            int min = nums[i];
            int AND = nums[i];
            for(int j = i; j<n; j++){
                min = Math.min(min, nums[j]);
                AND &= nums[j];
                if(AND == min) res++; 
            }
        }
        return res;
    }
}