class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[n - k + 1];
        int idx = 0;
        for(int i = 0; i<n; i++){
            // if window expire by size
            while(!dq.isEmpty() && dq.peek() < i - k + 1){
                dq.pollFirst();
            }
            // if element is small so no need
            while(!dq.isEmpty() && nums[i] > nums[dq.peekLast()]){
                dq.pollLast();
            } 
            // window has space
           
            dq.offerLast(i); 
            
            if(i >= k-1) res[idx++] = nums[dq.peekFirst()];
        }
        return res;
    }
}