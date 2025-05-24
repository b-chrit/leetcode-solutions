import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> rottenQueue = new LinkedList<>();
        int freshOranges = 0;
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 2) {
                    rottenQueue.offer(new int[]{row, col});
                } else if (grid[row][col] == 1) {
                    freshOranges++;
                }
            }
        }
        
        if (freshOranges == 0) return 0;
        
        int[][] adjacentDirections = {
                                        {-1, 0},
                                        {1, 0},
                                        {0, -1},
                                        {0, 1} 
                                    };

        int minutesElapsed = 0;
        
        while (!rottenQueue.isEmpty()) {
            int currentLevelSize = rottenQueue.size();
            boolean orangesRottedThisMinute = false;
            
            for (int i = 0; i < currentLevelSize; i++) {
                int[] currentPosition = rottenQueue.poll();
                int currentRow = currentPosition[0];
                int currentCol = currentPosition[1];
                
                for (int[] direction : adjacentDirections) {
                    int adjacentRow = currentRow + direction[0];
                    int adjacentCol = currentCol + direction[1];
                    
                    if (isValidPosition(adjacentRow, adjacentCol, rows, cols) && 
                        grid[adjacentRow][adjacentCol] == 1) {
                        
                        grid[adjacentRow][adjacentCol] = 2;
                        rottenQueue.offer(new int[]{adjacentRow, adjacentCol});
                        freshOranges--;
                        orangesRottedThisMinute = true;
                    }
                }
            }
            
            if (orangesRottedThisMinute) {
                minutesElapsed++;
            }
        }
        
        return freshOranges == 0 ? minutesElapsed : -1;
    }
    
    private boolean isValidPosition(int row, int col, int totalRows, int totalCols) {
        return row >= 0 && row < totalRows && col >= 0 && col < totalCols;
    }
}