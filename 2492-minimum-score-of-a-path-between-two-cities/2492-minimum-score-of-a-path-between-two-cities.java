class Solution {
    int minScore;
    List<List<int[]>> adj;
    public int minScore(int n, int[][] roads) {
        minScore = Integer.MAX_VALUE;
        adj = new ArrayList<>();
        for(int i = 0; i<=n; i++) adj.add(new ArrayList<>());
        for(int road[] : roads){
            int u = road[0], v = road[1], w = road[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }
        boolean vis[] = new boolean[n+1];

        DFS(vis, 1);
        
        return minScore;
    }
    public void DFS(boolean[] vis, int node){
        vis[node] = true;
        for(int[] road: adj.get(node)){
            int nei = road[0], cost = road[1];
            minScore = Math.min(minScore, cost);
            if(!vis[nei]){
                DFS(vis, nei);
            }
        }
    }
}