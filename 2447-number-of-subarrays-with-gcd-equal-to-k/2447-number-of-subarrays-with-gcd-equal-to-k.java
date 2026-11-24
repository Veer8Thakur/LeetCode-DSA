class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length;
        int ans = 0; 
        for(int i = 0; i<n; i++){
            int curGCD = 0;
            for(int j = i; j<n; j++){
                curGCD = GCD(curGCD, nums[j]);
                if(curGCD == k) ans++;
                else if(curGCD < k) break;
            }
        }
        return ans;
    }
    public int GCD(int a, int b){
        return b == 0 ? a : GCD(b, a%b);
    }
}