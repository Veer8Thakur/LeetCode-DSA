class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size(), n = grid.get(0).size();
        Deque<int[]> dq = new ArrayDeque<>();
        if(grid.get(0).get(0) == 0) dq.offer(new int[]{0, 0, health});
        else dq.offer(new int[]{0, 0, health-1});
        boolean[][] vis = new boolean[m][n];

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!dq.isEmpty()){
            int cur[] = dq.poll();
            int r = cur[0], c = cur[1], curHealth = cur[2];

            if(r == m-1 && c == n-1) return curHealth > 0;
            vis[r][c] = true; 

            for(int[] dir: directions){
                int newR = r + dir[0], newC = c + dir[1];
                if(newR >= 0 && newR < m && newC >= 0 && newC < n && !vis[newR][newC]){
                    if(grid.get(newR).get(newC) == 0) dq.addFirst(new int[]{newR, newC, curHealth});
                    else dq.addLast(new int[]{newR, newC, curHealth-1});
                    vis[newR][newC] = true;
                }
            }
        }
        return false;
    }
}