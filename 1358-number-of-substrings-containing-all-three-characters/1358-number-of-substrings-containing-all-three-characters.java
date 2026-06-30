class Solution {
    public int numberOfSubstrings(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int res = 0, left = 0;
        int[] freq = {0, 0, 0};

        for(int right = 0; right<n; right++){
            freq[arr[right] - 'a']++;
            while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0){
                res += n - right;
                freq[arr[left] - 'a']--;
                left++;
            }
        }
        return res;
    }
}