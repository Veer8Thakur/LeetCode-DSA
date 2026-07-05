import java.util.*;

class Solution {

    public int[] pathsWithMaxScore(List<String> board) {

        int MOD = 1_000_000_007;

        int m = board.size();
        int n = board.get(0).length();

        int[][] dp = new int[m][n];
        long[][] ways = new long[m][n];

        // -1 means unreachable
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Starting point for reverse DP
        dp[m - 1][n - 1] = 0;
        ways[m - 1][n - 1] = 1;


        // Last column
        for (int i = m - 2; i >= 0; i--) {

            char ch = board.get(i).charAt(n - 1);

            if (ch == 'X' || dp[i + 1][n - 1] == -1) {
                continue;
            }

            dp[i][n - 1] =
                    dp[i + 1][n - 1] + (ch - '0');

            ways[i][n - 1] =
                    ways[i + 1][n - 1];
        }


        // Last row
        for (int j = n - 2; j >= 0; j--) {

            char ch = board.get(m - 1).charAt(j);

            if (ch == 'X' || dp[m - 1][j + 1] == -1) {
                continue;
            }

            dp[m - 1][j] =
                    dp[m - 1][j + 1] + (ch - '0');

            ways[m - 1][j] =
                    ways[m - 1][j + 1];
        }


        // Remaining cells
        for (int i = m - 2; i >= 0; i--) {

            for (int j = n - 2; j >= 0; j--) {

                char ch = board.get(i).charAt(j);

                if (ch == 'X') {
                    continue;
                }

                int right = dp[i][j + 1];
                int down = dp[i + 1][j];
                int dia = dp[i + 1][j + 1];

                int best = Math.max(
                        dia,
                        Math.max(right, down)
                );

                // No valid path to S
                if (best == -1) {
                    continue;
                }

                int value = 0;

                // E contributes 0
                if (ch != 'E') {
                    value = ch - '0';
                }

                dp[i][j] = best + value;


                // Count all paths producing the best score

                if (right == best) {
                    ways[i][j] += ways[i][j + 1];
                }

                if (down == best) {
                    ways[i][j] += ways[i + 1][j];
                }

                if (dia == best) {
                    ways[i][j] += ways[i + 1][j + 1];
                }

                ways[i][j] %= MOD;
            }
        }

        // No path from E to S
        if (dp[0][0] == -1) {
            return new int[]{0, 0};
        }

        return new int[]{
                dp[0][0],
                (int) ways[0][0]
        };
    }
}