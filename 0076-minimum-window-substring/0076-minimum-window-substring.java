class Solution {
    public String minWindow(String s, String t) {
        char[] str = s.toCharArray();
        char[] pattern = t.toCharArray();

        int m = str.length, n = pattern.length;
        if(n > m) return "";

        int[] need = new int[128];
        for(char c: pattern) need[c]++;

        int[] window = new int[128];
        int left = 0, cnt = 0;
        int min = Integer.MAX_VALUE;
        int startIdx = -1;

        for(int right = 0; right<m; right++){
            char c = str[right];
            if(need[c] > 0){
                window[c]++;
                if(window[c] <= need[c]) cnt++; 
            }
            while(cnt == n){
                if(right - left + 1 < min){
                    min = right - left + 1;
                    startIdx = left;
                }
                int remove = str[left++];
                if(need[remove] > 0){
                    window[remove]--;
                    if(window[remove] < need[remove]) cnt--;
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + min);

    }
}