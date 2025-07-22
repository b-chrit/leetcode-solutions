class Solution {
    
    class Cell {
        int effort, row, col;
        
        public Cell(int effort, int row, int col) {
            this.effort = effort;
            this.row = row;
            this.col = col;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.effort - b.effort);
        boolean[][] visited = new boolean[m][n];

        pq.offer(new Cell(0, 0, 0));
        
        while (!pq.isEmpty()) {
            Cell curr = pq.poll();
            int effort = curr.effort, row = curr.row, col = curr.col;
            
            if (row == m - 1 && col == n - 1) {
                return effort;
            }
            
            if (visited[row][col]) {
                continue;
            }
            visited[row][col] = true;
            
            for (int[] dir : dirs) {
                int newRow = row + dir[0], newCol = col + dir[1];
                
                if (isValid(newRow, newCol, m, n, visited)) {
                    int newEffort = Math.max(effort, Math.abs(heights[newRow][newCol] - heights[row][col]));
                    pq.offer(new Cell(newEffort, newRow, newCol));
                }
            }
        }
        
        return 0;
    }

    private boolean isValid(int row, int col, int m, int n, boolean[][] visited) {
        return row >= 0 && row < m && col >= 0 && col < n && !visited[row][col];
    }
}
