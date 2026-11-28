class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        Arrays.sort(items, (a, b) -> a[1] - b[1]);
        int max = 0;
        for(int[] item: items){
            max = Math.max(max, item[0]);
        }

        int[] freq = new int[max+1];
        for(int[] item: items){
            freq[item[0]]++;
        } 
        for(int i = 1; i<=max; i++){
            if(freq[i] > 0);
            for(int j = i+i; j<=max; j+=i){
                freq[i] += freq[j];
            }
        }

        int ans = 0, min = items[0][1];
        for(int[] item: items){
            int factor = item[0], price = item[1];
            if(price - min > min) break;
            int cnt = freq[factor] - 1;
            int take = Math.min(cnt, budget/price);
            ans += 2*take;
            budget -= take * price; 
        }
        ans += budget/min;
        return ans;
    }
}