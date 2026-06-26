class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // map.put(0, -1);
        int idx1 = -1, idx2 = -1;
        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(target - nums[i])){
                idx1 = map.get(target - nums[i]);
                idx2 = i;
            }
            else map.put(nums[i], i);
        }
        return new int[]{idx1, idx2};
    }
}