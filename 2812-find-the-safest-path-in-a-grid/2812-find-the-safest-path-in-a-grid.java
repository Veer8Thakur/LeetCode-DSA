class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int m = grid.size(), n = grid.get(0).size();

        if (grid.get(0).get(0) == 1 || grid.get(m - 1).get(n - 1) == 1)
            return 0;

        // ---------- Multi Source BFS ----------
        int[][] dist = new int[m][n];
        for (int[] row : dist)
            Arrays.fill(row, -1);

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.offer(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];

            for (int[] dir : directions) {
                int newR = r + dir[0];
                int newC = c + dir[1];

                if (newR >= 0 && newR < m &&
                    newC >= 0 && newC < n &&
                    dist[newR][newC] == -1) {

                    dist[newR][newC] = dist[r][c] + 1;
                    q.offer(new int[]{newR, newC});
                }
            }
        }

        // ---------- Max Heap ----------
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        boolean[][] visit = new boolean[m][n];

        // {currentSafeness,row,col}
        pq.offer(new int[]{dist[0][0], 0, 0});

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();

            int safe = cur[0];
            int r = cur[1];
            int c = cur[2];

            if (visit[r][c])
                continue;

            visit[r][c] = true;

            if (r == m - 1 && c == n - 1)
                return safe;

            for (int[] dir : directions) {

                int newR = r + dir[0];
                int newC = c + dir[1];

                if (newR >= 0 && newR < m &&
                    newC >= 0 && newC < n &&
                    !visit[newR][newC]) {

                    int newSafe = Math.min(safe, dist[newR][newC]);

                    pq.offer(new int[]{newSafe, newR, newC});
                }
            }
        }
        return 0;
    }
}