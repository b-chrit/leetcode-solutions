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
        
        // Check 3x3 sub-boxes
        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {
                Set<Character> boxSet = new HashSet<>();
                
                int startRow = boxRow * 3;
                int endRow = startRow + 3;
                int startCol = boxCol * 3;
                int endCol = startCol + 3;
                
                for (int i = startRow; i < endRow; i++) {
                    for (int j = startCol; j < endCol; j++) {
                        char currentChar = board[i][j];
                        if (currentChar != '.') {
                            if (boxSet.contains(currentChar)) {
                                return false;
                            }
                            boxSet.add(currentChar);
                        }
                    }
                }
            }
        }
        
        return true;
    }
}