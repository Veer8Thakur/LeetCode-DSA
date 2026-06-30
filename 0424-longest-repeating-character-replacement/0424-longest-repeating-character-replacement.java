class Solution {
    public int characterReplacement(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[] freq = new int[26];
        int maxFreq = 0;
        int maxLen = 0, left = 0;

        for(int right = 0; right<n; right++){
            freq[arr[right] - 'A']++;
            maxFreq = Math.max(maxFreq, freq[arr[right] - 'A']);

            int wndSize = right - left + 1;
            int need = wndSize - maxFreq;
       
            if(need > k){
                while(right - left + 1 - maxFreq > k){
                    freq[arr[left] - 'A']--;
                    left++;   
                }
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}