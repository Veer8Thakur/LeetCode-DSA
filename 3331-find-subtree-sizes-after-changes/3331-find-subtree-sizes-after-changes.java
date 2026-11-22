class Solution {

    List<Integer>[] adj;
    List<Integer>[] newTree;
    int[] last;
    int[] ans;
    String s;

    public int[] findSubtreeSizes(int[] parent, String s) {

        int n = parent.length;
        this.s = s;

        adj = new ArrayList[n];
        newTree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            newTree[i] = new ArrayList<>();
        }

        // Build original tree
        for (int i = 1; i < n; i++) {
            adj[parent[i]].add(i);
        }

        last = new int[26];
        Arrays.fill(last, -1);

        // First DFS: Build modified tree
        dfs1(0, parent);

        // Second DFS: Calculate subtree sizes
        ans = new int[n];
        dfs2(0);

        return ans;
    }

    void dfs1(int node, int[] parent) {

        int c = s.charAt(node) - 'a';

        // Save previous ancestor
        int prev = last[c];

        // Determine new parent
        int newParent = (prev == -1) ? parent[node] : prev;

        // Build modified tree
        if (node != 0) {
            newTree[newParent].add(node);
        }

        // Update nearest ancestor
        last[c] = node;

        // Traverse original children
        for (int child : adj[node]) {
            dfs1(child, parent);
        }

        // Backtrack
        last[c] = prev;
    }

    int dfs2(int node) {

        int size = 1;

        for (int child : newTree[node]) {
            size += dfs2(child);
        }

        ans[node] = size;

        return size;
    }
}