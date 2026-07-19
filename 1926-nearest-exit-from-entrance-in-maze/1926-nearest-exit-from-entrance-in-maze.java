class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        boolean[][] vis = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{entrance[0], entrance[1], 0});

        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while(!q.isEmpty()){
            int cur[] = q.poll();
            int r = cur[0], c = cur[1], steps = cur[2];
            vis[r][c] = true;
            if((r != entrance[0] || c != entrance[1]) && (r == 0 || r == m-1 || c == 0 || c == n-1)) return steps;

            for(int[] dir: directions){
                int newR = r + dir[0], newC = c + dir[1];
                if(newR >= 0 && newR < m && newC >= 0 && newC < n && maze[newR][newC] == '.' && !vis[newR][newC]){
                    q.offer(new int[]{newR, newC, steps+1});
                    vis[newR][newC] = true;
                }
            } 
        }
        return -1;
    }
}