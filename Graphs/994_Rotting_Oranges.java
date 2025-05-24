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
        
    }
}