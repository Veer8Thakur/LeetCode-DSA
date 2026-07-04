class Solution {

    int[] parent;
    int[] rank;

    public int minScore(int n, int[][] roads) {
        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // Step 1: Build connected components
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];

            union(u, v);
        }

        // Step 2: Component containing city 1
        int root = find(1);

        int minScore = Integer.MAX_VALUE;

        // Step 3: Find minimum edge in that component
        for (int[] road : roads) {
            int u = road[0];
            int weight = road[2];

            if (find(u) == root) {
                minScore = Math.min(minScore, weight);
            }
        }

        return minScore;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        }

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
}