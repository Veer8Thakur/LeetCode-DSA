class Solution {
    public String decodeString(String s) {
        char[] arr = s.toCharArray();

        Stack<Character> stk = new Stack<>();
        for(char c: arr){
            if(c == ']'){
                StringBuilder sb = new StringBuilder();
                while(stk.peek() != '[') sb.append(stk.pop());
                sb = sb.reverse();
                stk.pop();
                int k = 0;
                StringBuilder digit = new StringBuilder(); 
                while(!stk.isEmpty() && Character.isDigit(stk.peek())){
                    digit.append(stk.pop());
                    digit.reverse();
                }
                for(int i = 0; i<digit.length(); i++){
                    int num = digit.charAt(i) - '0';
                    k = k * 10 + num;
                }
                // String str = new String(digit);
                // k = Integer.parseInt(str);
                for(int j = 0; j<k; j++)
                    for(int i = 0; i<sb.length(); i++) stk.push(sb.charAt(i));
            }
            else stk.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for(char c: stk) sb.append(c);
        return sb.toString();
    }
}