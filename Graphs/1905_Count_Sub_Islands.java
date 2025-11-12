class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int rows = grid1.length, cols = grid1[0].length;
        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid2[r][c] == 1) {
                    if (dfs(grid1, grid2, r, c)) count++;
                }
            }
        }
        return count;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int r, int c) {
        if (r < 0 || c < 0 || r >= grid1.length || c >= grid1[0].length || grid2[r][c] == 0)
            return true;

        grid2[r][c] = 0;
        boolean isSub = grid1[r][c] == 1;

        isSub &= dfs(grid1, grid2, r + 1, c);
        isSub &= dfs(grid1, grid2, r - 1, c);
        isSub &= dfs(grid1, grid2, r, c + 1);
        isSub &= dfs(grid1, grid2, r, c - 1);

        return isSub;
    }
}
