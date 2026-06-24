class Solution {
    public int countArrangement(int n) {
       int size = 1 << n;
       int[] dp = new int[size];
       return DFS(n, 0, dp);
    }
    public int DFS(int n, int mask, int[] dp){
        if(mask == (1 << n)-1) return 1;
        if(dp[mask] != 0) return dp[mask];
        int pos = Integer.bitCount(mask)+1;
        int total = 0;

        for(int i = 1; i<=n; i++){
            int bit = 1 << (i-1);
            if((mask & bit) == 0){
                if(pos % i == 0 || i % pos == 0){
                    total += DFS(n, mask | bit, dp);
                }
            }
        }
        return dp[mask] = total;
    }
}