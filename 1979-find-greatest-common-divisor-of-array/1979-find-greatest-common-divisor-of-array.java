class Solution {
    public int findGCD(int[] nums) {
        int max = 0, min = Integer.MAX_VALUE;
        for(int num: nums){
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        while(min != 0){
            int temp = min;
            min = max % min;
            max = temp;
        }
        return max;
    }
}