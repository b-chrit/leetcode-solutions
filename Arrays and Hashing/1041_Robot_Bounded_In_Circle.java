class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0;
        int direction = 0; // north = 0, east = 1, south = 2, west = 3
        
        int[][] directions = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };
        
        for (char instruction : instructions.toCharArray()) {
            if (instruction == 'G') {
                x += directions[direction][0];
                y += directions[direction][1];
            } else if (instruction == 'L') {
                direction = (direction + 3) % 4;
            } else if (instruction == 'R') {
                direction = (direction + 1) % 4;
            }
        }
        
        return (x == 0 && y == 0) || (direction != 0);
    }
}
