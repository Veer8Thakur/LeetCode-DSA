import java.util.*;

class Solution {
    public int[] pathExistenceQueries(
        int n,
        int[] nums,
        int maxDiff,
        int[][] queries
    ) {
        
        // 1. Store {value, originalIndex}
        int[][] pair = new int[n][2];

        for (int i = 0; i < n; i++) {
            pair[i][0] = nums[i];
            pair[i][1] = i;
        }

        // 2. Sort nodes according to nums value
        Arrays.sort(pair, (a, b) ->
            Integer.compare(a[0], b[0])
        );

        int[] arr = new int[n];

        // pos[originalIndex] = sortedPosition
        int[] pos = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = pair[i][0];

            int originalIndex = pair[i][1];
            pos[originalIndex] = i;
        }


        // ------------------------------------------------
        // 3. Find farthest right reachable in ONE edge
        // ------------------------------------------------

        int[] farthest = new int[n];

        int r = 0;

        for (int l = 0; l < n; l++) {

            r = Math.max(r, l);

            while (
                r + 1 < n &&
                arr[r + 1] - arr[l] <= maxDiff
            ) {
                r++;
            }

            farthest[l] = r;
        }


        // ------------------------------------------------
        // 4. Build connected component IDs
        // ------------------------------------------------

        int[] component = new int[n];

        int componentId = 0;

        for (int i = 1; i < n; i++) {

            if (arr[i] - arr[i - 1] > maxDiff) {
                componentId++;
            }

            component[i] = componentId;
        }


        // ------------------------------------------------
        // 5. Binary lifting table
        // ------------------------------------------------

        int LOG = 1;

        while ((1L << LOG) <= n) {
            LOG++;
        }

        int[][] up = new int[n][LOG];


        // 1 jump
        for (int i = 0; i < n; i++) {
            up[i][0] = farthest[i];
        }


        // 2, 4, 8, 16... jumps
        for (int k = 1; k < LOG; k++) {

            for (int i = 0; i < n; i++) {

                int mid = up[i][k - 1];

                up[i][k] = up[mid][k - 1];
            }
        }


        // ------------------------------------------------
        // 6. Answer queries
        // ------------------------------------------------

        int q = queries.length;
        int[] answer = new int[q];

        for (int qi = 0; qi < q; qi++) {

            int u = queries[qi][0];
            int v = queries[qi][1];


            // Convert original index → sorted position
            int left = pos[u];
            int right = pos[v];


            // Ensure left <= right
            if (left > right) {
                int temp = left;
                left = right;
                right = temp;
            }


            // Same node
            if (left == right) {
                answer[qi] = 0;
                continue;
            }


            // Different connected components
            if (component[left] != component[right]) {
                answer[qi] = -1;
                continue;
            }


            // --------------------------------------------
            // Binary lifting query
            // --------------------------------------------

            int current = left;
            int jumps = 0;


            // Take largest possible jumps
            // while remaining strictly before target
            for (int k = LOG - 1; k >= 0; k--) {

                if (up[current][k] < right) {

                    current = up[current][k];

                    jumps += (1 << k);
                }
            }


            // One final jump reaches/crosses target
            answer[qi] = jumps + 1;
        }

        return answer;
    }
}