class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefix = 0, res = 0;

        for(int num: nums){
            prefix += num;
            int mod = ((prefix % k) + k) % k;
            res += map.getOrDefault(mod, 0);
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return res;
    }
}