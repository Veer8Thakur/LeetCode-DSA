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

        for(int i = 0; i<n; i++){
            adj[i] = new ArrayList<>();
            newTree[i] = new ArrayList<>();
        }
        // old tree
        for(int i = 1; i<n; i++){
            adj[parent[i]].add(i);
        }
        last = new int[26];
        Arrays.fill(last, -1);

        // New Tree
        DFS(0, parent);

        ans = new int[n];
        postOrder(0);
        return ans;
    }

    public void DFS(int node, int[] parent){
        int c = s.charAt(node) - 'a';
        int prev = last[c];
        int newParent = (prev == -1) ? parent[node] : prev;
        if(node != 0){
            newTree[newParent].add(node);
        }
        last[c] = node;
        for(int child: adj[node]){
            DFS(child, parent);
        }
        last[c] = prev;
    } 
    public int postOrder(int node){
        int size = 1;
        for(int child: newTree[node]){
            size += postOrder(child);
        }
        ans[node] = size;
        return size;
    }
}