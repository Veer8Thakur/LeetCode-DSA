class Solution {
    int[] parent;
    int[] rank;

    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY) return ;
        if(rank[rootX] > rank[rootY]) parent[rootY] = rootX;
        else if(rank[rootX] < rank[rootY]) parent[rootX] = rootY;
        else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i<n; i++) parent[i] = i;

        for(int i = 1; i<n; i++){
            if(Math.abs(nums[i] - nums[i-1]) <= maxDiff) 
                union(i-1, i); 
        }

        int m = queries.length;
        boolean[] ans = new boolean[m];
        for(int i = 0; i<m; i++){
            int start = queries[i][0], end = queries[i][1];
            if(find(start) == find(end)) ans[i] = true;
        }
        return ans;
    }
}