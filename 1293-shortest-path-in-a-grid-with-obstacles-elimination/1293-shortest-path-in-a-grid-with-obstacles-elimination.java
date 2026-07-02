class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        // Optimization
        if (k >= m + n - 2) {
            return m + n - 2;
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][][] vis = new boolean[m][n][k + 1];

        q.offer(new int[]{0, 0, 0, 0}); // row, col, wallsBroken, steps
        vis[0][0][0] = true;

        int[][] dirs = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];
            int walls = cur[2];
            int steps = cur[3];

            if (r == m - 1 && c == n - 1) {
                return steps;
            }

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;

                int newWalls = walls + grid[nr][nc];

                if (newWalls <= k && !vis[nr][nc][newWalls]) {
                    vis[nr][nc][newWalls] = true;
                    q.offer(new int[]{nr, nc, newWalls, steps + 1});
                }
            }
        }

        return -1;
    }
}