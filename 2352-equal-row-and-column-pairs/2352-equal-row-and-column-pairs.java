class Solution {
    public int equalPairs(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[][] newGrid = new int[row][col];

        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                newGrid[i][j] = grid[j][i]; 
            }
        }

        int cnt = 0;
        for(int[] arr1: grid){
            for(int[] arr2: newGrid){
                if(Arrays.equals(arr1, arr2)) cnt++;
            }
        }
        return cnt;
    }
}