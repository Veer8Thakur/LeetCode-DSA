class Solution {
    class Pair{
        String str;
        double val;
        Pair(String str, double val){
            this.str = str;
            this.val = val;
        }
    }
    public double[] calcEquation(List<List<String>> equations,
                         double[] values, List<List<String>> queries) {

        Map<String, List<Pair>> adj = new HashMap<>();
        int n = equations.size();
        for(int i = 0; i<n; i++){
            String start = equations.get(i).get(0);
            String end = equations.get(i).get(1);
            adj.computeIfAbsent(start, k -> new ArrayList<>()).add(new Pair(end, values[i]));
            adj.computeIfAbsent(end, k -> new ArrayList<>()).add(new Pair(start, 1.0/values[i]));
        }

        int m = queries.size();
        double[] ans = new double[m];
        for(int i = 0; i<m; i++){
            String start = queries.get(i).get(0), end = queries.get(i).get(1);

            if(!adj.containsKey(start) || !adj.containsKey(end)) {
                ans[i] = -1.0;
                continue;
            }
            if(start.equals(end)) {
                ans[i] = 1.0;
                continue;
            }

            Queue<Pair> q = new LinkedList<>();
            q.offer(new Pair(start, 1.0));
            Set<String> vis = new HashSet<>();
            vis.add(start);
            double cost = -1.0;
            while(!q.isEmpty()){
                Pair cur = q.poll();
                String curNode = cur.str;
                double curCost = cur.val;

                if(curNode.equals(end)) {
                    cost = curCost;
                    break;
                }
                for(Pair nei: adj.get(curNode)){
                    if(!vis.contains(nei.str)){
                        vis.add(nei.str);
                        q.offer(new Pair(nei.str, curCost * nei.val));
                    }
                }
            }
            ans[i] = cost;
        }
        return ans;
    }
}