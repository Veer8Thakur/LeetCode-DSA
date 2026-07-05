class Solution {
    public int minFlips(int a, int b, int c) {
        int score = 0;
        while(a > 0 || b > 0 || c > 0){
            int bitA = a & 1;
            int bitB = b & 1;
            int bitC = c & 1;

            if((bitA | bitB) == bitC) score += 0;
            else if((bitA == 0 && bitB == 0) && bitC == 1) score++;
            else if((bitA == 1 && bitB == 1) && bitC == 0) score += 2;
            else if(((bitA == 0 && bitB == 1) || (bitA == 1 && bitB == 0)) && bitC == 0) score++;

            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return score;
    }
}