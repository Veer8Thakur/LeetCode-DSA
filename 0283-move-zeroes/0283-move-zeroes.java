class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];

        int idx = 0;
        for(int num: nums){
            if(num != 0) arr[idx++] = num;
        }
        for(int i = 0; i<n; i++){
            nums[i] = arr[i];
        }
    }
}