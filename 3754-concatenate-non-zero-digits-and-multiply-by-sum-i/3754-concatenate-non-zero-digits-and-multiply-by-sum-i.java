class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0;
        long x = 0;
        while(n > 0){
            int num = n%10;
            sum += num;
            if(num > 0) x = x*10+num; 
            n /= 10;
        }
        x = Reverse(x);
        return x * sum;
    }
    public long Reverse(long num){
        long rev = 0;
        while(num > 0){
            long digit = num % 10;
            rev = rev * 10 + digit;
            num /= 10; 
        }
        return rev;
    }
}