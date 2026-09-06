// class Solution {
//     public int numDistinct(String s, String t) {
//         int m = s.length(), n = t.length();
//         int[][] dp = new int[m+1][n+1];
//         char[] arr1 = s.toCharArray();
//         char[] arr2 = t.toCharArray();

//         for(int i = 0; i<=m; i++) dp[i][0] = 1;

//         for(int i = 1; i<=m; i++){
//             for(int j = 1; j<=n; j++){
//                 if(arr1[i-1] == arr2[j-1]){
//                     dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
//                 }else dp[i][j] = dp[i-1][j];
//             }
//         }
//         return dp[m][n];
//     }
// }

class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        int[] prev = new int[n+1];
        int[] cur = new int[n+1];

        prev[0] = 1;
        cur[0] = 1;

        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                if(arr1[i-1] == arr2[j-1]){
                    cur[j] = prev[j-1] + prev[j];
                }
                else cur[j] = prev[j];
            }
            int[] temp = prev;
            prev = cur;
            cur = temp;
        } 
        return prev[n];
    }
}