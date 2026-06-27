class Solution {

    public int maximumLength(int[] nums) {

        HashMap<Long, Integer> hm = new HashMap<>();

        for (int x : nums) {
            hm.put((long) x,
                    hm.getOrDefault((long) x, 0) + 1);
        }

        int ans = 1;

        // Special case for 1
        if (hm.containsKey(1L)) {

            int cnt = hm.get(1L);

            if (cnt % 2 == 0)
                cnt--;

            ans = Math.max(ans, cnt);
        }

        for (long start : hm.keySet()) {

            if (start == 1L)
                continue;

            long x = start;

            int len = 1; // middle element

            while (hm.getOrDefault(x, 0) >= 2) {

                long next = x * x;

                if (!hm.containsKey(next))
                    break;

                len += 2;

                if (x > 1e9 / x)
                    break;

                x = next;
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}