class Solution {
    class Cell {
        int row, col, elevation;

        Cell(int row, int col, int elevation) {
            this.row = row;
            this.col = col;
            this.elevation = elevation;
        }
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(Comparator.comparingInt(c -> c.elevation));
        minHeap.offer(new Cell(0, 0, grid[0][0]));

        int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};

        while (!minHeap.isEmpty()) {
            Cell cell = minHeap.poll();
            int row = cell.row, col = cell.col, elevation = cell.elevation;

            if (visited[row][col]) continue;
            visited[row][col] = true;

            if (row == n - 1 && col == n - 1) return elevation;

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    int newElevation = Math.max(elevation, grid[newRow][newCol]);
                    minHeap.offer(new Cell(newRow, newCol, newElevation));
                }
            }
        }

        return -1;
    }
}
