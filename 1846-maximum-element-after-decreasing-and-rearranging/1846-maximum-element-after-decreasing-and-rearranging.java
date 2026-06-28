class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        if(n == 1) return 1;
        if(arr[0] != 1) arr[0] = 1;
        int max = 1;
        for(int i = 1; i<n; i++){
            if(Math.abs(arr[i] - arr[i-1]) > 1){
                arr[i] = arr[i-1] + 1;
            }
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}