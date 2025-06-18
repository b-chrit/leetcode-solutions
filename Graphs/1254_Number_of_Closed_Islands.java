class Solution {
    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 0 && explore(grid, i, j)) {
                    count += 1;
                }
            }
        }
        
        return count;
    }

    private boolean explore(int[][] grid, int r, int c){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return false;
        }
        
        if(grid[r][c] == 1 || grid[r][c] == 2) {
            return true;
        }
        
        grid[r][c] = 2;
        
        boolean up = explore(grid, r - 1, c);
        boolean down = explore(grid, r + 1, c);
        boolean left = explore(grid, r, c - 1);
        boolean right = explore(grid, r, c + 1);
        
        return up && down && left && right;
    }
}
