class Solution {
    public String decodeString(String s) {
        Stack<Integer> numSt=new Stack<>();
        Stack<String> strst = new Stack<>();
        int num=0;
        
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10+(s.charAt(i)-'0');
            }
            
            else if(s.charAt(i)=='['){
                numSt.push(num);
                strst.push(sb.toString());
                num = 0;
                sb=new StringBuilder();

            }
            else if(s.charAt(i)==']'){
                int rep = numSt.pop();
                String str = strst.pop();

                StringBuilder temp = new StringBuilder(str);
                for(int j=0;j<rep;j++){
                    temp.append(sb);
                }
                sb = temp;
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}