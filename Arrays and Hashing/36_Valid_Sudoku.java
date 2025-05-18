class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Check rows
        for (int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char currentChar = board[i][j];
                if (currentChar != '.') {
                    if (rowSet.contains(currentChar)) {
                        return false;
                    }
                    rowSet.add(currentChar);
                }
            }
        }
        
        // Check columns
        for (int j = 0; j < 9; j++) {
            Set<Character> colSet = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                char currentChar = board[i][j];
                if (currentChar != '.') {
                    if (colSet.contains(currentChar)) {
                        return false;
                    }
                    colSet.add(currentChar);
                }
            }
        }
    }
}