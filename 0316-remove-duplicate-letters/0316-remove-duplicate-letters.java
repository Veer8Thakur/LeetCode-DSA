class Solution {
    public String removeDuplicateLetters(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        boolean[] vis = new boolean[26];
        int lastIdx[] = new int[26];

        for(int i = 0; i<n; i++) {
            char c = s.charAt(i);
            lastIdx[c - 'a'] = i;
        }

        Deque<Character> dq = new ArrayDeque<>();

        for(int i = 0; i<n; i++){
            char c = arr[i];
            if(vis[c - 'a']) continue;
            while(!dq.isEmpty() && dq.peekLast()-'a' > c-'a' && lastIdx[dq.peekLast() - 'a'] > i){
                char peek = dq.pollLast();
                vis[peek - 'a'] = false;
            }
            if(!vis[c - 'a']){
                dq.offerLast(c);
                vis[c - 'a'] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c: dq) sb.append(c);
        return sb.toString();
    }
}