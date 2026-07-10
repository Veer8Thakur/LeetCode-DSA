class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int n = candies.length;

        int max = 0;
        for(int candy: candies) 
            max = Math.max(max, candy);

        for(int i = 0; i<n; i++){
            if(candies[i] + extraCandies >= max) ans.add(true);
            else ans.add(false);
        }
        return ans;
    }
}