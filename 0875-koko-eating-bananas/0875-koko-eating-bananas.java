class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = Integer.MAX_VALUE;
        // for(int pile : piles){
        //     high += pile;
        // }
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(canEat(mid, piles, h)){
                ans = mid;
                high = mid-1;
            }
            else low = mid + 1;
        }
        return ans;
    }
    public boolean canEat(int curCap, int[] piles, int h){
        int time = 0;
        for(int pile: piles){
            time += (pile + curCap - 1)/curCap; // ceil division
        }
        return time <= h;
    }
}