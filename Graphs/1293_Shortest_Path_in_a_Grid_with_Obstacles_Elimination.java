class Solution {

    class State {
        int row;
        int col;
        int steps;
        int obstacles;

        State(int row, int col, int steps, int obstacles) {
            this.row = row;
            this.col = col;
            this.steps = steps;
            this.obstacles = obstacles;
        }
    }

    public int shortestPath(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        int[][] visited = new int[rows][cols];
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                visited[r][c] = Integer.MAX_VALUE;
            }
        }

        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(0, 0, 0, 0));
        visited[0][0] = 0;

        while (!queue.isEmpty()) {
            State current = queue.poll();
            if (current.row == rows - 1 && current.col == cols - 1) {
                return current.steps;
            }
            for (int[] dir : directions) {
                int newRow = current.row + dir[0];
                int newCol = current.col + dir[1];
                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) continue;
                int newObstacles = current.obstacles + grid[newRow][newCol];
                if (newObstacles <= k && visited[newRow][newCol] > newObstacles) {
                    visited[newRow][newCol] = newObstacles;
                    queue.offer(new State(newRow, newCol, current.steps + 1, newObstacles));
                }
            }
        }
        return -1;
    }
}
