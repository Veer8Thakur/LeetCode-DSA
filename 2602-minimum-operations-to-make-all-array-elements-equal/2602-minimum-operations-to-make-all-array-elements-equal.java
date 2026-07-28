class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        int n = nums.length, m = queries.length;
        List<Long> res = new ArrayList<>();
        Arrays.sort(nums);
        long[] prefix = new long[n+1];
        for(int i = 0; i<n; i++) 
            prefix[i+1] = prefix[i] + nums[i];

        for(int num: queries){
            int idx = Arrays.binarySearch(nums, num);
            if(idx < 0) idx = -(idx+1);

            long left = (long)idx*num - prefix[idx];
            long right = (prefix[n] - prefix[idx]) - (long)(n-idx)*num;

            res.add(left+right);
        }
        return res;
    }
}
