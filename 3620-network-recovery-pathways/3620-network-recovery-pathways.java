import java.util.*;

class Solution {

    List<List<int[]>> adj;

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        int n = online.length;

        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[n];
        List<Integer> edgeCost = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            adj.get(u).add(new int[]{v, cost});
            indegree[v]++;
            edgeCost.add(cost);
        }

        Collections.sort(edgeCost);

        List<Integer> unique = new ArrayList<>();
        for (int x : edgeCost) {
            if (unique.isEmpty() || unique.get(unique.size() - 1) != x) {
                unique.add(x);
            }
        }

        // Compute topo order ONCE
        List<Integer> topo = topoSort(indegree);

        int low = 0;
        int high = unique.size() - 1;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (check(unique.get(mid), k, online, topo, n)) {
                ans = unique.get(mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private List<Integer> topoSort(int[] indegree) {

        // int[] indeg = indegree.clone();

        Queue<Integer> q = new LinkedList<>();
        List<Integer> topo = new ArrayList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {

            int u = q.poll();
            topo.add(u);

            for (int[] edge : adj.get(u)) {

                int v = edge[0];

                indegree[v]--;

                if (indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        return topo;
    }

    private boolean check(int threshold,
                          long k,
                          boolean[] online,
                          List<Integer> topo,
                          int n) {

        long INF = Long.MAX_VALUE / 4;

        long[] dist = new long[n];
        Arrays.fill(dist, INF);

        dist[0] = 0;

        for (int u : topo) {

            if (dist[u] == INF)
                continue;

            if (u != 0 && u != n - 1 && !online[u])
                continue;

            for (int[] edge : adj.get(u)) {

                int v = edge[0];
                int cost = edge[1];

                if (cost < threshold)
                    continue;

                if (v != n - 1 && !online[v])
                    continue;

                dist[v] = Math.min(dist[v], dist[u] + cost);
            }
        }

        return dist[n - 1] <= k;
    }
}