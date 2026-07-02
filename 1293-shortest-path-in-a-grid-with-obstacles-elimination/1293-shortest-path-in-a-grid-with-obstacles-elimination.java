class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{0, 0, 0, 0});

        boolean[][][] vis = new boolean[m][n][k+1];
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            int r = cur[0], c = cur[1], wallBreak = cur[2], steps = cur[3];
            if(r == m-1 && c == n-1) return steps;
            vis[r][c][wallBreak] = true;

            for(int[] dir: directions){
                int newR = r + dir[0], newC = c + dir[1];
                if(newR >= 0  && newR < m && newC >= 0 && newC < n && !vis[newR][newC][wallBreak]){
                    int newWallBreak = wallBreak + grid[newR][newC];
                    if(newWallBreak <= k && !vis[newR][newC][newWallBreak]){
                        dq.offer(new int[]{newR, newC, newWallBreak, steps+1});
                        vis[newR][newC][newWallBreak] = true;
                    }
                }
            }
        }
        return -1;
    }
}






