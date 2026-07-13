class Solution {
    public String removeStars(String s) {
        char[] arr = s.toCharArray();
        Deque<Character> dq = new ArrayDeque<>();
        for(char c: arr){
            if(c == '*') dq.removeLast();
            else dq.add(c);
        }
        if(dq.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for(char c: dq) sb.append(c);
        return sb.toString();
    }
}