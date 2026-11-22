class Solution {
    public boolean checkString(String s) {
        int n = s.length();
        if(n == 1) return true;

        int lastA = -1, firstB = -1;
        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            if(c == 'a') lastA = i;
            else if(c == 'b' && firstB == -1) firstB = i;
        }
        if(lastA == -1 || firstB == -1) return true;
        return lastA < firstB;

    }
}