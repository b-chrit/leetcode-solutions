public class Solution {
    /**
     * LeetCode 286: Walls and Gates
     * 
     * You are given an m x n grid rooms initialized with these three possible values:
     * -1: A wall or an obstacle
     * 0: A gate  
     * INF: Infinity means an empty room
     * 
     * Fill each empty room with the distance to its nearest gate.
     * If it is impossible to reach a gate, it should be filled with INF.
     */
    
    private static final int INF = 2147483647;
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            
            for (int[] dir : DIRECTIONS) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < m && 
                    newCol >= 0 && newCol < n && 
                    rooms[newRow][newCol] == INF) {
                    
                    rooms[newRow][newCol] = rooms[row][col] + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
}
