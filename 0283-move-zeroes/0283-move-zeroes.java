class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0;
        for(int right = 0; right<n; right++){
            if(nums[left] == 0 && nums[right] != 0){
                // b = a - b + (b = a);
                // nums[right] = nums[left] - nums[right] + (nums[right] = nums[left]);
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            if(nums[left] != 0) left++;
        }
    }
}