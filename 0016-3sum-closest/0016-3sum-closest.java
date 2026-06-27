class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        long closest = Integer.MAX_VALUE;
        
        for(int i = 0; i<n-2; i++){
            for(int j = i+1; j<n-1; j++){
                for(int k = j+1; k<n; k++){
                    int sum = nums[i] + nums[j] + nums[k];

                    if(Math.abs(target - sum) < Math.abs(closest - target)) 
                        closest = sum;
                }
            }
        }
        return (int) closest;
    }
}