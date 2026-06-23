class Solution {
    List<List<Integer>> adj;
    int max = 1;

    public int longestPath(int[] parent, String s) {
        int n = parent.length;

        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            adj.get(parent[i]).add(i);
        }

        DFS(0, s.toCharArray());
        return max;
    }

    private int DFS(int node, char[] ch) {
        int best1 = 0;
        int best2 = 0;

        for (int child : adj.get(node)) {
            int childLen = DFS(child, ch);

            if (ch[node] == ch[child]) {
                continue;
            }

            if (childLen > best1) {
                best2 = best1;
                best1 = childLen;
            } else if (childLen > best2) {
                best2 = childLen;
            }
        }

        max = Math.max(max, 1 + best1 + best2);

        return 1 + best1;
    }
}