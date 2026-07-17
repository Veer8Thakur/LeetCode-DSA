class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;

        Map<List<Integer>, Integer> map = new HashMap<>();

        // Store all rows
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(grid[i][j]);
            }
            map.put(row, map.getOrDefault(row, 0) + 1);
        }
        int ans = 0;

        // Check every column
        for (int j = 0; j < n; j++) {
            List<Integer> col = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                col.add(grid[i][j]);
            }
            ans += map.getOrDefault(col, 0);
        }

        return ans;
    }
}