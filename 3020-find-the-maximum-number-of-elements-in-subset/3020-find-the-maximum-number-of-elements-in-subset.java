class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) 
            map.put(num, map.getOrDefault(num, 0) + 1);

        int maxLen = 0;
        if(map.containsKey(1)) 
            maxLen = map.get(1) - (map.get(1) % 2 == 0 ? 1 : 0);

        for(int num: nums){
            if(num != 1){
                int curLen = 0;
                long curVal = (long) num;
                while(map.containsKey((int)curVal) && map.get((int)curVal) >= 2){
                    curLen += 2;
                    curVal *= curVal;
                    if(curVal > Integer.MAX_VALUE) break; 
                }  
                if(map.containsKey((int) curVal) && map.get((int) curVal) == 1) curLen++;
                else curLen--;

                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }
}