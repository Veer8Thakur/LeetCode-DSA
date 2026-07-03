class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] indegree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());
        for(int[] relation: relations){
            int u = relation[0] - 1, v = relation[1] - 1;
            adj.get(u).add(v);
            indegree[v]++;
        }
        int[] deg = indegree.clone();
        // TOPO SORT
        List<Integer> topo = new ArrayList<>(); // node
        // Stack<Integer> topo = new Stack<>();
        Queue<Integer> q = new LinkedList<>(); // node
        
        for(int i = 0; i<n; i++) {
            if(indegree[i] == 0) q.offer(i);
        }
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            // topo.push(node);
            for(int nei: adj.get(node)) {
                indegree[nei]--;
                if(indegree[nei] == 0) q.offer(nei);
            }
        }

        // DAG 

        int[] dist = new int[n];
        for(int i = 0; i<n; i++){
            dist[i] = deg[i] == 0 ? time[i] : Integer.MIN_VALUE;
        }
        for(int cur: topo){
            // int cur = topo.pop();
            if(dist[cur] != Integer.MIN_VALUE){
                for(int nei: adj.get(cur)){
                    int cost = time[nei];
                    if(dist[nei] < dist[cur] + cost) {
                        dist[nei] = dist[cur] + cost;
                    }
                }
            }
        }
        int max = 0;
        for(int val : dist) max = Math.max(max, val);
        return max;
    }
}