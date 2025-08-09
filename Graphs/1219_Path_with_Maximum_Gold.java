class Solution {
    private int numRows, numCols;
    private int[][] goldGrid;

    public int getMaximumGold(int[][] grid) {
        goldGrid = grid;
        numRows = grid.length;
        numCols = grid[0].length;
        int maxGoldCollected = 0;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                maxGoldCollected = Math.max(maxGoldCollected, collectGold(row, col));
            }
        }
        return maxGoldCollected;
    }

    private int collectGold(int row, int col) {
        if (row < 0 || row >= numRows || col < 0 || col >= numCols || goldGrid[row][col] == 0) {
            return 0;
        }
        int currentGold = goldGrid[row][col];
        goldGrid[row][col] = 0;
        int maxGoldFromNextSteps = 0;
        maxGoldFromNextSteps = Math.max(maxGoldFromNextSteps, collectGold(row + 1, col));
        maxGoldFromNextSteps = Math.max(maxGoldFromNextSteps, collectGold(row - 1, col));
        maxGoldFromNextSteps = Math.max(maxGoldFromNextSteps, collectGold(row, col + 1));
        maxGoldFromNextSteps = Math.max(maxGoldFromNextSteps, collectGold(row, col - 1));
        goldGrid[row][col] = currentGold;
        return currentGold + maxGoldFromNextSteps;
    }
}
