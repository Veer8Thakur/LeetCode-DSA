class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int n = points.length;
        int arrows = 0;

        long start = points[0][0], end = points[0][1];
        for(int i = 1; i<n; i++){
            long newStart = points[i][0], newEnd = points[i][1];
            if(end >= newStart){
                start = Math.max(start, newStart);
                end = Math.min(end, newEnd);
            }
            else{
                arrows++;
                start = newStart;
                end = newEnd;
            }
        }

        return arrows+1;
    }
}