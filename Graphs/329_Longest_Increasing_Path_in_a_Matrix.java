class Solution {
    private Map<String, Integer> memo;
    private int[][] matrix;
    private int m, n;
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        this.matrix = matrix;
        this.m = matrix.length;
        this.n = matrix[0].length;
        this.memo = new HashMap<>();
        
        int maxPath = 1;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxPath = Math.max(maxPath, dfs(i, j));
            }
        }
        
        return maxPath;
    }
    
    private int dfs(int row, int col) {
        String key = row + "," + col;
        
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        int maxLength = 1;
        
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            
            if (isValid(newRow, newCol) && matrix[newRow][newCol] > matrix[row][col]) {
                maxLength = Math.max(maxLength, 1 + dfs(newRow, newCol));
            }
        }
        
        memo.put(key, maxLength);
        return maxLength;
    }
    
    private boolean isValid(int row, int col) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }
}
