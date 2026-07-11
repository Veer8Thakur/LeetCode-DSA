class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: arr)
            map.put(num, map.getOrDefault(num, 0) + 1);

        Set<Integer> set = new HashSet<>();
        for(Map.Entry<Integer, Integer> num: map.entrySet()) {
            if(set.contains(num.getValue())) return false;
            set.add(num.getValue());
        }
        return true;
    }
}