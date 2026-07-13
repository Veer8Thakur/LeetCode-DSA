class Solution {
        List<Integer> ans = new ArrayList<>();
    public List<Integer> sequentialDigits(int low, int high) {
        for(int i = 1; i<=9; i++){
            Backtrack(i, i+1, low, high);
        }
        Collections.sort(ans);
        return ans;
    }
    public void Backtrack(int cur, int next, int low, int high){
        if(cur > high) return ;
        if(cur >= low) ans.add(cur);
        if(next > 9) return ;
        Backtrack(cur*10+next, next+1, low, high);
    }
}