class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[][] pairs = new int[n][2];
        for(int i = 0; i<n; i++){
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        int[] pos = new int[n];
        int[] arr = new int[n];

        for(int i = 0; i<n; i++){
            arr[i] = pairs[i][0];
            int ogIdx = pairs[i][1];
            pos[ogIdx] = i;
        }

        // farthest range
        int[] farthest = new int[n];
        int r = 0;
        for(int l = 0; l<n; l++){
            r = Math.max(l, r);
            while(r + 1 < n && arr[r+1] - arr[l] <= maxDiff) r++;
            farthest[l] = r;
        }

        // Components
        int componentId = 0;
        int[] component = new int[n];
        for(int i = 1; i<n; i++){
            if(arr[i] - arr[i-1] > maxDiff) componentId++;
            component[i] = componentId; 
        }

        // Binary range
        int LOG = 1;
        while((1 << LOG) < n) LOG++;

        // Binary Lifting Table
        int[][] up = new int[n][LOG];
        for(int i = 0; i<n; i++) up[i][0] = farthest[i];

        for(int k = 1; k<LOG; k++){
            for(int i = 0; i<n; i++){
                up[i][k] = up[up[i][k-1]][k-1];
            }
        }

        int m = queries.length; 
        int[] ans = new int[m];
        for(int i = 0; i<m; i++){
            int u = queries[i][0];
            int v = queries[i][1];

            int start = pos[u], end = pos[v];
            if(start > end){
                int temp = start;
                start = end;
                end = temp;
            }
            if(start == end) {
                ans[i] = 0;
                continue;
            }
            if(component[start] != component[end]){
                ans[i] = -1;
                continue;
            }
            int cur = start;
            int jumps = 0;
            for(int k = LOG-1; k>=0; k--){
                if(up[cur][k] < end){
                    cur = up[cur][k];
                    jumps += (1 << k);
                }
            }
            ans[i] = jumps + 1;
        }
        return ans;
    }
}