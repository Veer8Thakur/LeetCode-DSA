class Solution {
    public int maxVowels(String s, int k) {
        char[] arr = s.toCharArray();
        int max = 0;
        int n = arr.length;

        int vowels = 0;
        for(int i = 0; i<k; i++){
            if(isVowel(arr[i])) vowels++;
            max = Math.max(max, vowels);
        }
  
        for(int right = k; right<n; right++){
            if(isVowel(arr[right - k])) vowels--;
            if(isVowel(arr[right])) vowels++;
            max = Math.max(max, vowels);
        }
        return max;
    }
    public boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        else return false;
    }
}