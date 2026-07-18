class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int flowers = 0;
        if(n == 0) return true;
        if(n == 1 && flowerbed.length == 1 && flowerbed[0] == 0) return true;
        if(n >= flowerbed.length) return false;

        if(flowerbed[0] == 0 && flowerbed[1] == 0){
            flowerbed[0] = 1;
            flowerbed[1] = 2;
            flowers++;
        }
        for(int i = 1; i<flowerbed.length; i++){
            if(flowerbed[i] == 0){
                if((flowerbed[i-1] == 0 || flowerbed[i-1] == 2)){
                    if((i + 1 < flowerbed.length && flowerbed[i+1] == 0) || i == flowerbed.length-1)
                       { flowerbed[i] = 1;
                        if(i + 1 < flowerbed.length) flowerbed[i+1] = 2;
                        flowers++;}
                }
            }
            if(flowers >= n) return true;
        }
        return false;
    }
}