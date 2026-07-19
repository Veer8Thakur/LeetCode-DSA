class Solution {
    public String smallestSubsequence(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        boolean[] vis = new boolean[26];
        int n = s.length();
        int[] lastIdx = new int[26];
        for(int i = 0; i<n; i++) {
            char c = s.charAt(i);
            lastIdx[c - 'a'] = i;
        }

        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            while(!dq.isEmpty() && dq.peekLast() > c && lastIdx[dq.peekLast() - 'a'] > i && !vis[c - 'a']){
                int peek = dq.removeLast();
                vis[peek - 'a'] = false;
            }
            if(!vis[c - 'a']){
                dq.addLast(c);
                vis[c - 'a'] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : dq) sb.append(c);
        return sb.toString();
    }
}