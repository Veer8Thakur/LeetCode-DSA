class Solution {
    public int GCD(int a, int b){
        while(b != 0) return GCD(b, a%b);
        return a;
    }
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int max = nums[0];
        for(int i = 0; i<n; i++){
            max = Math.max(max, nums[i]);
            arr[i] = GCD(max, nums[i]);
        }
        Arrays.sort(arr);
        int left = 0, right = n-1;
        long sum = 0;
        while(left < right){
            sum +=  GCD(arr[right--], arr[left++]);
        }
        return sum;
    }
}