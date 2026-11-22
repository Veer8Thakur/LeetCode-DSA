class Solution {
    public boolean checkString(String s) {
        int n = s.length();
        // if(n == 1) return true;

        int lastA = -1, firstB = n;
        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            if(c == 'a') lastA = i;
            else if(c == 'b' && firstB == n) firstB = i;
        }
        return lastA < firstB;
    }
}