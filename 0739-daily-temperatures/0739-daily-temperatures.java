class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[n];

        for(int i = 0; i<n; i++){
            while(!dq.isEmpty() && temperatures[dq.peekLast()] < temperatures[i]){
                int prev = dq.removeLast();
                ans[prev] = i - prev;
            }
            dq.offer(i);
        }

        return ans;
    }
}