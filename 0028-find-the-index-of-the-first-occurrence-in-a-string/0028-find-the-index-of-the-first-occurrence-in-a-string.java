class Solution {
    public int strStr(String haystack, String needle) {
        // return haystack.indexOf(needle);

        int m = haystack.length(), n = needle.length();
        char[] hay = haystack.toCharArray();
        char[] ned = needle.toCharArray();

        int[] lps = BuildLPS(ned);
        int i = 0, j = 0;
        while(i < m && j < n){
            if(hay[i] == ned[j]){
                i++;
                j++;
                if(j == n) return i - j;
            }
            else {
                if(j != 0) j = lps[j - 1];
                else i++;
            }
        }
        return -1;
    }
    public int[] BuildLPS(char[] ned){
        int n = ned.length;
        int[] lps = new int[n];
        int len = 0, i = 1;

        while(i < n){
            if(ned[i] == ned[len]){
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if(len != 0) len = lps[len - 1];
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        } 
        return lps;
    }
}