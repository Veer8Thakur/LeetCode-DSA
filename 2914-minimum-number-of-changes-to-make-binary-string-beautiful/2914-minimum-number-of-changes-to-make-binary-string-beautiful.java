class Solution {
    public int minChanges(String s) {
        int n = s.length();
        // char[] ch = s.toCharArray();
        int left = 0, right = 1;
        int ops = 0;

        while(right < n){
            if(s.charAt(left) != s.charAt(right)) ops++;
            left += 2;
            right += 2;
        }
        return ops;
    }
}