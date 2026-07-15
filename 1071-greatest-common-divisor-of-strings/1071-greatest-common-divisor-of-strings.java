class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2 + str1)) return "";
        int len = GCD(str1.length(), str2.length());
        return str1.substring(0, len);
    }
    public int GCD(int a, int b){
        while(b != 0){
            return GCD(b, a%b);
        }
        return a;
    }
}