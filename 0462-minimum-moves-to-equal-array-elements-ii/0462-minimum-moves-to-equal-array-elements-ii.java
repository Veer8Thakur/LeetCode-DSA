class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        int moves = 0;
        int mid = getMid(nums, 0, n-1, n/2);

        for(int num: nums){
            moves += Math.abs(mid - num);
        }
        return moves;
    }
    public int getMid(int[] nums, int low, int high, int k){
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[low] > nums[mid]) swap(nums, low, mid);
            if(nums[low] > nums[high]) swap(nums, low, high);
            if(nums[mid] > nums[high]) swap(nums, mid, high);
            int pivot = nums[mid];

            int i = low, j = high;
            while(i <= j){
                while(nums[i] < pivot) i++;
                while(nums[j] > pivot) j--;
                if(i <= j) swap(nums, i++, j--);
            }
            
            if(nums[k] >= pivot) low = i;
            else if(nums[k] < pivot) high = j;
            else return nums[k]; 
        }
        return nums[k];
    }
        public void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
}