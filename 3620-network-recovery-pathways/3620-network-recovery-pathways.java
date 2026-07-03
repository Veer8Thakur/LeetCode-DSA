import java.util.*;

class Solution {

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        int n = online.length;

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[n];
        List<Integer> costs = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            adj.get(u).add(new int[]{v, w});
            indegree[v]++;
            costs.add(w);
        }

        Collections.sort(costs);

        List<Integer> unique = new ArrayList<>();
        for (int x : costs) {
            if (unique.isEmpty() || unique.get(unique.size() - 1) != x) {
                unique.add(x);
            }
        }

        int low = 0;
        int high = unique.size() - 1;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;
            int threshold = unique.get(mid);

            if (check(threshold, k, online, indegree, adj, n)) {
                ans = threshold;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int threshold,
                          long k,
                          boolean[] online,
                          int[] indegree,
                          List<List<int[]>> adj,
                          int n) {

        // ---------- Topological Sort ----------
        int[] indeg = indegree.clone();

        Queue<Integer> q = new LinkedList<>();
        List<Integer> topo = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {

            int u = q.poll();
            topo.add(u);

            for (int[] edge : adj.get(u)) {
                int v = edge[0];

                indeg[v]--;

                if (indeg[v] == 0) {
                    q.offer(v);
                }
            }
        }

        // ---------- DAG Shortest Path ----------
        long INF = Long.MAX_VALUE / 4;

        long[] dist = new long[n];
        Arrays.fill(dist, INF);

        dist[0] = 0;

        for (int u : topo) {

            if (dist[u] == INF) continue;

            // intermediate offline nodes are not allowed
            if (u != 0 && u != n - 1 && !online[u]) continue;
            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int cost = edge[1];
                if (cost < threshold) continue;
                if (v != n - 1 && !online[v]) continue;
                dist[v] = Math.min(dist[v], dist[u] + cost);
            }
        }

        return dist[n - 1] <= k;
    }
}