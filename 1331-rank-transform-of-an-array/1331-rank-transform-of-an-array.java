class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        if(n == 0) return new int[]{};
        int[][] pairs = new int[n][2];
        for(int i = 0; i<n; i++) {
            pairs[i][0] = arr[i];
            pairs[i][1] = i;
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        int ans[] = new int[n];
        int rank = 1;
        ans[pairs[0][1]] = rank; 
        for(int i = 1; i<n; i++){
            if(pairs[i-1][0] != pairs[i][0]) rank++;
            ans[pairs[i][1]] = rank;
        }
        return ans;
    }
}