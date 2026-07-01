class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] dist = new int[m][n];
        for(int[] row: dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;

        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // Effort, row, col
        pq.offer(new int[]{0, 0, 0});
        boolean[][] vis = new boolean[m][n];

        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int effort = cur[0];
            int r = cur[1], c = cur[2];

            if(r == m-1 && c == n-1) return effort;
            if(vis[r][c]) continue;
            vis[r][c] = true;

            for(int[] dir: directions){
                int newR = r + dir[0];
                int newC = c + dir[1];

                if(newR >= 0 && newR < m && newC >= 0 && newC < n && !vis[newR][newC]){
                    int edge = Math.abs(heights[r][c] - heights[newR][newC]);
                    int newEffort = Math.max(dist[r][c], edge);
                    if(newEffort < dist[newR][newC]){
                        dist[newR][newC] = newEffort;
                        pq.offer(new int[]{newEffort, newR, newC});
                        // vis[newR][newC] = true;
                    }
                }
            }
        }
        return 0;
    }
}