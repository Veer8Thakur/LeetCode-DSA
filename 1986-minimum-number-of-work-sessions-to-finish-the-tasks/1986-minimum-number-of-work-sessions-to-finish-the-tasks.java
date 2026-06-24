class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length;
        int totalMasks = 1 << n;

        int[][] dp = new int[totalMasks][2];

        for (int mask = 0; mask < totalMasks; mask++) {
            dp[mask][0] = Integer.MAX_VALUE; // sessions
            dp[mask][1] = Integer.MAX_VALUE; // load
        }

        dp[0][0] = 1; // start with one empty session
        dp[0][1] = 0;

        for (int mask = 0; mask < totalMasks; mask++) {

            int sessions = dp[mask][0];
            int load = dp[mask][1];

            if (sessions == Integer.MAX_VALUE) continue;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) continue;

                int newMask = mask | (1 << i);

                int newSessions;
                int newLoad;

                if (load + tasks[i] <= sessionTime) {
                    newSessions = sessions;
                    newLoad = load + tasks[i];
                } else {
                    newSessions = sessions + 1;
                    newLoad = tasks[i];
                }

                if (newSessions < dp[newMask][0] ||
                   (newSessions == dp[newMask][0] &&
                    newLoad < dp[newMask][1])) {

                    dp[newMask][0] = newSessions;
                    dp[newMask][1] = newLoad;
                }
            }
        }

        return dp[totalMasks - 1][0];
    }
}