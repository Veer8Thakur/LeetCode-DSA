class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int max = 0;

        for(int i = 0; i<n; i++){
            int prod = 1;
            int curLCM = 1;
            int curGCD = 0;
            for(int j = i; j<n; j++){
                prod *= nums[j];
                curLCM = LCM(curLCM, nums[j]);
                curGCD = GCD(curGCD, nums[j]);
                if(prod == curLCM * curGCD) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    public int GCD(int a, int b){
        // if(b == 0) return a;
        // return GCD(b, a%b);
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;

    }

    public int LCM(int a, int b){
        return (a/GCD(a, b)) * b;
    }
}