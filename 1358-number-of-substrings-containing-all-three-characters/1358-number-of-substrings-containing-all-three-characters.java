class Solution {
    public int numberOfSubstrings(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int ans = 0;
        int lastIdx[] = {-1, -1, -1};

        for(int i = 0; i<n; i++){
            lastIdx[arr[i] - 'a'] = i;
            ans += Math.min(lastIdx[0], Math.min(lastIdx[1], lastIdx[2])) + 1;
        }
        return ans;
    }
}