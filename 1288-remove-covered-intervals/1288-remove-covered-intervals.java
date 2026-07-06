class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (x, y) -> {
            if (x[0] == y[0]) {
                return Integer.compare(y[1], x[1]);
            }
            return Integer.compare(x[0], y[0]);
        });

        int maxEnd = intervals[0][1];
        int covered = 0;

        for (int i = 1; i < n; i++) {
            int end = intervals[i][1];

            if (end <= maxEnd) {
                covered++;
            } else {
                maxEnd = end;
            }
        }

        return n - covered;
    }
}