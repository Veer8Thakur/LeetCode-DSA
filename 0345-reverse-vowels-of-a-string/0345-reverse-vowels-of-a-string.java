class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length-1;
        while(left <= right){
            if(isVowel(arr[left]) && isVowel(arr[right])){
                // swap(left, right);
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
            else if(isVowel(arr[left])) right--;
            else left++;
        }
        return new String(arr);
    }
    public boolean isVowel(char c){
        if(c == 'a' || c == 'A' || c == 'e' || c == 'E' ||
        c == 'i' || c == 'I' || c == 'o' || c == 'O' ||
        c == 'u' || c == 'U') return true;

        return false;
    }
}